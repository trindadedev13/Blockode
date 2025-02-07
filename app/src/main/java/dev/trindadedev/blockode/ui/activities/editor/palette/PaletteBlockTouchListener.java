package dev.trindadedev.blockode.ui.activities.editor.palette;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import dev.trindadedev.blockode.ui.activities.editor.components.ViewLogicEditor;
import dev.trindadedev.blockode.ui.editor.block.Block;
import dev.trindadedev.blockode.ui.editor.block.BlockBase;
import dev.trindadedev.blockode.ui.editor.block.BlockPane;
import dev.trindadedev.blockode.ui.editor.block.PaletteBlock;
import dev.trindadedev.blockode.ui.editor.view.ViewDummy;

public class PaletteBlockTouchListener implements View.OnTouchListener {

  protected Context context;
  private final Handler handler = new Handler();
  public View currentTouchedView;
  public ViewDummy dummy;
  public ViewLogicEditor editor;
  public PaletteBlock paletteBlock;
  public BlockPane pane;
  public Block originalParent;
  private Runnable longPressed =
      new Runnable() {
        @Override
        public void run() {
          dragStart();
        }
      };
  public boolean useVibrate;
  public boolean isDragged = false;
  public boolean bActiveIconDelete = false;
  public int BLOCK_DRAG_X = 0;
  public int BLOCK_DRAG_Y = -30;
  public int minDist;
  public int originalInsertOption;
  public int originalArgIndex;
  public int[] posDummy = new int[2];
  public int[] posOriginal = new int[2];
  public float posInitX;
  public float posInitY;
  public final Vibrator vibrator;

  public PaletteBlockTouchListener(final Context context) {
    this.context = context;
    minDist = ViewConfiguration.get(context).getScaledTouchSlop();
    vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
  }

  public void setContext(final Context context) {
    this.context = context;
  }

  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {
    int action = motionEvent.getAction();
    if (action == MotionEvent.ACTION_DOWN) {
      isDragged = false;
      handler.postDelayed(longPressed, (long) (ViewConfiguration.getLongPressTimeout() / 2));
      posInitX = motionEvent.getX();
      posInitY = motionEvent.getY();
      currentTouchedView = view;
      return true;
    } else if (action == MotionEvent.ACTION_MOVE) {
      if (isDragged) {
        handler.removeCallbacks(longPressed);
        dummy.moveDummy(
            view,
            motionEvent.getX(),
            motionEvent.getY(),
            posInitX,
            posInitY,
            (float) BLOCK_DRAG_X,
            (float) BLOCK_DRAG_Y);
        if (hitTestIconDelete(motionEvent.getRawX(), motionEvent.getRawY())) {
          dummy.setAllow(true);
          activeIconDelete(true);
          return true;
        }
        activeIconDelete(false);
        dummy.getDummyPosition(posDummy);
        if (editor.hitTest((float) posDummy[0], (float) posDummy[1])) {
          dummy.setAllow(true);
          pane.updateFeedbackFor((Block) view, posDummy[0], posDummy[1]);
        } else {
          dummy.setAllow(false);
          pane.hideFeedbackShape();
        }
        return true;
      } else if (Math.abs(posInitX - motionEvent.getX()) < ((float) minDist)
          && Math.abs(posInitY - motionEvent.getY()) < ((float) minDist)) {
        return false;
      } else {
        currentTouchedView = null;
        handler.removeCallbacks(longPressed);
        return false;
      }
    } else if (action == MotionEvent.ACTION_UP) {
      currentTouchedView = null;
      handler.removeCallbacks(longPressed);
      if (isDragged) {
        paletteBlock.setDragEnabled(true);
        editor.setScrollEnabled(true);
        dummy.setDummyVisibility(8);
        if (dummy.getAllow()) {
          if (bActiveIconDelete) {
            activeIconDelete(false);
            pane.removeBlock((Block) view);
          } else if (view instanceof Block) {
            dummy.getDummyPosition(posDummy);
            if (((Block) view).getBlockType() == 1) {

              pane.blockDropped((Block) view, posDummy[0], posDummy[1], false)
                  .setOnTouchListener(this);
            } else {
              pane.setVisibleBlock((Block) view, 0);
              pane.blockDropped((Block) view, posDummy[0], posDummy[1], true);
            }
            pane.draggingDone();
          }
        } else if (((Block) view).getBlockType() == 0) {
          pane.setVisibleBlock((Block) view, 0);
          if (originalParent != null) {
            if (originalInsertOption == 0) {
              originalParent.nextBlock = ((Integer) view.getTag()).intValue();
            }
            if (originalInsertOption == 2) {
              originalParent.subStack1 = ((Integer) view.getTag()).intValue();
            }
            if (originalInsertOption == 3) {
              originalParent.subStack2 = ((Integer) view.getTag()).intValue();
            }
            if (originalInsertOption == 5) {
              originalParent.replaceArgWithBlock(
                  (BlockBase) originalParent.args.get(originalArgIndex), (Block) view);
            }
            ((Block) view).parentBlock = originalParent;
            originalParent.topBlock().fixLayout();
          } else {
            ((Block) view).topBlock().fixLayout();
          }
        }
        dummy.setAllow(false);
        showIconDelete(false);
        isDragged = false;
        return true;
      }
      if ((view instanceof Block) && ((Block) view).getBlockType() == 0) {
        ((Block) view).actionClick(motionEvent.getX(), motionEvent.getY());
      }
      return false;
    } else if (action == MotionEvent.ACTION_CANCEL) {
      handler.removeCallbacks(longPressed);
      isDragged = false;
      return false;
    } else if (action != MotionEvent.ACTION_POINTER_ID_SHIFT) {
      return true;
    } else {
      handler.removeCallbacks(longPressed);
      isDragged = false;
      return false;
    }
  }

  private boolean hitTestIconDelete(final float x, final float y) {
    return false;
  }

  private void activeIconDelete(final boolean active) {}

  private void showIconDelete(final boolean show) {}

  private void dragStart() {
    if (currentTouchedView != null) {
      paletteBlock.setDragEnabled(false);
      editor.setScrollEnabled(false);
      if (useVibrate) {
        vibrator.vibrate(100);
      }
      isDragged = true;
      if (((Block) currentTouchedView).getBlockType() == 0) {
        getOriginalState((Block) currentTouchedView);
        showIconDelete(true);
        dummy.makeDummyWithBlock((Block) currentTouchedView);
        pane.setVisibleBlock((Block) currentTouchedView, 8);
        pane.removeRelation((Block) currentTouchedView);
      } else {
        dummy.makeDummyWithBlock((Block) currentTouchedView);
      }
      pane.prepareToDrag((Block) currentTouchedView);
      dummy.moveDummy(
          currentTouchedView,
          posInitX,
          posInitY,
          posInitX,
          posInitY,
          (float) BLOCK_DRAG_X,
          (float) BLOCK_DRAG_Y);
      dummy.getDummyPosition(posDummy);
      if (editor.hitTest((float) posDummy[0], (float) posDummy[1])) {
        dummy.setAllow(true);
        pane.updateFeedbackFor((Block) currentTouchedView, posDummy[0], posDummy[1]);
        return;
      }
      dummy.setAllow(false);
      pane.hideFeedbackShape();
    }
  }

  private void getOriginalState(final Block block) {
    originalParent = null;
    originalArgIndex = -1;
    originalInsertOption = 0;
    posOriginal = new int[2];
    block.getLocationOnScreen(posOriginal);
    if (block.parentBlock != null) {
      this.originalParent = block.parentBlock;
    }
    if (this.originalParent != null) {
      if (this.originalParent.nextBlock == ((Integer) block.getTag()).intValue()) {
        this.originalInsertOption = 0;
      } else if (this.originalParent.subStack1 == ((Integer) block.getTag()).intValue()) {
        this.originalInsertOption = 2;
      } else if (this.originalParent.subStack2 == ((Integer) block.getTag()).intValue()) {
        this.originalInsertOption = 3;
      } else if (this.originalParent.args.contains(block)) {
        this.originalInsertOption = 5;
        this.originalArgIndex = this.originalParent.args.indexOf(block);
      }
    }
  }
}

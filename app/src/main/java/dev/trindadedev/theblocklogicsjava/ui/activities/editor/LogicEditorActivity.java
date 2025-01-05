package dev.trindadedev.theblocklogicsjava.ui.activities.editor;

import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dev.trindadedev.theblocklogicsjava.R;
import dev.trindadedev.theblocklogicsjava.databinding.ActivityLogicEditorBinding;
import dev.trindadedev.theblocklogicsjava.ui.base.BaseAppCompatActivity;
import dev.trindadedev.theblocklogicsjava.ui.editor.block.OnBlockCategorySelectListener;
import dev.trindadedev.theblocklogicsjava.utils.LayoutUtil;

public class LogicEditorActivity extends BaseAppCompatActivity
    implements OnBlockCategorySelectListener {

  private ActivityLogicEditorBinding binding;

  @Nullable private String scId;
  private PaletteBlocksManager paletteBlocksManager;
  private Blocks blocks;
  private boolean isPaletteOpen = false;
  private boolean adjustLayout4Runned = false;
  private ObjectAnimator paletteOpenAnimator;
  private ObjectAnimator paletteCloseAnimator;
  private ObjectAnimator blockPaneOpenAnimator;
  private ObjectAnimator blockPaneCloseAnimator;

  @Override
  @NonNull
  protected View bindLayout() {
    binding = ActivityLogicEditorBinding.inflate(getLayoutInflater());
    return binding.getRoot();
  }

  @Override
  protected void onBindLayout(@Nullable final Bundle savedInstanceState) {
    configureData(savedInstanceState);
    configurePaletteManager();
    configureBlockPane();
    configureAnimators(getResources().getConfiguration().orientation);
    updatePalettePosition(getResources().getConfiguration().orientation);
    showHidePalette(!isPaletteOpen);
    binding.fabTogglePalette.setOnClickListener(v -> showHidePalette(!isPaletteOpen));
    binding.paletteBlock.getPaletteSelector().setOnBlockCategorySelectListener(this);
    blocks = new Blocks(paletteBlocksManager);
  }

  @Override
  public void onPostCreate(@Nullable final Bundle bundle) {
    super.onPostCreate(bundle);
    adjustLayout2(getResources().getConfiguration().orientation);
  }

  @Override
  public void onConfigurationChanged(@NonNull final Configuration configuration) {
    super.onConfigurationChanged(configuration);
    adjustLayout2(configuration.orientation);
  }

  @Override
  public void onSaveInstanceState(final Bundle bundle) {
    bundle.putString("sc_id", scId);
  }

  @Override
  public void onBlockCategorySelect(final int id, final int color) {
    paletteBlocksManager.removeAll();
    switch (id) {
      case 0 -> blocks.createVariableBlocksPalette();
      case 1 -> blocks.createListBlocksPalette();
      case 2 -> blocks.createControlBlocksPalette(color);
      case 3 -> blocks.createOperatorBlocksPalette(color);
      case 4 -> blocks.createMathBlocksPalette(color);
      case 5 -> blocks.createFileBlocksPalette(color);
      case 6 -> blocks.createViewBlocksPalette(color);
    }
  }

  /** Get and define all needed variables */
  private final void configureData(@Nullable final Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      scId = getIntent().getStringExtra("sc_id");
    } else {
      scId = savedInstanceState.getString("sc_id");
    }
  }

  /** Configures editor BlockPane */
  private final void configureBlockPane() {
    binding.editor.getBlockPane().setScId(scId);
  }

  private final void configurePaletteManager() {
    paletteBlocksManager = new PaletteBlocksManager(this, binding.paletteBlock);
    var paletteBlockTouchListener = paletteBlocksManager.getPaletteBlockTouchListener();
    paletteBlockTouchListener.dummy = binding.dummy;
    paletteBlockTouchListener.editor = binding.editor;
    paletteBlockTouchListener.paletteBlock = binding.paletteBlock;
    paletteBlockTouchListener.pane = binding.editor.getBlockPane();
  }

  /**
   * Shows or hides the palette according to the current state.
   *
   * @param isPaletteOpen Defines whether the palette should be shown (true) or hidden (false).
   */
  private final void showHidePalette(boolean isPaletteOpen) {
    if (this.isPaletteOpen == isPaletteOpen) {
      return;
    }
    this.isPaletteOpen = isPaletteOpen;

    if (isPaletteOpen) {
      adjustLayout5(false);
    }

    var animator = isPaletteOpen ? paletteOpenAnimator : paletteCloseAnimator;
    animator.start();
    adjustLayout(getResources().getConfiguration().orientation);
  }

  /**
   * Adjusts the layout of the view based on the screen orientation and whether the palette is open.
   * Depending on the orientation (portrait or landscape), the layout width and height are
   * dynamically adjusted. If the palette is open, the width and height are calculated considering
   * the screen dimensions and additional spaces such as the status bar. If the palette is not open,
   * the layout will be set to fill the entire screen.
   *
   * @param orientation The current screen orientation (e.g., 1 for portrait, 2 for landscape).
   */
  public void adjustLayout(int orientation) {
    LinearLayout.LayoutParams layoutParams;
    int layoutHeight;
    int layoutWidth = ViewGroup.LayoutParams.MATCH_PARENT;

    if (isPaletteOpen) {
      int screenWidth = getResources().getDisplayMetrics().widthPixels;
      int screenHeight = getResources().getDisplayMetrics().heightPixels;

      if (screenWidth <= screenHeight) {
        screenWidth = screenHeight;
      }

      if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        layoutWidth = screenWidth - ((int) LayoutUtil.getDip(this, 320.0f));
        layoutHeight = ViewGroup.LayoutParams.MATCH_PARENT;
      } else {
        layoutHeight =
            (screenWidth
                - ((int) LayoutUtil.getDip(this, 48.0f))
                - LayoutUtil.getStatusBarHeight(this)
                - ((int) LayoutUtil.getDip(this, 240.0f)));
      }

      layoutParams = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
    } else {
      layoutParams =
          new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }
    binding.editor.setLayoutParams(layoutParams);
    binding.editor.requestLayout();
  }

  public void adjustLayout2(final int orientation) {
    RelativeLayout.LayoutParams layoutParams;
    int layoutOrientation;
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
      binding.areaPalette.setLayoutParams(
          new LinearLayout.LayoutParams(
              (int) LayoutUtil.getDip(this, 320.0f), ViewGroup.LayoutParams.MATCH_PARENT));
      var params =
          new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      params.gravity = Gravity.CENTER | Gravity.BOTTOM;
      var dimension = (int) getResources().getDimension(R.dimen.action_button_margin);
      params.setMargins(dimension, dimension, dimension, dimension);
      binding.fabTogglePalette.setLayoutParams(params);
      layoutParams =
          new RelativeLayout.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
      layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
      layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
      layoutParams.topMargin = LayoutUtil.getStatusBarHeight(this);
      layoutOrientation = LinearLayout.HORIZONTAL;
    } else {
      binding.areaPalette.setLayoutParams(
          new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, (int) LayoutUtil.getDip(this, 240.0f)));
      LinearLayout.LayoutParams params =
          new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      params.gravity = Gravity.CENTER | Gravity.RIGHT;
      var dimension = (int) getResources().getDimension(R.dimen.action_button_margin);
      params.setMargins(dimension, dimension, dimension, dimension);
      binding.fabTogglePalette.setLayoutParams(params);
      layoutParams =
          new RelativeLayout.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
      layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
      layoutOrientation = LinearLayout.VERTICAL;
    }
    binding.layoutPalette.setOrientation(layoutOrientation);
    binding.layoutPalette.setLayoutParams(layoutParams);
    adjustLayout3(orientation);
    adjustLayout(orientation);
  }

  public void adjustLayout3(int orientation) {
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
      if (!isPaletteOpen) {
        binding.layoutPalette.setTranslationX(LayoutUtil.getDip(this, 320.0F));
      } else {
        binding.layoutPalette.setTranslationX(0.0F);
      }
      binding.layoutPalette.setTranslationY(0.0F);
    } else {
      if (!isPaletteOpen) {
        binding.layoutPalette.setTranslationX(0.0F);
        binding.layoutPalette.setTranslationY(LayoutUtil.getDip(this, 240.0F));
      } else {
        binding.layoutPalette.setTranslationX(0.0F);
        binding.layoutPalette.setTranslationY(0.0F);
      }
    }

    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
      paletteOpenAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_X, 0.0F);
      paletteCloseAnimator =
          ObjectAnimator.ofFloat(
              binding.layoutPalette, View.TRANSLATION_X, LayoutUtil.getDip(this, 320.0F));
    } else {
      paletteOpenAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_Y, 0.0F);
      paletteCloseAnimator =
          ObjectAnimator.ofFloat(
              binding.layoutPalette, View.TRANSLATION_Y, LayoutUtil.getDip(this, 240.0F));
    }

    paletteOpenAnimator.setDuration(500L);
    paletteOpenAnimator.setInterpolator(new DecelerateInterpolator());
    paletteCloseAnimator.setDuration(300L);
    paletteCloseAnimator.setInterpolator(new DecelerateInterpolator());
  }

  public void adjustLayout4() {
    blockPaneOpenAnimator =
        ObjectAnimator.ofFloat(binding.editor.getBlockPane(), View.TRANSLATION_X, 0.0f);
    blockPaneOpenAnimator.setDuration(500L);
    blockPaneOpenAnimator.setInterpolator(new DecelerateInterpolator());
    blockPaneCloseAnimator =
        ObjectAnimator.ofFloat(
            binding.editor.getBlockPane(),
            View.TRANSLATION_X,
            binding.editor.getBlockPane().getHeight());
    blockPaneCloseAnimator.setDuration(300L);
    blockPaneCloseAnimator.setInterpolator(new DecelerateInterpolator());
    adjustLayout4Runned = true;
  }

  public void adjustLayout5(boolean isPaletteOpen) {
    if (!adjustLayout4Runned) {
      adjustLayout4();
    }
    if (isPaletteOpen != isPaletteOpen) {
      adjustLayout5();
      (isPaletteOpen ? blockPaneOpenAnimator : blockPaneCloseAnimator).start();
    }
  }

  public void adjustLayout5() {
    if (blockPaneOpenAnimator.isRunning()) {
      blockPaneOpenAnimator.cancel();
    }
    if (blockPaneCloseAnimator.isRunning()) {
      blockPaneCloseAnimator.cancel();
    }
  }

  /**
   * Sets animators based on screen orientation.
   *
   * @param orientation Current screen orientation (portrait or landscape).
   */
  private final void configureAnimators(int orientation) {
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
      paletteOpenAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_X, 0f);
      paletteCloseAnimator =
          ObjectAnimator.ofFloat(
              binding.layoutPalette, View.TRANSLATION_X, LayoutUtil.getDip(this, 320f));
    } else {
      paletteOpenAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_Y, 0f);
      paletteCloseAnimator =
          ObjectAnimator.ofFloat(
              binding.layoutPalette, View.TRANSLATION_Y, LayoutUtil.getDip(this, 240f));
    }

    paletteOpenAnimator.setDuration(500L);
    paletteOpenAnimator.setInterpolator(new DecelerateInterpolator());
    paletteCloseAnimator.setDuration(300L);
    paletteCloseAnimator.setInterpolator(new DecelerateInterpolator());
  }

  /**
   * Updates the palette's starting position based on the screen orientation.
   *
   * @param orientation Current screen orientation.
   */
  private final void updatePalettePosition(int orientation) {
    float translationX = 0f;
    float translationY = 0f;

    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
      translationX = isPaletteOpen ? 0f : LayoutUtil.getDip(this, 320f);
    } else {
      translationY = isPaletteOpen ? 0f : LayoutUtil.getDip(this, 240f);
    }

    binding.layoutPalette.setTranslationX(translationX);
    binding.layoutPalette.setTranslationY(translationY);
  }
}

package dev.trindadedev.theblocklogicsjava.ui.activities.editor;

import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dev.trindadedev.theblocklogicsjava.R;
import dev.trindadedev.theblocklogicsjava.databinding.ActivityLogicEditorBinding;
import dev.trindadedev.theblocklogicsjava.ui.editor.block.OnBlockCategorySelectListener;
import dev.trindadedev.theblocklogicsjava.utils.LayoutUtil;

public class LogicEditorActivity extends AppCompatActivity
    implements OnBlockCategorySelectListener {

  private ActivityLogicEditorBinding binding;

  @Nullable private String scId;
  private PaletteBlocksManager paletteBlocksManager;
  private boolean isPaletteOpen = false;
  private ObjectAnimator openAnimator;
  private ObjectAnimator closeAnimator;

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLogicEditorBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    configureData(savedInstanceState);
    configureBlockPane();
    configureAnimators(getResources().getConfiguration().orientation);
    updatePalettePosition(getResources().getConfiguration().orientation);
    showHidePalette(!isPaletteOpen);
    binding.fabTogglePalette.setOnClickListener(v -> showHidePalette(!isPaletteOpen));
    binding.paletteBlock.getPaletteSelector().setOnBlockCategorySelectListener(this);
    paletteBlocksManager = new PaletteBlocksManager(binding.paletteBlock);
  }

  @Override
  public void onSaveInstanceState(final Bundle bundle) {
    bundle.putString("sc_id", scId);
  }

  @Override
  public void onBlockCategorySelect(final int id, final int color) {
    binding.paletteBlock.removeAllBlocks();
    switch (id) {
      case 0:
        paletteBlocksManager.addButtonToPalette(
            getString(R.string.logic_btn_add_variable), "variableAdd");
        paletteBlocksManager.addButtonToPalette(
            getString(R.string.logic_btn_remove_variable), "variableRemove");
        return;
      case 1:
        paletteBlocksManager.addButtonToPalette(getString(R.string.logic_btn_add_list), "listAdd");
        paletteBlocksManager.addButtonToPalette(
            getString(R.string.logic_btn_remove_list), "listRemove");

        return;
      case 2:
        paletteBlocksManager.addBlockToPalette("", "c", "repeat", color, Integer.valueOf(10));
        paletteBlocksManager.addBlockToPalette("", "c", "forever", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "f", "break", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "c", "if", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "e", "ifElse", color, new Object[0]);
        return;
      case 3:
        paletteBlocksManager.addBlockToPalette("", "b", "true", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "false", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "<", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "=", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", ">", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "&&", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "||", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "not", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "d", "+", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "d", "-", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "d", "*", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "d", "/", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "d", "%", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette(
            "", "d", "random", color, Integer.valueOf(1), Integer.valueOf(10));
        paletteBlocksManager.addBlockToPalette("", "d", "stringLength", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "s", "stringJoin", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "d", "stringIndex", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "s", "stringSub", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "stringEquals", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "d", "toNumber", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "s", "toString", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "s", "trim", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "s", "toUpperCase", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "s", "toLowerCase", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", " ", "addSourceDirectly", color, new Object[0]);
        return;
      case 4:
        paletteBlocksManager.addBlockToPalette("", " ", "setEnable", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "b", "getEnable", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", " ", "setVisible", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", " ", "setText", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", "s", "getText", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", " ", "setBgColor", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", " ", "setTextColor", color, new Object[0]);
        paletteBlocksManager.addBlockToPalette("", " ", "doToast", -13851166, new Object[0]);

        return;
      case 5:
        paletteBlocksManager.addButtonToPalette(
            getString(R.string.logic_btn_make_block), "blockAdd");
        return;
      default:
        return;
    }
  }

  /** Get and define all needed variables */
  private void configureData(@Nullable final Bundle savedInstanceState) {
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

    var animator = isPaletteOpen ? openAnimator : closeAnimator;
    animator.start();
  }

  /**
   * Sets animators based on screen orientation.
   *
   * @param orientation Current screen orientation (portrait or landscape).
   */
  private final void configureAnimators(int orientation) {
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
      openAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_X, 0f);
      closeAnimator =
          ObjectAnimator.ofFloat(
              binding.layoutPalette, View.TRANSLATION_X, LayoutUtil.getDip(this, 320f));
    } else {
      openAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_Y, 0f);
      closeAnimator =
          ObjectAnimator.ofFloat(
              binding.layoutPalette, View.TRANSLATION_Y, LayoutUtil.getDip(this, 240f));
    }

    openAnimator.setDuration(500L);
    openAnimator.setInterpolator(new DecelerateInterpolator());
    closeAnimator.setDuration(300L);
    closeAnimator.setInterpolator(new DecelerateInterpolator());
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

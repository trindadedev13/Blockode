package dev.trindadedev.theblocklogicsjava.ui.activities.editor;

import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dev.trindadedev.theblocklogicsjava.databinding.ActivityLogicEditorBinding;
import dev.trindadedev.theblocklogicsjava.utils.LayoutUtil;

public class LogicEditorActivity extends AppCompatActivity {

  private ActivityLogicEditorBinding binding;

  @Nullable
  private String scId;
  
  private boolean isPaletteOpen = false;
  private ObjectAnimator openAnimator;
  private ObjectAnimator closeAnimator;

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLogicEditorBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    configureData();
    configureBlockPane();
    configureAnimators(getResources().getConfiguration().orientation);
    binding.fabTogglePalette.setOnClickListener(v -> showHidePalette(!isPaletteOpen));
  }

  @Override
  public void onSaveInstanceState(final Bundle bundle) {
    bundle.putString("sc_id", scId);
  }

  /** Get and define all needed variables */
  private void configureData() {
    if (savedInstanceState == null) {
      scId = getIntent().getStringExtra("sc_id");
    } else {
      scId = savedInstanceState.getString("sc_id");
    }
  }

  /** Configures editor BlockPane */,
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
      closeAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_X, LayoutUtil.getDip(this, 320f));
    } else {
      openAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_Y, 0f);
      closeAnimator = ObjectAnimator.ofFloat(binding.layoutPalette, View.TRANSLATION_Y, LayoutUtil.getDip(this, 240f));
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
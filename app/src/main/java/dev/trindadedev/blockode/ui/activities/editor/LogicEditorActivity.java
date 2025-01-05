package dev.trindadedev.blockode.ui.activities.editor;

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
import com.google.android.material.appbar.MaterialToolbar;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.databinding.ActivityLogicEditorBinding;
import dev.trindadedev.blockode.ui.base.BaseAppCompatActivity;
import dev.trindadedev.blockode.ui.editor.block.OnBlockCategorySelectListener;
import dev.trindadedev.blockode.utils.LayoutUtil;

public class LogicEditorActivity extends BaseAppCompatActivity
    implements OnBlockCategorySelectListener {

  private ActivityLogicEditorBinding binding;

  @Nullable private EditorState editorState;
  private PaletteBlocksManager paletteBlocksManager;
  private Blocks blocks;
  private PaletteAnimator paletteAnimator;

  @Override
  @NonNull
  protected View bindLayout() {
    binding = ActivityLogicEditorBinding.inflate(getLayoutInflater());
    return binding.getRoot();
  }

  @Override
  protected void onBindLayout(@Nullable final Bundle savedInstanceState) {
    configureData(savedInstanceState);
    configurePaletteAnimator();
    configurePaletteManager();
    configureBlockPane();
    configureToolbar(binding.toolbar);
    binding.paletteBlock.getPaletteSelector().setOnBlockCategorySelectListener(this);
    blocks = new Blocks(paletteBlocksManager);
  }

  @Override
  public void onPostCreate(@Nullable final Bundle bundle) {
    super.onPostCreate(bundle);
    blocks.createRoot(editorState.getClassName());
    paletteAnimator.adjustLayout2(getResources().getConfiguration().orientation);
  }

  @Override
  public void onConfigurationChanged(@NonNull final Configuration configuration) {
    super.onConfigurationChanged(configuration);
    paletteAnimator.adjustLayout2(configuration.orientation);
  }

  @Override
  public void onSaveInstanceState(final Bundle bundle) {
    bundle.putSerializable("editor_state", editorState);
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
  
  @Override
  protected void configureToolbar(@NonNull MaterialToolbar toolbar) {
    super.configureToolbar(toolbar);
    toolbar.setSubtitle(editorState.getClassName());
  }
  

  /** Get and define all needed variables */
  private final void configureData(@Nullable final Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      editorState = getSerializable("editor_state", EditorState.class);
    } else {
      editorState = getSerializable(savedInstanceState, "editor_state", EditorState.class);
    }
  }

  /** Configures editor BlockPane */
  private final void configureBlockPane() {
    binding.editor.getBlockPane().setScId(editorState.getScId());
  }

  private final void configurePaletteAnimator() {
    paletteAnimator = new PaletteAnimator(this);
    paletteAnimator.fabTogglePalette = binding.fabTogglePalette;
    paletteAnimator.editor = binding.editor;
    paletteAnimator.layoutPalette = binding.layoutPalette;
    paletteAnimator.areaPalette = binding.areaPalette;
    paletteAnimator.configureAnimators(getResources().getConfiguration().orientation);
    paletteAnimator.updatePalettePosition(getResources().getConfiguration().orientation);
    paletteAnimator.showHidePalette(!paletteAnimator.isPaletteOpen);
    binding.fabTogglePalette.setOnClickListener(
        v -> paletteAnimator.showHidePalette(!paletteAnimator.isPaletteOpen));
  }

  private final void configurePaletteManager() {
    paletteBlocksManager = new PaletteBlocksManager(this, binding.paletteBlock);
    paletteBlocksManager.setBlockPane(binding.editor.getBlockPane());
    var paletteBlockTouchListener = paletteBlocksManager.getPaletteBlockTouchListener();
    paletteBlockTouchListener.dummy = binding.dummy;
    paletteBlockTouchListener.editor = binding.editor;
    paletteBlockTouchListener.paletteBlock = binding.paletteBlock;
    paletteBlockTouchListener.pane = binding.editor.getBlockPane();
  }
}

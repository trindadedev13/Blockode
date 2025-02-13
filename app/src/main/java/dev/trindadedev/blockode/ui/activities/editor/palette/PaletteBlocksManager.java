package dev.trindadedev.blockode.ui.activities.editor.palette;

import android.content.Context;
import androidx.annotation.NonNull;
import dev.trindadedev.blockode.ui.components.editor.block.BlockPane;
import dev.trindadedev.blockode.ui.components.editor.block.PaletteBlock;

public class PaletteBlocksManager {

  private Context context;
  private PaletteBlock paletteBlock;
  private PaletteButtonClickListener paletteButtonClickListener;
  private PaletteBlockTouchListener paletteBlockTouchListener;
  private BlockPane blockPane;
  private String scId;

  public PaletteBlocksManager(final Context context, final PaletteBlock paletteBlock) {
    paletteButtonClickListener = new PaletteButtonClickListener(context, scId);
    paletteBlockTouchListener = new PaletteBlockTouchListener(context);
    setPaletteBlock(paletteBlock);
    setContext(context);
  }

  public void addBlockToPalette(
      final String str, final String type, final String opCode, final int color, Object... objArr) {
    var block = paletteBlock.addBlock(str, type, opCode, color, objArr);
    block.setClickable(true);
    block.setOnTouchListener(paletteBlockTouchListener);
  }

  public void addButtonToPalette(String text, String id) {
    var button = paletteBlock.addButton(text);
    button.setTag(id);
    button.setSoundEffectsEnabled(true);
    button.setOnClickListener(paletteButtonClickListener);
  }

  public void removeAll() {
    paletteBlock.removeAllBlocks();
  }

  @NonNull
  public Context getContext() {
    return this.context;
  }

  public void setContext(@NonNull Context context) {
    this.context = context;
  }

  @NonNull
  public PaletteBlock getPaletteBlock() {
    return this.paletteBlock;
  }

  public void setPaletteBlock(@NonNull PaletteBlock paletteBlock) {
    this.paletteBlock = paletteBlock;
  }

  @NonNull
  public PaletteButtonClickListener getPaletteButtonClickListener() {
    return this.paletteButtonClickListener;
  }

  public void setPaletteButtonClickListener(
      @NonNull PaletteButtonClickListener paletteButtonClickListener) {
    this.paletteButtonClickListener = paletteButtonClickListener;
  }

  @NonNull
  public PaletteBlockTouchListener getPaletteBlockTouchListener() {
    return this.paletteBlockTouchListener;
  }

  public void setPaletteBlockTouchListener(
      @NonNull PaletteBlockTouchListener paletteBlockTouchListener) {
    this.paletteBlockTouchListener = paletteBlockTouchListener;
  }

  @NonNull
  public BlockPane getBlockPane() {
    return this.blockPane;
  }

  public void setBlockPane(@NonNull final BlockPane blockPane) {
    this.blockPane = blockPane;
  }

  public String getScId() {
    return this.scId;
  }

  public void setScId(String scId) {
    this.scId = scId;
    paletteButtonClickListener.setScId(scId);
  }
}

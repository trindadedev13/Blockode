package dev.trindadedev.theblocklogicsjava.ui.activities.editor;

import android.content.Context;
import dev.trindadedev.theblocklogicsjava.ui.editor.block.PaletteBlock;

public class PaletteBlocksManager {

  private Context context;
  private PaletteBlock paletteBlock;
  private PaletteButtonClickListener paletteButtonClickListener;
  private PaletteBlockTouchListener paletteBlockTouchListener;

  public PaletteBlocksManager(final Context context, final PaletteBlock paletteBlock) {
    paletteButtonClickListener = new PaletteButtonClickListener();
    paletteBlockTouchListener = new PaletteBlockTouchListener(context);
    setPaletteBlock(paletteBlock);
    setContext(context);
  }

  public void addBlockToPalette(String str, String str2, String str3, int i, Object... objArr) {
    var block = paletteBlock.addBlock(str, str2, str3, i, objArr);
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

  public Context getContext() {
    return this.context;
  }

  public void setContext(Context context) {
    this.context = context;
  }

  public PaletteBlock getPaletteBlock() {
    return this.paletteBlock;
  }

  public void setPaletteBlock(PaletteBlock paletteBlock) {
    this.paletteBlock = paletteBlock;
  }

  public PaletteButtonClickListener getPaletteButtonClickListener() {
    return this.paletteButtonClickListener;
  }

  public void setPaletteButtonClickListener(PaletteButtonClickListener paletteButtonClickListener) {
    this.paletteButtonClickListener = paletteButtonClickListener;
  }

  public PaletteBlockTouchListener getPaletteBlockTouchListener() {
    return this.paletteBlockTouchListener;
  }

  public void setPaletteBlockTouchListener(PaletteBlockTouchListener paletteBlockTouchListener) {
    this.paletteBlockTouchListener = paletteBlockTouchListener;
  }
}

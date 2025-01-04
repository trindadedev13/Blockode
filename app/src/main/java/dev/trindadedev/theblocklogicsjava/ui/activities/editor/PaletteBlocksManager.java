package dev.trindadedev.theblocklogicsjava.ui.activities.editor;

import dev.trindadedev.theblocklogicsjava.ui.editor.block.PaletteBlock;

public class PaletteBlocksManager {
  private PaletteBlock paletteBlock;

  public PaletteBlocksManager(final PaletteBlock paletteBlock) {
    setPaletteBlock(paletteBlock);
  }

  public void addBlockToPalette(String str, String str2, String str3, int i, Object... objArr) {
    var block = paletteBlock.addBlock(str, str2, str3, i, objArr);
    block.setClickable(true);
    /* TODO block.setOnTouchListener(this); */
  }

  public void addButtonToPalette(String text, String id) {
    var button = paletteBlock.addButton(text);
    button.setTag(id);
    button.setSoundEffectsEnabled(true);
    /* TODO  button.setOnClickListener(this); */
  }

  public void setPaletteBlock(final PaletteBlock paletteBlock) {
    this.paletteBlock = paletteBlock;
  }

  public PaletteBlock getPaletteBlock() {
    return paletteBlock;
  }
}

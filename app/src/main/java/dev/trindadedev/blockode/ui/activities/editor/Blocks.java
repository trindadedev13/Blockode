package dev.trindadedev.blockode.ui.activities.editor;

import static dev.trindadedev.blockode.utils.StringUtil.getString;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.Blockode;
import dev.trindadedev.blockode.utils.SpecUtil;

public class Blocks {
  private PaletteBlocksManager paletteBlocksManager;

  public Blocks(final PaletteBlocksManager paletteBlockManager) {
    this.paletteBlocksManager = paletteBlockManager;
  }
  
  @Nullable
  public void createRoot(@Nullable final String className) {
    paletteBlocksManager.getBlockPane().addRoot(SpecUtil.getSpecForFileName(className), className);
  }

  public void createVariableBlocksPalette() {
    paletteBlocksManager.addButtonToPalette(
        getString(R.string.logic_btn_add_variable), ButtonsTag.BUTTON_ADD_VARIABLE);
    paletteBlocksManager.addButtonToPalette(
        getString(R.string.logic_btn_remove_variable), ButtonsTag.BUTTON_REMOVE_VARIABLE);
  }

  public void createListBlocksPalette() {
    paletteBlocksManager.addButtonToPalette(
        getString(R.string.logic_btn_add_list), ButtonsTag.BUTTON_ADD_LIST);
    paletteBlocksManager.addButtonToPalette(
        getString(R.string.logic_btn_remove_list), ButtonsTag.BUTTON_REMOVE_VARIABLE);
  }

  public void createControlBlocksPalette(final int color) {
    paletteBlocksManager.addBlockToPalette("", "c", "repeat", color, Integer.valueOf(10));
    paletteBlocksManager.addBlockToPalette("", "c", "forever", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", "f", "break", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", "c", "if", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", "e", "ifElse", color, new Object[0]);
  }

  public void createOperatorBlocksPalette(final int color) {
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
  }

  public void createMathBlocksPalette(final int color) {}

  public void createFileBlocksPalette(final int color) {}

  public void createViewBlocksPalette(final int color) {
    paletteBlocksManager.addBlockToPalette("", " ", "setEnable", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", "b", "getEnable", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", " ", "setVisible", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", " ", "setText", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", "s", "getText", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", " ", "setBgColor", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", " ", "setTextColor", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", " ", "doToast", -13851166, new Object[0]);
  }
}

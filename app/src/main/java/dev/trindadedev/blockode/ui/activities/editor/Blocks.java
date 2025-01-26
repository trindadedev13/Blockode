package dev.trindadedev.blockode.ui.activities.editor;

import android.util.Pair;
import dev.trindadedev.blockode.beans.VariableBean;
import dev.trindadedev.blockode.ui.editor.manager.VariablesManager;
import static dev.trindadedev.blockode.utils.StringUtil.getString;

import androidx.annotation.Nullable;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.utils.SpecUtil;
import java.util.Iterator;
import java.util.List;

public class Blocks {
  private PaletteBlocksManager paletteBlocksManager;
  private VariablesManager variablesManager;

  public Blocks(final PaletteBlocksManager paletteBlockManager) {
    this.paletteBlocksManager = paletteBlockManager;
    this.variablesManager =
        paletteBlockManager.getPaletteButtonClickListener().getVariablesManager();
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
    addVariablesFromVariablesManager();
  }

  private void addVariablesFromVariablesManager() {
    variablesManager.setScId(paletteBlocksManager.getScId());
    List<VariableBean> variables = variablesManager.getVariables();
    int i = 0;
    int i2 = 0;
    int i3 = 0;

    for (VariableBean variable : variables) {
      int type = variable.type;
      String variableName = variable.name;

      if (type == 0) {
        paletteBlocksManager.addBlockToPalette(
            variableName, "b", "getVar", -1147626, new Object[0]);
        i3++;
      } else if (type == 1) {
        paletteBlocksManager.addBlockToPalette(
            variableName, "d", "getVar", -1147626, new Object[0]);
        i2++;
      } else {
        paletteBlocksManager.addBlockToPalette(
            variableName, "s", "getVar", -1147626, new Object[0]);
        i++;
      }
    }

    if (i3 > 0) {
      paletteBlocksManager.addBlockToPalette("", " ", "setVarBoolean", -1147626, new Object[0]);
    }
    if (i2 > 0) {
      paletteBlocksManager.addBlockToPalette("", " ", "setVarInt", -1147626, new Object[0]);
      paletteBlocksManager.addBlockToPalette("", " ", "increaseInt", -1147626, new Object[0]);
      paletteBlocksManager.addBlockToPalette("", " ", "decreaseInt", -1147626, new Object[0]);
    }
    if (i > 0) {
      paletteBlocksManager.addBlockToPalette("", " ", "setVarString", -1147626, new Object[0]);
    }
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

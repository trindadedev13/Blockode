package dev.trindadedev.blockode.ui.activities.editor;

import dev.trindadedev.blockode.utils.BlockUtil;
import static dev.trindadedev.blockode.utils.StringUtil.getString;

import androidx.annotation.Nullable;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.beans.VariableBean;
import dev.trindadedev.blockode.ui.editor.manager.VariablesManager;
import dev.trindadedev.blockode.utils.SpecUtil;
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
            variableName, BlockUtil.BLOCK_TYPE_BOOLEAN, BlockUtil.BLOCK_OPCODE_GET_VAR, BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
        i3++;
      } else if (type == 1) {
        paletteBlocksManager.addBlockToPalette(
            variableName, BlockUtil.BLOCK_TYPE_INTEGER, BlockUtil.BLOCK_OPCODE_GET_VAR, BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
        i2++;
      } else {
        paletteBlocksManager.addBlockToPalette(
            variableName, BlockUtil.BLOCK_TYPE_STRING, BlockUtil.BLOCK_OPCODE_GET_VAR, BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
        i++;
      }
    }

    if (i3 > 0) {
      paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_COMMAND, BlockUtil.BLOCK_OPCODE_SET_VAR_BOOL, BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
    }
    if (i2 > 0) {
      paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_COMMAND, BlockUtil.BLOCK_OPCODE_SET_VAR_INT, BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
      paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_COMMAND, "increaseInt", BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
      paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_COMMAND, "decreaseInt", BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
    }
    if (i > 0) {
      paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_COMMAND, BlockUtil.BLOCK_OPCODE_SET_VAR_STR, BlockUtil.BLOCK_COLOR_VARIABLE, new Object[0]);
    }
  }

  public void createListBlocksPalette() {
    paletteBlocksManager.addButtonToPalette(
        getString(R.string.logic_btn_add_list), ButtonsTag.BUTTON_ADD_LIST);
    paletteBlocksManager.addButtonToPalette(
        getString(R.string.logic_btn_remove_list), ButtonsTag.BUTTON_REMOVE_VARIABLE);
  }

  public void createControlBlocksPalette(final int color) {
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_LOOP, "repeat", color, Integer.valueOf(10));
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_LOOP, "forever", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_FINAL, "break", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_LOOP, "if", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_IFELSE, "ifElse", color, new Object[0]);
  }

  public void createOperatorBlocksPalette(final int color) {
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "true", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "false", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "<", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "=", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, ">", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "&&", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "||", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "not", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "+", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "-", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "*", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "/", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "%", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette(
        "", BlockUtil.BLOCK_TYPE_INTEGER, "random", color, Integer.valueOf(1), Integer.valueOf(10));
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "stringLength", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_STRING, "stringJoin", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "stringIndex", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_STRING, "stringSub", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_BOOLEAN, "stringEquals", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_INTEGER, "toNumber", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_STRING, "toString", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_STRING, "trim", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_STRING, "toUpperCase", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_STRING, "toLowerCase", color, new Object[0]);
    paletteBlocksManager.addBlockToPalette("", BlockUtil.BLOCK_TYPE_COMMAND, "addSourceDirectly", color, new Object[0]);
  }

  public void createMathBlocksPalette(final int color) {}

  public void createFileBlocksPalette(final int color) {}
}

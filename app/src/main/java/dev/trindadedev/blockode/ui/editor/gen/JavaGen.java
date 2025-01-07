package dev.trindadedev.blockode.ui.editor.gen;

import androidx.annotation.NonNull;
import dev.trindadedev.blockode.beans.BlockBean;
import dev.trindadedev.blockode.utils.BlockUtil;

public class JavaGen {

  public String getBlockCode(final BlockBean bean) {
    var toReturnCode = "";
    var params = bean.parameters;
    toReturnCode =
        switch (bean.opCode) {
          case BlockUtil.BLOCK_OPCODE_DEFINED_FUNC -> null;
          case BlockUtil.BLOCK_OPCODE_GET_VAR -> bean.spec;
          case BlockUtil.BLOCK_OPCODE_SET_VAR_BOOL,
              BlockUtil.BLOCK_OPCODE_SET_VAR_STR,
              BlockUtil.BLOCK_OPCODE_SET_VAR_INT -> format(
              "%s = %s;", params.get(0), params.get(1));
          default -> "Not possible to generate";
        };
    return toReturnCode;
  }

  @NonNull
  private String format(final String code, final Object... params) {
    return String.format(code, params);
  }
}

package dev.trindadedev.blockode.editor.generator;

import dev.trindadedev.blockode.beans.BlockBean;
import dev.trindadedev.blockode.utils.BlockUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

public class JavaGenerator {

  private final List<BlockBean> blocks;
  private final Map<String, BlockBean> blockMap = new HashMap<>();

  public JavaGenerator(final List<BlockBean> blocks) {
    this.blocks = blocks != null ? blocks : new ArrayList<>();
    for (BlockBean bean : this.blocks) {
      blockMap.put(bean.id, bean);
    }
  }

  public String generate() {
    final var code = new StringBuilder();
    final Set<String> processedBlocks = new HashSet<>();

    for (BlockBean block : blocks) {
      if (!processedBlocks.contains(block.id)) {
        code.append(generateBlock(block, processedBlocks)).append("\n");
      }
    }

    return code.toString().trim();
  }

  private String generateBlock(BlockBean bean, Set<String> processedBlocks) {
    if (bean == null || processedBlocks.contains(bean.id)) return "";
    processedBlocks.add(bean.id);

    final List<String> params = getBlockParams(bean);
    final var code = new StringBuilder();

    switch (bean.opCode) {
      case BlockUtil.BLOCK_OPCODE_DEFINED_FUNC -> code.append("");
      case BlockUtil.BLOCK_OPCODE_GET_ARG -> {
        if (bean.parameters.size() <= 0) {
          int specIndexOf = bean.spec.indexOf(" ");
          if (specIndexOf < 0) {
            code.append(bean.spec + "();");
          } else {
            code.append(bean.spec.substring(0, specIndexOf) + "();");
          }
        } else {
          final var specIndexOf = bean.spec.indexOf(" ");
          final var specSubStr = bean.spec.substring(0, specIndexOf);
          var specSubStrP = specSubStr + "(";
          boolean var203 = true;

          for (int blockode = 0; blockode < params.size(); var203 = false) {
            if (!var203) {
              specSubStrP = specSubStrP + ", ";
            }

            var param = params.get(blockode);
            var paramType = bean.parametersTypes.get(blockode);
            if (param.length() <= 0) {
              if (paramType.equals("b")) {
                specSubStrP = specSubStrP + "true";
              } else if (paramType.equals("d")) {
                specSubStrP = specSubStrP + "0";
              }
            } else {
              specSubStrP = specSubStrP + param;
            }

            ++blockode;
          }

          code.append(specSubStrP + ");");
        }
      }

      case BlockUtil.BLOCK_OPCODE_GET_VAR -> code.append(bean.spec);
      case BlockUtil.BLOCK_OPCODE_SET_VAR_BOOL,
          BlockUtil.BLOCK_OPCODE_SET_VAR_STR,
          BlockUtil.BLOCK_OPCODE_SET_VAR_INT -> {
        if (params.size() < 2) return "/* Invalid block params */";
        code.append(params.get(0)).append(" = ").append(params.get(1)).append(";");
      }
      case BlockUtil.BLOCK_OPCODE_DO_PRINT -> {
        if (params.isEmpty()) return "/* Missing parameter */";
        code.append("System.out.println(").append(params.get(0)).append(");");
      }
      case BlockUtil.BLOCK_OPCODE_ADD_SOURCE_DIRECTLY -> {
        if (params.isEmpty()) return "/* Missing source code */";
        code.append(params.get(0));
      }
      case BlockUtil.BLOCK_OPCODE_FOREVER -> {
        if (bean.subStack1 < 0) {
          code.append("while(true) {}");
        } else {
          final var loopBody =
              generateBlock(blockMap.get(String.valueOf(bean.subStack1)), processedBlocks);
          code.append("while(true) {\n  ").append(loopBody.replace("\n", "\n  ")).append("\n}");
        }
        return code.toString();
      }
      default -> code.append("/* Unsupported block: ").append(bean.opCode).append(" */");
    }

    if (bean.nextBlock >= 0) {
      final var next = blockMap.get(String.valueOf(bean.nextBlock));
      if (next != null) {
        code.append("\n").append(generateBlock(next, processedBlocks));
      }
    }

    return code.toString();
  }

  private List<String> getBlockParams(final BlockBean bean) {
    final List<String> params = new ArrayList<>();
    if (bean.parameters == null || bean.parametersTypes == null) return params;

    for (int i = 0; i < bean.parameters.size(); i++) {
      final String param = bean.parameters.get(i);
      final int type = parseType(bean.parametersTypes.get(i));
      params.add(formatParam(param, type));
    }
    return params;
  }

  private int parseType(final String typeStr) {
    try {
      return Integer.parseInt(typeStr);
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private String formatParam(final String param, final int type) {
    if (param == null) return "";

    return switch (type) {
      case 2 -> "\"" + escapeString(param) + "\"";
      case 1 -> isNumber(param) ? param + (param.contains(".") ? "d" : "") : param;
      case 0 -> param.isEmpty() ? "true" : param;
      default -> param;
    };
  }

  private boolean isNumber(final String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private String escapeString(final String input) {
    return input.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
  }
}

package dev.trindadedev.blockode.utils;

import dev.trindadedev.blockode.R;

public class BlockUtil {
  public static final int BLOCK_COLOR_ALL = -16740914;
  public static final int BLOCK_COLOR_ARG_BOOL = 1342177280;
  public static final int BLOCK_COLOR_ARG_FLOAT = -3155748;
  public static final int BLOCK_COLOR_ARG_INT = -657931;
  public static final int BLOCK_COLOR_ARG_SELECTABLE = 805306368;
  public static final int BLOCK_COLOR_ARG_STR = -1;
  public static final int BLOCK_COLOR_CONTROL = -1988310;
  public static final int BLOCK_COLOR_HAT = -3636432;
  public static final int BLOCK_COLOR_VARIABLE = 0xffee7d16;
  public static final int BLOCK_COLOR_VARIABLE_BOOL = -1499549;
  public static final int BLOCK_COLOR_VARIABLE_FLOAT = -10457717;
  public static final int BLOCK_COLOR_VARIABLE_INT = -16738680;
  public static final int BLOCK_COLOR_VARIABLE_STR = -8825528;
  public static final int BLOCK_COLOR_LIST = 0xffcc5b22;
  public static final int BLOCK_COLOR_OPERATORS = -10701022;
  public static final int BLOCK_COLOR_MATH = 0xff23b9a9;
  public static final int BLOCK_COLOR_FILE = 0xffa1887f;
  public static final int BLOCK_COLOR_MOREBLOCKS = -7711273;
  public static final int BLOCK_COLOR_MOREBLOCK_BOOL = -4056997;
  public static final int BLOCK_COLOR_MOREBLOCK_FLOAT = -12232092;
  public static final int BLOCK_COLOR_MOREBLOCK_INT = -16746133;
  public static final int BLOCK_COLOR_MOREBLOCK_STR = -10665929;

  public static final String BLOCK_OPCODE_AND = "&&";
  public static final String BLOCK_OPCODE_BREAK = "break";
  public static final String BLOCK_OPCODE_DECREASE_INT = "decreaseInt";
  public static final String BLOCK_OPCODE_DEFINED_FUNC = "definedFunc";
  public static final String BLOCK_OPCODE_DIVIDE = "/";
  public static final String BLOCK_OPCODE_DIVIDE_REST = "%";
  public static final String BLOCK_OPCODE_DO_PRINT = "doPrint";
  public static final String BLOCK_OPCODE_FALSE = "false";
  public static final String BLOCK_OPCODE_FOREVER = "forever";
  public static final String BLOCK_OPCODE_GET_ARG = "getArg";
  public static final String BLOCK_OPCODE_GET_VAR = "getVar";
  public static final String BLOCK_OPCODE_IF = "if";
  public static final String BLOCK_OPCODE_IFELSE = "ifElse";
  public static final String BLOCK_OPCODE_INCREASE_INT = "increaseInt";
  public static final String BLOCK_OPCODE_MATH_EQUAL = "=";
  public static final String BLOCK_OPCODE_MATH_GREAT = ">";
  public static final String BLOCK_OPCODE_MATH_LESS = "<";
  public static final String BLOCK_OPCODE_MINUS = "-";
  public static final String BLOCK_OPCODE_MULTIPLY = "*";
  public static final String BLOCK_OPCODE_NOT = "not";
  public static final String BLOCK_OPCODE_OR = "||";
  public static final String BLOCK_OPCODE_PLUS = "+";
  public static final String BLOCK_OPCODE_RANDOM = "random";
  public static final String BLOCK_OPCODE_REPEAT = "repeat";
  public static final String BLOCK_OPCODE_SET_VAR_BOOL = "setVarBoolean";
  public static final String BLOCK_OPCODE_SET_VAR_INT = "setVarInt";
  public static final String BLOCK_OPCODE_SET_VAR_STR = "setVarString";
  public static final String BLOCK_OPCODE_SET_VISIBLE = "setVisible";
  public static final String BLOCK_OPCODE_STR_CONTAINS = "stringContains";
  public static final String BLOCK_OPCODE_STR_EQUAL = "stringEquals";
  public static final String BLOCK_OPCODE_STR_INDEX = "stringIndex";
  public static final String BLOCK_OPCODE_STR_JOIN = "stringJoin";
  public static final String BLOCK_OPCODE_STR_LENGTH = "stringLength";
  public static final String BLOCK_OPCODE_STR_REPLACE = "stringReplace";
  public static final String BLOCK_OPCODE_STR_REPLACE_ALL = "stringReplaceAll";
  public static final String BLOCK_OPCODE_STR_REPLACE_FIRST = "stringReplaceFirst";
  public static final String BLOCK_OPCODE_STR_SUB = "stringSub";
  public static final String BLOCK_OPCODE_TIMER_AFTER = "timerAfter";
  public static final String BLOCK_OPCODE_TIMER_CANCEL = "timerCancel";
  public static final String BLOCK_OPCODE_TIMER_EVERY = "timerEvery";
  public static final String BLOCK_OPCODE_TOLOWERCASE = "toLowerCase";
  public static final String BLOCK_OPCODE_TOUPPERCASE = "toUpperCase";
  public static final String BLOCK_OPCODE_TO_NUMBER = "toNumber";
  public static final String BLOCK_OPCODE_TO_STRING = "toString";
  public static final String BLOCK_OPCODE_TRIM = "trim";
  public static final String BLOCK_OPCODE_TRUE = "true";
  public static final String BLOCK_OPCODE_ADD_SOURCE_DIRECTLY = "addSourceDirectly";

  public static final String BLOCK_TYPE_BOOLEAN = "b";
  public static final String BLOCK_TYPE_COMMAND = " ";
  public static final String BLOCK_TYPE_DROPDOWN = "m";
  public static final String BLOCK_TYPE_FINAL = "f";
  public static final String BLOCK_TYPE_FINALLOOP = "cf";
  public static final String BLOCK_TYPE_FLOAT = "n";
  public static final String BLOCK_TYPE_HAT = "h";
  public static final String BLOCK_TYPE_IFELSE = "e";
  public static final String BLOCK_TYPE_INTEGER = "d";
  public static final String BLOCK_TYPE_LOOP = "c";
  public static final String BLOCK_TYPE_STRING = "s";

  public static final int VAR_TYPE_BOOLEAN = 0;
  public static final int VAR_TYPE_INTEGER = 1;
  public static final int VAR_TYPE_STRING = 2;

  public static int getBlockColor(final String opCode, final String type) {
    if (type.equals(BLOCK_TYPE_HAT)) return BLOCK_COLOR_HAT;
    return switch (opCode) {
      case BLOCK_OPCODE_SET_VAR_INT,
              BLOCK_OPCODE_SET_VAR_STR,
              BLOCK_OPCODE_SET_VAR_BOOL,
              BLOCK_OPCODE_GET_ARG,
              BLOCK_OPCODE_GET_VAR,
              BLOCK_OPCODE_DECREASE_INT,
              BLOCK_OPCODE_INCREASE_INT ->
          BLOCK_COLOR_VARIABLE;
      case BLOCK_OPCODE_REPEAT,
              BLOCK_OPCODE_FOREVER,
              BLOCK_OPCODE_BREAK,
              BLOCK_OPCODE_IF,
              BLOCK_OPCODE_IFELSE ->
          BLOCK_COLOR_CONTROL;
      case BLOCK_OPCODE_TRUE,
              BLOCK_OPCODE_FALSE,
              BLOCK_OPCODE_MATH_EQUAL,
              BLOCK_OPCODE_MATH_GREAT,
              BLOCK_OPCODE_MATH_LESS,
              BLOCK_OPCODE_AND,
              BLOCK_OPCODE_OR,
              BLOCK_OPCODE_NOT,
              BLOCK_OPCODE_PLUS,
              BLOCK_OPCODE_MINUS,
              BLOCK_OPCODE_MULTIPLY,
              BLOCK_OPCODE_DIVIDE,
              BLOCK_OPCODE_DIVIDE_REST,
              BLOCK_OPCODE_RANDOM,
              BLOCK_OPCODE_STR_LENGTH,
              BLOCK_OPCODE_STR_SUB,
              BLOCK_OPCODE_STR_JOIN,
              BLOCK_OPCODE_STR_INDEX,
              BLOCK_OPCODE_STR_EQUAL,
              BLOCK_OPCODE_TO_NUMBER,
              BLOCK_OPCODE_TO_STRING,
              BLOCK_OPCODE_TRIM,
              BLOCK_OPCODE_TOUPPERCASE,
              BLOCK_OPCODE_TOLOWERCASE,
              BLOCK_OPCODE_ADD_SOURCE_DIRECTLY ->
          BLOCK_COLOR_OPERATORS;
      default -> BLOCK_COLOR_MOREBLOCKS;
    };
  }

  public static String getSpecString(final String opCode, final String type) {
    return switch (opCode) {
      case BLOCK_OPCODE_SET_VAR_BOOL -> StringUtil.getString(R.string.block_set_var_bool);
      case BLOCK_OPCODE_SET_VAR_INT -> StringUtil.getString(R.string.block_set_var_int);
      case BLOCK_OPCODE_SET_VAR_STR -> StringUtil.getString(R.string.block_set_var_str);
      case BLOCK_OPCODE_INCREASE_INT -> StringUtil.getString(R.string.block_increase_int);
      case BLOCK_OPCODE_DECREASE_INT -> StringUtil.getString(R.string.block_decrease_int);
      case BLOCK_OPCODE_REPEAT -> StringUtil.getString(R.string.block_repeat);
      case BLOCK_OPCODE_FOREVER -> StringUtil.getString(R.string.block_forever);
      case BLOCK_OPCODE_BREAK -> StringUtil.getString(R.string.block_break);
      case BLOCK_OPCODE_IF -> StringUtil.getString(R.string.block_if);
      case BLOCK_OPCODE_IFELSE -> StringUtil.getString(R.string.block_if_else);
      case BLOCK_OPCODE_TRUE -> StringUtil.getString(R.string.block_true);
      case BLOCK_OPCODE_FALSE -> StringUtil.getString(R.string.block_false);
      case BLOCK_OPCODE_MATH_LESS -> StringUtil.getString(R.string.block_smaller);
      case BLOCK_OPCODE_MATH_EQUAL -> StringUtil.getString(R.string.block_equal);
      case BLOCK_OPCODE_MATH_GREAT -> StringUtil.getString(R.string.block_bigger);
      case BLOCK_OPCODE_AND -> StringUtil.getString(R.string.block_and);
      case BLOCK_OPCODE_OR -> StringUtil.getString(R.string.block_or);
      case BLOCK_OPCODE_NOT -> StringUtil.getString(R.string.block_not);
      case BLOCK_OPCODE_PLUS -> StringUtil.getString(R.string.block_plus);
      case BLOCK_OPCODE_MINUS -> StringUtil.getString(R.string.block_minus);
      case BLOCK_OPCODE_MULTIPLY -> StringUtil.getString(R.string.block_times);
      case BLOCK_OPCODE_DIVIDE -> StringUtil.getString(R.string.block_divide);
      case BLOCK_OPCODE_DIVIDE_REST -> StringUtil.getString(R.string.block_rest);
      case BLOCK_OPCODE_RANDOM -> StringUtil.getString(R.string.block_random);
      case BLOCK_OPCODE_STR_LENGTH -> StringUtil.getString(R.string.block_string_length);
      case BLOCK_OPCODE_STR_JOIN -> StringUtil.getString(R.string.block_string_join);
      case BLOCK_OPCODE_STR_INDEX -> StringUtil.getString(R.string.block_string_index);
      case BLOCK_OPCODE_STR_SUB -> StringUtil.getString(R.string.block_string_sub);
      case BLOCK_OPCODE_STR_EQUAL -> StringUtil.getString(R.string.block_string_equals);
      case BLOCK_OPCODE_TO_NUMBER -> StringUtil.getString(R.string.block_to_number);
      case BLOCK_OPCODE_TO_STRING -> StringUtil.getString(R.string.block_to_string);
      case BLOCK_OPCODE_TRIM -> StringUtil.getString(R.string.block_trim);
      case BLOCK_OPCODE_TOUPPERCASE -> StringUtil.getString(R.string.block_to_upper_case);
      case BLOCK_OPCODE_TOLOWERCASE -> StringUtil.getString(R.string.block_to_lower_case);
      case BLOCK_OPCODE_DO_PRINT -> StringUtil.getString(R.string.block_do_print);
      case BLOCK_OPCODE_ADD_SOURCE_DIRECTLY ->
          StringUtil.getString(R.string.block_add_source_directly);
      default -> StringUtil.getString(R.string.block_invalid);
    };
  }
}

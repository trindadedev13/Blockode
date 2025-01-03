package dev.trindadedev.theblocklogicsjava.utils;

/** Decompiled from Sketchware 1.1.13 */
public class BlockUtil {
  public static final int BLOCK_COLOR_ALL = -16740914;
  public static final int BLOCK_COLOR_ARG_BOOL = 1342177280;
  public static final int BLOCK_COLOR_ARG_FLOAT = -3155748;
  public static final int BLOCK_COLOR_ARG_INT = -657931;
  public static final int BLOCK_COLOR_ARG_SELECTABLE = 805306368;
  public static final int BLOCK_COLOR_ARG_STR = -1;
  public static final int BLOCK_COLOR_COMPONENT_FUNCTIONS = -13851166;
  public static final int BLOCK_COLOR_CONTROL = -1988310;
  public static final int BLOCK_COLOR_HAT = -3636432;
  public static final int BLOCK_COLOR_LIST = -3384542;
  public static final int BLOCK_COLOR_MOREBLOCKS = -7711273;
  public static final int BLOCK_COLOR_MOREBLOCK_BOOL = -4056997;
  public static final int BLOCK_COLOR_MOREBLOCK_FLOAT = -12232092;
  public static final int BLOCK_COLOR_MOREBLOCK_INT = -16746133;
  public static final int BLOCK_COLOR_MOREBLOCK_STR = -10665929;
  public static final int BLOCK_COLOR_OPERATORS = -10701022;
  public static final int BLOCK_COLOR_VARIABLE = -1147626;
  public static final int BLOCK_COLOR_VARIABLE_BOOL = -1499549;
  public static final int BLOCK_COLOR_VARIABLE_FLOAT = -10457717;
  public static final int BLOCK_COLOR_VARIABLE_INT = -16738680;
  public static final int BLOCK_COLOR_VARIABLE_STR = -8825528;
  public static final int BLOCK_COLOR_VIEW_FUNCTIONS = -11899692;
  public static final int BLOCK_DEPENDENCY_ALL = 0;
  public static final int BLOCK_DEPENDENCY_LOGIC = 2;
  public static final int BLOCK_DEPENDENCY_VIEW = 1;
  public static final String[] BLOCK_FILTERS = {"V", "L", "C", "O", "F"};
  public static final String BLOCK_HELPER_ACTIVITY_GETEXTRA_S = "5F104";
  public static final String BLOCK_HELPER_AND = "4O05";
  public static final String BLOCK_HELPER_BOOL_SET_TO = "1V05";
  public static final String BLOCK_HELPER_BOOL_VAR = "1V04";
  public static final String BLOCK_HELPER_CAL_ADD_VALUE = "5F231";
  public static final String BLOCK_HELPER_CAL_DIFFERENCE = "5F234";
  public static final String BLOCK_HELPER_CAL_FORMAT = "5F233";
  public static final String BLOCK_HELPER_CAL_GETNOW = "5F230";
  public static final String BLOCK_HELPER_CAL_SET_VALUE = "5F232";
  public static final String BLOCK_HELPER_CHK_GET_CHECKED = "5F504";
  public static final String BLOCK_HELPER_CHK_SET_CHECKED = "5F505";
  public static final String BLOCK_HELPER_FALSE = "4O01";
  public static final String BLOCK_HELPER_FILE_GET_DATA = "5F201";
  public static final String BLOCK_HELPER_FILE_REMOVE_DATA = "5F203";
  public static final String BLOCK_HELPER_FILE_SET_DATA = "5F202";
  public static final String BLOCK_HELPER_FINISH_ACTIVITY = "5F106";
  public static final String BLOCK_HELPER_FOREVER = "3C02";
  public static final String BLOCK_HELPER_GET_ENABLE = "5F001";
  public static final String BLOCK_HELPER_GET_TEXT = "5F003";
  public static final String BLOCK_HELPER_IF_ELSE = "3C05";
  public static final String BLOCK_HELPER_IF_THEN = "3C04";
  public static final String BLOCK_HELPER_INIT_LOGIC = "0W00";
  public static final String BLOCK_HELPER_INTENT_PUTEXTRA = "5F103";
  public static final String BLOCK_HELPER_INTENT_SET_ACTION = "5F100";
  public static final String BLOCK_HELPER_INTENT_SET_DATA = "5F101";
  public static final String BLOCK_HELPER_INTENT_SET_FLAG = "5F107";
  public static final String BLOCK_HELPER_INTENT_SET_SCREEN = "5F102";
  public static final String BLOCK_HELPER_INT_DECREASE = "1V07";
  public static final String BLOCK_HELPER_INT_INCREASE = "1V06";
  public static final String BLOCK_HELPER_INT_SET_TO = "1V01";
  public static final String BLOCK_HELPER_INT_VAR = "1V00";
  public static final String BLOCK_HELPER_IV_GET_ROTATE = "5F300";
  public static final String BLOCK_HELPER_IV_SET_IMAGE = "5F006";
  public static final String BLOCK_HELPER_IV_SET_ROTATE = "5F301";
  public static final String BLOCK_HELPER_JOIN = "4O15";
  public static final String BLOCK_HELPER_LIST_ADDTO = "2L00";
  public static final String BLOCK_HELPER_LIST_CLEAR = "2L01";
  public static final String BLOCK_HELPER_LIST_CONTAINS = "2L02";
  public static final String BLOCK_HELPER_LIST_DELETE_AT = "2L03";
  public static final String BLOCK_HELPER_LIST_GET_AT_OF = "2L04";
  public static final String BLOCK_HELPER_LIST_INDEX_IN = "2L05";
  public static final String BLOCK_HELPER_LIST_INSERT_AT_TO = "2L06";
  public static final String BLOCK_HELPER_LIST_LENGTH_OF = "2L07";
  public static final String BLOCK_HELPER_LV_GETCHK_COUNT = "5F605";
  public static final String BLOCK_HELPER_LV_GETCHK_POS = "5F603";
  public static final String BLOCK_HELPER_LV_GETCHK_POS_ARR = "5F604";
  public static final String BLOCK_HELPER_LV_REFRESH = "5F601";
  public static final String BLOCK_HELPER_LV_SETDATA = "5F600";
  public static final String BLOCK_HELPER_LV_SETITEM_CHK_POS = "5F602";
  public static final String BLOCK_HELPER_MATH_DIVIDE = "4O11";
  public static final String BLOCK_HELPER_MATH_DIVIDE_REST = "4O12";
  public static final String BLOCK_HELPER_MATH_EQUALS = "4O03";
  public static final String BLOCK_HELPER_MATH_GREAT = "4O04";
  public static final String BLOCK_HELPER_MATH_LESS = "4O02";
  public static final String BLOCK_HELPER_MATH_MINUS = "4O09";
  public static final String BLOCK_HELPER_MATH_MULTI = "4O10";
  public static final String BLOCK_HELPER_MATH_PLUS = "4O08";
  public static final String BLOCK_HELPER_NOT = "4O07";
  public static final String BLOCK_HELPER_OR = "4O06";
  public static final String BLOCK_HELPER_PIC_RANDOM = "4O13";
  public static final String BLOCK_HELPER_REPEAT = "3C01";
  public static final String BLOCK_HELPER_SET_BGCOLOR = "5F004";
  public static final String BLOCK_HELPER_SET_ENABLE = "5F000";
  public static final String BLOCK_HELPER_SET_TEXT = "5F002";
  public static final String BLOCK_HELPER_SET_TEXTCOLOR = "5F005";
  public static final String BLOCK_HELPER_SET_VISIBLE = "5F010";
  public static final String BLOCK_HELPER_SHOW_MSG = "5F007";
  public static final String BLOCK_HELPER_SPN_GET_SELECTION = "5F403";
  public static final String BLOCK_HELPER_SPN_REFRESH = "5F401";
  public static final String BLOCK_HELPER_SPN_SET_DATA = "5F400";
  public static final String BLOCK_HELPER_SPN_SET_SELECTION = "5F402";
  public static final String BLOCK_HELPER_START_ACTIVITY = "5F105";
  public static final String BLOCK_HELPER_STOP = "3C03";
  public static final String BLOCK_HELPER_STR_CONTAINS = "4O23";
  public static final String BLOCK_HELPER_STR_EQUALS = "4O18";
  public static final String BLOCK_HELPER_STR_INDEX_OF = "4O16";
  public static final String BLOCK_HELPER_STR_LENGTH_OF = "4O14";
  public static final String BLOCK_HELPER_STR_REPLACE = "4O24";
  public static final String BLOCK_HELPER_STR_SET_TO = "1V03";
  public static final String BLOCK_HELPER_STR_VAR = "1V02";
  public static final String BLOCK_HELPER_SUBSTRING = "4O17";
  public static final String BLOCK_HELPER_TIMER_AFTER = "5F701";
  public static final String BLOCK_HELPER_TIMER_CANCEL = "5F703";
  public static final String BLOCK_HELPER_TIMER_EVERY = "5F702";
  public static final String BLOCK_HELPER_TO_NUMBER = "4O19";
  public static final String BLOCK_HELPER_TO_STRING = "4O20";
  public static final String BLOCK_HELPER_TRIM = "4O22";
  public static final String BLOCK_HELPER_TRUE = "4O00";
  public static final String BLOCK_HELPER_VIBRATOR = "5F060";
  public static final String BLOCK_OPCODE_ADD_LIST_INT = "addListInt";
  public static final String BLOCK_OPCODE_ADD_LIST_STR = "addListStr";
  public static final String BLOCK_OPCODE_AND = "&&";
  public static final String BLOCK_OPCODE_BREAK = "break";
  public static final String BLOCK_OPCODE_CALENDAR_ADD = "calendarAdd";
  public static final String BLOCK_OPCODE_CALENDAR_DIFF = "calendarDiff";
  public static final String BLOCK_OPCODE_CALENDAR_FORMAT = "calendarFormat";
  public static final String BLOCK_OPCODE_CALENDAR_GET_NOW = "calendarGetNow";
  public static final String BLOCK_OPCODE_CALENDAR_SET = "calendarSet";
  public static final String BLOCK_OPCODE_CLEAR_LIST = "clearList";
  public static final String BLOCK_OPCODE_CONTAIN_LIST_INT = "containListInt";
  public static final String BLOCK_OPCODE_CONTAIN_LIST_STR = "containListStr";
  public static final String BLOCK_OPCODE_DECREASE_INT = "decreaseInt";
  public static final String BLOCK_OPCODE_DEFINED_FUNC = "definedFunc";
  public static final String BLOCK_OPCODE_DELETE_LIST = "deleteList";
  public static final String BLOCK_OPCODE_DIALOG_SET_MESSAGE = "dialogSetMessage";
  public static final String BLOCK_OPCODE_DIALOG_SET_TITLE = "dialogSetTitle";
  public static final String BLOCK_OPCODE_DIALOG_SET_VIEW = "dialogSetView";
  public static final String BLOCK_OPCODE_DIALOG_SHOW = "dialogShow";
  public static final String BLOCK_OPCODE_DIVIDE = "/";
  public static final String BLOCK_OPCODE_DIVIDE_REST = "%";
  public static final String BLOCK_OPCODE_DO_TOAST = "doToast";
  public static final String BLOCK_OPCODE_FALSE = "false";
  public static final String BLOCK_OPCODE_FILE_GET_DATA = "fileGetData";
  public static final String BLOCK_OPCODE_FILE_REMOVE_DATA = "fileRemoveData";
  public static final String BLOCK_OPCODE_FILE_SET_DATA = "fileSetData";
  public static final String BLOCK_OPCODE_FINISH_ACTIVITY = "finishActivity";
  public static final String BLOCK_OPCODE_FIREBASE_ADD = "firebaseAdd";
  public static final String BLOCK_OPCODE_FIREBASE_DELETE = "firebaseDelete";
  public static final String BLOCK_OPCODE_FIREBASE_PUSH = "firebasePush";
  public static final String BLOCK_OPCODE_FOREVER = "forever";
  public static final String BLOCK_OPCODE_GET_ARG = "getArg";
  public static final String BLOCK_OPCODE_GET_AT_LIST_INT = "getAtListInt";
  public static final String BLOCK_OPCODE_GET_AT_LIST_STR = "getAtListStr";
  public static final String BLOCK_OPCODE_GET_CHECKED = "getChecked";
  public static final String BLOCK_OPCODE_GET_ENABLE = "getEnable";
  public static final String BLOCK_OPCODE_GET_ROTATE = "getRotate";
  public static final String BLOCK_OPCODE_GET_TEXT = "getText";
  public static final String BLOCK_OPCODE_GET_VAR = "getVar";
  public static final String BLOCK_OPCODE_IF = "if";
  public static final String BLOCK_OPCODE_IFELSE = "ifElse";
  public static final String BLOCK_OPCODE_INCREASE_INT = "increaseInt";
  public static final String BLOCK_OPCODE_INDEXOF_LIST_INT = "indexListInt";
  public static final String BLOCK_OPCODE_INDEXOF_LIST_STR = "indexListStr";
  public static final String BLOCK_OPCODE_INSERT_LIST_INT = "insertListInt";
  public static final String BLOCK_OPCODE_INSERT_LIST_STR = "insertListStr";
  public static final String BLOCK_OPCODE_INTENT_GET_STRING = "intentGetString";
  public static final String BLOCK_OPCODE_INTENT_PUT_EXTRA = "intentPutExtra";
  public static final String BLOCK_OPCODE_INTENT_SET_ACTION = "intentSetAction";
  public static final String BLOCK_OPCODE_INTENT_SET_DATA = "intentSetData";
  public static final String BLOCK_OPCODE_INTENT_SET_FLAGS = "intentSetFlags";
  public static final String BLOCK_OPCODE_INTENT_SET_SCREEN = "intentSetScreen";
  public static final String BLOCK_OPCODE_LENGTH_LIST = "lengthList";
  public static final String BLOCK_OPCODE_LIST_GET_CHECK_COUNT = "listGetCheckedCount";
  public static final String BLOCK_OPCODE_LIST_GET_CHECK_POS = "listGetCheckedPosition";
  public static final String BLOCK_OPCODE_LIST_GET_CHECK_POS_ALL = "listGetCheckedPositions";
  public static final String BLOCK_OPCODE_LIST_REFRESH = "listRefresh";
  public static final String BLOCK_OPCODE_LIST_SET_CHECKED = "listSetItemChecked";
  public static final String BLOCK_OPCODE_LIST_SET_DATA = "listSetData";
  public static final String BLOCK_OPCODE_MATH_EQUAL = "=";
  public static final String BLOCK_OPCODE_MATH_GREAT = ">";
  public static final String BLOCK_OPCODE_MATH_LESS = "<";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_CREATE = "mediaplayerCreate";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_GET_CURRENT = "mediaplayerGetCurrent";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_GET_DURATION = "mediaplayerGetDuration";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_ISPLAYING = "mediaplayerIsPlaying";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_PAUSE = "mediaplayerPause";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_RELEASE = "mediaplayerRelease";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_RESET = "mediaplayerReset";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_SEEK = "mediaplayerSeek";
  public static final String BLOCK_OPCODE_MEDIAPLAYER_START = "mediaplayerStart";
  public static final String BLOCK_OPCODE_MINUS = "-";
  public static final String BLOCK_OPCODE_MULTIPLY = "*";
  public static final String BLOCK_OPCODE_NOT = "not";
  public static final String BLOCK_OPCODE_OR = "||";
  public static final String BLOCK_OPCODE_PLUS = "+";
  public static final String BLOCK_OPCODE_RANDOM = "random";
  public static final String BLOCK_OPCODE_REPEAT = "repeat";
  public static final String BLOCK_OPCODE_SET_BGCOLOR = "setBgColor";
  public static final String BLOCK_OPCODE_SET_CHECKED = "setChecked";
  public static final String BLOCK_OPCODE_SET_CLICKABLE = "setClickable";
  public static final String BLOCK_OPCODE_SET_ENABLE = "setEnable";
  public static final String BLOCK_OPCODE_SET_IMAGE = "setImage";
  public static final String BLOCK_OPCODE_SET_ROTATE = "setRotate";
  public static final String BLOCK_OPCODE_SET_TEXT = "setText";
  public static final String BLOCK_OPCODE_SET_TEXTCOLOR = "setTextColor";
  public static final String BLOCK_OPCODE_SET_VAR_BOOL = "setVarBoolean";
  public static final String BLOCK_OPCODE_SET_VAR_INT = "setVarInt";
  public static final String BLOCK_OPCODE_SET_VAR_STR = "setVarString";
  public static final String BLOCK_OPCODE_SET_VISIBLE = "setVisible";
  public static final String BLOCK_OPCODE_SPN_GET_SELECTION = "spnGetSelection";
  public static final String BLOCK_OPCODE_SPN_REFRESH = "spnRefresh";
  public static final String BLOCK_OPCODE_SPN_SET_DATA = "spnSetData";
  public static final String BLOCK_OPCODE_SPN_SET_SELECTION = "spnSetSelection";
  public static final String BLOCK_OPCODE_START_ACTIVITY = "startActivity";
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
  public static final String BLOCK_OPCODE_VIBRATOR_ACTION = "vibratorAction";
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

  public static int getBlockColor(String opCode, String type) {
    int color;
    if (type.equals(BLOCK_TYPE_HAT)) {
      return BLOCK_COLOR_HAT;
    }
    char c = 65535;
    switch (opCode.hashCode()) {
      case -2020761366:
        if (opCode.equals(BLOCK_OPCODE_FILE_REMOVE_DATA)) {
          c = 'W';
          break;
        }
        break;
      case -1998407506:
        if (opCode.equals(BLOCK_OPCODE_LIST_SET_DATA)) {
          c = 'B';
          break;
        }
        break;
      case -1979147952:
        if (opCode.equals(BLOCK_OPCODE_STR_CONTAINS)) {
          c = ',';
          break;
        }
        break;
      case -1920517885:
        if (opCode.equals(BLOCK_OPCODE_SET_VAR_BOOL)) {
          c = 2;
          break;
        }
        break;
      case -1919300188:
        if (opCode.equals(BLOCK_OPCODE_TO_NUMBER)) {
          c = '0';
          break;
        }
        break;
      case -1776922004:
        if (opCode.equals(BLOCK_OPCODE_TO_STRING)) {
          c = '1';
          break;
        }
        break;
      case -1684072208:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_DATA)) {
          c = 'N';
          break;
        }
        break;
      case -1573371685:
        if (opCode.equals(BLOCK_OPCODE_STR_JOIN)) {
          c = '(';
          break;
        }
        break;
      case -1530840255:
        if (opCode.equals(BLOCK_OPCODE_STR_INDEX)) {
          c = ')';
          break;
        }
        break;
      case -1528850031:
        if (opCode.equals(BLOCK_OPCODE_START_ACTIVITY)) {
          c = 'R';
          break;
        }
        break;
      case -1526161572:
        if (opCode.equals(BLOCK_OPCODE_SET_BGCOLOR)) {
          c = ';';
          break;
        }
        break;
      case -1512519571:
        if (opCode.equals(BLOCK_OPCODE_DEFINED_FUNC)) {
          c = 'a';
          break;
        }
        break;
      case -1440042085:
        if (opCode.equals(BLOCK_OPCODE_SPN_SET_SELECTION)) {
          c = 'J';
          break;
        }
        break;
      case -1384861688:
        if (opCode.equals(BLOCK_OPCODE_GET_AT_LIST_INT)) {
          c = '\n';
          break;
        }
        break;
      case -1384851894:
        if (opCode.equals(BLOCK_OPCODE_GET_AT_LIST_STR)) {
          c = 17;
          break;
        }
        break;
      case -1377080719:
        if (opCode.equals(BLOCK_OPCODE_DECREASE_INT)) {
          c = 5;
          break;
        }
        break;
      case -1271141237:
        if (opCode.equals(BLOCK_OPCODE_CLEAR_LIST)) {
          c = 14;
          break;
        }
        break;
      case -1249367264:
        if (opCode.equals(BLOCK_OPCODE_GET_ARG)) {
          c = 0;
          break;
        }
        break;
      case -1249347599:
        if (opCode.equals(BLOCK_OPCODE_GET_VAR)) {
          c = 1;
          break;
        }
        break;
      case -1192544266:
        if (opCode.equals(BLOCK_OPCODE_IFELSE)) {
          c = 24;
          break;
        }
        break;
      case -1137582698:
        if (opCode.equals(BLOCK_OPCODE_TOLOWERCASE)) {
          c = '4';
          break;
        }
        break;
      case -938285885:
        if (opCode.equals(BLOCK_OPCODE_RANDOM)) {
          c = '&';
          break;
        }
        break;
      case -934531685:
        if (opCode.equals(BLOCK_OPCODE_REPEAT)) {
          c = 20;
          break;
        }
        break;
      case -918173448:
        if (opCode.equals(BLOCK_OPCODE_LIST_GET_CHECK_POS)) {
          c = 'E';
          break;
        }
        break;
      case -869293886:
        if (opCode.equals(BLOCK_OPCODE_FINISH_ACTIVITY)) {
          c = 'T';
          break;
        }
        break;
      case -854558288:
        if (opCode.equals(BLOCK_OPCODE_SET_VISIBLE)) {
          c = '7';
          break;
        }
        break;
      case -853550561:
        if (opCode.equals(BLOCK_OPCODE_TIMER_CANCEL)) {
          c = '`';
          break;
        }
        break;
      case -677662361:
        if (opCode.equals(BLOCK_OPCODE_FOREVER)) {
          c = 21;
          break;
        }
        break;
      case -668992194:
        if (opCode.equals(BLOCK_OPCODE_STR_REPLACE_ALL)) {
          c = '/';
          break;
        }
        break;
      case -664474111:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_FLAGS)) {
          c = 'Q';
          break;
        }
        break;
      case -578987803:
        if (opCode.equals(BLOCK_OPCODE_SET_CHECKED)) {
          c = '@';
          break;
        }
        break;
      case -509946902:
        if (opCode.equals(BLOCK_OPCODE_SPN_REFRESH)) {
          c = 'I';
          break;
        }
        break;
      case -425293664:
        if (opCode.equals(BLOCK_OPCODE_SET_CLICKABLE)) {
          c = '8';
          break;
        }
        break;
      case -411705840:
        if (opCode.equals(BLOCK_OPCODE_FILE_SET_DATA)) {
          c = 'V';
          break;
        }
        break;
      case -399551817:
        if (opCode.equals(BLOCK_OPCODE_TOUPPERCASE)) {
          c = '3';
          break;
        }
        break;
      case -353129373:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_DIFF)) {
          c = '\\';
          break;
        }
        break;
      case -329562760:
        if (opCode.equals(BLOCK_OPCODE_INSERT_LIST_INT)) {
          c = '\b';
          break;
        }
        break;
      case -329552966:
        if (opCode.equals(BLOCK_OPCODE_INSERT_LIST_STR)) {
          c = 16;
          break;
        }
        break;
      case -322651344:
        if (opCode.equals(BLOCK_OPCODE_STR_EQUAL)) {
          c = '+';
          break;
        }
        break;
      case -283328259:
        if (opCode.equals(BLOCK_OPCODE_INTENT_PUT_EXTRA)) {
          c = 'P';
          break;
        }
        break;
      case -189292433:
        if (opCode.equals(BLOCK_OPCODE_STR_SUB)) {
          c = '*';
          break;
        }
        break;
      case -133532073:
        if (opCode.equals(BLOCK_OPCODE_STR_LENGTH)) {
          c = '\'';
          break;
        }
        break;
      case -96313603:
        if (opCode.equals(BLOCK_OPCODE_CONTAIN_LIST_INT)) {
          c = '\r';
          break;
        }
        break;
      case -96303809:
        if (opCode.equals(BLOCK_OPCODE_CONTAIN_LIST_STR)) {
          c = 19;
          break;
        }
        break;
      case -75125341:
        if (opCode.equals(BLOCK_OPCODE_GET_TEXT)) {
          c = ':';
          break;
        }
        break;
      case -60494417:
        if (opCode.equals(BLOCK_OPCODE_VIBRATOR_ACTION)) {
          c = ']';
          break;
        }
        break;
      case 37:
        if (opCode.equals(BLOCK_OPCODE_DIVIDE_REST)) {
          c = '%';
          break;
        }
        break;
      case 42:
        if (opCode.equals(BLOCK_OPCODE_MULTIPLY)) {
          c = '#';
          break;
        }
        break;
      case 43:
        if (opCode.equals(BLOCK_OPCODE_PLUS)) {
          c = '!';
          break;
        }
        break;
      case 45:
        if (opCode.equals(BLOCK_OPCODE_MINUS)) {
          c = '\"';
          break;
        }
        break;
      case 47:
        if (opCode.equals(BLOCK_OPCODE_DIVIDE)) {
          c = '$';
          break;
        }
        break;
      case 60:
        if (opCode.equals(BLOCK_OPCODE_MATH_LESS)) {
          c = 27;
          break;
        }
        break;
      case 61:
        if (opCode.equals(BLOCK_OPCODE_MATH_EQUAL)) {
          c = 28;
          break;
        }
        break;
      case 62:
        if (opCode.equals(BLOCK_OPCODE_MATH_GREAT)) {
          c = 29;
          break;
        }
        break;
      case 1216:
        if (opCode.equals(BLOCK_OPCODE_AND)) {
          c = 30;
          break;
        }
        break;
      case 3357:
        if (opCode.equals(BLOCK_OPCODE_IF)) {
          c = 23;
          break;
        }
        break;
      case 3968:
        if (opCode.equals(BLOCK_OPCODE_OR)) {
          c = 31;
          break;
        }
        break;
      case 109267:
        if (opCode.equals(BLOCK_OPCODE_NOT)) {
          c = ' ';
          break;
        }
        break;
      case 3568674:
        if (opCode.equals(BLOCK_OPCODE_TRIM)) {
          c = '2';
          break;
        }
        break;
      case 3569038:
        if (opCode.equals(BLOCK_OPCODE_TRUE)) {
          c = 25;
          break;
        }
        break;
      case 8255701:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_FORMAT)) {
          c = '[';
          break;
        }
        break;
      case 27679870:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_GET_NOW)) {
          c = 'X';
          break;
        }
        break;
      case 94001407:
        if (opCode.equals(BLOCK_OPCODE_BREAK)) {
          c = 22;
          break;
        }
        break;
      case 97196323:
        if (opCode.equals(BLOCK_OPCODE_FALSE)) {
          c = 26;
          break;
        }
        break;
      case 182549637:
        if (opCode.equals(BLOCK_OPCODE_SET_ENABLE)) {
          c = '5';
          break;
        }
        break;
      case 389111867:
        if (opCode.equals(BLOCK_OPCODE_SPN_SET_DATA)) {
          c = 'H';
          break;
        }
        break;
      case 397166713:
        if (opCode.equals(BLOCK_OPCODE_GET_ENABLE)) {
          c = '6';
          break;
        }
        break;
      case 404247683:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_ADD)) {
          c = 'Y';
          break;
        }
        break;
      case 404265028:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_SET)) {
          c = 'Z';
          break;
        }
        break;
      case 475815924:
        if (opCode.equals(BLOCK_OPCODE_SET_TEXTCOLOR)) {
          c = '<';
          break;
        }
        break;
      case 556217437:
        if (opCode.equals(BLOCK_OPCODE_SET_ROTATE)) {
          c = '>';
          break;
        }
        break;
      case 573295520:
        if (opCode.equals(BLOCK_OPCODE_LIST_GET_CHECK_COUNT)) {
          c = 'G';
          break;
        }
        break;
      case 657721930:
        if (opCode.equals(BLOCK_OPCODE_SET_VAR_INT)) {
          c = 3;
          break;
        }
        break;
      case 725249532:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_ACTION)) {
          c = 'M';
          break;
        }
        break;
      case 754442829:
        if (opCode.equals(BLOCK_OPCODE_INCREASE_INT)) {
          c = 4;
          break;
        }
        break;
      case 762282303:
        if (opCode.equals(BLOCK_OPCODE_INDEXOF_LIST_INT)) {
          c = 11;
          break;
        }
        break;
      case 762292097:
        if (opCode.equals(BLOCK_OPCODE_INDEXOF_LIST_STR)) {
          c = 18;
          break;
        }
        break;
      case 770834513:
        if (opCode.equals(BLOCK_OPCODE_GET_ROTATE)) {
          c = '?';
          break;
        }
        break;
      case 845089750:
        if (opCode.equals(BLOCK_OPCODE_SET_VAR_STR)) {
          c = 6;
          break;
        }
        break;
      case 1160674468:
        if (opCode.equals(BLOCK_OPCODE_LENGTH_LIST)) {
          c = '\f';
          break;
        }
        break;
      case 1187505507:
        if (opCode.equals(BLOCK_OPCODE_STR_REPLACE)) {
          c = '-';
          break;
        }
        break;
      case 1240510514:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_SCREEN)) {
          c = 'O';
          break;
        }
        break;
      case 1305932583:
        if (opCode.equals(BLOCK_OPCODE_SPN_GET_SELECTION)) {
          c = 'K';
          break;
        }
        break;
      case 1343794064:
        if (opCode.equals(BLOCK_OPCODE_LIST_SET_CHECKED)) {
          c = 'D';
          break;
        }
        break;
      case 1348133645:
        if (opCode.equals(BLOCK_OPCODE_STR_REPLACE_FIRST)) {
          c = '.';
          break;
        }
        break;
      case 1395026457:
        if (opCode.equals(BLOCK_OPCODE_SET_IMAGE)) {
          c = '=';
          break;
        }
        break;
      case 1397501021:
        if (opCode.equals(BLOCK_OPCODE_LIST_REFRESH)) {
          c = 'C';
          break;
        }
        break;
      case 1470831563:
        if (opCode.equals(BLOCK_OPCODE_INTENT_GET_STRING)) {
          c = 'S';
          break;
        }
        break;
      case 1601394299:
        if (opCode.equals(BLOCK_OPCODE_LIST_GET_CHECK_POS_ALL)) {
          c = 'F';
          break;
        }
        break;
      case 1633341847:
        if (opCode.equals(BLOCK_OPCODE_TIMER_AFTER)) {
          c = '^';
          break;
        }
        break;
      case 1637498582:
        if (opCode.equals(BLOCK_OPCODE_TIMER_EVERY)) {
          c = '_';
          break;
        }
        break;
      case 1764351209:
        if (opCode.equals(BLOCK_OPCODE_DELETE_LIST)) {
          c = '\t';
          break;
        }
        break;
      case 1779174257:
        if (opCode.equals(BLOCK_OPCODE_GET_CHECKED)) {
          c = 'A';
          break;
        }
        break;
      case 1814870108:
        if (opCode.equals(BLOCK_OPCODE_DO_TOAST)) {
          c = 'L';
          break;
        }
        break;
      case 1823151876:
        if (opCode.equals(BLOCK_OPCODE_FILE_GET_DATA)) {
          c = 'U';
          break;
        }
        break;
      case 1984984239:
        if (opCode.equals(BLOCK_OPCODE_SET_TEXT)) {
          c = '9';
          break;
        }
        break;
      case 2090179216:
        if (opCode.equals(BLOCK_OPCODE_ADD_LIST_INT)) {
          c = 7;
          break;
        }
        break;
      case 2090189010:
        if (opCode.equals(BLOCK_OPCODE_ADD_LIST_STR)) {
          c = 15;
          break;
        }
        break;
    }
    switch (c) {
      case BLOCK_DEPENDENCY_ALL /* 0 */:
        color = BLOCK_COLOR_MOREBLOCKS;
        break;
      case BLOCK_DEPENDENCY_VIEW /* 1 */:
      case BLOCK_DEPENDENCY_LOGIC /* 2 */:
      case 3:
      case 4:
      case 5:
      case 6:
        color = BLOCK_COLOR_VARIABLE;
        break;
      case 7:
      case '\b':
      case '\t':
      case '\n':
      case 11:
      case '\f':
      case '\r':
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
        color = BLOCK_COLOR_LIST;
        break;
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
        color = BLOCK_COLOR_CONTROL;
        break;
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case ' ':
      case '!':
      case '\"':
      case '#':
      case '$':
      case '%':
      case '&':
      case '\'':
      case '(':
      case ')':
      case '*':
      case '+':
      case ',':
      case '-':
      case '.':
      case '/':
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
        color = BLOCK_COLOR_OPERATORS;
        break;
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      case ':':
      case ';':
      case '<':
      case '=':
      case '>':
      case '?':
      case '@':
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
      case 'G':
      case 'H':
      case 'I':
      case 'J':
      case 'K':
        color = BLOCK_COLOR_VIEW_FUNCTIONS;
        break;
      case 'L':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      case 'T':
      case 'U':
      case 'V':
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '_':
      case '`':
        color = BLOCK_COLOR_COMPONENT_FUNCTIONS;
        break;
      case 'a':
        color = BLOCK_COLOR_MOREBLOCKS;
        break;
      default:
        color = BLOCK_COLOR_MOREBLOCKS;
        break;
    }
    return color;
  }

  public static String getSpecStringId(String opCode, String type) {
    char c = 65535;
    switch (opCode.hashCode()) {
      case -2020761366:
        if (opCode.equals(BLOCK_OPCODE_FILE_REMOVE_DATA)) {
          c = 'T';
          break;
        }
        break;
      case -1998407506:
        if (opCode.equals(BLOCK_OPCODE_LIST_SET_DATA)) {
          c = '@';
          break;
        }
        break;
      case -1979147952:
        if (opCode.equals(BLOCK_OPCODE_STR_CONTAINS)) {
          c = '*';
          break;
        }
        break;
      case -1920517885:
        if (opCode.equals(BLOCK_OPCODE_SET_VAR_BOOL)) {
          c = 0;
          break;
        }
        break;
      case -1919300188:
        if (opCode.equals(BLOCK_OPCODE_TO_NUMBER)) {
          c = '.';
          break;
        }
        break;
      case -1776922004:
        if (opCode.equals(BLOCK_OPCODE_TO_STRING)) {
          c = '/';
          break;
        }
        break;
      case -1749698255:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_PAUSE)) {
          c = 'g';
          break;
        }
        break;
      case -1747734390:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_RESET)) {
          c = 'k';
          break;
        }
        break;
      case -1746380899:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_START)) {
          c = 'f';
          break;
        }
        break;
      case -1718917155:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_SEEK)) {
          c = 'h';
          break;
        }
        break;
      case -1684072208:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_DATA)) {
          c = 'K';
          break;
        }
        break;
      case -1573371685:
        if (opCode.equals(BLOCK_OPCODE_STR_JOIN)) {
          c = '&';
          break;
        }
        break;
      case -1530840255:
        if (opCode.equals(BLOCK_OPCODE_STR_INDEX)) {
          c = '\'';
          break;
        }
        break;
      case -1528850031:
        if (opCode.equals(BLOCK_OPCODE_START_ACTIVITY)) {
          c = 'O';
          break;
        }
        break;
      case -1526161572:
        if (opCode.equals(BLOCK_OPCODE_SET_BGCOLOR)) {
          c = '9';
          break;
        }
        break;
      case -1440042085:
        if (opCode.equals(BLOCK_OPCODE_SPN_SET_SELECTION)) {
          c = 'H';
          break;
        }
        break;
      case -1385076635:
        if (opCode.equals(BLOCK_OPCODE_DIALOG_SHOW)) {
          c = 'd';
          break;
        }
        break;
      case -1384861688:
        if (opCode.equals(BLOCK_OPCODE_GET_AT_LIST_INT)) {
          c = '\b';
          break;
        }
        break;
      case -1384851894:
        if (opCode.equals(BLOCK_OPCODE_GET_AT_LIST_STR)) {
          c = 15;
          break;
        }
        break;
      case -1377080719:
        if (opCode.equals(BLOCK_OPCODE_DECREASE_INT)) {
          c = 3;
          break;
        }
        break;
      case -1304067438:
        if (opCode.equals(BLOCK_OPCODE_FIREBASE_DELETE)) {
          c = '`';
          break;
        }
        break;
      case -1272546178:
        if (opCode.equals(BLOCK_OPCODE_DIALOG_SET_TITLE)) {
          c = 'a';
          break;
        }
        break;
      case -1271141237:
        if (opCode.equals(BLOCK_OPCODE_CLEAR_LIST)) {
          c = '\f';
          break;
        }
        break;
      case -1192544266:
        if (opCode.equals(BLOCK_OPCODE_IFELSE)) {
          c = 22;
          break;
        }
        break;
      case -1149369409:
        if (opCode.equals(BLOCK_OPCODE_DIALOG_SET_VIEW)) {
          c = 'c';
          break;
        }
        break;
      case -1137582698:
        if (opCode.equals(BLOCK_OPCODE_TOLOWERCASE)) {
          c = '2';
          break;
        }
        break;
      case -1043233275:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_GET_DURATION)) {
          c = 'j';
          break;
        }
        break;
      case -938285885:
        if (opCode.equals(BLOCK_OPCODE_RANDOM)) {
          c = '$';
          break;
        }
        break;
      case -934531685:
        if (opCode.equals(BLOCK_OPCODE_REPEAT)) {
          c = 18;
          break;
        }
        break;
      case -918173448:
        if (opCode.equals(BLOCK_OPCODE_LIST_GET_CHECK_POS)) {
          c = 'C';
          break;
        }
        break;
      case -883988307:
        if (opCode.equals(BLOCK_OPCODE_DIALOG_SET_MESSAGE)) {
          c = 'b';
          break;
        }
        break;
      case -869293886:
        if (opCode.equals(BLOCK_OPCODE_FINISH_ACTIVITY)) {
          c = 'Q';
          break;
        }
        break;
      case -854558288:
        if (opCode.equals(BLOCK_OPCODE_SET_VISIBLE)) {
          c = '5';
          break;
        }
        break;
      case -853550561:
        if (opCode.equals(BLOCK_OPCODE_TIMER_CANCEL)) {
          c = ']';
          break;
        }
        break;
      case -677662361:
        if (opCode.equals(BLOCK_OPCODE_FOREVER)) {
          c = 19;
          break;
        }
        break;
      case -668992194:
        if (opCode.equals(BLOCK_OPCODE_STR_REPLACE_ALL)) {
          c = '-';
          break;
        }
        break;
      case -664474111:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_FLAGS)) {
          c = 'N';
          break;
        }
        break;
      case -578987803:
        if (opCode.equals(BLOCK_OPCODE_SET_CHECKED)) {
          c = '>';
          break;
        }
        break;
      case -509946902:
        if (opCode.equals(BLOCK_OPCODE_SPN_REFRESH)) {
          c = 'G';
          break;
        }
        break;
      case -425293664:
        if (opCode.equals(BLOCK_OPCODE_SET_CLICKABLE)) {
          c = '6';
          break;
        }
        break;
      case -411705840:
        if (opCode.equals(BLOCK_OPCODE_FILE_SET_DATA)) {
          c = 'S';
          break;
        }
        break;
      case -399551817:
        if (opCode.equals(BLOCK_OPCODE_TOUPPERCASE)) {
          c = '1';
          break;
        }
        break;
      case -353129373:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_DIFF)) {
          c = 'Y';
          break;
        }
        break;
      case -329562760:
        if (opCode.equals(BLOCK_OPCODE_INSERT_LIST_INT)) {
          c = 6;
          break;
        }
        break;
      case -329552966:
        if (opCode.equals(BLOCK_OPCODE_INSERT_LIST_STR)) {
          c = 14;
          break;
        }
        break;
      case -322651344:
        if (opCode.equals(BLOCK_OPCODE_STR_EQUAL)) {
          c = ')';
          break;
        }
        break;
      case -283328259:
        if (opCode.equals(BLOCK_OPCODE_INTENT_PUT_EXTRA)) {
          c = 'M';
          break;
        }
        break;
      case -247015294:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_RELEASE)) {
          c = 'l';
          break;
        }
        break;
      case -189292433:
        if (opCode.equals(BLOCK_OPCODE_STR_SUB)) {
          c = '(';
          break;
        }
        break;
      case -133532073:
        if (opCode.equals(BLOCK_OPCODE_STR_LENGTH)) {
          c = '%';
          break;
        }
        break;
      case -96313603:
        if (opCode.equals(BLOCK_OPCODE_CONTAIN_LIST_INT)) {
          c = 11;
          break;
        }
        break;
      case -96303809:
        if (opCode.equals(BLOCK_OPCODE_CONTAIN_LIST_STR)) {
          c = 17;
          break;
        }
        break;
      case -75125341:
        if (opCode.equals(BLOCK_OPCODE_GET_TEXT)) {
          c = '8';
          break;
        }
        break;
      case -60494417:
        if (opCode.equals(BLOCK_OPCODE_VIBRATOR_ACTION)) {
          c = 'Z';
          break;
        }
        break;
      case 37:
        if (opCode.equals(BLOCK_OPCODE_DIVIDE_REST)) {
          c = '#';
          break;
        }
        break;
      case 42:
        if (opCode.equals(BLOCK_OPCODE_MULTIPLY)) {
          c = '!';
          break;
        }
        break;
      case 43:
        if (opCode.equals(BLOCK_OPCODE_PLUS)) {
          c = 31;
          break;
        }
        break;
      case 45:
        if (opCode.equals(BLOCK_OPCODE_MINUS)) {
          c = ' ';
          break;
        }
        break;
      case 47:
        if (opCode.equals(BLOCK_OPCODE_DIVIDE)) {
          c = '\"';
          break;
        }
        break;
      case 60:
        if (opCode.equals(BLOCK_OPCODE_MATH_LESS)) {
          c = 25;
          break;
        }
        break;
      case 61:
        if (opCode.equals(BLOCK_OPCODE_MATH_EQUAL)) {
          c = 26;
          break;
        }
        break;
      case 62:
        if (opCode.equals(BLOCK_OPCODE_MATH_GREAT)) {
          c = 27;
          break;
        }
        break;
      case 1216:
        if (opCode.equals(BLOCK_OPCODE_AND)) {
          c = 28;
          break;
        }
        break;
      case 3357:
        if (opCode.equals(BLOCK_OPCODE_IF)) {
          c = 21;
          break;
        }
        break;
      case 3968:
        if (opCode.equals(BLOCK_OPCODE_OR)) {
          c = 29;
          break;
        }
        break;
      case 109267:
        if (opCode.equals(BLOCK_OPCODE_NOT)) {
          c = 30;
          break;
        }
        break;
      case 3568674:
        if (opCode.equals(BLOCK_OPCODE_TRIM)) {
          c = '0';
          break;
        }
        break;
      case 3569038:
        if (opCode.equals(BLOCK_OPCODE_TRUE)) {
          c = 23;
          break;
        }
        break;
      case 8255701:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_FORMAT)) {
          c = 'X';
          break;
        }
        break;
      case 27679870:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_GET_NOW)) {
          c = 'U';
          break;
        }
        break;
      case 61585857:
        if (opCode.equals(BLOCK_OPCODE_FIREBASE_PUSH)) {
          c = '_';
          break;
        }
        break;
      case 94001407:
        if (opCode.equals(BLOCK_OPCODE_BREAK)) {
          c = 20;
          break;
        }
        break;
      case 97196323:
        if (opCode.equals(BLOCK_OPCODE_FALSE)) {
          c = 24;
          break;
        }
        break;
      case 182549637:
        if (opCode.equals(BLOCK_OPCODE_SET_ENABLE)) {
          c = '3';
          break;
        }
        break;
      case 389111867:
        if (opCode.equals(BLOCK_OPCODE_SPN_SET_DATA)) {
          c = 'F';
          break;
        }
        break;
      case 397166713:
        if (opCode.equals(BLOCK_OPCODE_GET_ENABLE)) {
          c = '4';
          break;
        }
        break;
      case 404247683:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_ADD)) {
          c = 'V';
          break;
        }
        break;
      case 404265028:
        if (opCode.equals(BLOCK_OPCODE_CALENDAR_SET)) {
          c = 'W';
          break;
        }
        break;
      case 475815924:
        if (opCode.equals(BLOCK_OPCODE_SET_TEXTCOLOR)) {
          c = ':';
          break;
        }
        break;
      case 556217437:
        if (opCode.equals(BLOCK_OPCODE_SET_ROTATE)) {
          c = '<';
          break;
        }
        break;
      case 573295520:
        if (opCode.equals(BLOCK_OPCODE_LIST_GET_CHECK_COUNT)) {
          c = 'E';
          break;
        }
        break;
      case 657721930:
        if (opCode.equals(BLOCK_OPCODE_SET_VAR_INT)) {
          c = 1;
          break;
        }
        break;
      case 725249532:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_ACTION)) {
          c = 'J';
          break;
        }
        break;
      case 754442829:
        if (opCode.equals(BLOCK_OPCODE_INCREASE_INT)) {
          c = 2;
          break;
        }
        break;
      case 762282303:
        if (opCode.equals(BLOCK_OPCODE_INDEXOF_LIST_INT)) {
          c = '\t';
          break;
        }
        break;
      case 762292097:
        if (opCode.equals(BLOCK_OPCODE_INDEXOF_LIST_STR)) {
          c = 16;
          break;
        }
        break;
      case 770834513:
        if (opCode.equals(BLOCK_OPCODE_GET_ROTATE)) {
          c = '=';
          break;
        }
        break;
      case 845089750:
        if (opCode.equals(BLOCK_OPCODE_SET_VAR_STR)) {
          c = 4;
          break;
        }
        break;
      case 1160674468:
        if (opCode.equals(BLOCK_OPCODE_LENGTH_LIST)) {
          c = '\n';
          break;
        }
        break;
      case 1187505507:
        if (opCode.equals(BLOCK_OPCODE_STR_REPLACE)) {
          c = '+';
          break;
        }
        break;
      case 1236956449:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_CREATE)) {
          c = 'e';
          break;
        }
        break;
      case 1240510514:
        if (opCode.equals(BLOCK_OPCODE_INTENT_SET_SCREEN)) {
          c = 'L';
          break;
        }
        break;
      case 1305932583:
        if (opCode.equals(BLOCK_OPCODE_SPN_GET_SELECTION)) {
          c = 'I';
          break;
        }
        break;
      case 1343794064:
        if (opCode.equals(BLOCK_OPCODE_LIST_SET_CHECKED)) {
          c = 'B';
          break;
        }
        break;
      case 1348133645:
        if (opCode.equals(BLOCK_OPCODE_STR_REPLACE_FIRST)) {
          c = ',';
          break;
        }
        break;
      case 1395026457:
        if (opCode.equals(BLOCK_OPCODE_SET_IMAGE)) {
          c = ';';
          break;
        }
        break;
      case 1397501021:
        if (opCode.equals(BLOCK_OPCODE_LIST_REFRESH)) {
          c = 'A';
          break;
        }
        break;
      case 1470831563:
        if (opCode.equals(BLOCK_OPCODE_INTENT_GET_STRING)) {
          c = 'P';
          break;
        }
        break;
      case 1601394299:
        if (opCode.equals(BLOCK_OPCODE_LIST_GET_CHECK_POS_ALL)) {
          c = 'D';
          break;
        }
        break;
      case 1633341847:
        if (opCode.equals(BLOCK_OPCODE_TIMER_AFTER)) {
          c = '[';
          break;
        }
        break;
      case 1637498582:
        if (opCode.equals(BLOCK_OPCODE_TIMER_EVERY)) {
          c = '\\';
          break;
        }
        break;
      case 1764351209:
        if (opCode.equals(BLOCK_OPCODE_DELETE_LIST)) {
          c = 7;
          break;
        }
        break;
      case 1779174257:
        if (opCode.equals(BLOCK_OPCODE_GET_CHECKED)) {
          c = '?';
          break;
        }
        break;
      case 1814870108:
        if (opCode.equals(BLOCK_OPCODE_DO_TOAST)) {
          c = 'n';
          break;
        }
        break;
      case 1823151876:
        if (opCode.equals(BLOCK_OPCODE_FILE_GET_DATA)) {
          c = 'R';
          break;
        }
        break;
      case 1941634330:
        if (opCode.equals(BLOCK_OPCODE_FIREBASE_ADD)) {
          c = '^';
          break;
        }
        break;
      case 1973523807:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_ISPLAYING)) {
          c = 'm';
          break;
        }
        break;
      case 1984984239:
        if (opCode.equals(BLOCK_OPCODE_SET_TEXT)) {
          c = '7';
          break;
        }
        break;
      case 2090179216:
        if (opCode.equals(BLOCK_OPCODE_ADD_LIST_INT)) {
          c = 5;
          break;
        }
        break;
      case 2090189010:
        if (opCode.equals(BLOCK_OPCODE_ADD_LIST_STR)) {
          c = '\r';
          break;
        }
        break;
      case 2127377128:
        if (opCode.equals(BLOCK_OPCODE_MEDIAPLAYER_GET_CURRENT)) {
          c = 'i';
          break;
        }
        break;
    }
    switch (c) {
      case BLOCK_DEPENDENCY_ALL /* 0 */:
        return "set_var_bool";
      case BLOCK_DEPENDENCY_VIEW /* 1 */:
        return "set_var_int";
      case BLOCK_DEPENDENCY_LOGIC /* 2 */:
        return "increase_int";
      case 3:
        return "decrease_int";
      case 4:
        return "set_var_str";
      case 5:
        return "add_list_int";
      case 6:
        return "insert_list_int";
      case 7:
        return "delete_list";
      case '\b':
        return "get_at_list_int";
      case '\t':
        return "indexof_list_int";
      case '\n':
        return "length_list";
      case 11:
        return "contain_list_int";
      case '\f':
        return "clear_list";
      case '\r':
        return "add_list_str";
      case 14:
        return "insert_list_str";
      case 15:
        return "get_at_list_str";
      case 16:
        return "indexof_list_str";
      case 17:
        return "contain_list_str";
      case 18:
        return BLOCK_OPCODE_REPEAT;
      case 19:
        return BLOCK_OPCODE_FOREVER;
      case 20:
        return BLOCK_OPCODE_BREAK;
      case 21:
        return BLOCK_OPCODE_IF;
      case 22:
        return "if_else";
      case 23:
        return BLOCK_OPCODE_TRUE;
      case 24:
        return BLOCK_OPCODE_FALSE;
      case 25:
        return "smaller";
      case 26:
        return "equal";
      case 27:
        return "bigger";
      case 28:
        return "and";
      case 29:
        return "or";
      case 30:
        return BLOCK_OPCODE_NOT;
      case 31:
        return "plus";
      case ' ':
        return "minus";
      case '!':
        return "times";
      case '\"':
        return "divide";
      case '#':
        return "rest";
      case '$':
        return BLOCK_OPCODE_RANDOM;
      case '%':
        return "string_length";
      case '&':
        return "string_join";
      case '\'':
        return "string_index";
      case '(':
        return "string_sub";
      case ')':
        return "string_equals";
      case '*':
        return "string_contains";
      case '+':
        return "string_replace";
      case ',':
        return "string_replace_first";
      case '-':
        return "string_replace_all";
      case '.':
        return "to_number";
      case '/':
        return "to_string";
      case '0':
        return BLOCK_OPCODE_TRIM;
      case '1':
        return "to_upper_case";
      case '2':
        return "to_lower_case";
      case '3':
        return "set_enable";
      case '4':
        return "get_enable";
      case '5':
        return "set_visible";
      case '6':
        return "set_clickable";
      case '7':
        return "set_text";
      case '8':
        return "get_text";
      case '9':
        return "set_bg_color";
      case ':':
        return "set_text_color";
      case ';':
        return "set_image";
      case '<':
        return "set_rotate";
      case '=':
        return "get_rotate";
      case '>':
        return "set_checked";
      case '?':
        return "get_checked";
      case '@':
        return "list_set_data";
      case 'A':
        return "list_refresh";
      case 'B':
        return "list_set_item_checked";
      case 'C':
        return "list_get_checked_position";
      case 'D':
        return "list_get_checked_positions";
      case 'E':
        return "list_get_checked_count";
      case 'F':
        return "spn_set_data";
      case 'G':
        return "spn_refresh";
      case 'H':
        return "spn_set_selection";
      case 'I':
        return "spn_get_selection";
      case 'J':
        return "intent_set_action";
      case 'K':
        return "intent_set_data";
      case 'L':
        return "intent_set_screen";
      case 'M':
        return "intent_put_extra";
      case 'N':
        return "intent_set_flags";
      case 'O':
        return "start_activity";
      case 'P':
        return "intent_get_string";
      case 'Q':
        return "finish_activity";
      case 'R':
        return "file_get_data";
      case 'S':
        return "file_set_data";
      case 'T':
        return "file_remove_data";
      case 'U':
        return "calendar_get_now";
      case 'V':
        return "calendar_add";
      case 'W':
        return "calendar_set";
      case 'X':
        return "calendar_format";
      case 'Y':
        return "calendar_diff";
      case 'Z':
        return "vibrator_action";
      case '[':
        return "timer_after";
      case '\\':
        return "timer_every";
      case ']':
        return "timer_cancel";
      case '^':
        return "firebase_add";
      case '_':
        return "firebase_push";
      case '`':
        return "firebase_delete";
      case 'a':
        return "dialog_set_title";
      case 'b':
        return "dialog_set_message";
      case 'c':
        return "dialog_set_view";
      case 'd':
        return "dialog_show";
      case 'e':
        return "mediaplayer_create";
      case 'f':
        return "mediaplayer_start";
      case 'g':
        return "mediaplayer_pause";
      case 'h':
        return "mediaplayer_seek";
      case 'i':
        return "mediaplayer_get_current";
      case 'j':
        return "mediaplayer_get_duration";
      case 'k':
        return "mediaplayer_reset";
      case 'l':
        return "mediaplayer_release";
      case 'm':
        return "mediaplayer_is_playing";
      case 'n':
        return "do_toast";
      default:
        return "";
    }
  }
}

package dev.trindadedev.blockode.utils;

import androidx.annotation.NonNull;
import dev.trindadedev.blockode.R;

public class SpecUtil {
  public static String getSpecForFileName(@NonNull String className) {
    return StringUtil.getString(R.string.root_spec_define) + " " + className;
  }
}

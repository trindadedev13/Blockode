package dev.trindadedev.blockode.utils;

import androidx.annotation.DrawableRes;
import dev.trindadedev.blockode.R;
import java.util.List;

public class DesignUtil {
  DesignUtil() {}

  @DrawableRes
  public static final <T> int getShapedBackgroundForList(final List<T> list, final int position) {
    if (list.size() == 1) {
      return R.drawable.shape_alone;
    } else if (position == 0) {
      return R.drawable.shape_top;
    } else if (position == list.size() - 1) {
      return R.drawable.shape_bottom;
    } else {
      return R.drawable.shape_middle;
    }
  }
}

package dev.trindadedev.theblocklogicsjava;

import android.os.Environment;
import java.io.File;

public final class TheBlockLogics {
  public static final String getPublicFolderPath() {
    return getPublicFolderFile().getAbsolutePath();
  }

  public static final File getPublicFolderFile() {
    return new File(Environment.getExternalStorageDirectory(), ".theblocklogics/java/");
  }
}

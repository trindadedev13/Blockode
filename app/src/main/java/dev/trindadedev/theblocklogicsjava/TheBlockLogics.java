package dev.trindadedev.theblocklogicsjava;

import android.app.Application;
import android.os.Environment;
import java.io.File;

public final class TheBlockLogics extends Application {
  public static final String getPublicFolderPath() {
    return getPublicFolderFile().getAbsolutePath();
  }

  public static final File getPublicFolderFile() {
    return new File(Environment.getExternalStorageDirectory(), ".theblocklogics/java/");
  }
}

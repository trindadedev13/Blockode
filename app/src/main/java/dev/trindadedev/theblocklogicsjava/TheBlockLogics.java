package dev.trindadedev.theblocklogicsjava;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import java.io.File;

public final class TheBlockLogics extends Application {

  private static Context appContext;

  @Override
  public void onCreate() {
    super.onCreate();
    appContext = this;
  }

  public static final String getPublicFolderPath() {
    return getPublicFolderFile().getAbsolutePath();
  }

  public static final File getPublicFolderFile() {
    return new File(Environment.getExternalStorageDirectory(), ".theblocklogics/java/");
  }

  public static final Context getAppContext() {
    return appContext;
  }
}

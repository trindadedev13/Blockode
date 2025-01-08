package dev.trindadedev.blockode;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import com.google.android.material.color.DynamicColors;
import dev.trindadedev.blockode.io.File;

public final class Blockode extends Application {

  private static Context appContext;

  @Override
  public void onCreate() {
    DynamicColors.applyToActivitiesIfAvailable(this);
    super.onCreate();
    appContext = this;
  }

  public static final String getPublicFolderPath() {
    return getPublicFolderFile().getAbsolutePath();
  }

  public static final File getPublicFolderFile() {
    return new File(Environment.getExternalStorageDirectory(), ".blockode/");
  }

  public static final Context getAppContext() {
    return appContext;
  }
}

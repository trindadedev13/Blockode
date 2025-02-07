package dev.trindadedev.blockode.utils;

import static dev.trindadedev.blockode.Blockode.getAppContext;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class URLUtil {
  URLUtil() { }

  public static void openUrl(final String url) {
    final var activity = (Activity) getAppContext();
    final var intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    activity.startActivity(intent);
  }
}
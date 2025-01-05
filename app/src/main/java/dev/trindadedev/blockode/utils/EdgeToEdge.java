package dev.trindadedev.blockode.utils;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import dev.trindadedev.blockode.ui.base.BaseAppCompatActivity;

public class EdgeToEdge {
  public static void enable(@NonNull BaseAppCompatActivity activity) {
    WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
    ViewCompat.setOnApplyWindowInsetsListener(
        activity.getWindow().getDecorView(),
        (a, insets) -> {
          var systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
          activity
              .getWindow()
              .getDecorView()
              .setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
          return insets;
        });
  }
}

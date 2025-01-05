package dev.trindadedev.theblocklogicsjava.ui.base;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseAppCompatActivity extends AppCompatActivity {

  @NonNull private View rootView;

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = bindLayout();
    setContentView(rootView);
    onBindLayout(savedInstanceState);
  }

  @NonNull
  protected abstract View bindLayout();

  protected abstract void onBindLayout(@Nullable final Bundle bundle);

  public View getRootView() {
    return rootView;
  }
}

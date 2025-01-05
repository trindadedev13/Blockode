package dev.trindadedev.blockode.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import java.io.Serializable;

@SuppressWarnings("DEPRECATION")
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

  protected void configureToolbar(@NonNull MaterialToolbar toolbar) {
    toolbar.setNavigationOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());
  }

  @Nullable
  protected <T extends Serializable> T getSerializable(final String key, final Class<T> clazz) {
    var extras = getIntent().getExtras();
    if (extras == null) return null;
    if (!extras.containsKey(key)) return null;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      return extras.getSerializable(key, clazz);
    } else {
      return clazz.cast(extras.getSerializable(key));
    }
  }

  @Nullable
  protected <T extends Serializable> T getSerializable(
      final Bundle bundle, final String key, final Class<T> clazz) {
    if (bundle == null) return null;
    if (!bundle.containsKey(key)) return null;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      return bundle.getSerializable(key, clazz);
    } else {
      return clazz.cast(bundle.getSerializable(key));
    }
  }
}

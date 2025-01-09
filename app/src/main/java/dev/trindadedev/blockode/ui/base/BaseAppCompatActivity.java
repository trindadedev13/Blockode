package dev.trindadedev.blockode.ui.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import dev.trindadedev.blockode.os.PermissionManager;
import dev.trindadedev.blockode.utils.EdgeToEdge;
import java.io.Serializable;

@SuppressWarnings("DEPRECATION")
public abstract class BaseAppCompatActivity extends AppCompatActivity {

  @NonNull private View rootView;
  protected PermissionManager.Storage storagePermissionManager;

  private final ActivityResultLauncher<Intent> allFilesPermissionLauncher =
      registerForActivityResult(
          new ActivityResultContracts.StartActivityForResult(),
          result -> {
            onReceive(PermissionType.STORAGE, storagePermissionManager.check());
          });

  private final ActivityResultLauncher<String[]> readWritePermissionLauncher =
      registerForActivityResult(
          new ActivityResultContracts.RequestMultiplePermissions(),
          permissions -> {
            onReceive(PermissionType.STORAGE, storagePermissionManager.check());
          });

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = bindLayout();
    setContentView(rootView);
    onBindLayout(savedInstanceState);
    EdgeToEdge.enable(this);
    storagePermissionManager =
        new PermissionManager.Storage(
            this, allFilesPermissionLauncher, readWritePermissionLauncher);
    onPostBind(savedInstanceState);
  }

  protected void onPostBind(@Nullable final Bundle savedInstanceState) {
    if (!storagePermissionManager.check()) storagePermissionManager.request();
  }

  protected void onReceive(final PermissionType type, final boolean status) {}

  @NonNull
  protected abstract View bindLayout();

  protected abstract void onBindLayout(@Nullable final Bundle savedInstanceState);

  public View getRootView() {
    return rootView;
  }

  protected void configureToolbar(@NonNull MaterialToolbar toolbar) {
    setSupportActionBar(toolbar);
    toolbar.setNavigationOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());
  }

  protected void onReceive() {}

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

  public enum PermissionType {
    STORAGE;
  }
}

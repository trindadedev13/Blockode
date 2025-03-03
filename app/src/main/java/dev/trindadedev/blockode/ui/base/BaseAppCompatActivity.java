package dev.trindadedev.blockode.ui.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import dev.trindadedev.blockode.os.PermissionManager;
import dev.trindadedev.blockode.ui.components.dialog.ProgressDialog;
import dev.trindadedev.blockode.utils.EdgeToEdge;
import dev.trindadedev.blockode.utils.PrintUtil;
import java.io.Serializable;

@SuppressWarnings("DEPRECATION")
public abstract class BaseAppCompatActivity extends AppCompatActivity {

  @NonNull private View rootView;
  @NonNull private ProgressDialog progressDialog;
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
    storagePermissionManager =
        new PermissionManager.Storage(
            this, allFilesPermissionLauncher, readWritePermissionLauncher);
    progressDialog = new ProgressDialog(this);
    onPostBind(savedInstanceState);
  }

  @NonNull
  protected abstract View bindLayout();

  protected abstract void onBindLayout(@Nullable final Bundle savedInstanceState);

  protected void onPostBind(@Nullable final Bundle savedInstanceState) {
    if (!storagePermissionManager.check()) storagePermissionManager.request();
    EdgeToEdge.enable(this);
  }

  protected void showProgress() {
    if (progressDialog != null && !progressDialog.isShowing() && !isFinishing())
      progressDialog.show();
  }

  protected void showProgress(@NonNull final String text) {
    if (progressDialog != null && !progressDialog.isShowing() && !isFinishing()) {
      progressDialog.setTitle(text);
      progressDialog.show();
    }
  }

  protected void dismissProgress() {
    try {
      if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
    } catch (final Exception e) {
      progressDialog = null;
      progressDialog = new ProgressDialog(this);
      PrintUtil.print(e);
    }
  }

  protected void onReceive(final PermissionType type, final boolean status) {}

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
    return getSerializable(extras, key, clazz);
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

  @Nullable
  protected <T extends Parcelable> T getParcelable(final String key, final Class<T> clazz) {
    var extras = getIntent().getExtras();
    return getParcelable(extras, key, clazz);
  }

  @Nullable
  protected <T extends Parcelable> T getParcelable(
      final Bundle bundle, final String key, final Class<T> clazz) {
    if (bundle == null) return null;
    if (!bundle.containsKey(key)) return null;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      return bundle.getParcelable(key, clazz);
    } else {
      return clazz.cast(bundle.getParcelable(key));
    }
  }

  public enum PermissionType {
    STORAGE;
  }
}

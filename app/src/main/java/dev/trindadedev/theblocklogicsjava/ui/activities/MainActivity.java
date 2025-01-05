package dev.trindadedev.theblocklogicsjava.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dev.trindadedev.theblocklogicsjava.databinding.ActivityMainBinding;
import dev.trindadedev.theblocklogicsjava.ui.activities.editor.LogicEditorActivity;
import dev.trindadedev.theblocklogicsjava.ui.base.BaseAppCompatActivity;

public class MainActivity extends BaseAppCompatActivity {
  private ActivityMainBinding binding;
  
  @Override
  @NonNull
  protected View bindLayout() {
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    return binding.getRoot();
  }
  
  @Override
  protected void onBindLayout(@Nullable final Bundle bundle) {
    openTestProject();
  }
  
  private void openTestProject() {
    var intent = new Intent(this, LogicEditorActivity.class);
    intent.putExtra("sc_id", "601"); // use fake SC ID for now
    startActivity(intent);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }
}

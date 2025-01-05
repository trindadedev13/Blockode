package dev.trindadedev.blockode.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dev.trindadedev.blockode.databinding.ActivityMainBinding;
import dev.trindadedev.blockode.ui.activities.editor.LogicEditorActivity;
import dev.trindadedev.blockode.ui.base.BaseAppCompatActivity;

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

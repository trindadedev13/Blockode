package dev.trindadedev.theblocklogicsjava.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import dev.trindadedev.theblocklogicsjava.databinding.ActivityMainBinding;
import dev.trindadedev.theblocklogicsjava.ui.activities.editor.LogicEditorActivity;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
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

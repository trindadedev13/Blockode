package dev.trindadedev.theblocklogicsjava.ui.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import dev.trindadedev.theblocklogicsjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }
}

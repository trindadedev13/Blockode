package dev.trindadedev.blockode.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import dev.trindadedev.blockode.databinding.ActivityMainBinding;
import dev.trindadedev.blockode.ui.activities.editor.EditorState;
import dev.trindadedev.blockode.ui.activities.editor.LogicEditorActivity;
import dev.trindadedev.blockode.ui.activities.project.ProjectViewModel;
import dev.trindadedev.blockode.ui.base.BaseAppCompatActivity;

public class MainActivity extends BaseAppCompatActivity {
  private ActivityMainBinding binding;
  private ProjectViewModel projectViewModel;

  @Override
  @NonNull
  protected View bindLayout() {
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    return binding.getRoot();
  }

  @Override
  protected void onBindLayout(@Nullable final Bundle bundle) {
    projectViewModel = new ViewModelProvider(this).get(ProjectViewModel.class);
    projectViewModel.fetch();
    openTestProject();
  }

  private void openTestProject() {
    var editorState = new EditorState();
    editorState.scId = "100"; // use fake sc id for now
    editorState.className = "Main";
    var intent = new Intent(this, LogicEditorActivity.class);
    intent.putExtra("editor_state", editorState);
    startActivity(intent);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }
}

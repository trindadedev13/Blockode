package dev.trindadedev.blockode.ui.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.databinding.ActivityMainBinding;
import dev.trindadedev.blockode.ui.activities.editor.EditorState;
import dev.trindadedev.blockode.ui.activities.editor.LogicEditorActivity;
import dev.trindadedev.blockode.ui.activities.project.ProjectsAdapter;
import dev.trindadedev.blockode.ui.activities.project.ProjectsViewModel;
import dev.trindadedev.blockode.ui.activities.main.components.CreateProjectDialog;
import dev.trindadedev.blockode.ui.base.BaseAppCompatActivity;
import dev.trindadedev.blockode.utils.StringUtil;
import dev.trindadedev.blockode.utils.URLUtil;

public class MainActivity extends BaseAppCompatActivity {
  private ActivityMainBinding binding;
  private ProjectsViewModel projectsViewModel;
  private ProjectsAdapter projectsAdapter;

  @Override
  @NonNull
  protected View bindLayout() {
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    return binding.getRoot();
  }

  @Override
  protected void onBindLayout(@Nullable final Bundle savedInstanceState) {

    projectsViewModel = new ViewModelProvider(this).get(ProjectsViewModel.class);
    projectsAdapter = new ProjectsAdapter();
    projectsAdapter.setOnProjectClick(
        project -> openProject(project.scId, project.basicInfo.mainClassPackage));
    projectsViewModel.fetch();
    projectsViewModel.getProjects().observe(this, projectsAdapter::submitList);
    binding.list.setAdapter(projectsAdapter);
    binding.createNew.setVisibility(View.GONE);
    binding.createNew.setOnClickListener(
        v -> {
          CreateProjectDialog d = new CreateProjectDialog(this);
          d.show();
          d.setOnDismissListener(
              dialog -> {
                projectsViewModel.fetch();
              });
        });

    binding.btnCreate.setOnClickListener(
        v -> {
          final var cpd = new CreateProjectDialog(this);
          cpd.show();
          cpd.setOnDismissListener(dialog -> projectsViewModel.fetch());
        });
    binding.telegram.setOnClickListener(v -> URLUtil.openUrl(this, StringUtil.getString(R.string.link_telegram)));
  }

  private void openProject(final String scId, final String className) {
    final var editorState = new EditorState();
    editorState.scId = scId;
    editorState.className = className;
    final var intent = new Intent(this, LogicEditorActivity.class);
    intent.putExtra("editor_state", editorState);
    startActivity(intent);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }
}

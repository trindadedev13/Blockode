package dev.trindadedev.blockode.ui.activities.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import dev.trindadedev.blockode.beans.ProjectBean;
import dev.trindadedev.blockode.io.File;
import dev.trindadedev.blockode.databinding.LayoutProjectBinding;
import dev.trindadedev.blockode.project.ProjectManager;
import dev.trindadedev.blockode.utils.DesignUtil;
import dev.trindadedev.blockode.utils.PrintUtil;
import java.util.function.Consumer;

public class ProjectsAdapter extends ListAdapter<File, ProjectsAdapter.ProjectsAdapterViewHolder> {
  private Consumer<ProjectBean> onProjectClickConsumer;

  public ProjectsAdapter() {
    super(new ProjectsAdapterDiffUtil());
  }

  @Override
  public ProjectsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int parentType) {
    return new ProjectsAdapterViewHolder(
        LayoutProjectBinding.inflate(LayoutInflater.from(parent.getContext())));
  }

  @Override
  @NonNull
  public void onBindViewHolder(@NonNull ProjectsAdapterViewHolder holder, int position) {
    holder.binding.getRoot().setBackgroundResource(DesignUtil.getShapedBackgroundForList(getCurrentList(), position));
    var item = getItem(position); // project folder
    // try load project data based in folder name.
    var project = ProjectManager.getProjectByScId(item.getName());
    holder.binding.name.setText(project.basicInfo.name);
    holder
        .binding
        .getRoot()
        .setOnClickListener(
            v -> {
              if (onProjectClickConsumer != null) onProjectClickConsumer.accept(project);
            });
  }

  public void setOnProjectClick(final Consumer<ProjectBean> onProjectClickConsumer) {
    this.onProjectClickConsumer = onProjectClickConsumer;
  }

  public static class ProjectsAdapterViewHolder extends RecyclerView.ViewHolder {
    private LayoutProjectBinding binding;

    public ProjectsAdapterViewHolder(@NonNull LayoutProjectBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }
  }

  public static class ProjectsAdapterDiffUtil extends DiffUtil.ItemCallback<File> {
    @Override
    public boolean areItemsTheSame(@NonNull File oldItem, @NonNull File newItem) {
      return oldItem.getName().equals(newItem.getName());
    }

    @Override
    public boolean areContentsTheSame(@NonNull File oldItem, @NonNull File newItem) {
      return oldItem.equals(newItem);
    }
  }
}

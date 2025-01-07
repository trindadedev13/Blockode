package dev.trindadedev.blockode.ui.activities.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import dev.trindadedev.blockode.databinding.LayoutProjectBinding;
import java.io.File;

public class ProjectsAdapter extends ListAdapter<File, ProjectsAdapter.ProjectsAdapterViewHolder> {

  public ProjectsAdapter() {
    super(new ProjectsAdapterDiffUtil());
  }

  @Override
  public ProjectsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int parentType) {
    return new ProjectsAdapterViewHolder(LayoutProjectBinding.inflate(LayoutInflater.from(parent.getContext())));
  }

  @Override
  @NonNull
  public void onBindViewHolder(@NonNull ProjectsAdapterViewHolder holder, int positiob) {}

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

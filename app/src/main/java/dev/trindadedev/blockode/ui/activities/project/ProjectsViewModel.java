package dev.trindadedev.blockode.ui.activities.project;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dev.trindadedev.blockode.Blockode;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ProjectsViewModel extends ViewModel {
  private final MutableLiveData<List<File>> projects = new MutableLiveData<>();

  public void fetch() {
    var files = getFile().listFiles();
    if (files == null) return;
    projects.setValue(Arrays.asList(files));
  }

  public final LiveData<List<File>> getProjects() {
    return projects;
  }

  private File getFile() {
    return new File(Blockode.getPublicFolderFile(), "projects/");
  }
}

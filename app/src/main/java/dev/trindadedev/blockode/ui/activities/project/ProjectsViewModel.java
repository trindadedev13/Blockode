package dev.trindadedev.blockode.ui.activities.project;

import android.os.Build;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dev.trindadedev.blockode.io.File;
import dev.trindadedev.blockode.project.ProjectManager;
import dev.trindadedev.blockode.utils.PrintUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectsViewModel extends ViewModel {
  private final MutableLiveData<List<File>> projects = new MutableLiveData<>();

  public final void fetch() {
    var ogFiles = ProjectManager.getProjectsFile().listFiles();
    PrintUtil.print(ogFiles);
    if (ogFiles == null) return;
    projects.setValue(toFiles(Arrays.asList(ogFiles)));
  }

  private final List<File> toFiles(final List<java.io.File> ogFiles) {
    var toReturnList = new ArrayList<File>();
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
          ogFiles.forEach(
              ogFile -> {
                toReturnList.add(new File(ogFile.getAbsolutePath()));
              });
      }
      return toReturnList;
  }

  public final LiveData<List<File>> getProjects() {
    return projects;
  }
}

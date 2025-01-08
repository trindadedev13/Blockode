package dev.trindadedev.blockode.project;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.reflect.TypeToken;
import dev.trindadedev.blockode.Blockode;
import dev.trindadedev.blockode.base.Contextualizable;
import dev.trindadedev.blockode.beans.ProjectBasicInfoBean;
import dev.trindadedev.blockode.beans.ProjectBean;
import dev.trindadedev.blockode.beans.VariableBean;
import dev.trindadedev.blockode.io.File;
import dev.trindadedev.blockode.utils.FileUtil;
import dev.trindadedev.blockode.utils.GsonUtil;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager extends Contextualizable {
  private String scId;

  public ProjectManager(@NonNull final Context context) {
    this(context, null);
  }

  public ProjectManager(@NonNull final Context context, final String scId) {
    super(context);
    this.scId = scId;
  }

  @Nullable
  public final ProjectBean getProjectByScId() {
    return getProjectByScId(scId);
  }

  /**
   * Creates and returns a ProjectBean based in files by scId
   *
   * @param scId The id of project to be searched
   */
  @Nullable
  public static final ProjectBean getProjectByScId(final String scId) {
    var basicInfoFileJsonType = new TypeToken<ProjectBasicInfoBean>() {}.getType();
    var basicInfoJsonContent = FileUtil.readFile(getBasicInfoFile(scId).getAbsolutePath(), false);
    var basicInfo = GsonUtil.getGson().fromJson(basicInfoJsonContent, basicInfoFileJsonType);
    var variablesFileJsonType = new TypeToken<List<VariableBean>>() {}.getType();
    var variablesFileJsonContent =
        FileUtil.readFile(getVariablesFile(scId).getAbsolutePath(), false);
    var variables = GsonUtil.getGson().fromJson(variablesFileJsonContent, variablesFileJsonType);
    var toReturnProject = new ProjectBean();
    toReturnProject.scId = scId;
    toReturnProject.basicInfo = (ProjectBasicInfoBean) basicInfo;
    toReturnProject.variables = (ArrayList<VariableBean>) variables;
    return toReturnProject;
  }

  /**
   * Creates nescessary files of project
   *
   * @param project The instance of ProjectBean with data to be created.
   */
  public static final void createProjectByBean(@NonNull final ProjectBean project) {
    var projectRootDir = new File(getProjectsFile(), project.scId).getAbsolutePath();
    var basicInfoFileJson = GsonUtil.getGson().toJson(project.basicInfo);
    var variablesFileJson = GsonUtil.getGson().toJson(project.variables);
    FileUtil.makeDir(projectRootDir);
    FileUtil.writeText(getBasicInfoFile(project.scId).getAbsolutePath(), basicInfoFileJson);
    FileUtil.writeText(getVariablesFile(project.scId).getAbsolutePath(), variablesFileJson);
  }

  /** Folder where all projects are stored */
  public static final File getProjectsFile() {
    return new File(Blockode.getPublicFolderFile(), "projects/");
  }

  /** The file where basic info of project are stored, like name, packageName */
  public static final File getBasicInfoFile(final String scId) {
    return new File(getProjectsFile(), scId + "/data/basic_info.json");
  }

  /** The file where variables are stored */
  public static final File getVariablesFile(final String scId) {
    return new File(getProjectsFile(), scId + "/data/variables.json");
  }

  @Nullable
  public String getScId() {
    return this.scId;
  }

  public void setScId(final String scId) {
    this.scId = scId;
  }
}

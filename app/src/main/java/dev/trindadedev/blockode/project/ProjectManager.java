package dev.trindadedev.blockode.project;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.reflect.TypeToken;
import dev.trindadedev.blockode.Blockode;
import dev.trindadedev.blockode.beans.ProjectBasicInfoBean;
import dev.trindadedev.blockode.beans.ProjectBean;
import dev.trindadedev.blockode.io.File;
import dev.trindadedev.blockode.base.Contextualizable;
import dev.trindadedev.blockode.beans.VariableBean;
import dev.trindadedev.blockode.ui.editor.manager.VariablesManager;
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

  public final ProjectBean getProjectByScId() {
    var basicInfoFileJsonType = new TypeToken<ProjectBasicInfoBean>() {}.getType();
    var basicInfoJsonContent = FileUtil.readFile(getBasicInfoFile(scId).getAbsolutePath());
    var basicInfo = GsonUtil.getGson().fromJson(basicInfoJsonContent, basicInfoFileJsonType);
    var variablesFileJsonType = new TypeToken<List<VariableBean>>() {}.getType();
    var variablesFileJsonContent = FileUtil.readFile(getVariablesFile(scId).getAbsolutePath());
    var variables = GsonUtil.getGson().fromJson(variablesFileJsonContent, variablesFileJsonType);
    var toReturnProject = new ProjectBean();
    toReturnProject.basicInfo = (ProjectBasicInfoBean) basicInfo;
    toReturnProject.variables = new ArrayList((List) variables);
    return toReturnProject;
  }

  /** The where basic info of project are stored, like name, packageName */
  public static final File getBasicInfoFile(final String scId) {
    return new File(Blockode.getPublicFolderFile(), "projects/" + scId + "/data/basic_info.json");
  }

  /** The file where variables are stored */
  public static final File getVariablesFile(final String scId) {
    return new File(Blockode.getPublicFolderFile(), "projects/" + scId + "/data/variables.json");
  }

  @Nullable
  public String getScId() {
    return this.scId;
  }

  public void setScId(final String scId) {
    this.scId = scId;
  }
}

package dev.trindadedev.blockode.ui.editor.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import static dev.trindadedev.blockode.Blockode.getPublicFolderFile;

import com.google.gson.reflect.TypeToken;
import dev.trindadedev.blockode.base.Contextualizable;
import dev.trindadedev.blockode.beans.VariableBean;
import dev.trindadedev.blockode.project.ProjectManager;
import dev.trindadedev.blockode.utils.FileUtil;
import dev.trindadedev.blockode.utils.GsonUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VariablesManager extends Contextualizable {

  private String scId;
  private List<VariableBean> variables;
  
  public VariablesManager(@NonNull final Context context) {
    this(context, null);
  }

  public VariablesManager(@NonNull final Context context, final String scId) {
    super(context);
    variables = new ArrayList<>();
    this.scId = scId;
    readVariables();
  }

  /**
   * Add new variable in list and save
   *
   * @param variable: The Bean of Variable with info
   * @see VariableBean
   */
  public void addVariable(final VariableBean variable) {
    variables.add(variable);
    saveVariables();
  }

  /*
   * Return only variables with requested type.
   *
   * @param type: The Type of Variables
   */
  public List<VariableBean> getVariablesByType(final int type) {
    List<VariableBean> result = new ArrayList<>();
    variables.forEach(
        variable -> {
          if (variable.type == type) {
            result.add(variable);
          }
        });
    return result;
  }

  /*
   * Read and return all variables of project from file.
   *
   * @ see getVariablesFile()
   */
  private List<VariableBean> readVariables() {
    var variables = new ProjectManager(context, scId).getProjectByScId().variables;
    return variables;
  }

  /**
   * Save all variables in file
   *
   * @see getVariablesFile()
   */
  private void saveVariables() {
    var json = GsonUtil.getGson().toJson(variables);
    FileUtil.writeText(ProjectManager.getVariablesFile(scId).getAbsolutePath(), json);
  }

  public void setScId(final String scId) {
    this.scId = scId;
    readVariables(); // read variables again if scId changes
  }

  public String getScId() {
    return scId;
  }
}

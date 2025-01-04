package dev.trindadedev.theblocklogicsjava.ui.editor.manager;

import static dev.trindadedev.theblocklogicsjava.TheBlockLogics.getPublicFolderFile;

import com.google.gson.reflect.TypeToken;
import dev.trindadedev.theblocklogicsjava.beans.VariableBean;
import dev.trindadedev.theblocklogicsjava.utils.FileUtil;
import dev.trindadedev.theblocklogicsjava.utils.GsonUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VariablesManager {

  private String scId;
  private List<VariableBean> variables;

  public VariablesManager(final String scId) {
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
    var listType = new TypeToken<List<VariableBean>>() {}.getType();
    var json = FileUtil.readFile(getVariablesFile().getAbsolutePath());
    return GsonUtil.getGson().fromJson(json, listType);
  }

  /**
   * Save all variables in file
   *
   * @see getVariablesFile()
   */
  private void saveVariables() {
    var json = GsonUtil.getGson().toJson(variables);
    FileUtil.writeText(getVariablesFile().getAbsolutePath(), json);
  }

  /** The file where variables are stored */
  private File getVariablesFile() {
    return new File(getPublicFolderFile(), "data/variables.json");
  }

  public void setScId(final String scId) {
    this.scId = scId;
  }

  public String getScId() {
    return scId;
  }
}

package dev.trindadedev.theblocklogicsjava.ui.editor.manager;

import static dev.trindadedev.theblocklogicsjava.TheBlockLogics.getPublicFolderFile;

import dev.trindadedev.theblocklogicsjava.beans.VariableBean;
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

  public void addVariable(final VariableBean variable) {
    variables.add(variable);
    saveVariables();
  }

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

  private void readVariables() {
    // todo
  }

  private void saveVariables() {
    // todo
  }

  private File getVariablesFile() {
    return new File(getPublicFolderFile(), "data/variables.json");
  }

  private String getScId() {
    return scId;
  }
}

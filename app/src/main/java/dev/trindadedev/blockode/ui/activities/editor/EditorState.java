package dev.trindadedev.blockode.ui.activities.editor;

import java.io.Serializable;

public class EditorState implements Serializable {
  public String scId;
  public String className;

  public String getScId() {
    return this.scId;
  }

  public void setScId(String scId) {
    this.scId = scId;
  }

  public String getClassName() {
    return this.className;
  }

  public void setClassName(String className) {
    this.className = className;
  }
}

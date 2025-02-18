package dev.trindadedev.blockode.ui.activities.editor;

import android.os.Parcel;
import android.os.Parcelable;
import dev.trindadedev.blockode.beans.BaseBean;
import dev.trindadedev.blockode.beans.ProjectBean;
import dev.trindadedev.blockode.utils.ParcelUtil;

public class EditorState extends BaseBean implements Parcelable {

  public static final Creator<EditorState> CREATOR =
      new Creator<EditorState>() {

        public EditorState createFromParcel(Parcel parcel) {
          return new EditorState(parcel);
        }

        public EditorState[] newArray(int i) {
          return new EditorState[i];
        }
      };

  public ProjectBean project;

  public EditorState() {}

  public EditorState(final Parcel parcel) {
    this.project = ParcelUtil.readParcelable(parcel, ProjectBean.class);
  }

  @Override
  public Creator getCreator() {
    return CREATOR;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(final Parcel parcel, int flags) {
    parcel.writeParcelable(project, flags);
  }

  @Override
  public void print() {
    project.print();
  }
}

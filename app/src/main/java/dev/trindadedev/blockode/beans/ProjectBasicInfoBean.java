package dev.trindadedev.blockode.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dev.trindadedev.blockode.utils.PrintUtil;

public class ProjectBasicInfoBean extends BaseBean implements Parcelable {
  public static final Creator<ProjectBasicInfoBean> CREATOR =
      new Creator<ProjectBasicInfoBean>() {
        public ProjectBasicInfoBean createFromParcel(Parcel parcel) {
          return new ProjectBasicInfoBean(parcel);
        }

        public ProjectBasicInfoBean[] newArray(int size) {
          return new ProjectBasicInfoBean[size];
        }
      };

  public String name;
  public String packageName;

  public ProjectBasicInfoBean() {}

  public ProjectBasicInfoBean(final Parcel parcel) {
    this.name = parcel.readString();
    this.packageName = parcel.readString();
  }

  public void copy(final ProjectBasicInfoBean other) {
    this.name = other.name;
    this.packageName = other.packageName;
  }

  public int describeContents() {
    return 0;
  }

  @Override
  public void print() {
    PrintUtil.print(this.name);
    PrintUtil.print(this.packageName);
  }

  public void writeToParcel(final Parcel parcel, final int flags) {
    parcel.writeString(this.name);
    parcel.writeString(this.packageName);
  }
}

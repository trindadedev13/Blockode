package dev.trindadedev.blockode.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dev.trindadedev.blockode.utils.PrintUtil;

public class VariableBean extends BaseBean implements Parcelable {
  public static final Creator<VariableBean> CREATOR =
      new Creator<VariableBean>() {
        public VariableBean createFromParcel(Parcel parcel) {
          return new VariableBean(parcel);
        }

        public VariableBean[] newArray(int size) {
          return new VariableBean[size];
        }
      };

  public int type;
  public String name;

  public VariableBean() {}

  public VariableBean(Parcel parcel) {
    this.type = parcel.readInt();
    this.name = parcel.readString();
  }

  public void copy(VariableBean other) {
    this.type = other.type;
    this.name = other.name;
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
  public void print() {
    PrintUtil.print(this.type);
    PrintUtil.print(this.name);
  }

  @Override
  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeInt(this.type);
    parcel.writeString(this.name);
  }
}

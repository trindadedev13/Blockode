package dev.trindadedev.theblocklogicsjava.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class BlockBean extends BaseBean implements Parcelable {
  public static final Creator<BlockBean> CREATOR =
      new Creator<BlockBean>() {

        public BlockBean createFromParcel(Parcel parcel) {
          return new BlockBean(parcel);
        }

        public BlockBean[] newArray(int i) {
          return new BlockBean[i];
        }
      };

  public int color;
  public int nextBlock;
  public int subStack1;
  public int subStack2;
  public String id;
  public String opCode;
  public String spec;
  public String type;
  public ArrayList<String> parametersTypes;
  public ArrayList<String> parameters;

  public BlockBean() {
    this.parameters = new ArrayList();
    this.parametersTypes = new ArrayList();
    this.subStack1 = -1;
    this.subStack2 = -1;
    this.nextBlock = -1;
  }

  public BlockBean(Parcel parcel) {
    this.color = parcel.readInt();
    this.nextBlock = parcel.readInt();
    this.subStack1 = parcel.readInt();
    this.subStack2 = parcel.readInt();
    this.id = parcel.readString();
    this.opCode = parcel.readString();
    this.spec = parcel.readString();
    this.type = parcel.readString();
    this.parameters = (ArrayList) parcel.readSerializable();
    this.parametersTypes = (ArrayList) parcel.readSerializable();
  }

  public BlockBean(String str, String str2, String str3, String str4) {
    this.nextBlock = -1;
    this.subStack1 = -1;
    this.subStack2 = -1;
    this.id = str;
    this.opCode = str4;
    this.spec = str2;
    this.type = str3;
    this.parameters = new ArrayList();
    this.parametersTypes = new ArrayList();
  }

  public static Creator<BlockBean> getCreator() {
    return CREATOR;
  }

  public void copy(BlockBean blockBean) {
    this.color = blockBean.color;
    this.nextBlock = blockBean.nextBlock;
    this.subStack1 = blockBean.subStack1;
    this.subStack2 = blockBean.subStack2;
    this.id = blockBean.id;
    this.opCode = blockBean.opCode;
    this.spec = blockBean.spec;
    this.type = blockBean.type;
    this.parameters = new ArrayList(blockBean.parameters);
    this.parametersTypes = new ArrayList(blockBean.parametersTypes);
  }

  public int describeContents() {
    return 0;
  }

  public void print() {}

  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(this.color);
    parcel.writeInt(this.nextBlock);
    parcel.writeInt(this.subStack1);
    parcel.writeInt(this.subStack2);
    parcel.writeString(this.id);
    parcel.writeString(this.opCode);
    parcel.writeString(this.spec);
    parcel.writeString(this.type);
    parcel.writeSerializable(this.parameters);
    parcel.writeSerializable(this.parametersTypes);
  }
}

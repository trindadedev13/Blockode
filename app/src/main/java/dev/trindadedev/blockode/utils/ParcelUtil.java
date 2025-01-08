package dev.trindadedev.blockode.utils;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.io.Serializable;

/** some util methods to be used with android.os.Parcel */
public class ParcelUtil {

  /**
   * Try read a parcelable with SDK verification to avoid crashes.
   *
   * @param parcel Parcel with parcelable.
   * @param clazz a Class of the parcelable to be used in SDK 33
   */
  @Nullable
  public static <T extends Parcelable> T readParcelable(final Parcel parcel, final Class<T> clazz) {
    if (parcel == null) return null;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      return parcel.readParcelable(clazz.getClassLoader());
    } else {
      return parcel.readParcelable(clazz.getClassLoader(), clazz);
    }
  }

  /**
   * Try read a serializable with SDK verification to avoid crashes.
   *
   * @param parcel Parcel with serializable.
   * @param clazz a Class of the serializable to be used in SDK 33
   */
  @Nullable
  public static <T extends Serializable> T readSerializable(
      final Parcel parcel, final Class<T> clazz) {
    if (parcel == null) return null;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      return parcel.readSerializable(clazz.getClassLoader(), clazz);
    } else {
      return (T) parcel.readSerializable();
    }
  }
}

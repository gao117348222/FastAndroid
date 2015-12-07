package com.gx303.framedemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2015/10/23.
 */
public class abc implements Parcelable {
    private String mUser;
    private int id;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mUser);
        dest.writeInt(this.id);
    }

    public abc() {
    }

    protected abc(Parcel in) {
        this.mUser = in.readString();
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<abc> CREATOR = new Parcelable.Creator<abc>() {
        public abc createFromParcel(Parcel source) {
            return new abc(source);
        }

        public abc[] newArray(int size) {
            return new abc[size];
        }
    };
}

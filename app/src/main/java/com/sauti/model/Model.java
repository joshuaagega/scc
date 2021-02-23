package com.sauti.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    String Title, code, tags;
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public Model() {
    }

    public Model(String title, String code, String tags) {
        this.Title = title;
        this.code = code;
        this.tags = tags;
    }

    public String getTitle() {
        return Title;
    }

    public String getCode() {
        return code;
    }

    public String getTags() {
        return tags;
    }

    public Model(Parcel in) {
        this.Title = in.readString();
        this.code = in.readString();
        this.tags = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.Title);
        dest.writeString(this.code);
        dest.writeString(this.tags);
    }
}

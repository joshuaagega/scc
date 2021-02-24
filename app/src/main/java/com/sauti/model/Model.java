package com.sauti.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    String Title, desc, cost, tags;
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

    public Model(String title, String code, String tags,String desc) {
        this.Title = title;
        this.cost = code;
        this.tags = tags;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return Title;
    }

    public String getCost() {
        return cost;
    }

    public String getTags() {
        return tags;
    }

    public Model(Parcel in) {
        this.Title = in.readString();
        this.cost = in.readString();
        this.tags = in.readString();
        this.desc = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.Title);
        dest.writeString(this.cost);
        dest.writeString(this.tags);
        dest.writeString(this.desc);
    }
}

package com.example.projekt;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {

    private String name;
    private String description;
    private String size;

    public Food(String name, String description, String size) {
        this.name = name;
        this.description = description;
        this.size = size;
    }

    protected Food(Parcel in) {
        name = in.readString();
        description = in.readString();
        size = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(size);
    }
}

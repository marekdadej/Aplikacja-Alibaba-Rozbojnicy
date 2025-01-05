package com.example.projekt;

import android.os.Parcel;
import android.os.Parcelable;

public class Alko implements Parcelable {

    private final String name;
    private final String description;
    private final String price;

    public Alko(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    protected Alko(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readString();
    }

    public static final Creator<Alko> CREATOR = new Creator<Alko>() {
        @Override
        public Alko createFromParcel(Parcel in) {
            return new Alko(in);
        }

        @Override
        public Alko[] newArray(int price) {
            return new Alko[price];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(price);
    }
}

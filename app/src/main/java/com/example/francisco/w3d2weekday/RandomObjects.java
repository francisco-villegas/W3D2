package com.example.francisco.w3d2weekday;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by FRANCISCO on 14/08/2017.
 */

public class RandomObjects implements Parcelable {
    String random1;
    double random2;
    int random3;
    int random4;

    public RandomObjects(String random1, double random2, int random3, int random4) {
        this.random1 = random1;
        this.random2 = random2;
        this.random3 = random3;
        this.random4 = random4;
    }

    protected RandomObjects(Parcel in) {
        random1 = in.readString();
        random2 = in.readDouble();
        random3 = in.readInt();
        random4 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(random1);
        dest.writeDouble(random2);
        dest.writeInt(random3);
        dest.writeInt(random4);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RandomObjects> CREATOR = new Creator<RandomObjects>() {
        @Override
        public RandomObjects createFromParcel(Parcel in) {
            return new RandomObjects(in);
        }

        @Override
        public RandomObjects[] newArray(int size) {
            return new RandomObjects[size];
        }
    };

    public String getRandom1() {
        return random1;
    }

    public void setRandom1(String random1) {
        this.random1 = random1;
    }

    public double getRandom2() {
        return random2;
    }

    public void setRandom2(double random2) {
        this.random2 = random2;
    }

    public int getRandom3() {
        return random3;
    }

    public void setRandom3(int random3) {
        this.random3 = random3;
    }

    public int getRandom4() {
        return random4;
    }

    public void setRandom4(int random4) {
        this.random4 = random4;
    }
}

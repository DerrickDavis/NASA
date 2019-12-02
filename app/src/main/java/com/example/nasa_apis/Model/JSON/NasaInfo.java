
package com.example.nasa_apis.Model.JSON;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NasaInfo implements Parcelable
{

    @SerializedName("collection")
    @Expose
    private Collection collection;
    public final static Creator<NasaInfo> CREATOR = new Creator<NasaInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NasaInfo createFromParcel(Parcel in) {
            return new NasaInfo(in);
        }

        public NasaInfo[] newArray(int size) {
            return (new NasaInfo[size]);
        }

    }
    ;

    protected NasaInfo(Parcel in) {
        this.collection = ((Collection) in.readValue((Collection.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public NasaInfo() {
    }

    /**
     * 
     * @param collection
     */
    public NasaInfo(Collection collection) {
        super();
        this.collection = collection;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(collection);
    }

    public int describeContents() {
        return  0;
    }

}


package com.example.nasa_apis.Model.JSON;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    public final static Creator<Collection> CREATOR = new Creator<Collection>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Collection createFromParcel(Parcel in) {
            return new Collection(in);
        }

        public Collection[] newArray(int size) {
            return (new Collection[size]);
        }

    }
    ;

    protected Collection(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.items, (com.example.nasa_apis.Model.JSON.Item.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Collection() {
    }

    /**
     * 
     * @param href
     * @param items
     */
    public Collection(String href, List<Item> items) {
        super();
        this.href = href;
        this.items = items;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}


package com.example.nasa_apis.Model.JSON;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    public final static Creator<Item> CREATOR = new Creator<Item>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return (new Item[size]);
        }

    }
    ;

    protected Item(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.links, (com.example.nasa_apis.Model.JSON.Link.class.getClassLoader()));
        in.readList(this.data, (Datum.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param data
     * @param links
     * @param href
     */
    public Item(String href, List<Link> links, List<Datum> data) {
        super();
        this.href = href;
        this.links = links;
        this.data = data;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
        dest.writeList(links);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}

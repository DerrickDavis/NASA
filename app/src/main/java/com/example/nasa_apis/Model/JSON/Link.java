
package com.example.nasa_apis.Model.JSON;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("render")
    @Expose
    private String render;
    @SerializedName("rel")
    @Expose
    private String rel;
    public final static Creator<Link> CREATOR = new Creator<Link>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Link createFromParcel(Parcel in) {
            return new Link(in);
        }

        public Link[] newArray(int size) {
            return (new Link[size]);
        }

    }
    ;

    protected Link(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
        this.render = ((String) in.readValue((String.class.getClassLoader())));
        this.rel = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Link() {
    }

    /**
     * 
     * @param rel
     * @param href
     * @param render
     */
    public Link(String href, String render, String rel) {
        super();
        this.href = href;
        this.render = render;
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
        dest.writeValue(render);
        dest.writeValue(rel);
    }

    public int describeContents() {
        return  0;
    }

}

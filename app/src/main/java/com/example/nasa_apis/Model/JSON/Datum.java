
package com.example.nasa_apis.Model.JSON;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable
{

    @SerializedName("keywords")
    @Expose
    private List<String> keywords = null;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("photographer")
    @Expose
    private String photographer;
    @SerializedName("nasa_id")
    @Expose
    private String nasaId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("center")
    @Expose
    private String center;
    @SerializedName("title")
    @Expose
    private String title;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    protected Datum(Parcel in) {
        in.readList(this.keywords, (String.class.getClassLoader()));
        this.mediaType = ((String) in.readValue((String.class.getClassLoader())));
        this.photographer = ((String) in.readValue((String.class.getClassLoader())));
        this.nasaId = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.dateCreated = ((String) in.readValue((String.class.getClassLoader())));
        this.center = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param dateCreated
     * @param keywords
     * @param center
     * @param description
     * @param mediaType
     * @param photographer
     * @param location
     * @param title
     * @param nasaId
     */
    public Datum(List<String> keywords, String mediaType, String photographer, String nasaId, String description, String location, String dateCreated, String center, String title) {
        super();
        this.keywords = keywords;
        this.mediaType = mediaType;
        this.photographer = photographer;
        this.nasaId = nasaId;
        this.description = description;
        this.location = location;
        this.dateCreated = dateCreated;
        this.center = center;
        this.title = title;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getNasaId() {
        return nasaId;
    }

    public void setNasaId(String nasaId) {
        this.nasaId = nasaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(keywords);
        dest.writeValue(mediaType);
        dest.writeValue(photographer);
        dest.writeValue(nasaId);
        dest.writeValue(description);
        dest.writeValue(location);
        dest.writeValue(dateCreated);
        dest.writeValue(center);
        dest.writeValue(title);
    }

    public int describeContents() {
        return  0;
    }

}

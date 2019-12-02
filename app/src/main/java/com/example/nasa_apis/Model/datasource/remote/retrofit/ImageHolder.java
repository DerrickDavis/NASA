package com.example.nasa_apis.Model.datasource.remote.retrofit;

import com.example.nasa_apis.Model.JSON.Datum;
import com.example.nasa_apis.Model.JSON.Item;


import java.util.List;

public interface ImageHolder {
    void getList(List<Datum> nasapi);

    void getList(List<Datum> nsapi, List<Item> imItm);
}

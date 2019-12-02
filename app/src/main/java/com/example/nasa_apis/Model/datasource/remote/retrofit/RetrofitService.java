package com.example.nasa_apis.Model.datasource.remote.retrofit;

import com.example.nasa_apis.Model.JSON.NasaInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.nasa_apis.Model.datasource.remote.retrofit.Constants.Q;
import static com.example.nasa_apis.Model.datasource.remote.retrofit.Constants.SEARCH;

public interface RetrofitService {
    @GET(SEARCH)
    Call<NasaInfo> getImages(@Query(Q) String pics);

}

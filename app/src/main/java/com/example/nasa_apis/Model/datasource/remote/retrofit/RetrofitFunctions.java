package com.example.nasa_apis.Model.datasource.remote.retrofit;

import android.util.Log;

import com.example.nasa_apis.Model.JSON.Collection;
import com.example.nasa_apis.Model.JSON.Datum;
import com.example.nasa_apis.Model.JSON.Item;
import com.example.nasa_apis.Model.JSON.NasaInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.nasa_apis.Model.datasource.remote.retrofit.Constants.IMG_URL;

public class RetrofitFunctions {
    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(IMG_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RetrofitService getService() {

        return getRetrofitInstance().create(RetrofitService.class);
    }

    public static void getPic(final ImageHolder imageHolder) {

        RetrofitFunctions retrofitHelper = new RetrofitFunctions();
        retrofitHelper.getService().getImages("apollo11").enqueue(new Callback<NasaInfo>() {
            @Override
            public void onResponse(Call<NasaInfo> call, Response<NasaInfo> response) {

                //String firstInList = response.body().get(0).getThumbnailUrl();
                NasaInfo list = response.body();
                Collection collection = list.getCollection();
                List<Item> item = collection.getItems();
                ArrayList<Datum> mdatum = new ArrayList<>();
                for (int i = 0; i < item.size(); i++) {
                    List<Datum> data;
                    data = item.get(i).getData();
                    mdatum.addAll(data);

                }
                Log.d("data_size", "" + mdatum.size());
                List<Datum> datumlist = new ArrayList<>();
                for (int i = 0; i < mdatum.size(); i++) {
                    Datum dtm = new Datum();
                    dtm.setTitle(mdatum.get(i).getTitle());
                    dtm.setDateCreated(mdatum.get(i).getDateCreated());
                    dtm.setPhotographer(mdatum.get(i).getPhotographer());
                    datumlist.add(dtm);
                }

                //Log.d("TAG_RETROFIT", list.toString());
                imageHolder.getList(datumlist);


            }

            @Override
            public void onFailure(Call<NasaInfo> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}

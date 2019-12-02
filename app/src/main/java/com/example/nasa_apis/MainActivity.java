package com.example.nasa_apis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.nasa_apis.Model.JSON.Datum;
import com.example.nasa_apis.Model.JSON.Item;
import com.example.nasa_apis.Model.datasource.remote.retrofit.ImageHolder;

import java.util.List;

import static com.example.nasa_apis.Model.datasource.remote.retrofit.RetrofitFunctions.getPic;

public class MainActivity extends AppCompatActivity implements ImageHolder {
    RecyclerView picassoPicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picassoPicList = findViewById(R.id.rv_nasa_obj);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPic(this);
    }

    @Override
    public void getList(List<Datum> nasapi) {

    }

    @Override
    public void getList(List<Datum> nsapi, List<Item> imItm) {
        //String firstInList = nsapi.get(0).getThumbnailUrl();

        String frstLst = imItm.get(0).getHref();

        Log.d("TAG_List", frstLst);

        LinearLayoutManager llppView = new LinearLayoutManager(this);

        RVAdapter display = new RVAdapter(this, nsapi, imItm);

        picassoPicList.setLayoutManager(llppView);

        picassoPicList.setAdapter(display);
    }
}

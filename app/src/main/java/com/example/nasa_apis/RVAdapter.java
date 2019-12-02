package com.example.nasa_apis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nasa_apis.Model.JSON.Datum;
import com.example.nasa_apis.Model.JSON.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MVH> {
    Context context;
    private List<Datum> mPicData;
    private List<Item> mImgItm;

    public RVAdapter(Context pContx, List<Datum> pPicData, List<Item> mImgItm) {
        this.context = pContx;
        this.mPicData = pPicData;
        this.mImgItm = mImgItm;
    }

    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vw;
        LayoutInflater mInflate = LayoutInflater.from(context);
        vw = mInflate.inflate(R.layout.rec_view_item, parent, false);

        return new MVH(vw);
    }

    @Override
    public void onBindViewHolder(@NonNull MVH holder, int position) {
        Datum VHdtm = mPicData.get(position);
        Item VHItm = mImgItm.get(position);

        holder.tv_title.setText(VHdtm.getTitle());
        holder.tv_author.setText(VHdtm.getPhotographer());
        holder.tv_date.setText(VHdtm.getDateCreated());

        //String x = mPicData.get(position).getThumbnailUrl();
        //String x = mImgItm.get(position).getHref();

        String x = VHItm.getHref();
        Picasso.get()
                .load(x)
                .resize(100,100)
                .into(holder.iv_imgPlc);
    }

    @Override
    public int getItemCount() {
        return mPicData.size();
    }

    public static class MVH extends RecyclerView.ViewHolder {

        TextView tv_author;
        TextView tv_title;
        TextView tv_date;
        ImageView iv_imgPlc;

        public MVH(@NonNull View itmVw) {
            super(itmVw);

            tv_author = itmVw.findViewById(R.id.tvauthor);
            tv_title = itmVw.findViewById(R.id.tvtitle);
            tv_date = itmVw.findViewById(R.id.tvdate);
            iv_imgPlc = itmVw.findViewById(R.id.ivnasapic);
        }
    }
}

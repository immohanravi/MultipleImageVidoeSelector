package com.immohanravi.multiimageselector.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.immohanravi.multiimageselector.R;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MyViewHolder>{
    private static final String TAG = "MediaAdapter";
    private List<String> bitmapList;
    private List<Boolean> selected;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail,check;

        public MyViewHolder(View view) {
            super(view);
            thumbnail=(ImageView) view.findViewById(R.id.image);
            check=(ImageView) view.findViewById(R.id.image2);
        }
    }

    public MediaAdapter(List<String> bitmapList, List<Boolean> selected, Context context) {
        this.bitmapList = bitmapList;
        this.context=context;
        this.selected=selected;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load("file://"+bitmapList.get(position)).apply(new RequestOptions().override(153,160).centerCrop().dontAnimate().skipMemoryCache(true)).transition(withCrossFade()).into(holder.thumbnail);
        Log.d(TAG, "onBindViewHolder: file://"+bitmapList.get(position));
        if(selected.get(position).equals(true)){
            holder.check.setVisibility(View.VISIBLE);
            holder.check.setAlpha(150);
        }else{
            holder.check.setVisibility(View.GONE);
        }

    }

    @Override
   public int getItemCount() {
        return bitmapList.size();
    }
}


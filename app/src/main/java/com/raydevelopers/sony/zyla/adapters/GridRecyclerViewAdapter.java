package com.raydevelopers.sony.zyla.adapters;

import android.Manifest;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raydevelopers.sony.zyla.R;
import com.raydevelopers.sony.zyla.databinding.GridRvLayoutBinding;
import com.raydevelopers.sony.zyla.models.SongDetails;

import java.util.ArrayList;

/**
 * Created by SONY on 22-12-2017.
 */

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder>{
Context mContext;
    ArrayList<SongDetails> arrayList;
    String artist;
    public  GridRecyclerViewAdapter(Context c,ArrayList<SongDetails> l,String s)
    {
        this.mContext=c;
        this.arrayList=l;
        this.artist=s;
    }
    @Override
    public GridRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GridRvLayoutBinding rvLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext)
        , R.layout.grid_rv_layout,parent,false);

        return new MyViewHolder(rvLayoutBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(GridRecyclerViewAdapter.MyViewHolder holder, int position) {
        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).getmArtist().equals(artist))
            {

                SongDetails s=arrayList.get(position);

                holder.layoutBinding.setSongs(s);
            }
        }
    }

    @Override
    public int getItemCount() {
        if(arrayList.size()>0)
            return arrayList.size();
        else
            return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        GridRvLayoutBinding layoutBinding;
        public MyViewHolder(View itemView) {
            super(itemView);
            layoutBinding=DataBindingUtil.bind(itemView);
        }
    }
}

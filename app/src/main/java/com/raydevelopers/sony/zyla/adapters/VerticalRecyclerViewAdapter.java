package com.raydevelopers.sony.zyla.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raydevelopers.sony.zyla.R;
import com.raydevelopers.sony.zyla.databinding.GridRvLayoutBinding;
import com.raydevelopers.sony.zyla.databinding.VerticalRvLayoutBinding;
import com.raydevelopers.sony.zyla.models.SongDetails;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SONY on 22-12-2017.
 */

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.Holder> {
    Context mContext;
    ArrayList<SongDetails> list;
    HashMap<String,ArrayList<SongDetails>> hashMap=new HashMap<>();


    public VerticalRecyclerViewAdapter(Context c,ArrayList<SongDetails> details)
    {
        this.mContext=c;
        this.list=details;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        VerticalRvLayoutBinding binding=DataBindingUtil.inflate(LayoutInflater.from(mContext)
        , R.layout.vertical_rv_layout,parent,false);


        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
SongDetails song=list.get(position);

        holder.binding.setSong(song);
        if(!hashMap.containsKey(song.getmName()))
        {

        }
        GridRecyclerViewAdapter recyclerViewAdapter=new GridRecyclerViewAdapter(mContext,list,song.getmArtist());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2,LinearLayoutManager.VERTICAL,false);
        holder.binding.gridRv.setLayoutManager(gridLayoutManager);
        holder.binding.gridRv.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        if(list.size()>0)
            return list.size();
        return 0;
    }



    public class Holder extends  RecyclerView.ViewHolder{
VerticalRvLayoutBinding binding;
        public Holder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}

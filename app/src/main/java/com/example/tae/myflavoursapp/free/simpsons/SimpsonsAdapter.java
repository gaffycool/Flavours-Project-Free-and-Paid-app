package com.example.tae.myflavoursapp.free.simpsons;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tae.myflavoursapp.R;
import com.example.tae.myflavoursapp.data.network.model.CharactersModel;
import com.example.tae.myflavoursapp.data.network.model.RelatedTopic;
import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 21-Feb-18.
 */

class SimpsonsAdapter extends RecyclerView.Adapter<SimpsonsAdapter.MyViewHolder>{

    private Context applicationContext;
    private int row;
    private List<RelatedTopic> results;
    private Consumer<CharactersModel> consumer;

    public SimpsonsAdapter(Context applicationContext, List<RelatedTopic> results, int row) {
        this.applicationContext = applicationContext;
        this.results = results;
        this.row = row;
        this.consumer = consumer;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpsonsAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mName.setText(results.get(position).getText().toString());
        holder.mText.setText(results.get(position).getResult().toString());
        holder.mURL.setText(results.get(position).getFirstURL().toString());
        holder.mIcon.setText(results.get(position).getIcon().toString());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mName, mText, mURL, mIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.mName);
            mText = itemView.findViewById(R.id.mText);
            mURL = itemView.findViewById(R.id.mURL);
            mIcon = itemView.findViewById(R.id.mIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                   // String id = results.get(pos).getPreviewUrl();
                   // String name = results.get(pos).getArtistName();
                  //  String collection = results.get(pos).getCollectionName();
                  //  String artWork = results.get(pos).getArtworkUrl60();
                    //GET IN BUNDLE ETC

                    //check if item still exits
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        RelatedTopic clickedDataItem = results.get(pos);
                        //code to play music
                       // MainActivity.playMusic(id, name, collection, artWork);
                    }
                }
            });


        }
    }
}

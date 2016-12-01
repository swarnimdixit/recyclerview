package com.example.swarnim_d.cardviewlist;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by swarnim_d on 01-12-2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    private ArrayList<FlowerModel> mDataset;

    public RecyclerViewAdapter(ArrayList<FlowerModel> mDataset) {
        this.mDataset = mDataset;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCard;
        public TextView mText, mDescription;
        public ImageView mImage;

        public ViewHolder(CardView cardView) {
            super(cardView);
            mCard = cardView;
            mImage = (ImageView) mCard.findViewById(R.id.item_image);
            mText = (TextView) mCard.findViewById(R.id.item_text);
            mDescription = (TextView) mCard.findViewById(R.id.item_description);
        }
    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder((CardView) v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        context = holder.mCard.getContext();


        final FlowerModel flowerModel = mDataset.get(holder.getAdapterPosition());
        holder.mImage.setImageResource(flowerModel.getmImage());
        holder.mText.setText(flowerModel.getmText());
        holder.mDescription.setText(flowerModel.getmDescription());

    holder.mCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        ItemDescription itemDescription = new ItemDescription();
            Intent intent = new Intent((ListActivity)context,ItemDescription.class);
            if(flowerModel!=null) {
                intent.putExtra("toDescText",flowerModel.getmText());
                intent.putExtra("toDescDesc",flowerModel.getmDescription());
                intent.putExtra("toDescImg",flowerModel.getmImage());
            }
            context.startActivity(intent);


        }
    });


    }



    @Override
    public int getItemCount() {
            return mDataset.size();
    }


}

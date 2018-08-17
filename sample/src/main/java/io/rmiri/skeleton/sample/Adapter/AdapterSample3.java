package io.rmiri.skeleton.sample.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.rmiri.skeleton.SkeletonGroup;
import io.rmiri.skeleton.master.AdapterSkeleton;
import io.rmiri.skeleton.master.IsCanSetAdapterListener;
import io.rmiri.skeleton.sample.Data.DataObject;
import io.rmiri.skeleton.sample.R;


public class AdapterSample3 extends AdapterSkeleton<DataObject, AdapterSample3.ViewHolder> {


  public AdapterSample3(final Context context, final ArrayList<DataObject> items, final RecyclerView recyclerView, final IsCanSetAdapterListener IsCanSetAdapterListener) {
    this.context = context;
    this.items = items;
    this.isCanSetAdapterListener = IsCanSetAdapterListener;

    measureHeightRecyclerViewAndItem(recyclerView, R.layout.item_sample_3);// Set height

  }


  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample_3, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {

    holder.cardView.setPreventCornerOverlap(false);

//        holder.skeletonGroup.setPosition(position);//just for debug log

    if (skeletonConfig.isSkeletonIsOn()) {
      //need show s for 2 cards
      holder.skeletonGroup.setAutoPlay(true);
      return;
    } else {
      holder.skeletonGroup.setShowSkeleton(false);
      holder.skeletonGroup.finishAnimation();
    }

    //set data in view
    final DataObject cardObj = items.get(position);

    holder.titleTv.setText(cardObj.getTitle());
    holder.descriptionTv.setText(cardObj.getDescription());
    holder.priceTv.setText(cardObj.getPrice());

    if (cardObj.isNew()) {
      holder.newFlagTv.setVisibility(View.VISIBLE);
    } else {
      holder.newFlagTv.setVisibility(View.GONE);
    }

    //set photo by Picasso lib
    Picasso.get().load(cardObj.getPhoto()).into(holder.photoACImgV);

  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private SkeletonGroup skeletonGroup;
    private AppCompatImageView photoACImgV;
    private TextView newFlagTv;
    private TextView titleTv;
    private TextView descriptionTv;
    private TextView priceTv;


    ViewHolder(View itemView) {
      super(itemView);

      cardView = itemView.findViewById(R.id.cardView);
      skeletonGroup = itemView.findViewById(R.id.skeletonGroup);
      photoACImgV = itemView.findViewById(R.id.photoACImgV);
      newFlagTv = itemView.findViewById(R.id.newFlagTv);
      titleTv = itemView.findViewById(R.id.titleTv);
      descriptionTv = itemView.findViewById(R.id.descriptionTv);
      priceTv = itemView.findViewById(R.id.priceTv);

    }
  }


}

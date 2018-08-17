package io.rmiri.skeleton.master;

import android.support.v7.widget.RecyclerView;

public class SkeletonConfig {

  private boolean skeletonIsOn = true;
  private float recyclerViewHeight, itemHeight;
  private int numberItemShow;
  private RecyclerView recyclerView;


  public SkeletonConfig() {
  }

  public SkeletonConfig(boolean skeletonIsOn, float recyclerViewHeight, float itemHeight, int numberItemShow, RecyclerView recyclerView) {
    this.skeletonIsOn = skeletonIsOn;
    this.recyclerViewHeight = recyclerViewHeight;
    this.itemHeight = itemHeight;
    this.numberItemShow = numberItemShow;
    this.recyclerView = recyclerView;
  }


  public boolean isSkeletonIsOn() {
    return skeletonIsOn;
  }

  public SkeletonConfig setSkeletonIsOn(boolean skeletonIsOn) {
    this.skeletonIsOn = skeletonIsOn;
    return this;
  }

  public float getRecyclerViewHeight() {
    return recyclerViewHeight;
  }

  public SkeletonConfig setRecyclerViewHeight(float recyclerViewHeight) {
    this.recyclerViewHeight = recyclerViewHeight;
    return this;
  }

  public float getItemHeight() {
    return itemHeight;
  }

  public SkeletonConfig setItemHeight(float itemHeight) {
    this.itemHeight = itemHeight;
    return this;
  }

  public int getNumberItemShow() {
    return numberItemShow;
  }

  public SkeletonConfig setNumberItemShow(int numberItemShow) {
    this.numberItemShow = numberItemShow;
    return this;
  }

  public RecyclerView getRecyclerView() {
    return recyclerView;
  }

  public SkeletonConfig setRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
    return this;
  }

  public SkeletonConfig build() {
    return new SkeletonConfig(skeletonIsOn, recyclerViewHeight, itemHeight, numberItemShow, recyclerView);
  }
}

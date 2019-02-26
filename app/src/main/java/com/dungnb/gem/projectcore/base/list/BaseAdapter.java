package com.dungnb.gem.projectcore.base.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseAdapter<O, VH extends BaseViewHolder<O>> extends RecyclerView.Adapter<VH> {
  ArrayList<O> mItems;
  Context mContext;

  public BaseAdapter(Context context) {
    mContext = context;
    mItems = new ArrayList<>();
  }

  public ArrayList<O> getItems() {
    return mItems;
  }

  public O getItem(int position) {
    return mItems.get(position);
  }

  public void addItem(O item) {
    mItems.add(item);
    notifyDataSetChanged();
  }

  public void addItems(ArrayList<O> otherNewList) {
    int lengthOldList = mItems.size();
    mItems.addAll(lengthOldList, otherNewList);
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mItems.size();
  }
}

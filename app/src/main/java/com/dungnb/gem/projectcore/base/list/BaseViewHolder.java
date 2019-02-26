package com.dungnb.gem.projectcore.base.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseViewHolder<O> extends RecyclerView.ViewHolder {

  public BaseViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public abstract void binView(O item, int position);
}

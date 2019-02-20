package com.dungnb.gem.projectcore.base.pattern_mvp.activity;

import android.content.Context;

public interface BaseActivityContract {

  interface View<P extends Presenter> {
    P createPresenter();

    P getPresenter();
  }

  interface Presenter<V extends View> {
    void setView(V view);

    V getView();

    Context getContext();
  }
}

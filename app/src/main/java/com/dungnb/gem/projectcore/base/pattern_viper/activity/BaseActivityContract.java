package com.dungnb.gem.projectcore.base.pattern_viper.activity;

import android.content.Context;

public interface BaseActivityContract {
  interface View<P extends Presenter> {
    P getPresenter();

    P createPresenter();
  }

  interface Presenter<V extends View, I extends Interactor> {
    /*Attack View*/
    void createView(V view);

    V getView();

    I createInteractor();

    I getInteractor();

    Context getContext();
  }

  interface Interactor<P extends Presenter> {
    P getPresenter();

    Context getContext();
  }
}

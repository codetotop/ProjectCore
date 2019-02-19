package com.dungnb.gem.projectcore.base.pattern_viper.activity;

import android.content.Context;

public abstract class BaseActivityPresenter<V extends BaseActivityContract.View, I extends BaseActivityContract.Interactor> implements BaseActivityContract.Presenter<V, I> {
  V mView;
  I mInteractor;

  public BaseActivityPresenter() {
    mInteractor = createInteractor();
  }

  @Override
  public V getView() {
    return mView;
  }

  @Override
  public void createView(V view) {
    mView = view;
  }

  @Override
  public I getInteractor() {
    return mInteractor;
  }

  @Override
  public Context getContext() {
    return (Context) mView;
  }
}

package com.dungnb.gem.projectcore.base.activity;

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
  public I getInteractor() {
    return mInteractor;
  }

  @Override
  public Context getContext() {
    return (Context) mView;
  }
}

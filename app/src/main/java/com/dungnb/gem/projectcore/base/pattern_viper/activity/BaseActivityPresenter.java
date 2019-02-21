package com.dungnb.gem.projectcore.base.pattern_viper.activity;

import android.content.Context;
import android.widget.Toast;

import com.dungnb.gem.projectcore.base.remote.ErrorHandler;

public abstract class BaseActivityPresenter<V extends BaseActivityContract.View, I extends BaseActivityContract.Interactor> implements BaseActivityContract.Presenter<V, I> {
  V mView;
  I mInteractor;

  public BaseActivityPresenter() {
    mInteractor = createInteractor();
    mInteractor.setPresenter(this);
  }

  @Override
  public V getView() {
    return mView;
  }

  @Override
  public void setView(V view) {
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

  @Override
  public void handleError(Throwable throwable) {
    ErrorHandler errorHandler = ErrorHandler.getInstance();
    getView().showError(errorHandler.getCode(), errorHandler.getMessage());
  }
}

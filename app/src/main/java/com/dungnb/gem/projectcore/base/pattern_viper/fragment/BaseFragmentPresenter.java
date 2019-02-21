package com.dungnb.gem.projectcore.base.pattern_viper.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.dungnb.gem.projectcore.base.remote.ErrorHandler;

public abstract class BaseFragmentPresenter<V extends BaseFragmentContract.View, I extends BaseFragmentContract.Interactor>
        implements BaseFragmentContract.Presenter<V, I> {
  V mView;
  I mInteractor;

  public BaseFragmentPresenter() {
    mView = createView();
    mView.setPresenter(this);
    mInteractor = createInteractor();
    mInteractor.setPresenter(this);
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
  public Fragment getFragment() {
    return (Fragment) mView;
  }

  @Override
  public Context getContext() {
    return mView.getContext();
  }

  @Override
  public void handleError(Throwable throwable) {
    ErrorHandler errorHandler = ErrorHandler.getInstance();
    getView().showError(errorHandler.getCode(), errorHandler.getMessage());
  }
}

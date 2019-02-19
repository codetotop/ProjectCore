package com.dungnb.gem.projectcore.base.pattern_viper.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

public abstract class BaseFragmentPresenter<V extends BaseFragmentContract.View, I extends BaseFragmentContract.Interactor>
        implements BaseFragmentContract.Presenter<V, I> {
  V mView;
  I mInteractor;

  public BaseFragmentPresenter(I interactor) {
    mView = createView();
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
  public Fragment getFragment() {
    return (Fragment) mView;
  }

  @Override
  public Context getContext() {
    return (Context) mView;
  }
}

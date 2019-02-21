package com.dungnb.gem.projectcore.base.pattern_mvp.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

public abstract class BaseFragmentPresenter<V extends BaseFragmentContract.View> implements BaseFragmentContract.Presenter<V> {
  V mView;

  public BaseFragmentPresenter() {
    mView = createView();
    mView.setPresenter(this);
  }

  @Override
  public V getView() {
    return mView;
  }

  @Override
  public Fragment getFragment() {
    return (Fragment) mView;
  }

  @Override
  public Context getContext() {
    return mView.getContext();
  }
}

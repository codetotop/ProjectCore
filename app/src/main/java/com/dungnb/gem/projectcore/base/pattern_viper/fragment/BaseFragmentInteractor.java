package com.dungnb.gem.projectcore.base.pattern_viper.fragment;

import android.content.Context;

public abstract class BaseFragmentInteractor<P extends BaseFragmentContract.Presenter>
        implements BaseFragmentContract.Interactor<P> {

  P mPresenter;

  public BaseFragmentInteractor(P presenter) {
    mPresenter = presenter;
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  @Override
  public Context getContext() {
    return mPresenter.getContext();
  }
}

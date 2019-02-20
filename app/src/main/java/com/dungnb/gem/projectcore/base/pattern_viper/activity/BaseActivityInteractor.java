package com.dungnb.gem.projectcore.base.pattern_viper.activity;

import android.content.Context;

public abstract class BaseActivityInteractor<P extends BaseActivityContract.Presenter> implements BaseActivityContract.Interactor<P> {
  P mPresenter;

  @Override
  public Context getContext() {
    return mPresenter.getContext();
  }

  @Override
  public void setPresenter(P presenter) {
    mPresenter = presenter;
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }
}

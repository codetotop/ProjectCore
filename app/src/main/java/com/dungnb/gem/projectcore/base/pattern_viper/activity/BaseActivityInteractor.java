package com.dungnb.gem.projectcore.base.pattern_viper.activity;

import android.content.Context;

public abstract class BaseActivityInteractor<P extends BaseActivityContract.Presenter> implements BaseActivityContract.Interactor<P> {
  P mPresenter;

  public BaseActivityInteractor(P presenter) {
    mPresenter = presenter;
  }

  @Override
  public Context getContext() {
    return mPresenter.getContext();
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }
}

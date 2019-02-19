package com.dungnb.gem.projectcore.base.activity;

import android.content.Context;

public abstract class BaseActivityInteractor<P extends BaseActivityContract.Presenter> implements BaseActivityContract.Interactor<P> {
  P mPresenter;

  @Override
  public Context getContext() {
    return mPresenter.getContext();
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }
}

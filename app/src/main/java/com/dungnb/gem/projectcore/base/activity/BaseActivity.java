package com.dungnb.gem.projectcore.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BaseActivityContract.Presenter> extends AppCompatActivity implements BaseActivityContract.View<P> {
  P mPresenter;
  Unbinder mUnbinder;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutID());

    mUnbinder = ButterKnife.bind(this);
    mPresenter = createPresenter();
    if (mPresenter != null) {
      mPresenter.createView(this);
    }

  }

  abstract int getLayoutID();

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    mUnbinder.unbind();
    super.onDestroy();
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }
}

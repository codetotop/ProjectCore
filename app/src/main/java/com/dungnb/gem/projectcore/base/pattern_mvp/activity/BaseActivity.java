package com.dungnb.gem.projectcore.base.pattern_mvp.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BaseActivityContract.Presenter> extends AppCompatActivity
        implements BaseActivityContract.View<P> {
  P mPresenter;
  Unbinder mUnbinder;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    setContentView(getLayoutResourceID());
    mUnbinder = ButterKnife.bind(this);
    mPresenter = createPresenter();
    if (mPresenter != null)
      mPresenter.setView(this);

  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mUnbinder.unbind();
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  protected abstract int getLayoutResourceID();
}

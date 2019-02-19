package com.dungnb.gem.projectcore.base.pattern_viper.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BaseFragmentContract.Presenter>
        extends Fragment
        implements BaseFragmentContract.View<P> {
  P mPresenter;
  Unbinder mUnbinder;

  public BaseFragment(P presenter) {
    mPresenter = presenter;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutResourceID(), container, false);
    mUnbinder = ButterKnife.bind(this, view);
    return view;
  }

  protected abstract int getLayoutResourceID();


  @Override
  public P getPresenter() {
    return mPresenter;
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }
}

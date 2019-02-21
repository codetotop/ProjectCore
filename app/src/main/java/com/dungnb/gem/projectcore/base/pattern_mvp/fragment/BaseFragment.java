package com.dungnb.gem.projectcore.base.pattern_mvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BaseFragmentContract.Presenter>
        extends Fragment implements BaseFragmentContract.View<P> {
  P mPresenter;
  Unbinder mUnbinder;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutResourceID(), container, false);
    mUnbinder = ButterKnife.bind(this, view);
    return view;
  }

  protected abstract int getLayoutResourceID();

  @Override
  public void setPresenter(P presenter) {
    mPresenter = presenter;
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  @Nullable
  @Override
  public Context getContext() {
    return getActivity();
  }
}

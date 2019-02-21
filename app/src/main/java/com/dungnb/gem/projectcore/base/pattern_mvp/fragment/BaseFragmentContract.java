package com.dungnb.gem.projectcore.base.pattern_mvp.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

public interface BaseFragmentContract {
  interface View<P extends Presenter> {
    void setPresenter(P presenter);

    P getPresenter();

    Context getContext();

    void showError();
  }

  interface Presenter<V extends View> {
    V createView();

    V getView();

    Fragment getFragment();

    Context getContext();
  }
}

package com.dungnb.gem.projectcore.base.pattern_viper.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

public interface BaseFragmentContract {
  interface View<P extends Presenter> {
    P getPresenter();

    void setPresenter(P presenter);

    void showError(int code, String message);

    Context getContext();
  }

  interface Presenter<V extends View, I extends Interactor> {
    V createView();

    V getView();

    I createInteractor();

    I getInteractor();

    Fragment getFragment();

    Context getContext();

    void handleError(Throwable throwable);
  }

  interface Interactor<P extends Presenter> {
    P getPresenter();

    void setPresenter(P presenter);

    Context getContext();
  }
}

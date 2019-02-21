package com.dungnb.gem.projectcore.base.pattern_viper.activity;

import android.content.Context;

public interface BaseActivityContract {
  interface View<P extends Presenter> {
    P createPresenter();

    P getPresenter();

    void showError(int code, String message);
  }

  interface Presenter<V extends View, I extends Interactor> {
    /*Attack View*/
    void setView(V view);

    V getView();

    I createInteractor();

    I getInteractor();

    Context getContext();

    void handleError(Throwable throwable);
  }

  interface Interactor<P extends Presenter> {
    void setPresenter(P presenter);

    P getPresenter();

    Context getContext();
  }
}

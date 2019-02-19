package com.dungnb.gem.projectcore.screen.login;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivityContract;

public interface LoginActivityContract {
  interface View extends BaseActivityContract.View<Presenter> {

    void loginSuccess();

    void loginFailure(String error);
  }

  interface Presenter extends BaseActivityContract.Presenter<View, Interactor> {

    void login(String user_name, String pass_word);

    void loginFailure(String error);

    void loginSuccess();
  }

  interface Interactor extends BaseActivityContract.Interactor<Presenter> {

    void login(String user_name, String pass_word);
  }
}

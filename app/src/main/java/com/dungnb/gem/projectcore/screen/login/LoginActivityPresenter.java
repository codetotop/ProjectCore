package com.dungnb.gem.projectcore.screen.login;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivityPresenter;

public class LoginActivityPresenter
        extends BaseActivityPresenter<LoginActivityContract.View, LoginActivityContract.Interactor>
        implements LoginActivityContract.Presenter {


  @Override
  public LoginActivityContract.Interactor createInteractor() {
    return new LoginActivityInteractor();
  }

  @Override
  public void login(String user_name, String pass_word) {
    getInteractor().login(user_name, pass_word);
  }

  @Override
  public void loginFailure(String error) {
    getView().loginFailure(error);
  }

  @Override
  public void loginSuccess() {
    getView().loginSuccess();
  }
}

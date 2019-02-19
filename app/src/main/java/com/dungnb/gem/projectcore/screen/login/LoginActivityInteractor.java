package com.dungnb.gem.projectcore.screen.login;

import android.text.TextUtils;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivityInteractor;

public class LoginActivityInteractor
        extends BaseActivityInteractor<LoginActivityContract.Presenter>
        implements LoginActivityContract.Interactor {

  public LoginActivityInteractor(LoginActivityContract.Presenter presenter) {
    super(presenter);
  }

  @Override
  public void login(String user_name, String pass_word) {

    if (TextUtils.isEmpty(user_name)) {
      getPresenter().loginFailure("UserName Is Empty !");
    } else if (TextUtils.isEmpty(pass_word)) {
      getPresenter().loginFailure("PassWord Is Empty !");
    } else {
      getPresenter().loginSuccess();
    }
  }
}

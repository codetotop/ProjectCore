package com.dungnb.gem.projectcore.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivity;
import com.dungnb.gem.projectcore.screen.home.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginActivityContract.Presenter> implements LoginActivityContract.View {
  @BindView(R.id.edtUserName)
  EditText mEdtUserName;

  @BindView(R.id.edtPassWord)
  EditText mEdtPassWord;

  @BindView(R.id.btnLogin)
  Button mBtnLogin;

  @Override
  public int getLayoutResourceID() {
    return R.layout.activity_login;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @OnClick(R.id.btnLogin)
  void login1() {
    getPresenter().login(mEdtUserName.getText().toString(), mEdtPassWord.getText().toString());
  }

  @Override
  public void loginSuccess() {
    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
    startActivity(intent);
  }

  @Override
  public void loginFailure(String error) {
    Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
  }

  @Override
  public LoginActivityContract.Presenter createPresenter() {
    return new LoginActivityPresenter();
  }
}

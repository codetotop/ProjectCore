package com.dungnb.gem.projectcore.base.pattern_viper.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BaseActivityContract.Presenter> extends AppCompatActivity implements BaseActivityContract.View<P> {
  P mPresenter;
  Unbinder mUnbinder;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResourceID());
    mUnbinder = ButterKnife.bind(this);
    mPresenter = createPresenter();
    if (mPresenter != null) {
      mPresenter.setView(this);
    }

  }

  public abstract int getLayoutResourceID();

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    mUnbinder.unbind();
    super.onDestroy();
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  protected void replaceChildrenFragment(Fragment children_fragment, int container_id, boolean add_to_backstack, String tag) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(container_id, children_fragment, tag);
    if (add_to_backstack)
      transaction.addToBackStack(tag);
    transaction.commit();
  }

  protected void addOrShowChildrenFragment(Fragment children_fragment, int container_id, boolean add_to_backstack, String tag) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    List<Fragment> fragments = manager.getFragments();
    if (fragments.isEmpty()) {
      addChildrenFragment(children_fragment, container_id, add_to_backstack, tag);
    } else {
      Fragment fm = manager.findFragmentByTag(tag);
      for (Fragment fragment : fragments) {
        if (fragment != fm)
          transaction.hide(fragment);
      }
      if (fm != null)
        showChildrenFragment(children_fragment);
      else {
        addChildrenFragment(children_fragment, container_id, add_to_backstack, tag);
      }
    }
    transaction.commit();
  }

  protected void showChildrenFragment(Fragment children_fragment) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.show(children_fragment);
    transaction.commit();
  }

  protected void addChildrenFragment(Fragment children_fragment, int container_id, boolean add_to_backstack, String tag) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(container_id, children_fragment, tag);
    if (add_to_backstack)
      transaction.addToBackStack(tag);
    transaction.commit();
  }

}

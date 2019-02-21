package com.dungnb.gem.projectcore.base.pattern_mvp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.dungnb.gem.projectcore.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BaseActivityContract.Presenter> extends AppCompatActivity
        implements BaseActivityContract.View<P> {
  P mPresenter;
  Unbinder mUnbinder;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    setContentView(getLayoutResourceID());
    mUnbinder = ButterKnife.bind(this);
    mPresenter = createPresenter();
    if (mPresenter != null)
      mPresenter.setView(this);

  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mUnbinder.unbind();
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  protected abstract int getLayoutResourceID();

  protected void addOrReplaceChildrenFragment(int container_id, Fragment children_fragment, Bundle args, boolean add_to_backstack, String tag) {
    if (args != null)
      children_fragment.setArguments(args);
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(container_id, children_fragment, tag);
    if (add_to_backstack)
      transaction.addToBackStack(tag);
    transaction.commit();
  }

  protected void addOrShowChildrenFragment(int container_id, Fragment children_fragment, Bundle args, boolean add_to_back_stack, String tag) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    List<Fragment> fragments = manager.getFragments();
    if (fragments.isEmpty()) {
      addChildrenFragment(container_id, children_fragment, args, add_to_back_stack, tag);
    } else {
      Fragment fm = manager.findFragmentByTag(tag);
      for (Fragment fragment : fragments) {
        if (fragment != null && fragment != fm)
          transaction.hide(fragment);
      }
      if (fm != null)
        showChildrenFragment(fm);
      else {
        addChildrenFragment(container_id, children_fragment, args, add_to_back_stack, tag);
      }
    }
    transaction.commit();
  }

  protected void showChildrenFragment(Fragment children_fragment) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
    transaction.show(children_fragment);
    transaction.commit();
  }

  protected void addChildrenFragment(int container_id, Fragment children_fragment, Bundle args, boolean add_to_back_stack, String tag) {
    if (args != null)
      children_fragment.setArguments(args);
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
    transaction.add(container_id, children_fragment, tag);
    if (add_to_back_stack)
      transaction.addToBackStack(tag);
    transaction.commit();
  }

  @Override
  public void onBackPressed() {
    if (getSupportFragmentManager().getBackStackEntryCount() > 0)
      getSupportFragmentManager().popBackStack();
    else
      super.onBackPressed();
  }

  public static void hideSoftKeyboard(Activity activity) {
    final InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    if (inputMethodManager.isActive()) {
      if (activity.getCurrentFocus() != null) {
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
      }
    }
  }

}

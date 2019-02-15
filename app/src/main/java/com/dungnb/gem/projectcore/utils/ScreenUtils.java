package com.dungnb.gem.projectcore.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by dongc on 12/3/2017.
 */

public class ScreenUtils {
  private static ScreenUtils sInstance;
  private int mScreenWidth;
  private int mScreenHeight;

  private ScreenUtils() {
  }

  public static ScreenUtils getInstance() {
    if (sInstance == null) {
      synchronized (ScreenUtils.class) {
        if (sInstance == null)
          sInstance = new ScreenUtils();
      }
    }
    return sInstance;
  }

  public void init(Context context) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    mScreenWidth = displayMetrics.widthPixels;
    mScreenHeight = displayMetrics.heightPixels;
  }

  public int getScreenWidth() {
    return mScreenWidth;
  }

  public int getScreenHeight() {
    return mScreenHeight;
  }
}

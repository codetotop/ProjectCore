package com.dungnb.gem.projectcore.common;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheHelper {

  private static final String PREF_NAME = "com.dungnb.gem.projectcore";
  private static CacheHelper sInstance;
  private SharedPreferences mSharedPreferences;

  private CacheHelper() {
  }

  public static CacheHelper getInstance() {
    if (sInstance == null) {
      synchronized (CacheHelper.class) {
        if (sInstance == null)
          sInstance = new CacheHelper();
      }
    }
    return sInstance;
  }

  public void init(Context context) {
    mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
  }

  /*Use SharePreferen*/
}

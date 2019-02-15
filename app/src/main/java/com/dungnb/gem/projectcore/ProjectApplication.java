package com.dungnb.gem.projectcore;

import android.support.multidex.MultiDexApplication;

import com.dungnb.gem.projectcore.common.CacheHelper;
import com.dungnb.gem.projectcore.webservice.WebServiceBuilder;
import com.facebook.drawee.backends.pipeline.Fresco;

import io.realm.Realm;

public class ProjectApplication extends MultiDexApplication {


  @Override
  public void onCreate() {
    super.onCreate();
    Fresco.initialize(this);
    CacheHelper.getInstance().init(this);
    WebServiceBuilder.getInstance().initServices();
    Realm.init(this);
  }
}

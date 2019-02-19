package com.dungnb.gem.projectcore.webservice;

import com.dungnb.gem.projectcore.BuildConfig;
import com.dungnb.gem.projectcore.webservice.content.ProjectService;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WebServiceBuilder {
  private static final int CONNECTION_TIME_OUT = 60000;
  private static final int READ_TIME_OUT = 60000;

  private static WebServiceBuilder mInstance;

  private ProjectService mProjectService;

  public static WebServiceBuilder getInstance() {
    synchronized (WebServiceBuilder.class) {
      if (mInstance == null) mInstance = new WebServiceBuilder();
    }
    return mInstance;
  }

  private String getBaseUrl() {
    return BuildConfig.BASE_URL;
  }

  public void initServices() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    if (BuildConfig.DEBUG)
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    Dispatcher dispatcher = new Dispatcher();
    dispatcher.setMaxRequests(1);

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    mProjectService = retrofit.create(ProjectService.class);
  }

  public ProjectService getProjectService() {
    return mProjectService;
  }
}

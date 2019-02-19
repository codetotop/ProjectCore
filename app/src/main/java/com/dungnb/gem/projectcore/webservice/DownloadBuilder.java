package com.dungnb.gem.projectcore.webservice;

import com.dungnb.gem.projectcore.BuildConfig;
import com.dungnb.gem.projectcore.webservice.download.DownloadService;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DownloadBuilder {
  private static final int CONNECTION_TIME_OUT = 60000;
  private static final int READ_TIME_OUT = 60000;

  private static final String BASE_URL = "http://mta.edu.vn/Portals/0/xNews/uploads/2018/11/21/";

  private static DownloadBuilder mInstance;
  private DownloadService mDownloadService;


  public static DownloadBuilder getInstance() {
    synchronized (DownloadBuilder.class) {
      if (mInstance == null) mInstance = new DownloadBuilder();
    }
    return mInstance;
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
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    mDownloadService = retrofit.create(DownloadService.class);
  }

  public DownloadService getDownloadService() {
    return mDownloadService;
  }
}

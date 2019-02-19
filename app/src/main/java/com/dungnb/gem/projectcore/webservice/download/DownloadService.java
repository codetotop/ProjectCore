package com.dungnb.gem.projectcore.webservice.download;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface DownloadService {
  @Streaming
  @GET
  Single<ResponseBody> downloadFilePDF(@Url String adaptiveUrl);
}

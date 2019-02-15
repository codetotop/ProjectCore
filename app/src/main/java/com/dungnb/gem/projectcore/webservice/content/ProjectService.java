package com.dungnb.gem.projectcore.webservice.content;

import com.dungnb.gem.projectcore.pojo.business_model.SourceInformationPersonnelDTO;
import com.dungnb.gem.projectcore.pojo.response.SourceChildrenResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProjectService {
  @POST("assets")
  @FormUrlEncoded
  Single<SourceChildrenResponse> fetchSourceChildrenList(@Field("page_num") int pageNum,
                                                         @Field("page_size") int pageSize,
                                                         @Field("company_id") String companyId,
                                                         @Field("organization_id") String organizationId,
                                                         @Field("parent_id") String parentId,
                                                         @Field("dmz_dma") String dmzDma);

  @POST("asset/personnel")
  @FormUrlEncoded
  Single<List<SourceInformationPersonnelDTO>> fetchSourceInformationPersonnel(@Field("asset_id") String assetId,
                                                                              @Field("organization_id") String organizationId,
                                                                              @Field("company_id") String companyId);
}
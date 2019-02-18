package com.dungnb.gem.projectcore.pojo.business_model;

import com.google.gson.annotations.SerializedName;

public class SourceInformationPersonnelDTO {

  @SerializedName("asset_id")
  private String mAssetId;
  @SerializedName("department_name")
  private String mDepartmentName;
  @SerializedName("user_assign")
  private String mUserAssign;
  @SerializedName("role")
  private String mRole;
  @SerializedName("date_start")
  private String mDateStart;
  @SerializedName("date_end")
  private String mDateEnd;

  // Getter Methods

  public String getAssetId() {
    return mAssetId;
  }

  public String getDepartmentName() {
    return mDepartmentName;
  }

  public String getUserAssign() {
    return mUserAssign;
  }

  public String getRole() {
    return mRole;
  }

  public String getDateStart() {
    return mDateStart;
  }

  public String getDateEnd() {
    return mDateEnd;
  }

  // Setter Methods

  public void setAssetId(String assetId) {
    this.mAssetId = assetId;
  }

  public void setDepartmentName(String departmentName) {
    this.mDepartmentName = departmentName;
  }

  public void setUserAssign(String userAssign) {
    this.mUserAssign = userAssign;
  }

  public void setRole(String role) {
    this.mRole = role;
  }

  public void setDateStart(String dateStart) {
    this.mDateStart = dateStart;
  }

  public void setDateEnd(String dateEnd) {
    this.mDateEnd = dateEnd;
  }
}

package com.dungnb.gem.projectcore.pojo.model;

import com.dungnb.gem.projectcore.pojo.business_model.SourceInformationPersonnelDTO;

public class SourceInformationPersonnel {
  private String mAssetId;
  private String mDepartmentName;
  private String mUserAssign;
  private String mRole;
  private String mDateStart;
  private String mDateEnd;


  public SourceInformationPersonnel() {
  }

  public SourceInformationPersonnel(String assetId, String departmentName, String userAssign, String role, String dateStart, String dateEnd) {
    mAssetId = assetId;
    mDepartmentName = departmentName;
    mUserAssign = userAssign;
    mRole = role;
    mDateStart = dateStart;
    mDateEnd = dateEnd;
  }


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

  public void convert(SourceInformationPersonnelDTO personnelDTO) {
    mAssetId = personnelDTO.getAssetId();
    mDepartmentName = personnelDTO.getDepartmentName();
    mUserAssign = personnelDTO.getUserAssign();
    mRole = personnelDTO.getRole();
    mDateStart = personnelDTO.getDateStart();
    mDateEnd = personnelDTO.getDateEnd();
  }
}

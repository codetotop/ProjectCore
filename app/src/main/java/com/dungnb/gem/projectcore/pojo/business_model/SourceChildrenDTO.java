package com.dungnb.gem.projectcore.pojo.business_model;

import com.google.gson.annotations.SerializedName;

public class SourceChildrenDTO {
  @SerializedName("oid")
  private float mOid;
  @SerializedName("code")
  private String mCode;
  @SerializedName("count_child")
  private float mCountChild;
  @SerializedName("name")
  private String mName;
  @SerializedName("notes")
  private String mNotes;
  @SerializedName("status")
  private String mStatus;
  @SerializedName("address")
  private String mAddress;
  @SerializedName("catalog_name")
  private String mCatalogName;
  @SerializedName("exploiter_name")
  private String mExploiterName;
  @SerializedName("management_name")
  private String mManagementName;
  @SerializedName("old_supply_id")
  private String mOldSupplyId;
  @SerializedName("supply_id")
  private String mSupplyId;
  @SerializedName("location_id")
  private String mLocationId;
  @SerializedName("date_of_use")
  private String mDateOfUse;
  @SerializedName("date_of_expiration")
  private String mDateOfExpiration;
  @SerializedName("scheme_id")
  private String mSchemeId;
  @SerializedName("status_name")
  private String mStatusName;

  // Getter Methods

  public float getOid() {
    return mOid;
  }

  public String getCode() {
    return mCode;
  }

  public float getCountChild() {
    return mCountChild;
  }

  public String getName() {
    return mName;
  }

  public String getNotes() {
    return mNotes;
  }

  public String getStatus() {
    return mStatus;
  }

  public String getAddress() {
    return mAddress;
  }

  public String getCatalogName() {
    return mCatalogName;
  }

  public String getExploiterName() {
    return mExploiterName;
  }

  public String getManagementName() {
    return mManagementName;
  }

  public String getOldSupplyId() {
    return mOldSupplyId;
  }

  public String getSupplyId() {
    return mSupplyId;
  }

  public String getLocationId() {
    return mLocationId;
  }

  public String getDateOfUse() {
    return mDateOfUse;
  }

  public String getDateOfExpiration() {
    return mDateOfExpiration;
  }

  public String getSchemeId() {
    return mSchemeId;
  }

  public String getStatusName() {
    return mStatusName;
  }

  // Setter Methods

  public void setOid(float oid) {
    this.mOid = oid;
  }

  public void setCode(String code) {
    this.mCode = code;
  }

  public void setCountChild(float countChild) {
    this.mCountChild = countChild;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public void setNotes(String notes) {
    this.mNotes = notes;
  }

  public void setStatus(String status) {
    this.mStatus = status;
  }

  public void setAddress(String address) {
    this.mAddress = address;
  }

  public void setCatalogName(String catalogName) {
    this.mCatalogName = catalogName;
  }

  public void setExploiterName(String exploiterName) {
    this.mExploiterName = exploiterName;
  }

  public void setManagementName(String managementName) {
    this.mManagementName = managementName;
  }

  public void setOldSupplyId(String oldSupplyId) {
    this.mOldSupplyId = oldSupplyId;
  }

  public void setSupplyId(String supplyId) {
    this.mSupplyId = supplyId;
  }

  public void setLocationId(String locationId) {
    this.mLocationId = locationId;
  }

  public void setDateOfUse(String dateOfUse) {
    this.mDateOfUse = dateOfUse;
  }

  public void setDateOfExpiration(String dateOfExpiration) {
    this.mDateOfExpiration = dateOfExpiration;
  }

  public void setSchemeId(String schemeId) {
    this.mSchemeId = schemeId;
  }

  public void setStatusName(String statusName) {
    this.mStatusName = statusName;
  }
}

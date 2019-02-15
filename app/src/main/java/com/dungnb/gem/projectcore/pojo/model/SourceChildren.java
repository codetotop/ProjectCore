package com.dungnb.gem.projectcore.pojo.model;
import com.dungnb.gem.projectcore.pojo.business_model.SourceChildrenDTO;

import java.io.Serializable;

public class SourceChildren implements Serializable {
  private float mOid;
  private String mCode;
  private float mCountChild;
  private String mName;
  private String mNotes;
  private String mStatus;
  private String mAddress;
  private String mCatalogName;
  private String mExploiterName;
  private String mManagementName;
  private String mOldSupplyId;
  private String mSupplyId;
  private String mLocationId;
  private String mDateOfUse;
  private String mDateOfExpiration;
  private String mSchemeId;
  private String mStatusName;

  public SourceChildren() {
  }

  public SourceChildren(float oid, String code, float countChild,
                        String name, String notes, String status,
                        String address, String catalogName,
                        String exploiterName, String managementName,
                        String oldSupplyId, String supplyId,
                        String locationId, String dateOfUse,
                        String dateOfExpiration, String schemeId, String statusName) {
    mOid = oid;
    mCode = code;
    mCountChild = countChild;
    mName = name;
    mNotes = notes;
    mStatus = status;
    mAddress = address;
    mCatalogName = catalogName;
    mExploiterName = exploiterName;
    mManagementName = managementName;
    mOldSupplyId = oldSupplyId;
    mSupplyId = supplyId;
    mLocationId = locationId;
    mDateOfUse = dateOfUse;
    mDateOfExpiration = dateOfExpiration;
    mSchemeId = schemeId;
    mStatusName = statusName;
  }


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

  public void convert(SourceChildrenDTO item) {

    mOid = item.getOid();
    mCode = item.getCode();
    mCountChild = item.getCountChild();
    mName = item.getName();
    mNotes = item.getNotes();
    mStatus = item.getStatus();
    mAddress = item.getAddress();
    mCatalogName = item.getCatalogName();
    mExploiterName = item.getExploiterName();
    mManagementName = item.getManagementName();
    mOldSupplyId = item.getOldSupplyId();
    mSupplyId = item.getSupplyId();
    mLocationId = item.getLocationId();
    mDateOfExpiration = item.getDateOfExpiration();
    mDateOfUse = item.getDateOfUse();
    mSchemeId = item.getSchemeId();
    mStatusName = item.getStatusName();
  }
}

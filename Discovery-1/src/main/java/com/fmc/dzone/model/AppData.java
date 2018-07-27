package com.fmc.dzone.model;

import java.math.BigDecimal;
import java.util.Date;


public class AppData {
	
	private BigDecimal appId;
	private String appName;
	private String appDesc;
	private Date startDate;
	private Date endDate;
	private Date modifiedDate;
public AppData() {
		
	}
	
	 public BigDecimal getAppId() {
			return appId;
		}
		public void setAppId(BigDecimal appId) {
			this.appId = appId;
		}
	
		public String getAppName() {
			return appName;
		}
		public void setAppName(String appName) {
			this.appName = appName;
		}
		
	public String getAppDesc() {
		return appDesc;
	}
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date date) {
		this.startDate = date;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	  @Override
	public String toString() {
		return "AppData [appId=" + appId + ", appName=" + appName + ", appDesc=" + appDesc + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", modifiedDate=" + modifiedDate + "]";
	}
}

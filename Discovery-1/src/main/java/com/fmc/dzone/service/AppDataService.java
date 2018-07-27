package com.fmc.dzone.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.fmc.dzone.model.AppData;



public interface AppDataService {
	
	void insertAppData(AppData appData);
	AppData getAppDataByName(String appName);
	List<AppData> getAllApps();
	
}

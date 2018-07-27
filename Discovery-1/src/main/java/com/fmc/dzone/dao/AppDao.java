package com.fmc.dzone.dao;



import java.util.List;

import com.fmc.dzone.model.AppData;


public interface AppDao {

	
	void insertAppData(AppData appData);
	

	
	
	List<AppData> getAllApps();
	AppData getAppbyName(String appName);
	

}

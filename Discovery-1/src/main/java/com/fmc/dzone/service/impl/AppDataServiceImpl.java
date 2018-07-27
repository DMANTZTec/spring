package com.fmc.dzone.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmc.dzone.dao.AppDao;
import com.fmc.dzone.model.AppData;
import com.fmc.dzone.service.AppDataService;


@Service
public class AppDataServiceImpl implements AppDataService {
	
@Autowired
AppDao appDataDao;
	@Override
	public void insertAppData(AppData appData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AppData getAppDataByName(String appName) {
		// TODO Auto-generated method stub
	
		//AppData appData=appDataDao.getAppbyId(appId);
		//System.out.println(appData);
		return appDataDao.getAppbyName(appName);
	}

	@Override
	public List<AppData> getAllApps() {
		// TODO Auto-generated method stub
		return appDataDao.getAllApps();
		
	}
}

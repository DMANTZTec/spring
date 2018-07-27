package com.fmc.dzone.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.fmc.dzone.dao.AppDao;
import com.fmc.dzone.model.AppData;



@Repository
public class AppDaoImpl extends JdbcDaoSupport implements AppDao {
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public void insertAppData(AppData appData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AppData> getAllApps() {
		String sql="SELECT * FROM DZ_APP";
		List<Map<String,Object>> rows=getJdbcTemplate().queryForList(sql);
		List<AppData> resultSet=new ArrayList<AppData>();
		for(Map<String,Object>row:rows) {
			AppData appData =new AppData();
			appData.setAppId((BigDecimal)row.get("DZ_APP_ID"));
			
			
			//System.out.println("DZ_APP_ID");
			appData.setAppName((String)row.get("DZ_APP_NM"));
			
			appData.setAppDesc((String)row.get("DZ_APP_DESC"));
			
	        appData.setStartDate((Timestamp)row.get("START_DATE"));
	        appData.setStartDate((Timestamp)row.get("END_DATE"));
	        appData.setStartDate((Timestamp)row.get("MODIFIED_DATE"));
	        
	resultSet.add(appData);
	        
			}
		
		return resultSet;
	}

	@Override
	public AppData getAppbyName(String appName) {
		// TODO Auto-generated method stub
		
		String sql="SELECT * FROM DZ_APP WHERE DZ_APP_NM=?";
		return (AppData)getJdbcTemplate().queryForObject(sql,new Object[] {appName},new RowMapper<AppData>() {

			@Override
			public AppData mapRow(ResultSet rs, int rwNumber) throws SQLException {
				// TODO Auto-generated method stub
				AppData appData=new AppData();
				appData.setAppId(rs.getBigDecimal("DZ_APP_ID"));
				appData.setAppName(rs.getString("DZ_APP_NM"));
				appData.setAppDesc(rs.getString("DZ_APP_DESC"));
				  appData.setStartDate(rs.getTimestamp("START_DATE"));
			        appData.setStartDate(rs.getTimestamp("END_DATE"));
			        appData.setStartDate(rs.getTimestamp("MODIFIED_DATE"));
			        
				return appData;
			}
			
		}
		);
		
	}

		
	}
	












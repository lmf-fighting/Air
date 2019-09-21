package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.AirQuality;
import connect.ConnectDS;

/**
 * 
 * @author 廖明凤
 *附近检测站空气质量的对应数据库操作类
 */
public class AirQualityService {
	public AirQuality queryAirQuality(String province, String city, String district, String createdDate) {
		ConnectDS connect = new ConnectDS();

		try {

			String sql = "select * from airquality where createddate='" + createdDate + "' and province='" + province
					+ "'  and city='" + city + "'  and district='" + district + "'";

			ResultSet rs = connect.query(sql);

			AirQuality air = new AirQuality();

			if (rs.next()) {

				Integer id = rs.getInt("id");
				air.setId(id);
				air.setCity(rs.getString("city"));
				air.setProvince(rs.getString("province"));
				air.setDistrict(rs.getString("district"));
				air.setAqi(rs.getString("aqi"));
				air.setCo(rs.getString("co"));
				air.setO3(rs.getString("o3"));
				air.setNo2(rs.getString("no2"));
				air.setPm2_5(rs.getString("pm2_5"));
				
				air.setSo2(rs.getString("so2"));
				air.setPm10(rs.getString("pm10"));
				air.setPollutions(rs.getString("pollutions"));
				air.setQuality(rs.getString("quality"));
				air.setPubtime(rs.getString("pubtime"));
				air.setStation(rs.getString("station"));

				return air;
			}

			return null;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public boolean addAirQuality(AirQuality air) {
		ConnectDS connect = new ConnectDS();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			//先查询是否存在当天日期的天气
			String querySql = "select * from airquality as info  where DATE_FORMAT(info.createddate,'%Y-%m-%d') = '"+sdf.format(cal.getTime())+"' and province='"+air.getProvince()+"'  and city='"+air.getCity()+"'  and district='"+air.getDistrict()+"'";
			
			ResultSet rs = connect.query(querySql);
			
			if(rs.next()){
				Integer id = rs.getInt("id");
				
				 String sql2 ="update airquality set createddate='"
						 +air.getCreatedDate()+"',province='"
						 +air.getProvince()+"',city='"
						 +air.getCity()+"',district='"
						 +air.getDistrict()+"',aqi='"
						 +air.getAqi()+"',pm2_5='"
						 +air.getPm2_5()+"',quality='"
						 +air.getQuality()+"',pollutions='"
						 +air.getPollutions()+"',co='"
						 +air.getCo()+"',no2='"
						 +air.getNo2()+"',o3='"
						 +air.getO3()+"',pm10='"
						 +air.getPm10()+"',so2='"
						 +air.getSo2()+"',pubtime='"
						 +air.getPubtime()+"',station='"
						 +air.getStation()+"' where id='"+id+"'";
				 
				return connect.update(sql2);
				
			}else{
				String sql  = "insert into airquality(createddate,province,city,district,aqi,pm2_5,quality,pollutions,co,no2,o3,pm10,so2,pubtime,station) "
						+ "value('"+air.getCreatedDate()+"','"+air.getProvince()+"','"
						+air.getCity()+"','"+air.getDistrict()+"','"
						+air.getAqi()+"','"+air.getPm2_5()+"','"+air.getQuality()+"','"
						+air.getPollutions()+"','"+air.getCo()+"','"
						+air.getNo2()+"','"+air.getO3()+"','"+air.getPm10()+"','"
						+air.getSo2()+"','"+air.getPubtime()+"','"+air.getStation()+"')";
				
				return connect.update(sql);
			}
			
			
			
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}

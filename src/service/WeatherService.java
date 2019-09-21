package service;

import java.sql.ResultSet;
/**
 * 
 * @author 廖明凤
 *当前地址当前日期的天气情况的对应数据库操作类
 */
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.Weather;
import connect.ConnectDS;

public class WeatherService {
	
	public Weather queryWeather(String province,String city,String district,String currentDate) {
		ConnectDS connect = new ConnectDS();

		try {
			
			String sql  = "select * from todayweather where createddate='"+currentDate +"' and province='"+province+"'  and city='"+city+"'  and district='"+district+"'";
			
			ResultSet rs =connect.query(sql);

			Weather weather = new Weather();
			//FutureWeather future=new FutureWeather();
			if(rs.next()){
				
				Integer id = rs.getInt("id");
				weather.setId(id);
				weather.setCity(rs.getString("city"));
				weather.setProvince(rs.getString("province"));
				weather.setDistrict(rs.getString("district"));
				weather.setWind(rs.getString("wind"));
				weather.setDate(rs.getString("date"));
				weather.setTemperature(rs.getString("temperature"));
				weather.setWeather(rs.getString("weatherDesc"));
				weather.setDayPictureUrl(rs.getString("daypictureurl"));
				weather.setNightPictureUrl(rs.getString("nightpictureurl"));
				
				return weather;
			}
			
			return null;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public boolean addWeather(Weather weather) {
		ConnectDS connect = new ConnectDS();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			//先查询是否存在当天日期的天气
			String querySql = "select * from todayweather as info  where DATE_FORMAT(info.createddate,'%Y-%m-%d') = '"+sdf.format(cal.getTime())+"' and province='"+weather.getProvince()+"'  and city='"+weather.getCity()+"'  and district='"+weather.getDistrict()+"'";
			
			ResultSet rs = connect.query(querySql);
			
			if(rs.next()){
				Integer id = rs.getInt("id");
				
				 String sql2 ="update todayweather set createddate='"
						 +weather.getCreatedDate()+"',date='"
						 +weather.getDate()+"',province='"
						 +weather.getProvince()+"',city='"
						 +weather.getCity()+"',district='"
						 +weather.getDistrict()+"',temperature='"
						 +weather.getTemperature()+"',wind='"
						 +weather.getWind()+"',weatherDesc='"
						 +weather.getWeather()+"' ,daypictureurl='"
						 +weather.getDayPictureUrl()+"',nightpictureurl='"
						 +weather.getNightPictureUrl()+"' where id='"+id+"'";
				 
				return connect.update(sql2);
			}else{
				String sql  = "insert into todayweather(createddate,date,province,city,district,temperature,wind,weatherDesc,daypictureurl,nightpictureurl) "
						+ "value('"+weather.getCreatedDate()+"','"+weather.getDate()+"','"+weather.getProvince()+"','"
						+weather.getCity()+"','"+weather.getDistrict()+"','"+weather.getTemperature()+"','"+weather.getWind()+"','"+weather.getWeather()+"','"+weather.getDayPictureUrl()+"','"+weather.getNightPictureUrl()+"')";
				
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

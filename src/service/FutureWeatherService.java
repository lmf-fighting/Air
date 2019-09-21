package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bean.Weather;
import connect.ConnectDS;

/**
 * 
 * @author 廖明凤
 *未来3天天气的对应数据库操作类
 */
public class FutureWeatherService {

	public List<Weather> queryFutureWeather(String province,String city,String district,String currentDate) {
		ConnectDS connect = new ConnectDS();

		try {
			
			String sql = "select * from futureweather where createddate='"+currentDate +"' and province='"+province+"'  and city='"+city+"'  and district='"+district+"'";
			ResultSet rs =connect.query(sql);

			List<Weather> list = new ArrayList<>();
			
			while(rs.next()){
				Weather weather = new Weather();
				weather.setId(rs.getInt("id"));
				weather.setWind(rs.getString("wind"));
				weather.setDate(rs.getString("date"));
				weather.setTemperature(rs.getString("temperature"));
				weather.setWeather(rs.getString("weatherDesc"));
				weather.setDayPictureUrl(rs.getString("daypictureurl"));
				weather.setNightPictureUrl(rs.getString("nightpictureurl"));
				list.add(weather);
				System.out.println(rs.getString("daypictureurl"));
			}
			
			return list;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public boolean addFutureWeather(List<Weather> futureWeathers,String province,String city,String district,String currentDate) {
		ConnectDS connect = new ConnectDS();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
			
		
		try {
			
			if(futureWeathers!=null&&futureWeathers.size()>0){
				
				
			
				String querySql = "select * from futureweather as info  where DATE_FORMAT(info.createddate,'%Y-%m-%d') = '"
				+sdf.format(cal.getTime())+"' and province='"
						+province+"'  and city='"
				        +city+"'  and district='"
						+district+"'";
				
				ResultSet rs = connect.query(querySql);
				
				if(rs.next()){
					
					 String sql2 ="update futureweather set createddate='"
							 +currentDate+"' where DATE_FORMAT(createddate,'%Y-%m-%d') = '"
				+sdf.format(cal.getTime())+"' and province='"
						+province+"'  and city='"
				        +city+"'  and district='"
						+district+"'";
					 System.out.println("update sql2"+sql2);
					return connect.update(sql2);
						
				}
				else{
			
					String sql  = "insert into futureweather(createddate,date,temperature,weatherdesc,wind,province,city,district,daypictureurl,nightpictureurl)"
							+ "value";
					for(Weather weather : futureWeathers){
						System.out.println(weather.getWeather());
						
						sql+= "('"+currentDate+"','"+weather.getDate()+"','"
								+weather.getTemperature()+"','"+weather.getWeather()+"','"+weather.getWind()+"','"+province+"','"
								+city+"','"+district+"','"
								+weather.getDayPictureUrl()+"','"+weather.getNightPictureUrl()+"'),";
					}
					sql = sql.substring(0,sql.length()-1);
					//System.out.println("sql="+sql);	
					return connect.update(sql);
				}
			
				
			}
			System.out.println(futureWeathers);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
}


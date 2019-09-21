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
 *生活指数的对应数据库操作类
 */
	public class LifeService {

		public List<Weather> queryLifeIndex(String province,String city,String district,String currentDate) {
			ConnectDS connect = new ConnectDS();

			try {
				
				String sql = "select * from life_index where createddate='"+currentDate +"' and province='"+province+"'  and city='"+city+"'  and district='"+district+"'";
				ResultSet rs =connect.query(sql);

				List<Weather> list = new ArrayList<>();
				
				while(rs.next()){
					Weather weather = new Weather();
					weather.setId(rs.getInt("id"));
					weather.setDes(rs.getString("des"));
					weather.setTipt(rs.getString("tipt"));
					weather.setTitle(rs.getString("title"));
					
					weather.setZs(rs.getString("zs"));
					
					list.add(weather);
					//System.out.println(rs.getString("des"));
				}
				
				return list;
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		
		public boolean addLifeIndex(List<Weather> lifeIndex1,String province,String city,String district,String currentDate) {
			ConnectDS connect = new ConnectDS();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
				
			
			try {
				
				if(lifeIndex1!=null&&lifeIndex1.size()>0){
					
					
				
					String querySql = "select * from life_index as info  where DATE_FORMAT(info.createddate,'%Y-%m-%d') = '"
					+sdf.format(cal.getTime())+"' and province='"
							+province+"'  and city='"
					        +city+"'  and district='"
							+district+"'";
					
					ResultSet rs = connect.query(querySql);
					
					if(rs.next()){
						
						 String sql2 ="update life_index set createddate='"
								 +currentDate+"' where DATE_FORMAT(createddate,'%Y-%m-%d') = '"
					+sdf.format(cal.getTime())+"' and province='"
							+province+"'  and city='"
					        +city+"'  and district='"
							+district+"'";
						 System.out.println("update sql2"+sql2);
						return connect.update(sql2);
							
					}
					else{
				
						String sql  = "insert into life_index(createddate,province,city,district,des,tipt,title,zs)"
								+ "value";
						for(Weather weather : lifeIndex1){
							System.out.println(weather.getWeather());
							
							sql+= "('"+currentDate+"','"+province+"','"
									+city+"','"+district+"','"
									+weather.getDes()+"','"+weather.getTipt()+"','"+weather.getTitle()+"','"+weather.getZs()+"'),";
						}
						sql = sql.substring(0,sql.length()-1);
						//System.out.println("sql="+sql);	
						return connect.update(sql);
					}
				
					
				}
				//System.out.println(lifeIndex1);
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return false;
		}
	}


package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CityTop;
import connect.ConnectDS;

/**
 * 
 * @author 廖明凤
 *全国空气质量排行榜的对应的数据库操作类
 */
public class CityTopService {
	public List<CityTop> queryTop() {
		ConnectDS connect = new ConnectDS();
		try {

			String sql = "select * from city_top";
			ResultSet rs = connect.query(sql);

			List<CityTop> citytop = new ArrayList<>();

			while (rs.next()) {
				CityTop top = new CityTop();
				top.setId(rs.getInt("id"));
				top.setAqi(rs.getString("aqi"));
				top.setArea(rs.getString("area"));
				top.setCo(rs.getString("co"));
				top.setCt(rs.getString("ct"));
				top.setNo2(rs.getString("no2"));
				top.setNum(rs.getString("num"));
				top.setO3(rs.getString("o3"));
				top.setPm10(rs.getString("pm10"));
				top.setPm2_5(rs.getString("pm2_5"));
				top.setPrimary_pollutant(rs.getString("primary_pollutant"));
				top.setQuality(rs.getString("quality"));
				top.setSo2(rs.getString("so2"));
				citytop.add(top);
				// System.out.println(rs.getString("daypictureurl"));
			}
			
			System.err.println("queryResult:"+citytop);

			return citytop;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean updateTop(List<CityTop> citytop, Integer id) throws ClassNotFoundException, SQLException {
		ConnectDS connect = new ConnectDS();

		// id = rs.getInt("id");
		String sql = "update city_top set'";
		for (CityTop top : citytop) {
			System.out.println(top.getId());

			sql += "num='" + top.getNum() + "',area='" + top.getArea() + "',aqi='" + top.getAqi() + "',pm2_5='"
					+ top.getPm2_5() + "',quality='" + top.getPm2_5() + "',primary_pollutant='"
					+ top.getPrimary_pollutant() + "',co='" + top.getCo() + "',no2='" + top.getNo2() + "',o3='"
					+ top.getO3() + "',pm10='" + top.getPm10() + "',so2='" + top.getSo2() + "',ct='" + top.getCt()
					+ "'where id='" + id + "'";
		}
		// sql+= "where id='"+id+"'";
		// sql = sql.substring(0,sql.length()-1);

		System.out.println("update sql" + sql);
		return connect.update(sql);

	}

	public boolean addTop(List<CityTop> citytop) throws ClassNotFoundException, SQLException {
		ConnectDS connect = new ConnectDS();
		
		String sql2 = "delete from city_top;";
		
		connect.delete(sql2);
		
		String sql = "insert into city_top(num,area,aqi,pm2_5,quality,primary_pollutant,co,no2,o3,pm10,so2,ct)"
				+ "value";
		for (CityTop top : citytop) {
			System.out.println(top.getArea());

			sql += "('" + top.getNum() + "','" + top.getArea() + "','" + top.getAqi() + "','" + top.getPm2_5() + "','"
					+ top.getQuality() + "','" + top.getPrimary_pollutant() + "','" + top.getCo() + "','" + top.getNo2()
					+ "','" + top.getO3() + "','" + top.getPm10() + "','" + top.getSo2() + "','" + top.getCt() + "'),";
		}
		sql = sql.substring(0, sql.length() - 1);
	 System.out.println("先删除再插入成功");
		 //connect.update(sql);
		return connect.update(sql);
		}	

}

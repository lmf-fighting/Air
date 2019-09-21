package servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import bean.AirQuality;
import bean.CityTop;
import bean.Weather;
import service.AirQualityService;
import service.CityTopService;
import service.FutureWeatherService;
import service.LifeService;
import service.WeatherService;

@WebServlet("/conn_servlet")
/**
 * 
 * @author 廖明凤
 *servlet后台：对微信小程序段与Java后端的交互
 *前台微信小程序端响应对应的方法，并在对应的方法内调用数据库操作函数
 */

public class conn_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * GET方法 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取前端请求的目标方法，执行调用
		String method = request.getParameter("method");

		if ("queryTop".equals(method)) {

			System.out.println("queryTop");

			queryTop(request, response);
		}
		else if ("updateTop".equals(method)) {

			System.out.println("updateTop");

			try {
				updateTop(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("addTop".equals(method)) {

			System.out.println("addTop");

		
				try {
					addTop(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if ("addAir".equals(method)) {

			System.out.println("addAir");

		
				try {
					addAir(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/**
	 * 接收前端传回来的天气数据并存入数据库
	 * 
	 * 
	 * @param request
	 * @param response
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) {
	
		response.setCharacterEncoding("utf-8");
		
		WeatherService ws = new WeatherService();
		FutureWeatherService fws = new FutureWeatherService();
		LifeService ls =new LifeService();
		
		String weatherData = request.getParameter("weatherData");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String currentDate = request.getParameter("currentDate");
		String futureWeatherData = request.getParameter("futureWeather");
		String lifeIndex = request.getParameter("lifeIndex");
		
		
		//System.err.println("futureWeatherData:"+futureWeatherData);
		
		Weather weather =JSON.parseObject(weatherData, Weather.class);
		List<Weather> futureWeathers = JSON.parseArray(futureWeatherData, Weather.class);
		List<Weather> lifeIndex1 = JSON.parseArray(lifeIndex, Weather.class);
		
		weather.setCreatedDate(currentDate);
		weather.setProvince(province);
		weather.setCity(city);
		weather.setDistrict(district);
		
		
		/*if (ws.addWeather(weather)) {
			fws.addFutureWeather(futureWeathers,province,city,district,currentDate);
			ls.addLifeIndex(lifeIndex1,province,city,district,currentDate);
			System.err.println("调用数据库插入数据成功");
		} else {
			System.err.println("调用数据库插入数据失败");
		}*/
		
	}

	/**
	 * 
	 * 获取对应日期，对应地址再查询数据库中对应的天气情况再将其返回小程序前端
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
		
		List<Weather> future=null;
		
		Weather weather=null;
		
		List<Weather> lifeIndex1=null;
		
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String district = request.getParameter("district");
		String currentDate = request.getParameter("currentDate");
		
		WeatherService ws = new WeatherService();
		FutureWeatherService fws = new FutureWeatherService();
		LifeService ls=new LifeService();

		// 查询数据库
		weather = ws.queryWeather(province,city,district, currentDate);
		//当天天气不为空时，查询未来天气和生活指数
		if(weather!=null){
			future = fws.queryFutureWeather(province,city,district, currentDate);
			lifeIndex1=ls.queryLifeIndex(province, city, district, currentDate);
		}
		// 将weather和future对象封装到JSON对象中再转换成JSON字符串并将其传回前端
		JSONObject jo = new JSONObject();
		jo.put("weather", weather);
		jo.put("futureWeather", future);
		jo.put("lifeIndex", lifeIndex1);
		
		Writer out = response.getWriter();
		out.write(jo.toJSONString());

		out.flush();
	}
	
	/**
	 * 接收前端传回来的空气质量数据并存入数据库
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void addAir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	
		response.setCharacterEncoding("utf-8");
		
		AirQualityService aqs = new AirQualityService();
		
		String result = request.getParameter("result");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String createdDate = request.getParameter("createdDate");
		
		System.err.println("result:"+result);
		
		AirQuality air =JSON.parseObject(result, AirQuality.class);
		air.setCreatedDate(createdDate);
		air.setProvince(province);
		air.setCity(city);
		air.setDistrict(district);
		
		if (aqs.addAirQuality(air)) {
			System.err.println("调用数据库插入数据成功");
		} else {
			System.err.println("调用数据库插入数据失败");
		}	
	}
	
	/**
	 * 
	 * 获取对应日期，对应地址再查询数据库中对应的空气质量再将其返回小程序前端
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void queryAir(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
		
		AirQuality air = null;
		
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String district = request.getParameter("district");
		String createdDate = request.getParameter("createdDate");
		
		AirQualityService aqs = new AirQualityService();

		// 查询数据库
		air = aqs.queryAirQuality(province,city,district, createdDate);		//当天天气不为空时，查询未来天气和生活指数
		
		if(air!=null){
			//future = fws.queryFutureWeather(province,city,district, currentDate);
			System.out.println("更新成功");
		}
		// 将result和result对象封装到JSON对象中再转换成JSON字符串并将其传回前端
		JSONObject jo = new JSONObject();
		jo.put("result", air);
		
		Writer out = response.getWriter();
		out.write(jo.toJSONString());
		System.out.println(jo.toJSONString());
		out.flush();
	}
	/**
	 * 接收前端传回来的空气质量数据并存入数据库
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void addTop(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	
		response.setCharacterEncoding("utf-8");
		
		CityTopService cts = new CityTopService();

		//CityTop ct= new CityTop();
		String list = request.getParameter("list");
		//Integer id=Integer.parseInt(request.getParameter("id"));
		
		System.err.println("list:"+list);
		
	    List<CityTop> citytop = JSON.parseArray(list,CityTop.class);
		//ct.setId(id);
		if (cts.addTop(citytop)) {
			System.err.println("调用数据库插入数据成功");
		} else {
			System.err.println("调用数据库插入数据失败");
		}
		/*if (cts.updateTop(top,id)) {
			System.err.println("调用数据库更新数据成功");
		} else {
			System.err.println("调用数据库更新数据失败");
		}*/	
	}
	
	/**
	 * 接收前端传回来的空气质量数据并存入数据库
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void updateTop(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	
		response.setCharacterEncoding("utf-8");
		
		CityTopService cts = new CityTopService();

		CityTop ct= new CityTop();
		String list = request.getParameter("list");
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		System.err.println("list:"+list);
		
	    List<CityTop> citytop = JSON.parseArray(list,CityTop.class);
		ct.setId(id);
		
		if (cts.updateTop(citytop,id)) {
			System.err.println("调用数据库更新数据成功");
		} else {
			System.err.println("调用数据库更新数据失败");
		}	
	}
	/**
	 * 
	 * 获取对应日期，对应地址再查询数据库中对应的空气质量再将其返回小程序前端
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void queryTop(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
		
		List<CityTop> citytop=null;
		
		CityTopService cts = new CityTopService();
		// 查询数据库
		citytop=cts.queryTop();
		
		//if(air!=null){
		//}
		// 将result和result对象封装到JSON对象中再转换成JSON字符串并将其传回前端
		JSONObject jo = new JSONObject();
		jo.put("list", citytop);
		
		Writer out = response.getWriter();
		out.write(jo.toJSONString());
		System.out.println(jo.toJSONString());
		out.flush();
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

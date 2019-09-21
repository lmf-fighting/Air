package bean;

/**
 * 
 * @author 廖明凤
 *未来3天天气实体类
 */
public class FutureWeather {
		/**
		 * id
		 */
		private Integer id;
		
		/**
		 * 当前日期
		 */
		private String currentDate;
		/**
		 * api日期
		 */
		private String date;

		/**
		 * 当天温度范围
		 */
		private String temperature;
		
		/**
		 * 风力情况
		 */
		private String wind;
		
		/**
		 * 当日天气状况
		 */
		private String weather;
		
		public String getTemperature() {
			return temperature;
		}
		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}
		public String getWind() {
			return wind;
		}
		public void setWind(String wind) {
			this.wind = wind;
		}
		public String getWeather() {
			return weather;
		}
		public void setWeather(String weather) {
			this.weather = weather;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCurrentDate() {
			return currentDate;
		}
		public void setCurrentDate(String currentDate) {
			this.currentDate = currentDate;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		private String city;
		private String province;
		private String district;

}

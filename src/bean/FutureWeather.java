package bean;

/**
 * 
 * @author ������
 *δ��3������ʵ����
 */
public class FutureWeather {
		/**
		 * id
		 */
		private Integer id;
		
		/**
		 * ��ǰ����
		 */
		private String currentDate;
		/**
		 * api����
		 */
		private String date;

		/**
		 * �����¶ȷ�Χ
		 */
		private String temperature;
		
		/**
		 * �������
		 */
		private String wind;
		
		/**
		 * ��������״��
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

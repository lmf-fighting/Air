package bean;

/**
 * 天气实体类
 * 
 * @author 廖明凤
 *
 */
public class Weather {
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 记录创建日期
	 */
	private String createdDate;
	
	/**
	 * api日期
	 */
	private String date;
	
	/**
	 * 当地市
	 */
	private String city;
	
	/**
	 * 当前省
	 */
	private String province;
	
	/**
	 * 当前区
	 */
	private String district;

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

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
	/**
	 * 天气图标day or night
	 */
	private String dayPictureUrl;
	private String nightPictureUrl;
	
	/**
	 * 生活指数
	 * @return
	 */
	private String des;//建议
	private String tipt;//穿衣指数等
	private String title;
	private String zs;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getTipt() {
		return tipt;
	}

	public void setTipt(String tipt) {
		this.tipt = tipt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getNightPictureUrl() {
		return nightPictureUrl;
	}

	public void setNightPictureUrl(String nightPictureUrl) {
		this.nightPictureUrl = nightPictureUrl;
	}

	public String getDayPictureUrl() {
		return dayPictureUrl;
	}

	public void setDayPictureUrl(String dayPictureUrl) {
		this.dayPictureUrl = dayPictureUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
}

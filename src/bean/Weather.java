package bean;

/**
 * ����ʵ����
 * 
 * @author ������
 *
 */
public class Weather {
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * ��¼��������
	 */
	private String createdDate;
	
	/**
	 * api����
	 */
	private String date;
	
	/**
	 * ������
	 */
	private String city;
	
	/**
	 * ��ǰʡ
	 */
	private String province;
	
	/**
	 * ��ǰ��
	 */
	private String district;

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

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
	/**
	 * ����ͼ��day or night
	 */
	private String dayPictureUrl;
	private String nightPictureUrl;
	
	/**
	 * ����ָ��
	 * @return
	 */
	private String des;//����
	private String tipt;//����ָ����
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

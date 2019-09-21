package bean;
/**
 * ��������ʵ����
 * 
 * @author ������
 *
 */
public class AirQuality {
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * ��¼��������
	 */
	private String createdDate;
	/**
	 * AQIָ��
	 */
	private String aqi;
	/**
	 * PM2.5
	 */
	private String pm2_5;
	/**
	 * ������������
	 */
	private String quality;
	
	/**
	 * ��Ҫ��Ⱦ��
	 */
	private String pollutions;
	/**
	 * CO
	 */
	private String co;
	/**
	 * NO2
	 */
	private String no2;
	/**
	 * O3
	 */
	private String o3;
	/**
	 * PM10
	 */
	private String pm10;
	/**
	 * SO2
	 */
	private String so2;
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
	/**
	 * ���վ��
	 */
	private String station;
	/**
	 * ����ʱ��
	 */
	private String pubtime;
	
	
	public String getPollutions() {
		return pollutions;
	}
	public void setPollutions(String pollutions) {
		this.pollutions = pollutions;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	public Integer getId() {
		return id;
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
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getPm2_5() {
		return pm2_5;
	}
	public void setPm2_5(String pm2_5) {
		this.pm2_5 = pm2_5;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	
	public String getCo() {
		return co;
	}
	public void setCo(String co) {
		this.co = co;
	}
	public String getNo2() {
		return no2;
	}
	public void setNo2(String no2) {
		this.no2 = no2;
	}
	public String getO3() {
		return o3;
	}
	public void setO3(String o3) {
		this.o3 = o3;
	}
	public String getPm10() {
		return pm10;
	}
	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}
	public String getSo2() {
		return so2;
	}
	public void setSo2(String so2) {
		this.so2 = so2;
	}

}

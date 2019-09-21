package bean;/**
 * 
 * @author 廖明凤
 *城市空气质量排行榜实体类
 */

public class CityTop {
	/**
	 * id
	 */
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * AQI指数
	 */
	private String aqi;
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
	public String getPrimary_pollutant() {
		return primary_pollutant;
	}
	public void setPrimary_pollutant(String primary_pollutant) {
		this.primary_pollutant = primary_pollutant;
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
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * PM2.5
	 */
	private String pm2_5;
	/**
	 * 空气质量指数
	 */
	private String quality;
	
	/**
	 * 主要污染物
	 */
	private String primary_pollutant;
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
	 * 发布时间
	 */
	private String ct;
	/**
	 * area地区
	 */
	private String area;
	/**
	 * 排名
	 */
	private String num;



}

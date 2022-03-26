package YamlPackage;

import java.util.List;
import java.util.Map;

public class YamlDriver {
	
	private String more_id;
	private String weather_xpath;
	private Map<String , String> weatherPage;
	private List requiredCities;
	public String getMore_id() {
		return more_id;
	}
	public void setMore_id(String more_id) {
		this.more_id = more_id;
	}
	public String getWeather_xpath() {
		return weather_xpath;
	}
	public void setWeather_xpath(String weather_xpath) {
		this.weather_xpath = weather_xpath;
	}
	public Map<String, String> getWeatherPage() {
		return weatherPage;
	}
	public void setWeatherPage(Map<String, String> weatherPage) {
		this.weatherPage = weatherPage;
	}
	public List getRequiredCities() {
		return requiredCities;
	}
	public void setRequiredCities(List requiredCities) {
		this.requiredCities = requiredCities;
	}
	
	
	
	

}

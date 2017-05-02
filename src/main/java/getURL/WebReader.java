package getURL;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.esotericsoftware.yamlbeans.YamlReader;

public class WebReader {
	private Document document;
	private StringBuilder temp;

	WebReader(String url) {
		try {
			document = Jsoup.connect(url).get();
		} catch (UnknownHostException u) {
			System.err.println("Check internet connection");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void readYamlFromGithub() {
		temp = new StringBuilder();
		for (Element table : document.select("table[class=highlight tab-size js-file-line-container]")) {
			for (Element row : table.select("tr")) {
				if (!row.text().startsWith("-")) {
					temp.append("  ");
				}
				temp.append(row.text() + "\n");
			}
		}
	}

	public ArrayList<Sensor> createArrayListFromYaml() {
		YamlReader reader = new YamlReader(new String(temp));
		ArrayList<?> sensors;
		ArrayList<Sensor> sensorList = new ArrayList<>();
		try {
			sensors = (ArrayList<?>) reader.read();

			for (Object o : sensors) {
				@SuppressWarnings("unchecked")
				HashMap<String, String> map =  (HashMap<String, String>) o;
				
				if(map.get("type").equals("temperature")) {
					sensorList.add(new Sensor.Builder(map.get("id"))
							.masterSensorId(map.get("master-sensor-id"))
							.type(map.get("type"))
							.value(map.get("value"))
							.minValue(map.get("min_value"))
							.maxValue(map.get("max_value"))
							.build());
				} else {
					sensorList.add(new Sensor.Builder(map.get("id"))
							.engine(map.get("engine"))
							.type(map.get("type"))
							.name(map.get("name"))
							.value(map.get("value"))
							.minValue(map.get("min_value"))
							.maxValue(map.get("max_value"))
							.build());
				}
			}
			sensors.clear();

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sensorList;
	}
}

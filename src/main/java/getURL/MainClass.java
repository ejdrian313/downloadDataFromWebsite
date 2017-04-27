package getURL;

import java.util.ArrayList;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainClass {

	public static void main(String[] args) {
		try {
			String url;
			if(args.length > 0) {
				url = args[0];
			} else url = "https://github.com/ejdrian313/downloadDataFromWebsite/blob/master/file.yml";
			
			Document document = Jsoup.connect(url).get();
			
			StringBuilder temp = new StringBuilder();
			for (Element table : document.select("table[class=highlight tab-size js-file-line-container]")) {
				for (Element row : table.select("tr")) {
					if(!row.text().startsWith("-")){
						temp.append("  ");
					}
					temp.append(row.text() + "\n");
				}
			}

			YamlReader reader = new YamlReader(new String(temp));
			
			ArrayList<?> sensors = (ArrayList<?>) reader.read();
			sensors.forEach(s -> System.out.println(s));
			
			ArrayList<Sensor> sensorList = new ArrayList<>();
			for(Object o : sensors) {			
				@SuppressWarnings("rawtypes")
				Map map = (Map)o;
				sensorList.add(new Sensor.Builder(map.get("id"))
						.engine(map.get("engine"))
						.masterSensorId(map.get("masterSensorId"))
						.type(map.get("type"))
						.name(map.get("name"))
						.value(map.get("value"))
						.minValue(map.get("min_value"))
						.maxValue(map.get("max_value"))
						.build());
			}
			sensorList.forEach(s -> System.out.println(s.getValue()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
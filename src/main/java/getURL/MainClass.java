package getURL;

import java.util.ArrayList;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainClass {

	public static void main(String[] args) {
		ArrayList<Sensor> sensors;
		try {
			String url;
			if(args.length > 0) {
				url = args[0];
			} else url = "https://github.com/ejdrian313/downloadDataFromWebsite/blob/master/file.yml";
			
			WebReader webReader = new WebReader(url);
			sensors = new ArrayList<>(webReader.createArrayListFromYaml());
			sensors.forEach(s -> System.out.println(s.getValue()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
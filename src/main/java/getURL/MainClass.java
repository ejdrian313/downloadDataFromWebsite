package getURL;

import java.io.FileReader;
import java.util.ArrayList;

import com.esotericsoftware.yamlbeans.YamlReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) {
		try {
			String url = "https://github.com/relayr/pdm-test/blob/master/sensors.yml";
			Document document = Jsoup.connect(url).get();

			for (Element table : document.select("table[class=highlight tab-size js-file-line-container]")) {
				for (Element row : table.select("tr")) {
					Elements tds = row.select("td");
					System.out.println(tds.get(0).text() + tds.get(1).text());
				}
			}

			YamlReader reader = new YamlReader(new FileReader("file.yml"));
			ArrayList<?> sensors = (ArrayList<?>) reader.read();
			sensors.forEach(s -> System.out.println(s));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

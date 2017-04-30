package getURL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainClass {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		ArrayList<Sensor> sensors;
		try {
			String url;
			if(args.length > 0) {
				url = args[0];
			} else url = "https://github.com/ejdrian313/downloadDataFromWebsite/blob/master/file.yml";
			
			WebReader webReader = new WebReader(url);
			sensors = new ArrayList<>(webReader.createArrayListFromYaml());
			
			Collections.sort(sensors, new Comparator<Sensor>() {
		        public int compare(Sensor s2, Sensor s1)
		        {
		            return  Integer.valueOf(s2.getId()).compareTo(s1.getId());
		        }
		    });
			
			sensors.forEach(s -> System.out.println("Sensor: " + s.getId() +" of " + s.getType() + " current value: " + s.getValue()));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Long endTime = System.nanoTime();
			Double duration = (endTime - startTime) / 1000000000.0;
			System.out.println("I'm out in time: " + String.format("%.2f", duration) + "s");
		}
	}
}
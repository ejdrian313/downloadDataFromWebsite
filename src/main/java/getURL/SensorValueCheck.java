package getURL;

import java.util.ArrayList;

public abstract class SensorValueCheck {
	
	public static boolean isValueCorrect(Sensor s) {
		if(s.getMin_value() < s.getValue() && s.getValue() < s.getMax_value()) {
			return true;
		} else return false;
	}
	
	public static void checkChildSensors(Sensor s, ArrayList<Sensor> listSensor) {
		for(Sensor se : listSensor) {
			if(se.getType().equals("temperature")) {
				if(se.getMasterSensorId() == s.getId()) {
					System.out.println("For sensor: " + s.getId() + 
							" child id: " + se.getId() + " is correct: "
							+ isValueCorrect(se));
				}
			}
		}
	}
}

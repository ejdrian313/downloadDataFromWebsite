package getURL;

import java.util.ArrayList;

public abstract class SensorValueCheck {
	
	public static boolean isValueCorrect(Sensor s) {
		if(s.getMin_value() > s.getValue() && s.getValue() < s.getMax_value()) {
			return true;
		} else return false;
	}
	
	public static void getChildSensors(Sensor s, ArrayList<Sensor> listSensor) {
		for(Sensor s : listSensor) {
			s.getMasterSensorId() // TODO: implement method to get all the child of master sensor.
		}
	}
}

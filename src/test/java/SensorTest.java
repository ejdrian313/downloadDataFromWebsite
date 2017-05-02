import static org.junit.Assert.*;

import org.junit.Test;

import getURL.Sensor;

public class SensorTest {
	
	Sensor sensor = new Sensor.Builder("123")
			.type("temperature")
			.maxValue("30")
			.minValue("5")
			.value("23")
			.build();

	@Test
	public void testOnCreate() {
		assertEquals(123, sensor.getId());
		assertEquals("temperature", sensor.getType());
		assertEquals(30, sensor.getMax_value());
		assertEquals(5, sensor.getMin_value());
		assertEquals(23, sensor.getValue());
	}
	
	@Test
	public void testCheckingNotSame() {
		assertNotSame(sensor, new Sensor.Builder("124")
								.masterSensorId("3213")
								.type("temperature")
								.build());
	}
	
	@Test
	public void testNotValidDataToCreateSensor() {
		String s = "It's not vaild data to create an object of Sensor.class. \n Check your data file";
		Sensor sensor2 = new Sensor.Builder("123")
				.build();
		assertEquals(s, sensor2.getName());
	}
}
import static org.junit.Assert.*;

import org.junit.Test;

import getURL.Sensor;

public class SensorTest {
	
	Sensor sensor = new Sensor.Builder("123")
			.name("engine")
			.type("temperature")
			.maxValue("30")
			.minValue("5")
			.value("23")
			.build();

	@Test
	public void testOnCreate() {
		assertEquals(123, sensor.getId());
		assertEquals("engine", sensor.getName());
		assertEquals("temperature", sensor.getType());
		assertEquals(30, sensor.getMax_value());
		assertEquals(5, sensor.getMin_value());
		assertEquals(23, sensor.getValue());
	}
	
	@Test
	public void testCheckingNotSame() {
		assertNotSame(sensor, new Sensor.Builder("123").build());
	}
}
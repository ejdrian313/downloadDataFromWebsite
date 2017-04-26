package getURL;

public class Sensor {
	int id;
	int engine;
	int masterSensorId;
	String type;
	String name;
	int value;
	int min_value;
	int max_value;
	
	/**
	 * 
	 * Getters and setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getMin_value() {
		return min_value;
	}
	public void setMin_value(int min_value) {
		this.min_value = min_value;
	}
	public int getMax_value() {
		return max_value;
	}
	public void setMax_value(int max_value) {
		this.max_value = max_value;
	}
	public int getMasterSensorId() {
		return masterSensorId;
	}
	public void setMasterSensorId(int masterSensorId) {
		this.masterSensorId = masterSensorId;
	}
}

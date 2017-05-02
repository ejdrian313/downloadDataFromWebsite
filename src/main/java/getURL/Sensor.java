package getURL;

public class Sensor {
	private int id;
	private int engine;
	private int masterSensorId;
	private String type;
	private String name;
	private int value;
	private int min_value;
	private int max_value;
	
	
	private Sensor(final Builder builder) {
		if (builder.type == null) {
			String notVaild = "It's not vaild data to create an object of Sensor.class. "
								+ "\nCheck your data file";
			this.name = notVaild;
			System.out.println(notVaild);
		} else {
			if (builder.type.equals("temperature")) {
				this.id = builder.id;
				this.masterSensorId = builder.masterSensorId;
				this.type = builder.type;
				this.value = builder.value;
				this.min_value = builder.min_value;
				this.max_value = builder.max_value;
			} else {
				this.id = builder.id;
				this.engine = builder.engine;
				this.type = builder.type;
				this.name = builder.name;
				this.value = builder.value;
				this.min_value = builder.min_value;
				this.max_value = builder.max_value;
			}
		}
	}

	public int getId() {
		return id;
	}

	public int getEngine() {
		return engine;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public int getMin_value() {
		return min_value;
	}

	public int getMax_value() {
		return max_value;
	}

	public int getMasterSensorId() {
		return masterSensorId;
	}

	@Override
	public String toString() {
		return Sensor.class.getName() + id + ", engine=" + engine + ", masterSensorId=" + masterSensorId + ", type="
				+ type + ", name=" + name + ", value=" + value + ", min_value=" + min_value + ", max_value=" + max_value
				+ "]";
	}

	public static class Builder {
		private final int id;
		private int engine;
		private int masterSensorId;
		private String type;
		private String name;
		private int value;
		private int min_value;
		private int max_value;

		public Builder(final Object object) {
			this.id = Integer.valueOf((String) object);
		}

		public Builder engine(final Object object) {
			this.engine = Integer.valueOf((String) object);
			return this;
		}

		public Builder masterSensorId(final Object object) {
			this.masterSensorId = Integer.valueOf((String) object);
			return this;
		}

		public Builder type(final Object object) {
			this.type = (String) object;
			return this;
		}

		public Builder name(final Object object) {
			this.name = (String) object;
			return this;
		}

		public Builder value(final Object value) {
			this.value = Integer.valueOf((String) value);
			return this;
		}

		public Builder minValue(final Object min_value) {
			this.min_value = Integer.valueOf((String) min_value);
			return this;
		}

		public Builder maxValue(final Object max_value) {
			this.max_value = Integer.valueOf((String) max_value);
			return this;
		}

		public Sensor build() {
			return new Sensor(this);
		}
	}
}

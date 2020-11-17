package Factory;

public class HealthParametersFactory {

	HealthParameters getParameterType(String type) {
		if (type == "blood pressure") {
			return new BloodPressure();
		} else if (type == "blood oxygen level") {
			return new BloodOxygenLevel();
		}else if (type == "body temperature") {
			return new BodyTemperature();
		}else if(type == "heart rate") {
			return new HeartRate();
		}
		
		return null;
	}
}

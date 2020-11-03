package Factory;

public class UserFactory {
	User getUserType(String type) {
		if (type == "patient") {
			return new Patient();
		} else if (type == "doctor") {
			return new Doctor();
		}
		
		return null;
	}
}

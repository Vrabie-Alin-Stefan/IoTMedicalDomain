package Factory;

public class FactoryMain {
	public static void main(String[] args) {
		UserFactory uFact = new UserFactory();

		User u = uFact.getUserType("patient");

		u.login();
		u.changePassword();

		u = uFact.getUserType("doctor");
		u.login();
		u.logout();

	}

}

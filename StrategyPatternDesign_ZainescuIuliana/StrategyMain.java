package Strategy;

public class StrategyMain {

	public static void main(String[] args) {
		UserContext userContext;

		userContext = new UserContext(new Doctor());
		userContext.login();
		userContext.changePassword();

		userContext = new UserContext(new Patient());
		userContext.login();

	}
}

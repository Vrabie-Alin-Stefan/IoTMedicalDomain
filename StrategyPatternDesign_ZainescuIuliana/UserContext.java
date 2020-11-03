package Strategy;

public class UserContext {
	private User user;

	public UserContext(User user) {
		this.user = user;
	}

	public int login() {
		return user.login();
	}

	public int register() {
		return user.register();
	}

	public int changePassword() {
		return user.changePassword();
	}

	public int logout() {
		return user.logout();
	}
}

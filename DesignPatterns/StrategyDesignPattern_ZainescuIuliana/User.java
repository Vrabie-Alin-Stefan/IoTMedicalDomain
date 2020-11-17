package Strategy;

public abstract class User {

	public int Id;
	public String firstName;
	public String lastName;
	public String email;
	public String password;

	public abstract int login();

	public abstract int register();

	public abstract int changePassword();

	public abstract int logout();
}

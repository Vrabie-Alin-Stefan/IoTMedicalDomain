package Factory;

import java.util.Date;

public class Patient extends User {

	private String address;
	private Date dateOfBirth;
	private HealthParametersFactory healthParams;

	public void setHealthParams(String type) {
		this.healthParams = new HealthParametersFactory();
		HealthParameters p = this.healthParams.getParameterType(type);
		p.showValue();
	}

	@Override
	public int login() {
		System.out.println("Login from Patient!");
		this.setHealthParams("blood pressure");

		this.setHealthParams("body temperature");

		return 0;
	}

	@Override
	public int register() {
		System.out.println("Register from Patient!");
		return 0;
	}

	@Override
	public int changePassword() {
		System.out.println("ChangePassword from Patient!");
		return 0;
	}

	@Override
	public int logout() {
		System.out.println("Logout from Patient!");
		return 0;
	}

	public void sendMessageToDoctor(String message) {

	}

}

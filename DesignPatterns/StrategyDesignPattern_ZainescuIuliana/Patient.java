package Strategy;

import java.util.Date;

public class Patient extends User {

	private String address;
	private Date dateOfBirth;
	private HealthParametersStrategy healthParams;

	public void setHealthParams(HealthParametersStrategy healthParams) {
		this.healthParams = healthParams;
	}

	@Override
	public int login() {
		System.out.println("Login from Patient!");
		this.setHealthParams(new HeartRate());
		this.viewParameter();

		this.setHealthParams(new BodyTemperature());
		this.viewParameter();

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

	public int viewParameter() {
		return this.healthParams.showValue();
	}

	public void sendMessageToDoctor(String message) {

	}

}

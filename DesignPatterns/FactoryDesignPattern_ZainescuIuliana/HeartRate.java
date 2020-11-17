package Factory;

public class HeartRate implements HealthParameters {
	private int value = 100;

	@Override
	public int showValue() {
		System.out.println("The heart rate is: " + value);
		return 0;
	}
}

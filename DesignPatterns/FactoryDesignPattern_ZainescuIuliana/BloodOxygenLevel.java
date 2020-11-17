package Factory;

public class BloodOxygenLevel implements HealthParameters {
	private int value = 80;

	@Override
	public int showValue() {
		System.out.println("The blood oxygen level is: " + value);
		return 0;
	}
}

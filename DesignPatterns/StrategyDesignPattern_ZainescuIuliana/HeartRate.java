package Strategy;

public class HeartRate implements HealthParametersStrategy {
    private int value=100;

    @Override
    public int showValue() {
        System.out.println("The heart rate is: "+value);
        return 0;
    }
}

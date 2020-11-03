package Strategy;
public class BodyTemperature implements HealthParametersStrategy {
    private double value=36.6;

    @Override
    public int showValue() {
        System.out.println("The body temperature is: "+value);
        return 0;
    }
}

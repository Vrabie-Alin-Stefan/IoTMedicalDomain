package Strategy;
public class BloodPressure implements HealthParametersStrategy{

    private int value=12;

    @Override
    public int showValue() {
        System.out.println("The blood pressure value is: "+value);
        return 0;
    }
}

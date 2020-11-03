package Strategy;

public class BloodOxygenLevel  implements  HealthParametersStrategy{
    private int value=80;

    @Override
    public int showValue() {
        System.out.println("The blood oxygen level is: "+value);
        return 0;
    }
}

package solid;

public class TwentyFivePercentDiscount implements IDiscount {
    @Override
    public double apply(double total) {
        return total * 0.75;
    }

    @Override
    public double applyDiscount(double total) {
        return 0.9 * total;
    }
}

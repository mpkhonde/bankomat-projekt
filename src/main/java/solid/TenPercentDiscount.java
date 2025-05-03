package solid;

public class TenPercentDiscount implements IDiscount {
    @Override
    public double apply(double total) {
        return total * 0.9;
    }

    @Override
    public double applyDiscount(double total) {
        return 0.9 * total;
    }
}

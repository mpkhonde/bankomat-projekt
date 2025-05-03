package solid;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;
    private IDiscount discount;

    public ShoppingCart(IDiscount discount) {
        this.items = new ArrayList<>();
        this.discount = discount;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void checkout() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotal();
        }

        System.out.println("Totalt innan rabatt: " + total + " kr");
        double discountedTotal = discount.applyDiscount(total);
        System.out.println("Totalt efter rabatt: " + discountedTotal + " kr");
    }
}

package solid;

public class Main {
    public static void main(String[] args) {
        IDiscount discount = new TwentyFivePercentDiscount();
        ShoppingCart cart = new ShoppingCart(discount);

        cart.addItem(new Item("Laptop", 1000, 1));
        cart.addItem(new Item("Phone", 500, 2));

        cart.checkout();
    }
}

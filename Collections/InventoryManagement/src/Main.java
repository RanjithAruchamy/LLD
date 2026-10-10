import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Item i1 = new Electronics(1, "Mobile", 10, 50000d, 1);
        Item i2 = new Electronics(2, "TV", 5, 20000d, 2);
        Item i3 = new Clothing(3, "Shirt", 7, 1200d, "S");
        Item i4 = new Book(4, "Comic", 6, 700d, "Ranjith");

        List<Item> items = new java.util.ArrayList<>(List.of(i1, i2, i3, i4));

        Collections.sort(items);

        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("\nItem Creation completed, Inventory creation begins\n");

        Electronics mobile = new Electronics(1, "Mobile", 10, 50000d, 1);
        Electronics tv = new Electronics(2, "TV", 5, 20000d, 2);

        Inventory<Electronics> electronicsInventory = new Inventory<>();
        electronicsInventory.addItem(mobile);
        electronicsInventory.addItem(tv);

        System.out.println(electronicsInventory.getAllItems());
        System.out.println(electronicsInventory.getItem(tv.getId().toString()));

        electronicsInventory.removeItem(tv.getId().toString());

        System.out.println(electronicsInventory.getAllItems());
        System.out.println();

        RecentlyViewedItems<Electronics> recentlyViewedItems = new RecentlyViewedItems<>();
        recentlyViewedItems.addRecentlyViewedItem(mobile);
        recentlyViewedItems.addRecentlyViewedItem(tv);

        System.out.println(recentlyViewedItems.getRecentlyViewedItems());
        System.out.println();

        System.out.println("Process priority orders \n");

        Order order1 = new Order(false, "1");
        Order order2 = new Order(true, "2");
        Order order3 = new Order(false, "3");
        Order order4 = new Order(true, "4");

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.addOrder(order1);
        orderProcessor.addOrder(order2);
        orderProcessor.addOrder(order3);
        orderProcessor.addOrder(order4);

        System.out.println(orderProcessor.getAllOrders());

        orderProcessor.processOrder();

        System.out.println(orderProcessor.getAllOrders());
    }
}
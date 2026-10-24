import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Object> items;
    private int maxSize;

    public Store(int maxSize) {
        items = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public synchronized void addItem(Object item) {
        if (items.size() < maxSize) {
            items.add(item);
            System.out.println("Producer Added item: " + items.size());
        }
    }

    public synchronized void removeItem() {
        if (!items.isEmpty()) {
            items.removeLast();
            System.out.println("Consumer Removed item: " + items.size());
        }
    }
}

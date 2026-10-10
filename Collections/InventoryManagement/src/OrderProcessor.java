import java.util.Collection;
import java.util.PriorityQueue;

public class OrderProcessor {

    private final PriorityQueue<Order> orders;

    public OrderProcessor() {
        this.orders = new PriorityQueue<>();
    }

    public void addOrder(Order order) {
        if (orders.contains(order)) {
            return;
        }

        orders.offer(order);
    }

    public void processOrder() {
        orders.poll();
    }

    public Collection<Order> getAllOrders() {
        return orders;
    }
}

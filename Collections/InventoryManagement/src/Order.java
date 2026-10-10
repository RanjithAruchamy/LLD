import java.util.PriorityQueue;

public class Order implements Comparable<Order> {

    private String orderId;
    private Boolean isExpress;


    public Order(Boolean isExpress, String orderId) {
        this.isExpress = isExpress;
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Boolean getExpress() {
        return isExpress;
    }

    public void setExpress(Boolean express) {
        isExpress = express;
    }

    @Override
    public int compareTo(Order o) {
        int result = o.isExpress.compareTo(this.isExpress);
        if (result == 0) {
            return o.orderId.compareTo(this.orderId);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", isExpress=" + isExpress +
                '}';
    }
}

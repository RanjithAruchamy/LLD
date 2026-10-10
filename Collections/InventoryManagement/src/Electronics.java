public class Electronics extends Item {

    public Electronics(Integer id, String name, Integer quantity, Double price, int warranty) {
        super(id, name, quantity, price);
        this.warranty = warranty;
    }

    private int warranty;

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
}

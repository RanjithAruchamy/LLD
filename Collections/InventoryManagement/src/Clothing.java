public class Clothing extends Item {

    public Clothing(Integer id, String name, Integer quantity, Double price, String size) {
        super(id, name, quantity, price);
        this.size = size;
    }

    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

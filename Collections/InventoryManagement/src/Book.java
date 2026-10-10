public class Book extends Item {

    public Book(Integer id, String name, Integer quantity, Double price, String author) {
        super(id, name, quantity, price);
        this.author = author;
    }

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

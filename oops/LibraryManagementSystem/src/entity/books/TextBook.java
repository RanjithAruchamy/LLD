package entity.books;


public class TextBook extends Book {

    public TextBook(String isbn, String title, String author) {
        super(isbn, title, author);
    }

    @Override
    public void displayBookDetails() {
        System.out.println("------------Text Book-------------");
        System.out.printf("Title: %s%n", getTitle());
        System.out.printf("ISBN: %s%n", getIsbn());
        System.out.printf("Author: %s%n", getAuthor());
        System.out.printf("IsAvailable: %s%n", isAvailable());
    }

    @Override
    public boolean isLendable() {
        return false;
    }

    @Override
    public BookType getType() {
        return BookType.TEXT_BOOK;
    }
}

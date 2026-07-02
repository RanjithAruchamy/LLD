package entity.books;

public class NovelBook extends Book {

    public NovelBook(String isbn, String title, String author) {
        super(isbn, title, author);
    }

    @Override
    public void displayBookDetails() {
        System.out.println("------------Novel Book-------------");
        System.out.printf("Title: %s%n", getTitle());
        System.out.printf("ISBN: %s%n", getIsbn());
        System.out.printf("Author: %s%n", getAuthor());
        System.out.printf("IsAvailable: %s%n", isAvailable());
    }

    @Override
    public boolean isLendable() {
        return true;
    }

    @Override
    public BookType getType() {
        return BookType.NOVEL_BOOK;
    }
}

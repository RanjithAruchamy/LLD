package repository;

import entity.books.Book;
import entity.books.BookType;
import entity.users.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> bookInventory = new ArrayList<>();
    private List<User> registeredUsers = new ArrayList<>();

    public void addBook(Book book) {
        bookInventory.add(book);
    }

    public void registerUser(User user) {
        registeredUsers.add(user);
    }

    public List<Book> searchBook(String title) {
        return bookInventory.stream().filter(book -> book.getTitle().equals(title)).toList();
    }

    public List<Book> searchBook(String criteria, BookType type) {
        return bookInventory.stream().filter(book -> type.equals(book.getType())).toList();
    }

    public void lendBook(User user, Book book) {
        book.lend(user);

    }
}

import entity.books.Book;
import entity.books.BookType;
import entity.books.NovelBook;
import entity.books.TextBook;
import entity.users.Librarian;
import entity.users.Member;
import entity.users.User;
import repository.LibraryManagementSystem;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User member1 = new Member("Harshitha", "12312456");
        User member2 = new Member("Rihaan", "12312456");
        User member3 = new Member("Srnika", "12312456");
        User librarian1 = new Librarian("Ranjith", "123456789", "EMP-01");
        User librarian2 = new Librarian("Athvik", "123456789", "EMP-02");
        User librarian3 = new Librarian("Ria", "123456789", "EMP-03");

        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        System.out.printf("TotalUser: %d%n", User.getTotalUsers());

        Book textBook1 = new TextBook("123","Physics", "Govind");
        Book textBook2 = new TextBook("1234","Tamil", "Thiruvalluvar");
        Book textBook3 = new TextBook("125","English", "James");
        Book novel1 = new NovelBook("234","Comic", "John");
        Book novel2 = new NovelBook("221","Kids Rhymes", "Kine");
        Book novel3 = new NovelBook("235","Horror World", "Chris");

        novel1.lend(member2);

        List<User> users = List.of(member1, member2, member3, librarian1, librarian2, librarian3);
        users.forEach(user -> {
            user.displayDashboard();
            libraryManagementSystem.registerUser(user);
        });

        List<Book> books = List.of(textBook1, textBook2, textBook3, novel1, novel2, novel3);
        books.forEach(book -> {
            book.displayBookDetails();
            libraryManagementSystem.addBook(book);
        });

        System.out.println(libraryManagementSystem.searchBook("English"));
        System.out.println(libraryManagementSystem.searchBook("", BookType.TEXT_BOOK));

        novel1.returnBook(member2);
        novel1.displayBookDetails();
    }
}
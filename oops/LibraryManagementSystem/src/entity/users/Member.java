package entity.users;

public class Member extends User {

    public Member(String name, String contactInfo) {
        super(name, contactInfo);
        this.borrowBooksCount = 0;
    }

    private static final int MAX_BORROW_LIMIT = 5;

    private int borrowBooksCount;

    @Override
    public void displayDashboard() {
        System.out.println("------Member Dashboard-------");
        System.out.printf("Member name: %s%n", getName());
        System.out.printf("Books Borrowed: %d%n", borrowBooksCount);
    }

    @Override
    public boolean canBorrowBooks() {
        return borrowBooksCount < MAX_BORROW_LIMIT;
    }
}

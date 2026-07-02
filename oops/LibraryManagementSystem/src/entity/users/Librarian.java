package entity.users;

public class Librarian extends User {

    private final String employeeNumber;

    public Librarian(String name, String contactInfo, String employeeNumber) {
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void displayDashboard() {
        System.out.println("----------Librarian Dashboard-----------");
        System.out.printf("Name: %s%n", getName());
        System.out.printf("Employee number is %s%n", employeeNumber);
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    public void addNewBook() {

    }

    public void removeNewBook() {

    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
}

package entity.users;

public abstract class User {
    private final String userId;
    private String name;
    private String contactInfo;
    private static int totalUsers = 0;
    private static int idCount = 0;

    public User() {
        this.userId = generateUniqueId();
        totalUsers++;
    }

    public User(String name, String contactInfo) {
        this.userId = generateUniqueId();
        this.name = name;
        this.contactInfo = contactInfo;
        totalUsers++;
    }

    public User(User user) {
        this.userId = generateUniqueId();
        this.name = user.name;
        this.contactInfo = user.contactInfo;
        totalUsers++;
    }

    public abstract void displayDashboard();
    public abstract boolean canBorrowBooks();

    protected final String generateUniqueId() {
        return "U-" + (++idCount);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }
}

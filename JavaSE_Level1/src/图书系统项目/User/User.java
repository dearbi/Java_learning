package 图书系统项目.User;

public abstract class User {
    protected String name;
    protected int userID;
    protected String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String name, int userID, String role) {
        this.name = name;
        this.userID = userID;
        this.role = role;
    }
    public abstract int display();
}

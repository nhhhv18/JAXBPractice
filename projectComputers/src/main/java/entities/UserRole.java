package entities;

public enum UserRole {

    ADMIN("admin", "Administrator with full privileges"),
    USER("user", "Regular user with limited access"),
    GUEST("guest", "Guest user with minimal access");

    private String roleName;
    private String description;

    UserRole(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public void displayInfo() {
        System.out.println("Role: " + roleName);
        System.out.println("Description: " + description);
    }
}


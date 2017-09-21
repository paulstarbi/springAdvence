package beans.models;

public enum UsersRole {

    REGISTERED_USER ("USER"),
    BOOKING_MANAGER ("MANAGER");

    private String role;

    UsersRole(String role) {
        this.role =role;
    }

    public String getRole() {
        return role;
    }
}

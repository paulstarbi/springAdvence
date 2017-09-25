package beans.models;

public enum UsersRole {

    REGISTERED_USER ("REGISTERED_USER"),
    BOOKING_MANAGER ("BOOKING_MANAGER");

    private String role;

    UsersRole(String role) {
        this.role =role;
    }

    public String getRole() {
        return role;
    }
}

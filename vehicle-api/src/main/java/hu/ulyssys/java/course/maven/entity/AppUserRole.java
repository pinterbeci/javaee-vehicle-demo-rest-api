package hu.ulyssys.java.course.maven.entity;

public enum AppUserRole {
    USER("Mezei felhasználó"),
    ADMIN("Admin csávó/csajo$"),
    SOFTWARE_ENGINEER("Fejlesztő mérnök");

    private final String role;

    AppUserRole(final String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}

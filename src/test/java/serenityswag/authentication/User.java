package serenityswag.authentication;

/**
 * Accepted usernames are:
 * standard_user
 * locked_out_user
 * problem_user
 * performance_glitch_user
 *
 */
public enum User {
    STANDARD_USER("standard_user", "secret_sauce", "A standard user"),
    LOCKET_OUT_USER("locked_out_user", "secret_sauce", "A user who locked out the account"),
    PROBLEM_USER("problem_user", "secret_sauce", "A standard user");
    private final String username;
    private final String password;
    private final String description;

    User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return description;
    }
}

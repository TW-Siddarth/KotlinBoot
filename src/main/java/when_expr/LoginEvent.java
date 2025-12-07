package when_expr;

// LoginEvent.java
public class LoginEvent implements Event {
	private final String username;
	public LoginEvent(String username) { this.username = username; }
	public String getUsername() { return username; }
}

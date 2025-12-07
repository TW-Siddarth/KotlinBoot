package when_expr;

public class EventLogger {
	public String getLogMessage(Event event) {
		String log;
		if (event instanceof MessageEvent) {
			MessageEvent messageEvent = (MessageEvent) event;
			log = "INFO: MessageEvent with content: '" + messageEvent.getMessage() + "'";
		} else if (event instanceof LoginEvent) {
			LoginEvent loginEvent = (LoginEvent) event;
			log = "INFO: LoginEvent for user: '" + loginEvent.getUsername() + "'";
		} else if (event instanceof LogoutEvent) {
			log = "INFO: LogoutEvent occurred.";
		} else {
			log = "WARN: An unknown event occurred.";
		}
		return log;
	}
}

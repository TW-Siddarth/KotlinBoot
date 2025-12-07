package builder;

// Config.java
public final class Config {
	private final String host;
	private final int port;
	private final boolean useTls;
	private final int timeout;

	// Private constructor to enforce builder usage
	private Config(Builder builder) {
		this.host = builder.host;
		this.port = builder.port;
		this.useTls = builder.useTls;
		this.timeout = builder.timeout;
	}

	// Only getters, no setters, for immutability
	public String getHost() { return host; }
	public int getPort() { return port; }
	public boolean isUseTls() { return useTls; }
	public int getTimeout() { return timeout; }

	@Override
	public String toString() {
		return "Config{" + "host='" + host + '\'' + ", port=" + port +
				", useTls=" + useTls + ", timeout=" + timeout + '}';
	}

	// A method to create a builder from an existing instance
	public Builder toBuilder() {
		return new Builder()
				.host(this.host)
				.port(this.port)
				.useTls(this.useTls)
				.timeout(this.timeout);
	}

	// The static nested Builder class
	public static class Builder {
		private String host = "localhost";
		private int port = 8080;
		private boolean useTls = false;
		private int timeout = 5000; // Default values

		public Builder host(String host) {
			this.host = host;
			return this;
		}

		public Builder port(int port) {
			this.port = port;
			return this;
		}

		public Builder useTls(boolean useTls) {
			this.useTls = useTls;
			return this;
		}

		public Builder timeout(int timeout) {
			this.timeout = timeout;
			return this;
		}

		public Config build() {
			return new Config(this);
		}
	}

	public static void main(String[] args) {
		// 1. Create an initial configuration
		Config defaultConfig = new Config.Builder()
				.host("api.example.com")
				.port(443)
				.useTls(true)
				.build();

		System.out.println("Default: " + defaultConfig);

		// 2. Create a modified version with a longer timeout
		Config longTimeoutConfig = defaultConfig.toBuilder()
				.timeout(15000) // Only change what you need
				.build();

		System.out.println("Modified: " + longTimeoutConfig);

		// The original object remains unchanged
		System.out.println("Original is unchanged: " + defaultConfig);
	}
}
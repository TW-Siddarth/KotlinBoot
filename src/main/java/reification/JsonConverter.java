package reification;

import com.fasterxml.jackson.databind.ObjectMapper; // Example library

public class JsonConverter {
	private final ObjectMapper mapper = new ObjectMapper(); // A real library instance

	public <T> String toJson(T object) throws Exception {
		return mapper.writeValueAsString(object);
	}

	// Note the 'Class<T> clazz' parameter.
	// This is the boilerplate we want to eliminate.
	public <T> T fromJson(String json, Class<T> clazz) throws Exception {
		return mapper.readValue(json, clazz);
	}

	// Usage
	public static void main(String[] args) throws Exception {
		JsonConverter converter = new JsonConverter();
		User user = new User("Alice", 30);

		// Serialization is fine
		String json = converter.toJson(user);
		System.out.println("Serialized JSON: " + json);

		// Deserialization requires passing User.class
		User deserializedUser = converter.fromJson(json, User.class); // <-- The boilerplate
		System.out.println("Deserialized User: " + deserializedUser);
	}
}

package reification;


// A simple POJO
public class User {
	private String name;
	private int age;

	// Default constructor needed for many deserializers
	public User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "User{name='" + name + "', age=" + age + '}';
	}
}

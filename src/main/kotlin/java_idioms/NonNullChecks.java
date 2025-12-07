package java_idioms;

public class NonNullChecks {
	// Example 1

	class User {
		private final String name;
		private final Address address;

		public User(String name, Address address) {
			this.name = name;
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public Address getAddress() {
			return address;
		}
	}

	class Address {
		private final String street;

		public Address(String street) {
			this.street = street;
		}

		public String getStreet() {
			return street;
		}
	}

	static class Main {
		public String getStreetAddress(User user) {
			if (user != null) {
				Address address = user.getAddress();
				if (address != null) {
					String street = address.getStreet();
					if (street != null) {
						return street;
					}
				}
			}
			return "Not available";
		}
	}

	// Example 2

	class OrderService {
		public void processOrder(Product product) {
			if (product == null) {
				throw new IllegalArgumentException("Product cannot be null");
			}
			if (product.getName() == null) {
				throw new IllegalArgumentException("Product name cannot be null");
			}
			// ... process the order
			System.out.println("Processing order for: " + product.getName());
		}
	}

	class Product {
		private final String name;

		public Product(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}

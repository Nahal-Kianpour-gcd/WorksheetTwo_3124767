/* Student name:Nahal Kianpour Lirharani
 * Student number:3124767
 */
package griffith;

public class Conversions {

	// Converts Euro to Dollar
	public double euroToDollar(double euro) {
		if (euro < 0) {
			throw new IllegalArgumentException("Euro amount cannot be negative");
		}
		return euro * 1.08; // Assuming 1 EUR = 1.08 USD
	}

	// Converts Dollar to Euro
	public double dollarToEuro(double dollar) {
		if (dollar < 0) {
			throw new IllegalArgumentException("Dollar amount cannot be negative");
		}
		return dollar * 0.93; // Assuming 1 USD = 0.93 EUR
	}

	// Converts String to Integer
	public int stringToInteger(String val) {
		if (val == null) {
			throw new IllegalArgumentException("Input string cannot be null");
		}
		return Integer.parseInt(val.trim()); // Trims spaces and converts string to integer
	}

	// Converts Integer to String
	public String integerToString(int val) {
		return String.valueOf(val); // Converts int to String
	}

	// Switches uppercase letters to lowercase and vice versa
	public String switchCase(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Input string cannot be null");
		}
		StringBuilder switched = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isUpperCase(c)) {
				switched.append(Character.toLowerCase(c));
			} else if (Character.isLowerCase(c)) {
				switched.append(Character.toUpperCase(c));
			} else {
				switched.append(c); // Keep numbers and special characters unchanged
			}
		}
		return switched.toString();
	}

}

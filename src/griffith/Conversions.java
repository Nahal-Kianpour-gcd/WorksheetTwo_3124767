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
		// Implementation will be here later
		return 0;
	}

	// Converts Integer to String
	public String integerToString(int val) {
		return null;
	}

	// Switchs uppercase letters to lowercase and vice versa
	public String switchCase() {
		return null;
	}
}

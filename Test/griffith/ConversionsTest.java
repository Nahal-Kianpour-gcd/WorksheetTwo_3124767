/* Student name:Nahal Kianpour Lirharani
 * Student number:3124767
 */
package griffith;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ConversionsTest {

	@Test
	void testEuroToDollar() {
		Conversions conv = new Conversions();

		// Normal conversion cases (Assuming 1 Euro = 1.08 USD)
		assertEquals(1.08, conv.euroToDollar(1), 0.01, "1 Euro should be 1.08 USD");
		assertEquals(10.8, conv.euroToDollar(10), 0.01, "10 Euros should be 10.8 USD");
		assertEquals(108.0, conv.euroToDollar(100), 0.01, "100 Euros should be 108 USD");

		// Zero Euros should return zero USD
		assertEquals(0, conv.euroToDollar(0), "0 Euro should return 0 USD");

		// Negative input should throw an exceptio
		assertThrows(IllegalArgumentException.class, () -> conv.euroToDollar(-5),
				"Negative Euros should throw an exception");

		// Edge Case: Very small decimal value
		assertEquals(0.01, conv.euroToDollar(0.01), 0.01, "0.01 Euro should convert correctly");

		// Edge Case: Large Value Conversion
		assertEquals(1080000.0, conv.euroToDollar(1000000), 0.01, "1,000,000 Euros should convert correctly");
	}

	@Test
	void testDollarToEuro() {
		Conversions conv = new Conversions();

		// Normal conversion cases (Assuming 1 USD = 0.93 EUR)
		assertEquals(0.93, conv.dollarToEuro(1), 0.01, "1 USD should be 0.93 Euros");
		assertEquals(9.3, conv.dollarToEuro(10), 0.01, "10 USD should be 9.3 Euros");
		assertEquals(930.0, conv.dollarToEuro(1000), 0.01, "1000 USD should be 930 Euros");

		// Zero Dollars should return zero Euros
		assertEquals(0, conv.dollarToEuro(0), "0 USD should return 0 Euros");

		// Negative input should throw an exception
		assertThrows(IllegalArgumentException.class, () -> conv.dollarToEuro(-5),
				"Negative dollars should throw an exception");

		// Edge Case: Small Decimal Values
		assertEquals(0.0093, conv.dollarToEuro(0.01), 0.01, "0.01 USD should convert correctly");

		// Edge Case: Large Value Conversion
		assertEquals(930000.0, conv.dollarToEuro(1000000), 0.01, "1,000,000 USD should convert correctly");
	}

	@Test
	void testStringToInteger() {
		Conversions conv = new Conversions();

		// Normal conversion cases
		assertEquals(123, conv.stringToInteger("123"), "Should convert '123' to integer 123");
		assertEquals(-456, conv.stringToInteger("-456"), "Should convert '-456' to integer -456");
		assertEquals(0, conv.stringToInteger("0"), "Should convert '0' to integer 0");

		// Large integer cases
		assertEquals(999999, conv.stringToInteger("999999"), "Should convert '999999' to integer 999999");
		assertEquals(-999999, conv.stringToInteger("-999999"), "Should convert '-999999' to integer -999999");

		// Edge Cases: Whitespace should be trimmed
		assertEquals(42, conv.stringToInteger(" 42 "), "Should handle leading/trailing spaces");
		assertEquals(-78, conv.stringToInteger("  -78 "), "Should handle leading/trailing spaces with negatives");

		// Invalid cases: Non-numeric strings should throw exceptions
		assertThrows(NumberFormatException.class, () -> conv.stringToInteger("ABC"),
				"Invalid string should throw exception");
		assertThrows(NumberFormatException.class, () -> conv.stringToInteger("12.5"),
				"Decimal string should throw exception");
		assertThrows(NumberFormatException.class, () -> conv.stringToInteger("123abc"),
				"Mixed characters should throw exception");

		// Null input should throw exception
		assertThrows(IllegalArgumentException.class, () -> conv.stringToInteger(null),
				"Null input should throw exception");
	}

	@Test
	void testIntegerToString() {
		Conversions conv = new Conversions();

		// Normal conversion cases
		assertEquals("123", conv.integerToString(123), "Should convert 123 to '123'");
		assertEquals("-456", conv.integerToString(-456), "Should convert -456 to '-456'");
		assertEquals("0", conv.integerToString(0), "Should convert 0 to '0'");

		// Large integer cases
		assertEquals("999999", conv.integerToString(999999), "Should convert 999999 to '999999'");
		assertEquals("-999999", conv.integerToString(-999999), "Should convert -999999 to '-999999'");

		// Edge Case: Integer.MIN_VALUE and Integer.MAX_VALUE
		assertEquals(String.valueOf(Integer.MAX_VALUE), conv.integerToString(Integer.MAX_VALUE),
				"Should handle Integer.MAX_VALUE");
		assertEquals(String.valueOf(Integer.MIN_VALUE), conv.integerToString(Integer.MIN_VALUE),
				"Should handle Integer.MIN_VALUE");
	}

	@Test
	void testSwitchCase() {
		Conversions conv = new Conversions();

		// Normal case: Simple uppercase to lowercase and vice versa
		assertEquals("hELLO", conv.switchCase("Hello"), "Should switch 'Hello' to 'hELLO'");
		assertEquals("wORLD", conv.switchCase("World"), "Should switch 'World' to 'wORLD'");

		// All uppercase letters
		assertEquals("abc", conv.switchCase("ABC"), "Should switch all uppercase letters to lowercase");

		// All lowercase letters
		assertEquals("XYZ", conv.switchCase("xyz"), "Should switch all lowercase letters to uppercase");

		// Mixed case
		assertEquals("jAvA", conv.switchCase("JaVa"), "Should correctly switch each character");

		// Edge Case: Numbers and special characters should remain unchanged
		assertEquals("123!@#", conv.switchCase("123!@#"), "Numbers and special characters should not be affected");

		// Edge Case: Empty string should return an empty string
		assertEquals("", conv.switchCase(""), "Empty string should return an empty string");

		// Null input should throw an exception
		assertThrows(IllegalArgumentException.class, () -> conv.switchCase(null),
				"Null input should throw an exception");
	}
}

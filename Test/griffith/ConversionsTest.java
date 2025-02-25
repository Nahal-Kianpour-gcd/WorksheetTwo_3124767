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
		fail("Not yet implemented"); // Placeholder to ensure failure
	}

	@Test
	void testIntegerToString() {
		fail("Not yet implemented"); // Placeholder to ensure failure
	}

	@Test
	void testSwitchCase() {
		fail("Not yet implemented"); // Placeholder to ensure failure
	}
}

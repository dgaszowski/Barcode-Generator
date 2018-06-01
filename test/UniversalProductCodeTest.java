import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

public class UniversalProductCodeTest {
	JSONObject definition = new JSONObject();

	@Test(expected = IllegalArgumentException.class)
	public void testUniversalProductCodeShouldFailOnDigitsStringTooShort() {
		UniversalProductCode upc = new UniversalProductCode("", definition);
		UniversalProductCode upc1 = new UniversalProductCode("13489367", definition);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUniversalProductCodeShouldFailOnDigitsStringTooLong() {
		UniversalProductCode upc = new UniversalProductCode("7789265789123", definition);
	}
	 
	@Test(expected = IllegalArgumentException.class)
	public void testUniversalProductCodeShouldFailOnDigitsStringContainingNonAlpha() {
		UniversalProductCode upc = new UniversalProductCode("00000000A00", definition);
		UniversalProductCode upc1 = new UniversalProductCode("0000!000900", definition);
		UniversalProductCode upc2 = new UniversalProductCode("0e007000900", definition);
	}
}

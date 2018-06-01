import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass; 
import org.junit.Test;

public class AbstractBarcodeTest {
	private AbstractBarcode ab;
	
	private AbstractBarcode returnAbstractBarcode(JSONObject definition) {
		return new AbstractBarcode(definition) {
			
			@Override
			public int getChecksum() {
				return 0;
			}
			 
			@Override
			public JSONObject barcode() {
				return null;
			}
		};
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAbstractBarcodeJSONObject_ShouldFailOnNullJSONObject() {
		returnAbstractBarcode(null);
	}
	
	@Test
	public void testGetName() {
		
	}

}

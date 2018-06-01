import org.json.JSONObject;

/*
 * https://en.wikipedia.org/wiki/Universal_Product_Code
 */
 
public class UniversalProductCode extends AbstractBarcode {
	private final int USABLE_DIGITS_COUNT = 11;
	
	private int checkSum; 
	private int[] digits; 
	 
	public UniversalProductCode(String digits, JSONObject definition) {
		super(definition);  
		
		if (digits.length() != USABLE_DIGITS_COUNT)
			throw new IllegalArgumentException(
					String.format(
							"UPC-A standard encodes USABLE_DIGITS_COUNT digit numbers, %d digit number has been provided.",
							digits.length()
							)
					);		
		
		for (char ch: digits.toCharArray())
			if (!Character.isDigit(ch))
				throw new IllegalArgumentException(
						"Non digit character found."
				);				
		
		this.digits = new int[USABLE_DIGITS_COUNT];
		
		for (int i = 0; i < USABLE_DIGITS_COUNT; i++) {
			this.digits[i] = (short) Integer.parseInt(
					String.format("%c", digits.charAt(i))
			);			
		}
		
		this.checkSum = UPCChecksum.checksum(this.digits);
		
	}
	
	public int getNumberSystem() {
		return digits[0];
	}
	
	@Override
	public JSONObject barcode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getChecksum() {
		return checkSum;
	}
	
	public static void main(String[] args) {
		UniversalProductCode upc = new UniversalProductCode("00000000000", null);
		
	}

}

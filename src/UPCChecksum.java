
public final class UPCChecksum implements BarcodeChecksum{
	private static final int USABLE_DIGITS_COUNT = 11;
	
	public static int checksum(int[] digits) {
		short oddSum = 0;
		for (short odd = 0; odd < USABLE_DIGITS_COUNT; odd += 2)
			oddSum += digits[odd];
		
		oddSum *= 3;
		
		short evenSum = 0;
		for (short even = 1; even < USABLE_DIGITS_COUNT; even +=2)
			evenSum += digits[even];
		
		int M = (oddSum + evenSum) % 10;
		
		if (M != 0) M = 10 - M;
		
		return M;
	}
}

import static org.junit.Assert.*;
import org.junit.Test;

public class UPCChecksumTest {

	@Test
	public void testChecksumEquals() {
		
		int[][] digits = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 9, 9, 3, 7, 8, 2, 2, 3, 9, 0},
			{3, 4, 5, 6, 8, 9, 7, 7, 8, 1, 2}
		};
		
		int[] results = {0, 3, 4};
		
		for (int i = 0; i < digits.length; i++)			
			assertEquals(UPCChecksum.checksum(digits[i]), results[i]);
		
	}
	
	@Test
	public void testChecksumNotEquals() {
		int[][] digits = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 9, 9, 3, 7, 8, 2, 2, 3, 9, 0},
			{3, 4, 5, 6, 8, 9, 7, 7, 8, 1, 2}
		};
		
		int[] results = {7, 9, 2};
		
		for (int i = 0; i < digits.length; i++)		
			assertNotEquals(UPCChecksum.checksum(digits[i]), results[i]);
	}

}

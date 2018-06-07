import java.util.TreeMap;
import java.util.ArrayList;

public class BarcodeDefinition {
	public String name;
	public String shortname;
	public int length;
	public boolean has_checksum;
	public String left_side_parity;
	public int modules_count;
	public String[] artifacts;
	
	TreeMap<String, ArrayList<Boolean>> alphabet;
	ArrayList<TreeMap<String, Integer>> sequence;
}

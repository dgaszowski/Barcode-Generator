import org.json.JSONObject;

public interface Barcode {
	public JSONObject barcode(String message);
	public Iterable<JSONObject> barcode(Iterable<String> messages);
	public int getChecksum(String message);
	public Iterable<Integer> getChecksum(Iterable<String> messages);
}

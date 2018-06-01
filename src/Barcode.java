import org.json.JSONObject;

public interface Barcode {
	public JSONObject barcode();
	public int getChecksum();
}

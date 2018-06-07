import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

public abstract class AbstractBarcode implements Barcode{
	
	private boolean validateMessage(String message) {
		if (message.length() != this.length) return false;
		
		for (int i = 0; i < message.length(); i++)
			if (!this.alphabet.keySet().contains(String.format("%c", message.charAt(i))))
					return false;
			
		return true;
	}
	
	AbstractBarcode(JSONObject definition) {
		BarcodeDefinition barcodeDefinition = new BarcodeDefinition();
		
	}
	
	@Override
	public JSONObject barcode(String message) {
		if (!validateMessage(message))
			throw new IllegalArgumentException(
					String.format("Invalid message format: '%s'.", message)
					);
						
		return null;
	}
	
	@Override
	public abstract ArrayList<JSONObject> barcode(Iterable<String> messages);
	
	@Override
	public abstract int getChecksum(String message);
	
	@Override
	public abstract ArrayList<Integer> getChecksum(Iterable<String> messages);
	
	public String getName() {
		return name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean hasChecksum() {
		return hasChecksum;
	}
	
	public LeftSideParity getParity() {
		return leftSideParity;
	}

}

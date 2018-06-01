import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AbstractBarcode implements Barcode{
	
	protected JSONObject barcode; 
	private JSONObject definition;
	
	private String name;
	private String shortName;
	private int length;
	private boolean hasChecksum;
	private LeftSideParity leftSideParity;
	private HashSet<String> artifacts;
	private TreeMap<String, ArrayList<Boolean>> alphabet;
	private TreeMap<String, ArrayList<Boolean>> sequence;
	
	private void throwMissingField(String fieldName) {
		throw new IllegalArgumentException( 
				String.format(
						"Field '%s' is required in barcode definition. Please refine your JSON definition file.",
						fieldName
				)
		);
	}
	
	AbstractBarcode(JSONObject definition) {
		if (definition == null)
			throw new IllegalArgumentException(
					"JSON definition object of UPC-A cannot be null."
			);
		
		this.definition = definition;
		this.barcode = new JSONObject();
		
		// Parse the definition object.
		
		if (definition.has(BarcodeDefinition.NAME.getFieldName()))		
			this.name = definition.getString(BarcodeDefinition.NAME.getFieldName());
		
		if (definition.has(BarcodeDefinition.SHORT.getFieldName()))
			this.shortName = definition.getString(BarcodeDefinition.SHORT.getFieldName());
		
		if (!definition.has(BarcodeDefinition.CHECKSUM.getFieldName()))
			this.hasChecksum = true;
		else
			this.hasChecksum = definition.getBoolean(BarcodeDefinition.CHECKSUM.getFieldName());
		
		if (!definition.has(BarcodeDefinition.LENGTH.getFieldName()))
			throwMissingField(BarcodeDefinition.LENGTH.getFieldName());
		else
			this.length = definition.getInt(BarcodeDefinition.LENGTH.getFieldName());
		
		if (!definition.has(BarcodeDefinition.LEFT_SIDE_PARITY.getFieldName()))
			this.leftSideParity = LeftSideParity.ODD;
		else {	
			
			if (definition.getString("left_side_parity").toUpperCase().equals("ODD"))
				this.leftSideParity = LeftSideParity.ODD;
			else
				this.leftSideParity = LeftSideParity.EVEN;
		}
		
		// Get names of artifacts
		if (definition.has(BarcodeDefinition.ARTIFACTS.getFieldName())
				&& definition.get(BarcodeDefinition.ARTIFACTS.getFieldName()) instanceof JSONArray) {
			
			JSONArray artifacts = definition.getJSONArray(BarcodeDefinition.ARTIFACTS.getFieldName());
			for (int i = 0; i < artifacts.length(); i++) 
				this.artifacts.add(artifacts.getString(i));
		}
		
		// Parse the definition of alphabet
		if (!definition.has(BarcodeDefinition.ALPHABET.getFieldName()))
			
			throwMissingField(BarcodeDefinition.ALPHABET.getFieldName());
		
		else {
			JSONObject alpha = definition.getJSONObject(BarcodeDefinition.ALPHABET.getFieldName());
			while (alpha.keys().hasNext()) {
				String key = alpha.keys().next();
				JSONArray letter = null;
				if (alpha.get(key) instanceof JSONArray) {
					
					letter = alpha.getJSONArray(key);
					ArrayList<Boolean> modules = new ArrayList<>();
					
					for (int i = 0; i < letter.length(); i++)
						modules.add(letter.getBoolean(i));
					
					this.alphabet.put(key, modules);
				}
			}
		}
		
	}
	 
	public AbstractBarcode(JSONObject definition, String message) {
		this(definition);
		
	}
	
	@Override
	public abstract JSONObject barcode();
	
	@Override
	public abstract int getChecksum();
	
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

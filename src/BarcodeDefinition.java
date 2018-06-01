
public enum BarcodeDefinition {
	NAME("name", false),
	SHORT("shortname", false),
	LENGTH("length", true),
	CHECKSUM("checksum", false),
	LEFT_SIDE_PARITY("left_side_parity", false),
	ARTIFACTS("artifacts", false),
	ALPHABET("alphabet", true),
	SEQUENCE("sequence", true);
	
	private String fieldName;
	private boolean required;
	
	BarcodeDefinition(String fieldName, boolean required) {
		this.fieldName = fieldName;
		this.required = required;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public boolean isRequired() {
		return required;
	}
	
}

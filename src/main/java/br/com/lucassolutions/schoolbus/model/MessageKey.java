package br.com.lucassolutions.schoolbus.model;

public enum MessageKey {
	
	WARNING("warning"),
	SUCESS("sucess"),
	ERROR("error");
	
	private String key;
	
	MessageKey(String key){
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	} 
}

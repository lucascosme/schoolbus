package br.com.lucassolutions.schoolbus.model;

public enum Period {
	
	MORNING("Manhã"),
	AFTERNOON("Tarde");
	
	private String description;
	
	private Period(String description) {
		setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

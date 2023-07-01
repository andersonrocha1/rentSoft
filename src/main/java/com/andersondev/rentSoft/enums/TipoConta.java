package com.andersondev.rentSoft.enums;

public enum TipoConta {
	
	AGUA("Agua"),
    ENERGIA("Energia");
	
	
	private String value;

	private TipoConta(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		
		return value;
	}
   

}

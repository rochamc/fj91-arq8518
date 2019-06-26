package br.com.caelum.parking.users.shared.validation;

public class FormErrorDTO {
	
	private String field;
	private String error;
	
	public FormErrorDTO(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getCampo() {
		return field;
	}

	public String getErro() {
		return error;
	}
	
	

}

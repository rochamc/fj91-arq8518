package br.com.caelum.parking.users.loginUser;

class TokenDTO {
	
	private String token;
	private String type;

	public TokenDTO(String token, String type) {
		this.token = token;
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return type;
	}
}

package br.com.caelum.parking.users.loginUser;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

class UserLoginForm {
	
	@NotNull
	@NotEmpty
	private String principal;
	
	@NotEmpty
	@NotNull
	@Length(min = 10, max = 30)
	private String password;
	
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}

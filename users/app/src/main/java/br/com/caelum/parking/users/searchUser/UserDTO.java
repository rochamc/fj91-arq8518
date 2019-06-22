package br.com.caelum.parking.users.searchUser;

import java.time.LocalDate;


public class UserDTO {
	
	private Long id;
	private String email;
	private String username;
	private String fullName;
	private LocalDate birthDate;
	
	public UserDTO(Long id, String email, String username, String fullName, LocalDate birthDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}

}

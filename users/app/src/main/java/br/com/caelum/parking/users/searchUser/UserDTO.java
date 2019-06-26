package br.com.caelum.parking.users.searchUser;

import java.math.BigDecimal;
import java.time.LocalDate;


class UserDTO {
	
	private Long id;
	private String email;
	private String username;
	private String fullName;
	private LocalDate birthDate;
	private BigDecimal clientRating;
	private BigDecimal partnerRating;
	
	public UserDTO(Long id, String email, String username, String fullName, LocalDate birthDate, BigDecimal clientRating, BigDecimal partnerRating) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.clientRating = clientRating;
		this.partnerRating = partnerRating;
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

	public BigDecimal getClientRating() {
		return clientRating;
	}

	public void setClientRating(BigDecimal clientRating) {
		this.clientRating = clientRating;
	}

	public BigDecimal getPartnerRating() {
		return partnerRating;
	}

	public void setPartnerRating(BigDecimal partnerRating) {
		this.partnerRating = partnerRating;
	}

}

package br.com.caelum.parking.users.shared.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
	
	private static final long serialVersionUID = -5118387308496403193L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String password;
	@Column(unique = true)
	private String username;
	private String firstName;
	private String lastName;
	private BigDecimal clientRating = BigDecimal.ZERO;
	private BigDecimal partnerRating = BigDecimal.ZERO;
	private LocalDate birthDate;
	@Column(columnDefinition = "BIT(1) default true")
	private boolean isActive = true;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	public User() {
	}

	public User(String email, String password, String username, String firstName, String lastName, LocalDate birthDate) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.perfis.add(new Perfil(1L, "Usuario"));
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public void inactivate() {
		this.isActive = false;
	}
	
	public void activate() {
		this.isActive = true;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.isActive;
	}
	
}

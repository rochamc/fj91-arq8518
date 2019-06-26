package br.com.caelum.parking.users.loginUser;

import java.util.Optional;

import br.com.caelum.parking.users.shared.domain.User;

public interface UserLoginRepository {
	
	public Optional<User> findByUsernameOrEmail(String username, String email);
	public Optional<User> findById(Long id);
}

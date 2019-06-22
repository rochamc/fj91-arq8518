package br.com.caelum.parking.users.searchUser;

import java.util.Optional;

import br.com.caelum.parking.users.shared.domain.User;

public interface UserSearchRepository {
	
	public Optional<User> findById(Long id);

}

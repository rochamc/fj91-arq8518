package br.com.caelum.parking.users.rateUser;

import java.util.Optional;

import br.com.caelum.parking.users.shared.domain.User;

public interface UserRatingRepository {
	
	Optional<User> findById(Long id);
	User save(User user);

}

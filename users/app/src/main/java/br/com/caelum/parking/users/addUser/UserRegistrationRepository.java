package br.com.caelum.parking.users.addUser;

import br.com.caelum.parking.users.shared.domain.User;

public interface UserRegistrationRepository {
	
	User saveAndFlush(User user);

}

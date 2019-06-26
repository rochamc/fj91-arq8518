package br.com.caelum.parking.users.searchUser;

import org.springframework.stereotype.Service;

import br.com.caelum.parking.users.shared.domain.User;
import br.com.caelum.parking.users.shared.exception.UserNotFoundException;

@Service
class UserSearchService {
	
	private final UserSearchRepository repository;
	private final UserToUserDTOConverter converter;
	
	UserSearchService(UserSearchRepository userRepository, UserToUserDTOConverter converter) {
		this.repository = userRepository;
		this.converter = converter;
	}
	
	UserDTO findById(Long id) {
		User user = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		return this.converter.convert(user);
	}

}

package br.com.caelum.parking.users.searchUser;

import java.util.Optional;



import org.springframework.stereotype.Service;

import br.com.caelum.parking.users.shared.domain.User;

@Service
public class UserSearchService {
	
	private final UserSearchRepository repository;
	private final UserToUserDTOConverter converter;
	
	public UserSearchService(UserSearchRepository userRepository, UserToUserDTOConverter converter) {
		this.repository = userRepository;
		this.converter = converter;
	}
	
	UserDTO findById(Long id) {
		Optional<User> user = this.repository.findById(id);
		if (user.isPresent()) {
			UserDTO dto = this.converter.convert(user.get());
			return dto;
		}
		return null;		
	}

}

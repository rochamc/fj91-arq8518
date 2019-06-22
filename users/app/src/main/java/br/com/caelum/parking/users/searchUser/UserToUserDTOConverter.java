package br.com.caelum.parking.users.searchUser;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.caelum.parking.users.shared.domain.User;

@Component
public class UserToUserDTOConverter implements Converter<User, UserDTO> {
	
	@Override
	public UserDTO convert(User user) {
		return new UserDTO(user.getId(), user.getEmail(), user.getUsername(), user.getFullName(), user.getBirthDate());
	}

}

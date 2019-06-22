package br.com.caelum.parking.users.addUser;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.caelum.parking.users.shared.domain.User;

@Component
public class UserFormToUserConverter implements Converter<UserRegistrationForm, User> {
	
	@Override
	public User convert(UserRegistrationForm form) {
		return new User(form.getEmail(), form.getPassword(), form.getUsername(), form.getFirstName(), form.getLastName(), form.getBirthDate());
	}
	
}

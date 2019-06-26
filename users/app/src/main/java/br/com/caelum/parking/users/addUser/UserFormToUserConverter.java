package br.com.caelum.parking.users.addUser;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.caelum.parking.users.shared.domain.User;

@Component
class UserFormToUserConverter implements Converter<UserRegistrationForm, User> {
	
	@Override
	public User convert(UserRegistrationForm form) {
		String encoded_pass = new BCryptPasswordEncoder().encode(form.getPassword());
		return new User(form.getEmail(), encoded_pass, form.getUsername(), form.getFirstName(), form.getLastName(), form.getBirthDate());
	}
	
}

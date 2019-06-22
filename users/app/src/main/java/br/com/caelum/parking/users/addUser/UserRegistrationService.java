package br.com.caelum.parking.users.addUser;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import br.com.caelum.parking.users.shared.domain.User;

@Service
public class UserRegistrationService {
	
	private final Converter<UserRegistrationForm, User> formConverter;
	private final UserRegistrationRepository userRepository;
	
	public UserRegistrationService(Converter<UserRegistrationForm, User> formConverter, UserRegistrationRepository userRepository) {
		this.formConverter = formConverter;
		this.userRepository = userRepository;
	}
	
	Long createUser(UserRegistrationForm form) {
		User user = formConverter.convert(form);
		User savedUser = this.userRepository.saveAndFlush(user);
		return savedUser.getId();
	}
	

}

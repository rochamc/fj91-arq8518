package br.com.caelum.parking.users.config.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.caelum.parking.users.loginUser.UserLoginRepository;
import br.com.caelum.parking.users.shared.domain.User;


@Service
public class AuthenticationService  implements UserDetailsService {
	
	private final UserLoginRepository repository;
	
	public AuthenticationService(UserLoginRepository loginRepository) {
		this.repository = loginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String principal) throws UsernameNotFoundException {
		Optional<User> usuario = repository.findByUsernameOrEmail(principal, principal);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}


}

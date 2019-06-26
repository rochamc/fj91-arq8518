package br.com.caelum.parking.users.loginUser;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.parking.users.config.security.TokenService;

@RestController
@RequestMapping("/login")
public class UserLoginController {
		
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserLoginFormToAuthenticationTokenConverter converter;
	
	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody @Valid UserLoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = converter.convert(form);
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.generateToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(401).build();
		}
	}
}

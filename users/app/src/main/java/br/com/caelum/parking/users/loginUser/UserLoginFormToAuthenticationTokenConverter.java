package br.com.caelum.parking.users.loginUser;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
class UserLoginFormToAuthenticationTokenConverter implements Converter<UserLoginForm, UsernamePasswordAuthenticationToken> {
		
		@Override
		public UsernamePasswordAuthenticationToken convert(UserLoginForm form) {
			return new UsernamePasswordAuthenticationToken(form.getPrincipal(), form.getPassword());
		}
}

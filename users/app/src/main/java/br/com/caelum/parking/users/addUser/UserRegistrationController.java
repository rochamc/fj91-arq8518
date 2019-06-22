package br.com.caelum.parking.users.addUser;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService service;
	
	@PostMapping
    ResponseEntity<?> create(@Valid @RequestBody UserRegistrationForm form, UriComponentsBuilder uriBuilder) {
		
		Long userId = this.service.createUser(form);
        URI uri = uriBuilder.path("users/{userId}").build(userId);
        return created(uri).build();
    }
	
}

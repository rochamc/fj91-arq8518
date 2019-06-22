package br.com.caelum.parking.users.searchUser;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserSearchController {
	
	@Autowired
	private UserSearchService service;
	
	@GetMapping("/{id}")
	ResponseEntity<UserDTO> findById(@Valid @PathVariable Long id, UriComponentsBuilder uriBuilder) {
		
		UserDTO dto = this.service.findById(id);
		if (dto != null) {
			return ok(dto);
		}
        return notFound().build();
    }

}

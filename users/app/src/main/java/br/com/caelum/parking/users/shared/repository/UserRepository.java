package br.com.caelum.parking.users.shared.repository;

import org.springframework.data.repository.Repository;

import br.com.caelum.parking.users.addUser.UserRegistrationRepository;
import br.com.caelum.parking.users.searchUser.UserSearchRepository;
import br.com.caelum.parking.users.shared.domain.User;

public interface UserRepository extends Repository<User, Long>, UserRegistrationRepository, UserSearchRepository {

}

package carrental.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import carrental.demo.model.User;
import carrental.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}

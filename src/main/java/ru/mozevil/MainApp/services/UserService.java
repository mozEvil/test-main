package ru.mozevil.MainApp.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mozevil.MainApp.entities.User;
import ru.mozevil.MainApp.entities.dto.UserDTO;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    List<User> findAll();

    void deleteUser(Long id);

    User getById(Long id);

    User save(User user);

    User update(User user);

    List<UserDTO> findAllUserDTO();

}

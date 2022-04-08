package ru.mozevil.MainApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mozevil.MainApp.entities.User;
import ru.mozevil.MainApp.entities.dto.UserDTO;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String username);

    @Query("SELECT u FROM User u ORDER BY u.id")
    List<UserDTO> findAllUserDTO();
}

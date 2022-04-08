package ru.mozevil.MainApp.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.mozevil.MainApp.entities.Role;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class RoleRepositoryTest {
    @Autowired
    private RoleRepository underTest;

    @Test
    void findOneByName_exists() {
        //given
        String name = "ROLE_ADMIN";
        Role role = new Role(null, name);
        underTest.save(role);
        //when
        Role roleExp = underTest.findOneByName(name);
        //then
        assertThat(roleExp).isEqualTo(role);
    }

    @Test
    void findOneByName_notExists() {
        Role role = new Role(null, "ROLE_ADMIN");
        underTest.save(role);

        Role roleExp = underTest.findOneByName("ADMIN");

        assertThat(roleExp).isNull();
    }
}
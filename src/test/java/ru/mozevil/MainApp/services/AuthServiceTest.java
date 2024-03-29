package ru.mozevil.MainApp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import ru.mozevil.MainApp.configurations.jwt.TokenUtils;
import ru.mozevil.MainApp.entities.Role;
import ru.mozevil.MainApp.entities.User;
import ru.mozevil.MainApp.entities.pojo.LoginRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    @Mock private AuthenticationManager authenticationManager;
    @Mock private UserService userService;
    @Mock private TokenUtils tokenUtils;
    private AuthService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AuthService(authenticationManager, userService, tokenUtils);
    }

    @Test
    void authenticate() {
        LoginRequest loginRequest = new LoginRequest("anon", "pass");
        Collection<Role> roles = new ArrayList<>(List.of(new Role(1L, "ROLE_ADMIN")));
        User user = new User(1L, loginRequest.getUsername(), "123", null, roles);
        given(userService.findByUsername(loginRequest.getUsername())).willReturn(user);
        //when
        underTest.authenticate(loginRequest);
        //then
        verify(authenticationManager).authenticate(any());
        verify(tokenUtils).generateToken(any());
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(userService).findByUsername(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(loginRequest.getUsername());
    }
}
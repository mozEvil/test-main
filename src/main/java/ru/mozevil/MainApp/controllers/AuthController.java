package ru.mozevil.MainApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mozevil.MainApp.entities.pojo.LoginRequest;
import ru.mozevil.MainApp.entities.pojo.TokenResponse;
import ru.mozevil.MainApp.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	
	@PostMapping
//	public ResponseEntity<TokenResponse> authUser(@ModelAttribute LoginRequest loginRequest) {
	public ResponseEntity<TokenResponse> authUser(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(authService.authenticate(loginRequest));
	}

}

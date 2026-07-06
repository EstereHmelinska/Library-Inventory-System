package bootcamp.hibernate_practical.service;

import bootcamp.hibernate_practical.dto.LoginRequest;
import bootcamp.hibernate_practical.dto.LoginResponse;
import bootcamp.hibernate_practical.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager; //verifies username/password
    private final JwtService jwtService; //generates the token
    private final UserDetailsService userDetailsService; //loads the user

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public LoginResponse login (LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        UserDetails user = userDetailsService.loadUserByUsername(request.username());
        String token = jwtService.generateToken(user);
        return new LoginResponse(token);
    }
}

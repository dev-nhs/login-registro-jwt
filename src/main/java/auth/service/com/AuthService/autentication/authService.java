package auth.service.com.AuthService.autentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import auth.service.com.AuthService.jwt.jwtService;
import auth.service.com.AuthService.model.user.role;
import auth.service.com.AuthService.model.user.user;
import auth.service.com.AuthService.repository.userRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class authService {

    @Autowired
    private userRepository repo;
    @Autowired
    private jwtService jwt;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public authResponse login(loginRequest req) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        UserDetails datauser = repo.findByUsername(req.getUsername()).orElseThrow();
        String token = jwt.getToken(datauser);
        return authResponse.builder()
        .token(token)
        .build();
    }

    public authResponse register(registerRequest req) {
        user datauser = user.builder()
                .username(req.getUsername())
                .firstname(req.getFirstname())
                .lastname(req.getLastname())
                .country(req.getCountry())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(role.USER)
                .build();
        repo.save(datauser);

        return authResponse.builder()
        .token(jwt.getToken(datauser))
        .build();
    }

}

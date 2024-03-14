package auth.service.com.AuthService.autentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authController {

    @Autowired
    private authService service;
    
    @PostMapping(value = "login")
    public ResponseEntity<authResponse> login(@RequestBody loginRequest req){
        return ResponseEntity.ok(service.login(req));
    }

    @PostMapping(value = "register")
    public ResponseEntity<authResponse> register(@RequestBody registerRequest req){
        return ResponseEntity.ok(service.register(req));
    }
}

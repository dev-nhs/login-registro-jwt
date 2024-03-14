package auth.service.com.AuthService.autentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class registerRequest {
    String username;
    String firstname;
    String lastname;
    String country;
    String password;

}

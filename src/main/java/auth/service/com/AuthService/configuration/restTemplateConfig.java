package auth.service.com.AuthService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class restTemplateConfig {
    

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

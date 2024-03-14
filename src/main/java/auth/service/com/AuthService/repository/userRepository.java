package auth.service.com.AuthService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.service.com.AuthService.model.user.user;


@Repository
public interface userRepository  extends JpaRepository<user, Integer>{
    Optional<user> findByUsername(String username);
}

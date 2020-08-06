package spring.web.app01.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.web.app01.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}

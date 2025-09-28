package tr.ozanbey.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.ozanbey.user.entity.User;

import java.util.Optional;

/**
 * JPA Repository for User entity.
 * Provides CRUD operations out of the box.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

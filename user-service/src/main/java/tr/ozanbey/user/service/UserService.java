package tr.ozanbey.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.ozanbey.user.entity.User;
import tr.ozanbey.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling business logic related to Users.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    // Injects the repository
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users.
     * @return List of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by ID.
     * @param id The user ID.
     * @return Optional User.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Creates a new user.
     * @param user The user to create.
     * @return Saved user.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing user.
     * @param id The user ID.
     * @param userDetails Updated user details.
     * @return Updated user or null if not found.
     */
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    /**
     * Deletes a user by ID.
     * @param id The user ID.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

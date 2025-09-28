package tr.ozanbey.user.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.ozanbey.user.entity.User;
import tr.ozanbey.user.service.UserService;
import tr.ozanbey.common.dto.UserDto;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller exposing CRUD endpoints for users.
 * Converts between User entity and UserDto to avoid leaking internals.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Helper conversion from entity to DTO
    private UserDto toDto(User u) {
        return new UserDto(u.getId(), u.getUsername(), null, u.getEmail());
    }

    // Helper conversion from DTO to entity
    private User fromDto(UserDto dto) {
        return new User(dto.getId(), dto.getUsername(), dto.getPassword(), dto.getEmail(), null, null);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> listAll() {
        List<UserDto> users = userService.getAllUsers().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto dto) {
        // In real apps: hash dto.getPassword() before saving
        User saved = userService.createUser(fromDto(dto));
        return ResponseEntity.created(URI.create("/api/users/" + saved.getId())).body(toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(u -> ResponseEntity.ok(toDto(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<UserDto> update(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
//        return userService.update(id, fromDto(dto))
//                .map(u -> ResponseEntity.ok(toDto(u)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

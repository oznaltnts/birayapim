package tr.ozanbey.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Simple DTO used to send/receive user data between services and the gateway.
 * Uses validation annotations for basic request validation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank(message = "username is required")
    @Size(min = 3, max = 100)
    private String username;

    // Password should not be sent back in responses in real systems.
    @NotBlank(message = "password is required")
    @Size(min = 6, max = 255)
    private String password;

    @Email(message = "must be a valid email")
    private String email;
}

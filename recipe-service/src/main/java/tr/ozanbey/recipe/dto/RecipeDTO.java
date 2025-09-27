package tr.ozanbey.recipe.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {
    private Long id;

    @NotBlank(message = "Recipe name is required")
    private String name;

    private String description;

    @NotBlank(message = "Ingredients are required")
    private String ingredients;

    @NotBlank(message = "Instructions are required")
    private String instructions;

    @Min(value = 0, message = "Prep time cannot be negative")
    private Integer prepTime;

    @Min(value = 0, message = "Cook time cannot be negative")
    private Integer cookTime;

    @Min(value = 1, message = "Servings must be at least 1")
    private Integer servings;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

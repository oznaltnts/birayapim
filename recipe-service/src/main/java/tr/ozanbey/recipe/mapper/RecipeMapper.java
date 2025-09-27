package tr.ozanbey.recipe.mapper;

import org.springframework.stereotype.Component;
import tr.ozanbey.recipe.dto.RecipeDTO;
import tr.ozanbey.recipe.entity.Recipe;

@Component
public class RecipeMapper {

    public RecipeDTO toDTO(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        return RecipeDTO.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients())
                .instructions(recipe.getInstructions())
                .prepTime(recipe.getPrepTime())
                .cookTime(recipe.getCookTime())
                .servings(recipe.getServings())
                .createdAt(recipe.getCreatedAt())
                .updatedAt(recipe.getUpdatedAt())
                .build();
    }

    public Recipe toEntity(RecipeDTO recipeDTO) {
        if (recipeDTO == null) {
            return null;
        }

        return Recipe.builder()
                .id(recipeDTO.getId())
                .name(recipeDTO.getName())
                .description(recipeDTO.getDescription())
                .ingredients(recipeDTO.getIngredients())
                .instructions(recipeDTO.getInstructions())
                .prepTime(recipeDTO.getPrepTime())
                .cookTime(recipeDTO.getCookTime())
                .servings(recipeDTO.getServings())
                .build();
    }
}

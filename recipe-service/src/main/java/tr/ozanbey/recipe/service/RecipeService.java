package tr.ozanbey.recipe.service;

import tr.ozanbey.recipe.dto.RecipeDTO;
import java.util.List;

public interface RecipeService {
    List<RecipeDTO> getAllRecipes();
    RecipeDTO getRecipeById(Long id);
    RecipeDTO createRecipe(RecipeDTO recipeDTO);
    RecipeDTO updateRecipe(Long id, RecipeDTO recipeDTO);
    void deleteRecipe(Long id);
    List<RecipeDTO> searchRecipesByName(String name);
}

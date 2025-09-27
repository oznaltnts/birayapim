package tr.ozanbey.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.ozanbey.recipe.dto.RecipeDTO;
import tr.ozanbey.recipe.entity.Recipe;
import tr.ozanbey.recipe.exception.RecipeNotFoundException;
import tr.ozanbey.recipe.mapper.RecipeMapper;
import tr.ozanbey.recipe.repository.RecipeRepository;
import tr.ozanbey.recipe.service.RecipeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<RecipeDTO> getAllRecipes() {
        log.info("Fetching all recipes");
        return recipeRepository.findAll().stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeDTO getRecipeById(Long id) {
        log.info("Fetching recipe with id: {}", id);
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
        return recipeMapper.toDTO(recipe);
    }

    @Override
    public RecipeDTO createRecipe(RecipeDTO recipeDTO) {
        log.info("Creating new recipe: {}", recipeDTO.getName());
        Recipe recipe = recipeMapper.toEntity(recipeDTO);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toDTO(savedRecipe);
    }

    @Override
    public RecipeDTO updateRecipe(Long id, RecipeDTO recipeDTO) {
        log.info("Updating recipe with id: {}", id);
        Recipe existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));

        existingRecipe.setName(recipeDTO.getName());
        existingRecipe.setDescription(recipeDTO.getDescription());
        existingRecipe.setIngredients(recipeDTO.getIngredients());
        existingRecipe.setInstructions(recipeDTO.getInstructions());
        existingRecipe.setPrepTime(recipeDTO.getPrepTime());
        existingRecipe.setCookTime(recipeDTO.getCookTime());
        existingRecipe.setServings(recipeDTO.getServings());

        Recipe updatedRecipe = recipeRepository.save(existingRecipe);
        return recipeMapper.toDTO(updatedRecipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        log.info("Deleting recipe with id: {}", id);
        if (!recipeRepository.existsById(id)) {
            throw new RecipeNotFoundException("Recipe not found with id: " + id);
        }
        recipeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeDTO> searchRecipesByName(String name) {
        log.info("Searching recipes by name: {}", name);
        return recipeRepository.findByNameContainingIgnoreCase(name).stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }
}

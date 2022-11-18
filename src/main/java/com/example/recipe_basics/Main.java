package com.example.recipe_basics;

import com.example.recipe_basics.dao.RecipeJpaDao;
import com.example.recipe_basics.models.Ingredient;
import com.example.recipe_basics.models.Recipe;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");



        Recipe recipe = new Recipe(
                "tarte aux pommes",
                "Eplucher les pommes. Etaler la pâte."
        );

        System.out.println(recipe.toString());



        RecipeJpaDao recipeCrudDAO = new RecipeJpaDao();
        recipe.setIngredients_recipe_list(Arrays.asList(new Ingredient("pomme", 2)));

        System.out.println(recipe);

        Recipe createdRecipe = recipeCrudDAO.create(recipe);

        recipeCrudDAO.findAll();
    }
}

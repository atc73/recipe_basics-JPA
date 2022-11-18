package com.example.recipe_basics.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Recipe;

    private String recipe_name;
    private String recipe_description;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "recipe")
    private List<Ingredient> ingredients_recipe_list = new ArrayList<>();

    public Recipe() {

    }

    @Override
    public String toString() {
        return "Recipe{" +
                "Id_Recipe=" + Id_Recipe +
                ", recipe_name='" + recipe_name + '\'' +
                ", recipe_description='" + recipe_description + '\'' +
                ", ingredients_recipe_list=" + ingredients_recipe_list +
                '}';
    }

    public Recipe(String recipe_name, String recipe_description) {
        this.recipe_name = recipe_name;
        this.recipe_description = recipe_description;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getRecipe_description() {
        return recipe_description;
    }

    public void setRecipe_description(String recipe_description) {
        this.recipe_description = recipe_description;
    }

    public List<Ingredient> getIngredients_recipe_list() {
        return ingredients_recipe_list;
    }

    public void setIngredients_recipe_list(List<Ingredient> ingredients_recipe_list) {
        this.ingredients_recipe_list = ingredients_recipe_list;
    }
}

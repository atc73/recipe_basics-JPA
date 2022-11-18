package com.example.recipe_basics.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Ingredient;
    private String ingredient_name;
    private Integer ingredient_quantity;
    @ManyToOne
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient() {

    }

    public Ingredient(String ingredient_name, Integer ingredient_quantity) {
        this.ingredient_name = ingredient_name;
        this.ingredient_quantity = ingredient_quantity;
    }

    public Long getId_Ingredient() {
        return Id_Ingredient;
    }

    public void setId_Ingredient(Long id_Ingredient) {
        Id_Ingredient = id_Ingredient;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public Integer getIngredient_quantity() {
        return ingredient_quantity;
    }

    public void setIngredient_quantity(Integer ingredient_quantity) {
        this.ingredient_quantity = ingredient_quantity;
    }
}

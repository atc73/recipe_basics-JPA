package com.example.recipe_basics.dao;

import com.example.recipe_basics.models.Recipe;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<E> {
    List<E> findAll();
    Optional<E> findById(Long id);

    boolean delete(Long id);

    E create(E element);
}

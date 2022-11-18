package com.example.recipe_basics.dao;

import com.example.recipe_basics.connection.EntityManagerConnection;
import com.example.recipe_basics.models.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeJpaDao implements CrudDAO<Recipe> {

    EntityManagerFactory emf = EntityManagerConnection.getEntityManager();

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipeList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Recipe> query = em.createQuery("SELECT b FROM Recipe b", Recipe.class);
            recipeList = query.getResultList();
            recipeList.forEach(e -> System.out.println(e));
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return recipeList;
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Recipe recipe = em.createQuery("SELECT b FROM b WHERE b.id = :idParam", Recipe.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
            et.commit();
            return Optional.of(recipe);
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Recipe recipe = em.find(Recipe.class, id);
            em.remove(recipe);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return true;
    }


    @Override
    public Recipe create(Recipe element) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(element);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return element;
    }
}

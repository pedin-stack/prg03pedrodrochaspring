/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class GenericDao<T extends PersistenceEntity> implements GenericIDao<T> {

    @PersistenceContext
    public EntityManager em;

    @Override
    public T save(T entity) {
        em.persist(entity);
        
        return entity;
    }

    @Override
    public T update(T entity) {
        em.merge(entity);
        
        return entity;
    }

    @Override
    public T delete(T entity) {
        T managed = em.contains(entity) ? entity : em.merge(entity);
        em.remove(managed);
        
        return entity;
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("FROM " + getTypeClass().getName(), (Class<T>) getTypeClass())
                            .getResultList();
    }

    @Override
    public T findById(Long id) {
        return em.find((Class<T>) getTypeClass(), id);
    }

    private Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}

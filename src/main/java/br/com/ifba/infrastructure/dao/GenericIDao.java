/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;


public interface GenericIDao<T extends PersistenceEntity> {
    
    // metodos basicos 
     T save(T entity);
     T update(T entity);
     T delete(T entity);
     List<T> findAll();
     T findById(Long id);
}
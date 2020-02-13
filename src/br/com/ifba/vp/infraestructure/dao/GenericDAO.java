/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.infraestructure.dao;

import br.com.ifba.vp.infraestructure.model.AbstractEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author amand
 * @param <Entity>
 */
//  Faz crud no banco
public class GenericDAO <Entity extends AbstractEntity>  implements IGenericDAO<Entity>{
    protected static EntityManager entityManager;
    
    static{
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projeto");
        entityManager = factory.createEntityManager();
    }
    @Override
    public Entity save(Entity entity){
       entityManager.getTransaction().begin();
       entityManager.persist(entity);
       entityManager.getTransaction().commit();
       return entity;
        
    }
    @Override
    public Entity update(Entity entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;

    }
    @Override
    public void delete(Entity obj) {
        obj = findById(obj.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit(); 
    }
    @Override
    public List<Entity> findAll(){
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }
    @Override
    public Entity findById(Long id){
        return (Entity) entityManager.find(getTypeClass(), id);
    }
    //Retorna o tipo da classe
    protected Class<?> getTypeClass(){
        
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        
        return clazz;
    }

}

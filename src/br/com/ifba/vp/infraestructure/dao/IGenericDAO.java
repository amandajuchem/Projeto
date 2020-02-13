/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.infraestructure.dao;

import br.com.ifba.vp.infraestructure.model.AbstractEntity;
import java.util.List;

/**
 *
 * @author amand
 */
public interface IGenericDAO <Entity extends AbstractEntity>{
    //Salva objetos entidades no banco
    Entity save(Entity obj);
    //Atualiza objetos entidades no banco
    Entity update(Entity obj);
    //Deleta um objeto entidade
    void delete(Entity obj);
    //Procura todos os objetos entidades no banco
    List<Entity> findAll();
    //Procura objetos entidades por id
    Entity findById(Long id);
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.cliente.dao;


import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.infraestructure.dao.GenericDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author Icaro
 */
public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO{

    @Override
    public Cliente findByCPF(String cpf) {
        String sql = "FROM Cliente WHERE cpf = '" + cpf + "'";
        
        try {
            return (Cliente) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }

    
    
    
}

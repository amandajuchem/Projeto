/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.funcionario.dao;

import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.infraestructure.dao.GenericDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author amand
 */
public class FuncionarioDAO extends GenericDAO<Funcionario> implements IFuncionarioDAO {

    @Override
    public int login(Funcionario funcionario) {
        String sql = "FROM Funcionario WHERE cpf = '" + funcionario.getCpf() + "' AND senha = '" + funcionario.getSenha() + "'";
        
        try {
            return  entityManager.createQuery(sql).getSingleResult() != null ? 2 : 0;
        } catch (NoResultException ex) {}
        
        return 0;
    }

    @Override
    public Funcionario findByCPF(String cpf) {
        String sql = "FROM Funcionario WHERE cpf = '" + cpf + "'";
        
        try {
            return (Funcionario) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
         
        return null;
    }
    
    
    
}

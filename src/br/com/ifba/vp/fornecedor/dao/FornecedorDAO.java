/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.fornecedor.dao;
import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.infraestructure.dao.GenericDAO;
import javax.persistence.NoResultException;
/**
 *
 * @author Icaro
 */
public class FornecedorDAO extends GenericDAO<Fornecedor> implements IFornecedorDAO{

    @Override
    public Fornecedor findByCNPJ(long cnpj) {
        String sql = "FROM Fornecedor WHERE cnpj = '" + Long.toString(cnpj) + "'";
        
        try {
            return (Fornecedor) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }
    
  
    
}

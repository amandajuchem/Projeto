/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.produto.dao;

import br.com.ifba.vp.produto.model.Produto;
import br.com.ifba.vp.infraestructure.dao.GenericDAO;
import java.util.List;
import javax.persistence.NoResultException;


public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO{

    @Override
    public Produto findByCodigoBarras(int codigo) {
        String sql = "FROM Produto WHERE codigoBarras = '" + Integer.toString(codigo)  + "'";
        
        try {
            return (Produto) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }

    @Override
    public List<Produto> findByName(String name) {
        String sql = "FROM Produto WHERE nome LIKE '%" + name + "%'";
        
        try {
            return entityManager.createQuery(sql).getResultList();
        } catch (NoResultException ex) {}
        
        return null;
    }
    
    
}

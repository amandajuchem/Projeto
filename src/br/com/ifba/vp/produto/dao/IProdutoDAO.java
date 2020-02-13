/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.produto.dao;

import br.com.ifba.vp.infraestructure.dao.IGenericDAO;
import br.com.ifba.vp.produto.model.Produto;
import java.util.List;

/**
 *
 * @author amand
 */
public interface IProdutoDAO extends IGenericDAO<Produto>{
    //Metodo que busca um produto por codigo de barras
     public abstract Produto findByCodigoBarras (int codigo);
    //Metodo que busca um produto por nome 
     public abstract List<Produto> findByName (String name);
     
}

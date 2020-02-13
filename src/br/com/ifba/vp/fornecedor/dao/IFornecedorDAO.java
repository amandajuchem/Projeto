/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.fornecedor.dao;

import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.infraestructure.dao.IGenericDAO;

/**
 *
 * @author amand
 */
public interface IFornecedorDAO extends IGenericDAO<Fornecedor>{
    ////Metodo que busca um fornecedor no banco pelo CNPJ
    public abstract Fornecedor findByCNPJ (long cnpj);

}

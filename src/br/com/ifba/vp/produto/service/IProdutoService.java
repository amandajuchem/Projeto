/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.produto.service;

import br.com.ifba.vp.produto.model.Produto;
import java.util.List;

/**
 *
 * @author amand
 */
public interface IProdutoService {
    //Metodo que salva um produto no banco
    public abstract Produto save (Produto produto);
    //Metodo que atualiza um produto no banco
    public abstract Produto update (Produto produto);
    //Metodo que deleta um produto no banco 
    public abstract void delete (Produto produto);
    //Metodo que busca um produto por id
    public abstract Produto findById (long id);
    //Metodo que busca um produto por codigo de barras
    public abstract Produto findByCodigoBarras (int codigo);
    //Metodo que busca um produto por nome
    public abstract List<Produto> findByName (String name);
    //Metodo que lista uma lista de produtos
    public abstract List<Produto> findAll ();
}

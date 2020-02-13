/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.fornecedor.service;

import br.com.ifba.vp.fornecedor.model.Fornecedor;
import java.util.List;

/**
 *
 * @author amand
 */
public interface IFornecedorService {
    //Metodo que salva um fornecedor no banco
    public abstract Fornecedor save (Fornecedor fornecedor);
    //Metodo que atualiza um fornecedor no banco
    public abstract Fornecedor update (Fornecedor fornecedor);
    //Metodo que deleta um fornecedor no banco
    public abstract void delete (Fornecedor fornecedor);
    //Metodo que busca um fornecedor no banco por id
    public abstract Fornecedor findById (long id);
    //Metodo que busca um fornecedor no banco por CNPJ
    public abstract Fornecedor findByCNPJ (long cnpj);
    //Metodo que busca uma lista de fornecedores no banco
    public abstract List<Fornecedor> findAll ();
}

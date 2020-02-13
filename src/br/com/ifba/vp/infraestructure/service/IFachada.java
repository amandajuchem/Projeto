/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.infraestructure.service;

import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.produto.model.Produto;
import java.util.List;

/**
 *
 * @author amand
 */
public interface IFachada {
    
    /* ------------------------------ CLIENTE ---------------------------- */
    //Metodo que salva um cliente no banco
    public abstract Cliente saveCliente (Cliente cliente);
    //Metodo que atualiza um cliente no banco
    public abstract Cliente updateCliente (Cliente cliente);
    //Metodo que deleta um cliente do banco
    public abstract void deleteCliente (Cliente cliente);
    //Metodo que encontra um cliente pelo id 
    public abstract Cliente findByIdCliente (long id);
    //Metodo que encontra um cliente pelo cpf 
    public abstract Cliente findByCPFCliente (String cpf);
    //Metodo que encontra uma lista de clientes 
    public abstract List<Cliente> findAllCliente ();
    
    /* ------------------------------ FORNECEDOR ---------------------------- */
    //Metodo que salva um fornecedor no banco
    public abstract Fornecedor saveFornecedor (Fornecedor fornecedor);
    //Metodo que atualiza um fornecedor no banco
    public abstract Fornecedor updateFornecedor (Fornecedor fornecedor);
    //Metodo que deleta um fornecedor no banco
    public abstract void deleteFornecedor (Fornecedor fornecedor);
    //Metodo que busca um fornecedor no banco por id
    public abstract Fornecedor findByIdFornecedor (long id);
    //Metodo que busca um fornecedor no banco por cnpj
    public abstract Fornecedor findByCNPJFornecedor (long cnpj);
    //Metodo que busca uma lista de fornecedores no banco 
    public abstract List<Fornecedor> findAllFornecedor ();
    
    /* ------------------------------ FUNCIONARIO ---------------------------- */
    //Metodo que faz login
    public abstract int loginFuncionario (Funcionario funcionario);
    //Metodo que salva um funcionario no banco
    public abstract Funcionario saveFuncionario (Funcionario funcionario);
    //Metodo que atualiza um funcionario no banco
    public abstract Funcionario updateFuncionario (Funcionario funcionario);
    //Metodo que deleta um funcionario no banco
    public abstract void deleteFuncionario (Funcionario funcionario);
    //Metodo que busca funcionario por id
    public abstract Funcionario findByIdFuncionario (long id);
    //Metodo que busca funcionario por cpf
    public abstract Funcionario findByCPFFuncionario (String cpf);
    //Metodo que busca uma lista de funcionarios
    public abstract List<Funcionario> findAllFuncionario ();
    
    /* ------------------------------ PRODUTO ---------------------------- */
    //Metodo que salva um produto no banco
    public abstract Produto saveProduto (Produto produto);
    //Metodo que atualiza um produto no banco
    public abstract Produto updateProduto (Produto produto);
    //Metodo que deleta um produto no banco 
    public abstract void deleteProduto (Produto produto);
    //Metodo que busca um produto por id
    public abstract Produto findByIdProduto (long id);
    //Metodo que busca um produto por codigo de barras
    public abstract Produto findByCodigoBarras (int codigo);
    //Metodo que busca um produto por nome
    public abstract List<Produto> findByName (String name);
    //Metodo que lista uma lista de produtos
    public abstract List<Produto> findAllProduto ();
    
}

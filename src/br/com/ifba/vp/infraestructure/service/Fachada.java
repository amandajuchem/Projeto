/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.infraestructure.service;

import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.cliente.service.ClienteService;
import br.com.ifba.vp.cliente.service.IClienteService;
import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.fornecedor.service.FornecedorService;
import br.com.ifba.vp.fornecedor.service.IFornecedorService;
import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.funcionario.service.FuncionarioService;
import br.com.ifba.vp.funcionario.service.IFuncionarioService;
import br.com.ifba.vp.produto.model.Produto;
import br.com.ifba.vp.produto.service.IProdutoService;
import br.com.ifba.vp.produto.service.ProdutoService;
import java.util.List;

/**
 *
 * @author amand
 */
public class Fachada implements IFachada{
    private volatile static Fachada instance; 
    
    /* Padrão Singleton */
    
    public static Fachada getInstance() {
        if (instance == null) {
            synchronized (Fachada.class) {
                if (instance == null) {
                    instance = new Fachada();
                }
            }
        }
        
        return instance;
    }
    /* ------------------------------ CLIENTE ---------------------------- */
    private final IClienteService clienteService = new ClienteService();

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteService.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteService.update(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteService.delete(cliente);
    }

    @Override
    public Cliente findByIdCliente(long id) {
        return clienteService.findById(id);
    }

    @Override
    public Cliente findByCPFCliente(String cpf) {
        return clienteService.findByCPF(cpf);
    }

    @Override
    public List<Cliente> findAllCliente() {
        return clienteService.findAll();
    }
    
    /* ------------------------------ FORNECEDOR ---------------------------- */
    
    private final IFornecedorService fornecedorService = new FornecedorService();
    
    @Override
    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @Override
    public Fornecedor updateFornecedor(Fornecedor fornecedor) {
        return fornecedorService.update(fornecedor);
    }

    @Override
    public void deleteFornecedor(Fornecedor fornecedor) {
        fornecedorService.delete(fornecedor);
    }

    @Override
    public Fornecedor findByIdFornecedor(long id) {
        return fornecedorService.findById(id);
    }

    @Override
    public Fornecedor findByCNPJFornecedor(long cnpj) {
        return fornecedorService.findByCNPJ(cnpj);
    }

    @Override
    public List<Fornecedor> findAllFornecedor() {
        return fornecedorService.findAll();
    }
    
    /* ------------------------------ FUNCIONARIO ---------------------------- */
    
    private final IFuncionarioService funcionarioService = new FuncionarioService();
    
    @Override
    public int loginFuncionario(Funcionario funcionario) {
        return funcionarioService.login(funcionario);
    }

    @Override
    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @Override
    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcionarioService.update(funcionario);
    }

    @Override
    public void deleteFuncionario(Funcionario funcionario) {
        funcionarioService.delete(funcionario);
    }

    @Override
    public Funcionario findByIdFuncionario(long id) {
        return funcionarioService.findById(id);
    }

    @Override
    public Funcionario findByCPFFuncionario(String cpf) {
        return funcionarioService.findByCPF(cpf);
    }

    @Override
    public List<Funcionario> findAllFuncionario() {
        return funcionarioService.findAll();
    }
    
    /* ------------------------------ PRODUTO ---------------------------- */
    
    private final IProdutoService produtoService = new ProdutoService();
    
    @Override
    public Produto saveProduto(Produto produto) {
        return produtoService.save(produto);
    }

    @Override
    public Produto updateProduto(Produto produto) {
        return produtoService.update(produto);
    }

    @Override
    public void deleteProduto(Produto produto) {
        produtoService.delete(produto);
    }

    @Override
    public Produto findByIdProduto(long id) {
        return produtoService.findById(id);
    }

    @Override
    public Produto findByCodigoBarras(int codigo) {
        return produtoService.findByCodigoBarras(codigo);
    }

    @Override
    public List<Produto> findByName(String name) {
        return produtoService.findByName(name);
    }

    @Override
    public List<Produto> findAllProduto() {
        return produtoService.findAll();
    }
    
    
    
    
    
}

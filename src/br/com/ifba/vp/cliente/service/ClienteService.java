/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.cliente.service;

import br.com.ifba.vp.infraestructure.exception.BusinessException;
import br.com.ifba.vp.infraestructure.suport.StringUtil;
import br.com.ifba.vp.cliente.dao.ClienteDAO;
import br.com.ifba.vp.cliente.dao.IClienteDAO;
import br.com.ifba.vp.cliente.model.Cliente;
import java.util.List;

/**
 *
 * @author amand
 */
public class ClienteService implements IClienteService{
    public final static String CLIENTE_NULL = "O cliente é nulo!";
    public final static String CLIENTE = "O cliente já existe!";
    public final static String CLIENTE_NAO_EXISTE = "O cliente não existe!";
    public final static String CLIENTE_INVALIDO = "Cliente inválido!";
    
    private final IClienteDAO clienteDAO = new ClienteDAO();
    
    private boolean validarCliente (Cliente cliente) {
        
        StringUtil util = new StringUtil();
        
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            return false;
        }
        
        /* Verifica se o nome do cliente é nulo ou vazio */
        
        if (util.isNullOrEmpty(cliente.getNome())){
            return false;
        }
        
        /* Verifica se o sexo do cliente é nulo ou vazio */
        
        if (util.isNullOrEmpty(cliente.getSexo())) {
            return false;
        }
        
        /* Verifica se o CPF do cliente foi digitado */
        
        if (cliente.getCpf()!=0) {
            return false;
        }
         /*Informações de cliente estão corretas */
        return true;
    }

    @Override
    public Cliente save(Cliente cliente) {
        
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            return null;
            //throw new BusinessException (CLIENTE_NULL);
        }
        
        /* Verifica se já existe um cliente no banco de dados com o mesmo CPF */
        
        else if (cliente.getCpf()!=0) {
            return null;
            //throw new BusinessException (CLIENTE);
        }
        
        /* Verifica se os dados do cliente são válidos */
        
        else if (!validarCliente(cliente)) {
            return null;
            //throw new BusinessException (CLIENTE_INVALIDO);
        }
        
        
        else {
        /* Salva o cliente no banco de dados */
            return clienteDAO.save(cliente);
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            return null;
            //throw new BusinessException (CLIENTE_NULL);
        }
        
        /* Verifica se o cliente existe no banco de dados */
        
        else if (findById(cliente.getId()) == null) {
            return null;
            //throw new BusinessException (CLIENTE_NAO_EXISTE);
        }
        
        /* Verifica se os dados do cliente são validos */
        
        else if (!validarCliente(cliente)){
            return null;
            //throw new BusinessException (CLIENTE_INVALIDO);
        }
        
        
        else {
        /* Atualiza os dados do cliente no banco de dados */
            return clienteDAO.update(cliente);
        }
    }

    @Override
    public void delete(Cliente cliente) {
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            throw new BusinessException (CLIENTE_NULL);
        }
        
        /* Verifica se o cliente existe no banco de dados */
        
        else if (clienteDAO.findById(cliente.getId()) == null) {
            throw new BusinessException (CLIENTE_NAO_EXISTE);
        }
        
        else {
        /* Exclui os dados do cliente do banco de dados */
        
            clienteDAO.delete(cliente);
        }
    }

    @Override
    public Cliente findById(long id) {
        return clienteDAO.findById(id);
    }

    @Override
    public Cliente findByCPF(long cpf) {
        return clienteDAO.findByCPF(cpf);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }
    
    
}

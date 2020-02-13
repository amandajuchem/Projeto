/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.fornecedor.service;

import br.com.ifba.vp.fornecedor.dao.FornecedorDAO;
import br.com.ifba.vp.fornecedor.dao.IFornecedorDAO;
import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.infraestructure.exception.BusinessException;
import br.com.ifba.vp.infraestructure.suport.StringUtil;
import java.util.List;

/**
 *
 * @author amand
 */
public class FornecedorService implements IFornecedorService{
    public final static String FORNECEDOR_NULL = "O fornecedor é nulo!";
    public final static String FORNECEDOR = "O fornecedor já existe!";
    public final static String FORNECEDOR_NAO_EXISTE = "O fornecedor não existe!";
    public final static String FORNECEDOR_INVALIDO = "Fornecedor inválido!";
    
    private final IFornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    private boolean validarFornecedor (Fornecedor fornecedor) {
        
        StringUtil util = new StringUtil();
        
        /* Verifica se o objeto é nulo */
        
        if (fornecedor == null) {
            return false;
        }
        
        /* Verifica se a razão social do fornecedor é nula ou vazia */
        
        if (util.isNullOrEmpty(fornecedor.getRazaoSocial())) {
            return false;
        }
        
        /* Verifica se o CNPJ do fornecedor foi digitado */
        
        if (fornecedor.getCnpj()!=0) {
            return false;
        }
        /*Informações de fornecedor estão corretas */
        return true;
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        /* Verifica se o objeto é nulo */
        
        if (fornecedor == null) {
            return null;
            //throw new BusinessException (FORNECEDOR_NULL);
        }
        
        /* Verifica se já existe um fornecedor no banco de dados com o mesmo CNPJ */
        
        else if (findByCNPJ(fornecedor.getCnpj()) != null) {
            return null;
            //throw new BusinessException (FORNECEDOR_EXISTE);
        }
        
        /* Verifica se os dados do fornecedor são válidos */
        
        else if (!validarFornecedor(fornecedor)) {
            return null;
            //throw new BusinessException (FORNECEDOR_INVALIDO);
        }
        
        else {
        /* Salva o fornecedor no banco de dados */
            return fornecedorDAO.save(fornecedor);
        }
    }

    @Override
    public Fornecedor update(Fornecedor fornecedor) {
        if (fornecedor == null) {
            return null;
            //throw new BusinessException (FORNECEDOR_NULL);
        }
        
        /* Verifica se o fornecedor existe no banco de dados */
        
        else if (findById(fornecedor.getId()) == null) {
            return null;
            //throw new BusinessException (FORNECEDOR_NAO_EXISTE);
        }
        
        /* Verifica se os dados do fornecedor são validos */
        
        else if (!validarFornecedor(fornecedor)) {
            return null;
            //throw new BusinessException (FORNECEDOR_INVALIDO);
        }
        
        
        else {
        /* Atualiza os dados do fornecedor no banco de dados */
            return fornecedorDAO.update(fornecedor);
        }
    }

    @Override
    public void delete(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new BusinessException (FORNECEDOR_NULL);
        }
        
        /* Verifica se o fornecedor existe no banco de dados */
        
        else if (fornecedorDAO.findById(fornecedor.getId()) == null) {
            throw new BusinessException (FORNECEDOR_NAO_EXISTE);
        }
        
        
        else {
        /* Exclui os dados do fornecedor do banco de dados */
            fornecedorDAO.delete(fornecedor);
        }
    }

    @Override
    public Fornecedor findById(long id) {
        return fornecedorDAO.findById(id);
    }

    @Override
    public Fornecedor findByCNPJ(long cnpj) {
        return fornecedorDAO.findByCNPJ(cnpj);
    }

    @Override
    public List<Fornecedor> findAll() {
        return fornecedorDAO.findAll();
    }
    
}

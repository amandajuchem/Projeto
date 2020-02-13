/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.produto.service;

import br.com.ifba.vp.infraestructure.exception.BusinessException;
import br.com.ifba.vp.infraestructure.suport.StringUtil;
import br.com.ifba.vp.produto.dao.IProdutoDAO;
import br.com.ifba.vp.produto.dao.ProdutoDAO;
import br.com.ifba.vp.produto.model.Produto;
import java.util.List;

/**
 *
 * @author amand
 */
public class ProdutoService implements IProdutoService {
    public final static String PRODUTO_NULL = "O produto é nulo!";
    public final static String PRODUTO = "O produto já existe!";
    public final static String PRODUTO_NAO_EXISTE = "O produto não existe!";
    public final static String PRODUTO_INVALIDO = "Produto inválido!";
    
    private final IProdutoDAO produtoDAO = new ProdutoDAO();
    
    private boolean validarProduto (Produto produto) {
        
        StringUtil util = new StringUtil();
        
        /* Verifica se o objeto é nulo */
        
        if (produto == null) {
            return false;
        }
        
        /* Verifica se o nome do produto é nulo ou vazio */
        
        if (util.isNullOrEmpty(produto.getNomeProduto())){
            return false;
        }
        
        /* Verifica se o código de barras do produto é nulo ou vazio */
        
        if (Integer.toString(produto.getCodigoBarras()).equals("")
                || Integer.toString(produto.getCodigoBarras()).equals("0")) {
            return false;
        }
        
        /* Verifica se o preço do produto é inferior ou igual a zero */
        
        if (produto.getPreco() <= 0) {
            return false;
        }
        
        /* Verifica se o estoque do produto é inferior a um */
        
        if (produto.getQuantidade() <= 1) {
            return false;
        }
        //As informações estão corretas
        return true;
    }

    @Override
    public Produto save(Produto produto) {
        if (produto == null) {
            return null;
            //throw new BusinessException (PRODUTO_NULL);
        }
        
        /* Verifica se já existe um produto no banco de dados com o mesmo código de barras */
        
        else if (findByCodigoBarras(produto.getCodigoBarras()) != null) {
            return null;
            //throw new BusinessException (PRODUTO);
        }
        
        /* Verifica se os dados do produto são válidos */
        
        else if (!validarProduto(produto)) {
            return null;
            //throw new BusinessException (PRODUTO_INVALIDO);
        }
        
        
        else {
        /* Salva o produto no banco de dados */
            return produtoDAO.save(produto);
        }
    }

    @Override
    public Produto update(Produto produto) {
         if (produto == null) {
            return null;
            //throw new BusinessException (PRODUTO_NULL);
        }
        
        /* Verifica se o produto existe no banco de dados */
        
        else if (findById(produto.getId()) == null) {
            return null;
            //throw new BusinessException (PRODUTO_NAO_EXISTE);
        }
        
        /* Verifica se os dados do produto são validos */
        
        else if (!validarProduto(produto)) {
            return null;
            //throw new BusinessException (PRODUTO_INVALIDO);
        }
        
        
        else {
        /* Atualiza os dados do produto no banco de dados */
            return produtoDAO.update(produto);
        }
    }

    @Override
    public void delete(Produto produto) {
        if (produto == null) {
            throw new BusinessException (PRODUTO_NULL);
        }
        
        /* Verifica se o produto existe no banco de dados */
        
        else if (findById(produto.getId()) == null) {
            throw new BusinessException (PRODUTO_NAO_EXISTE);
        }
        
        
        else {
        /* Exclui os dados do produto do banco de dados */
            produtoDAO.delete(produto);
        }
    }
    @Override
    public Produto findById(long id) {
        return produtoDAO.findById(id);
    }

    @Override
    public Produto findByCodigoBarras(int codigo) {
        return produtoDAO.findByCodigoBarras(codigo);
    }

    @Override
    public List<Produto> findByName(String name) {
        return produtoDAO.findByName(name);
    }

    @Override
    public List<Produto> findAll() {
        return produtoDAO.findAll();
    }

    
}

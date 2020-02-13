/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.funcionario.service;

import br.com.ifba.vp.funcionario.dao.FuncionarioDAO;
import br.com.ifba.vp.funcionario.dao.IFuncionarioDAO;
import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.infraestructure.exception.BusinessException;
import br.com.ifba.vp.infraestructure.suport.StringUtil;
import java.util.List;

/**
 *
 * @author amand
 */
public class FuncionarioService implements IFuncionarioService {
    public final static String FUNCIONARIO_NULL = "O funcionário é nulo!";
    public final static String FUNCIONARIO = "O funcionário já existe!";
    public final static String FUNCIONARIO_NAO_EXISTE = "O funcionário não existe!";
    public final static String FUNCIONARIO_INVALIDO = "Funcionário inválido!";
    
    private final IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    
    
    public boolean validarFuncionario (Funcionario funcionario) {
        
        StringUtil util = StringUtil.getInstance();
        
        /* Verifica se o objeto é nulo */
        
        if (funcionario == null) {
            return false;
        }
        
        /* Verifica se o nome do funcionário é nulo ou vazio */
        
        if (util.isNullOrEmpty(funcionario.getNome())){
            return false;
        }
        
        /* Verifica se o sexo do funcionário é nulo ou vazio */
        
        if (util.isNullOrEmpty(funcionario.getSexo())){
            return false;
        }
        
        /* Verifica se o CPF do funcionário foi digitado */
        
        if (util.isNullOrEmpty(funcionario.getCpf())) {
            return false;
        }
        
        /* Verifica se a senha do funcionário é nula ou vazia */
        
        if (funcionario.getSenha()!=0){
            return false;
        }
        /* As informações de funcionario estão corretas */ 
        return true;
    }
    
    @Override
    public int login(Funcionario funcionario) {
        if (funcionario == null) {
            return 0;
        }
        
        /* Verifica se os dados informados são do funcionário gerente */
        
        else if(funcionario.getCpf().equals("12345678910") && (Integer.toString(funcionario.getSenha()).equals("1234"))){
            return 1;
        }
        
        /* Verifica no banco de dados se os dados informados pertencem a um funcionário cadastrado */
        
        else {
            return 2;
        }
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        if (funcionario == null) {
            return null;
            //throw new BusinessException (FUNCIONARIO_NULL);
        }
        
        /* Verifica se já existe um funcionário no banco de dados com o mesmo CPF */
        
        else if (findByCPF(funcionario.getCpf()) != null) {
            return null;            
            //throw new BusinessException (FUNCIONARIO_EXISTE);
        }
        
        /* Verifica se os dados do funcionário são válidos */
        
        else if (!validarFuncionario(funcionario)) {
            return null;
            //throw new BusinessException (FUNCIONARIO_INVALIDO);
        }
        
        
        else {
        /* Salva o funcionário no banco de dados */
            return funcionarioDAO.save(funcionario);
        }
    }

    @Override
    public Funcionario update(Funcionario funcionario) {
        if (funcionario == null) {
            return null;
            //throw new BusinessException (FUNCIONARIO_NULL);
        }
        
        /* Verifica se o funcionário existe no banco de dados */
        
        else if (findById(funcionario.getId()) == null) {
            return null;
            //throw new BusinessException (FUNCIONARIO_NAO_EXISTE);
        }
        
        /* Verifica se os dados do funcionário são validos */
        
        else if (!validarFuncionario(funcionario)) {
            return null;
            //throw new BusinessException (FUNCIONARIO_INVALIDO);
        }
        
        
        else {
        /* Atualiza os dados do funcionário no banco de dados */
            return funcionarioDAO.update(funcionario);
        }
    }

    @Override
    public void delete(Funcionario funcionario) {
         if (funcionario == null) {
            throw new BusinessException (FUNCIONARIO_NULL);
        }
        
        /* Verifica se o funcionário existe no banco de dados */
        
        else if (funcionarioDAO.findById(funcionario.getId()) == null) {
            throw new BusinessException (FUNCIONARIO_NAO_EXISTE);
        }
        
        
        else {
        /* Exclui os dados do funcionário do banco de dados */
            funcionarioDAO.delete(funcionario);
        }
    }

    @Override
    public Funcionario findById(long id) {
         return funcionarioDAO.findById(id);
    }

    @Override
    public Funcionario findByCPF(String cpf) {
        return funcionarioDAO.findByCPF(cpf);
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioDAO.findAll();
    }

    
}

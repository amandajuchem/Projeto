/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.funcionario.dao;

import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.infraestructure.dao.IGenericDAO;

/**
 *
 * @author amand
 */
public interface IFuncionarioDAO extends IGenericDAO<Funcionario>{
    //Metodo que faz login
    public abstract int login (Funcionario funcionario);
    //Metodo que busca um funcionario por CPF
    public abstract Funcionario findByCPF (long cpf);
}

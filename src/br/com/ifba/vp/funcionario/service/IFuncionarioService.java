/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.funcionario.service;

import br.com.ifba.vp.funcionario.model.Funcionario;
import java.util.List;

/**
 *
 * @author amand
 */
public interface IFuncionarioService {
    //Metodo que faz login 
    public abstract int login (Funcionario funcionario);
    //Metodo que salva um funcionario no banco
    public abstract Funcionario save (Funcionario funcionario);
    //Metodo que atualiza um funcionario no banco
    public abstract Funcionario update (Funcionario funcionario);
    //Metodo que deleta um funcionario do banco
    public abstract void delete (Funcionario funcionario);
    //Metodo que busca funcionario por id
    public abstract Funcionario findById (long id);
    //Metodo que busca funcionario pelo cpf
    public abstract Funcionario findByCPF (String cpf);
    //Metodo que busca uma lista de funcionarios 
    public abstract List<Funcionario> findAll ();
}

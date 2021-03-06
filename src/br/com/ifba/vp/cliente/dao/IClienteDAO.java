/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.cliente.dao;

import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.infraestructure.dao.IGenericDAO;



/**
 *
 * @author amand
 */
public interface IClienteDAO extends IGenericDAO<Cliente>{
    
    //Metodo que encontra um cliente pelo cpf 
    public abstract Cliente findByCPF (String cpf);
    
}

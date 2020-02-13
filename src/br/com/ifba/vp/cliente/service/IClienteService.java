/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.cliente.service;

import br.com.ifba.vp.cliente.model.Cliente;
import java.util.List;

/**
 *
 * @author amand
 */
public interface IClienteService {
    //Metodo que salva um cliente no banco
    public abstract Cliente save (Cliente cliente);
    //Metodo que atualiza um cliente no banco
    public abstract Cliente update (Cliente cliente);
    //Metodo que deleta um cliente no banco
    public abstract void delete (Cliente cliente);
    //Metodo que procura um cliente no banco pelo id
    public abstract Cliente findById (long id);
    //Metodo que procura um cliente no banco pelo cpf
    public abstract Cliente findByCPF (String cpf);
    //Metodo que retorna uma lista de clientes do banco
    public abstract List<Cliente> findAll ();
}

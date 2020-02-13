/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vp.cliente.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import br.com.ifba.vp.infraestructure.model.Pessoa;

/**
 *
 * @author Icaro
 */
@Entity
@Table(name = "Cliente")
public class Cliente extends Pessoa implements Serializable {

 
}

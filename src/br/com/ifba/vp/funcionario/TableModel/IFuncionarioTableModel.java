package br.com.ifba.vp.funcionario.TableModel;


import br.com.ifba.vp.funcionario.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edson
 */

public interface IFuncionarioTableModel {
    
    /* Lista de funcionários que aparecerão na tabela */
    public List<Funcionario> funcionario = new ArrayList<>();
    
    /* Colunas da tabela */
    public String[] colunas = {"Nome", "RG"};
}
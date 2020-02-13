package br.com.ifba.vp.produto.TableModel;


import br.com.ifba.vp.produto.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edson
 */

public interface IProdutoTableModel {
    
    /* Lista de funcionários que aparecerão na tabela */
    public List<Produto> produtos = new ArrayList<>();
    
    /* Colunas da tabela */
    public final String[] colunas = {"Produto", "Preço", "Seção", "Data de Validade", "Estoque"};
}
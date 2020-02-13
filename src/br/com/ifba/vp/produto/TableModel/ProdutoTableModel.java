package br.com.ifba.vp.produto.TableModel;


import br.com.ifba.vp.produto.model.Produto;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author edson
 */

public class ProdutoTableModel extends AbstractTableModel implements IProdutoTableModel {
    
    /* Retorna o nome das colunas da tabela */
    
    @Override
    public String getColumnName(int coluna) {
        return ProdutoTableModel.colunas[coluna];
    }
    
    /* Retorna a quantidade de linhas da tabela */
    
    @Override
    public int getRowCount() {
        return ProdutoTableModel.produtos.size();
    }
    
    /* Retorna a quantidade de colunas da tabela */
    
    @Override
    public int getColumnCount() {
        return ProdutoTableModel.colunas.length;
    }
    
    /* Atribui um dado a uma célula da tabela */
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch (coluna) {
            case 0:
                return ProdutoTableModel.produtos.get(linha).getNomeProduto();
            case 1:
                return ProdutoTableModel.produtos.get(linha).getPreco();
            case 2:
                return ProdutoTableModel.produtos.get(linha).getSecao();
            case 3:
                return ProdutoTableModel.produtos.get(linha).getDataValidade();
            case 4:
                return ProdutoTableModel.produtos.get(linha).getQuantidade();
        }
    
        return null;
    }
    
    /* Adiciona um elemento a lista, logo adiciona uma linha a tabela */
    
    public void addElement (Produto produto) {
        ProdutoTableModel.produtos.add(produto);
        fireTableDataChanged();
    }
    
    /* Remove um elemento da lista, logo remove uma linha da tabela, ambos com base na posição informada */
    
    public void removeElement (int posicao) {
        ProdutoTableModel.produtos.remove(posicao);
        fireTableDataChanged();
    }
}
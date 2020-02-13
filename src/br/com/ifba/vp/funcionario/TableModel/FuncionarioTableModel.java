package br.com.ifba.vp.funcionario.TableModel;


import br.com.ifba.vp.funcionario.model.Funcionario;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author edson
 */

public class FuncionarioTableModel extends AbstractTableModel implements IFuncionarioTableModel {

    /* Retorna o nome das colunas da tabela */
    
    @Override
    public String getColumnName(int coluna) {
        return FuncionarioTableModel.colunas[coluna];
    }
    
    /* Retorna a quantidade de linhas da tabela */
    
    @Override
    public int getRowCount() {
        return FuncionarioTableModel.funcionario.size();
    }
    
    /* Retorna a quantidade de colunas da tabela */
    
    @Override
    public int getColumnCount() {
        return FuncionarioTableModel.colunas.length;
    }

    /* Atribui um dado a uma célula da tabela */
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch (coluna) {
            case 0:
                return FuncionarioTableModel.funcionario.get(linha).getNome();
            case 1:
                return FuncionarioTableModel.funcionario.get(linha).getRg();
        }
        
        return null;
    }
    
    /* Adiciona um elemento a lista, logo adiciona uma linha a tabela */
    
    public void addElement (Funcionario funcionario) {
        FuncionarioTableModel.funcionario.add(funcionario);
        fireTableDataChanged();
    }
    
    /* Remove um elemento da lista, logo remove uma linha da tabela, ambos com base na posição informada */
    
    public void removeElement (int posicao) {
        FuncionarioTableModel.funcionario.remove(posicao);
        fireTableDataChanged();
    }
}
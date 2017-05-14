/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDs.Vetor;

/**
 *
 * @author 11645
 */
public interface IVetor<Tipo> {
    public boolean adicionar(Tipo valor);
    public boolean adicionar(int posicao, Tipo valor);
    public Tipo obter(int posicao);
    public void remover(int posicao);
    public boolean removerValor(Tipo valor);
    public boolean contem(Tipo valor);
    public int tamanho();
    public void limpar();
    
}

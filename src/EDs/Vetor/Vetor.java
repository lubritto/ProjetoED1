
package EDs.Vetor;

import java.util.Iterator;

import EDs.Vetor.IVetor;
import java.awt.BorderLayout;


public class Vetor<Tipo> implements IVetor<Tipo>, Iterable<Tipo> {
    
    Tipo[] vetor;
    private int TotalDeObjetos = 0;
    private int QuantidadeDeSlots = 0;
    
    public Vetor() {
    	vetor = (Tipo[]) new Object[50];
    }
    
    public Vetor(int tamanhoInicial) {
    	vetor = (Tipo[]) new Object[tamanhoInicial];
         this.QuantidadeDeSlots = tamanhoInicial;
    }
    
    @Override
    public boolean adicionar(Tipo objeto) {
        this.garantaEspaco();
        this.vetor[TotalDeObjetos] = objeto;
        this.TotalDeObjetos++;
        return true;
    }

    @Override
    public boolean adicionar(int posicao, Tipo objeto) {
        this.garantaEspaco(); 
        if (!this.posicaoValida(posicao)) { 
            throw new IllegalArgumentException("Posição inválida"); 
        }
            for (int i = this.TotalDeObjetos - 1; i >= posicao; i--) { 
                this.vetor[i + 1] = this.vetor[i]; 
            }
            this.vetor[posicao] = objeto; 
            this.TotalDeObjetos++;
        return false;
    }

    @Override
    public Tipo obter(int posicao) {
        return this.vetor[posicao];
    }

    @Override
    public void remover(int posicao) {
        if (this.vetor[posicao] == null | posicao < 0) { 
            throw new IllegalArgumentException("Posição inválida"); 
        } 
            for (int i = posicao; i < this.TotalDeObjetos - 1; i++) { 
               this.vetor[i] = null;
               this.vetor[i] = this.vetor[i + 1]; 
               this.vetor[i + 1] = null;
        } 
        this.TotalDeObjetos--;
    }

    @Override
    public boolean removerValor(Tipo valor) {
            for (int i = 0; i < this.TotalDeObjetos; i++) { 
                if (valor.equals(this.vetor[i])) {
                    for (int x = i; x <= this.TotalDeObjetos - 1; x++){
                        //Verifica se X é o indice do ultimo slot.
                        if (x == this.TotalDeObjetos - 1){
                            this.vetor[x] = null;
                            this.TotalDeObjetos--;
                            return true; 
                        }
                        
                        this.vetor[x] = this.vetor[x + 1];
                        this.vetor[x + 1] = null;
                    }
                    this.TotalDeObjetos--;
                    return true; 
                } 
        } 
        return false;
    }

    @Override
    public boolean contem(Tipo valor) {
        for (int i = 0; i < this.TotalDeObjetos; i++) { 
            if (valor.equals(this.vetor[i])) { 
                return true; 
            }
        }
        return false;
    }

    @Override
    public int tamanho() {
        return this.TotalDeObjetos;
    }

    @Override
    public void limpar() {
        for (int i = 0; i < this.TotalDeObjetos; i++){
            this.vetor[i] = null;
        }
    }
    
    private boolean posicaoValida(int posicao) { 
        return posicao >= 0 && posicao <= this.TotalDeObjetos; 
    }
    
    private void garantaEspaco() { 
        if (this.TotalDeObjetos == this.vetor.length) { 
            Tipo[] novaArray = (Tipo[]) new Object[this.vetor.length * 3]; 
            for (int i = 0; i < this.vetor.length; i++) { 
                novaArray[i] =  this.vetor[i]; 
            } 
            this.vetor = (Tipo[]) novaArray; 
        } 
    }

    @Override
    public Iterator<Tipo> iterator() {
	return new EDs.Vetor.Iterator<Tipo>(this);
    }
        
    public int NumeroDeSlots(){
        return this.QuantidadeDeSlots;
    }
}

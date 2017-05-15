package EDs.ListaEncadeada;

import java.util.Iterator;

/**
 *
 * author Edmário Vieira Souza
 * 
 */

public class ListaDuplamenteEncadeada<T> implements IListaDuplamenteEncadeada<T>, Iterable<T> {
    NoDuplamenteEncadeado<T> inicio, fim;
    int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public boolean adicionarNoInicio(T valor) { // feito
        NoDuplamenteEncadeado<T> novoNo = new NoDuplamenteEncadeado<>(valor);
        if (inicio == null){
            inicio = fim = novoNo;
            this.tamanho++;
        } else {
            inicio.setAnterior(novoNo);
            novoNo.setProximo(inicio);
            inicio = novoNo;
            this.tamanho++;
        }
        return true;
    }

    @Override
    public T removerDoInicio() { // feito
        
        inicio = inicio.getProximo();
        inicio.getAnterior().setProximo(null);
	inicio.setAnterior(null);
	
        this.tamanho--;
        
        if (tamanho == 0){
            limpar();
        }
        
        return null;
    }

    @Override
    public T removerDoFim() { // feito
        
        NoDuplamenteEncadeado<T> atual = inicio;
       
        for(int i = 0; i < this.tamanho - 1; i++){
            
            atual = atual.getProximo();
            
        }
        
        fim = null;
        fim = atual.getAnterior();
        fim.setProximo(null);
        
        this.tamanho--;
        
            if (tamanho == 0){
                limpar();
            }
        
        return null; 
    }

    @Override
    public boolean adicionarFim(T valor) { // feito
        
       if(this.tamanho == 0){
            throw new ExceptionInInitializerError("Posicao invalida."); 
        }
        
       NoDuplamenteEncadeado<T> novoNo = new NoDuplamenteEncadeado<>(valor);
       if (fim == null){
            throw new NullPointerException();
       } else {
           fim.setProximo(novoNo);
           novoNo.setAnterior(fim);
           fim = novoNo;
           this.tamanho++;
       }
       return true;
    }

    @Override
    public boolean adicionar(int posicao, T valor) { // feito
        
        if(!posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida"); 
        }
        
        if (posicao == 0){
            return adicionarNoInicio(valor);
        } else if(posicao == this.tamanho){  
            return adicionarFim(valor);
        }
        
        NoDuplamenteEncadeado<T> novoNo = new NoDuplamenteEncadeado<>(valor);
        NoDuplamenteEncadeado<T> atual = inicio;    
        
        for (int i = 0; i <= posicao; i++){

                if(i == posicao){
                    atual.getAnterior().setProximo(novoNo);
		    novoNo.setAnterior(atual.getAnterior());
		    atual.setAnterior(novoNo);
		    novoNo.setProximo(atual);
		    System.out.println("Passou");
		    this.tamanho++;
                    return true;
                }
		
		atual = atual.getProximo();
		
        }
        
        return false;
        
    }

    @Override
    public T obter(int posicao) { 
       NoDuplamenteEncadeado<T> Obter = inicio;
       
       if(posicao == 0){
           obterInicio();
       } else if(posicao == this.tamanho - 1) {
           obterUltimo();
       } else if (posicao == this.tamanho) {
    	   return null;						
       }									 
       
       for (int i = 0; i < posicao; i++){
           Obter = Obter.getProximo();
       }
       return (T) Obter.getValor();
    }
    
    public T obterInicio(){ // feito
        return (T) this.inicio.getValor();
    }
    
    public T obterUltimo(){ // feito
        return (T) this.fim.getValor();
    }
    
    @Override
    public T remover(int posicao) { // feito
        
        if(!posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida"); 
        }
        
        if(posicao == 0){
          return removerDoInicio();
        } else if(posicao == this.tamanho) {
          return removerDoFim();
        }
        
        NoDuplamenteEncadeado<T> atual = inicio;
        
        for (int i = 0; i <= posicao ; i++){
             
            if (i == posicao){
                
                atual.getAnterior().setProximo(atual.getProximo());
		atual.getProximo().setAnterior(atual.getAnterior());
                atual = null;
                
                this.tamanho--;
                   
                    if (tamanho == 0){
                        limpar();
                    }
                    
                return null;
                
            }
	    
            atual = atual.getProximo();
	    
        }
        return null;
    }

    @Override
    public boolean remover(T valor) { // feito
        
        if (inicio.getValor().equals(valor)){
            removerDoInicio();
            return true;
        } else if (fim.getValor().equals(valor)){
            removerDoFim();
            return true;
        }
        
        NoDuplamenteEncadeado<T> atual = inicio;
        
        for (int i = 0; i < this.tamanho - 1; i++ ){
           
            atual = atual.getProximo();
            
            if (atual.getValor().equals(valor)){
                
                atual.getAnterior().setProximo(atual.getProximo());
		atual.getProximo().setAnterior(atual.getAnterior());
                atual = null;
                
                this.tamanho--;
                   
                    if (tamanho == 0){
                        limpar();
                    }
                
                return true;
                
            }
        }
        
        if (tamanho == 0){
            limpar();
        }
        
        return false;
    }

    @Override
    public boolean contem(T valor) { // feito
        NoDuplamenteEncadeado<T> Comparacao = inicio;
        for (int i = 0; i < this.tamanho; i++ ){
            
            if (Comparacao.getValor().equals(valor)){
                return true;
            }
            
            Comparacao = Comparacao.getProximo();
            
        }
        return false;
    }

    @Override
    public int tamanho() { // feito
        return this.tamanho;
    }

    @Override
    public void limpar() { // feito
       
       NoDuplamenteEncadeado<T> atual = inicio;
       NoDuplamenteEncadeado<T> anterior;
       
       for (int i = 0; i < this.tamanho; i++){
           anterior = atual;
           atual.getProximo();
           anterior = null;
       } 
       
       this.inicio = null;
       this.fim = null;
       this.tamanho = 0;
    }

    @Override
    public String toString() { // feito
        if(this.tamanho == 0){ 
            return "[]"; 
        }
        StringBuilder builder = new StringBuilder("[");
        NoDuplamenteEncadeado<T> atual = inicio;
        
        for (int i = 0; i < this.tamanho - 1; i++) { 
            builder.append(atual.getValor()); 
            builder.append(", "); 
            atual = atual.getProximo(); 
        }
        builder.append(atual.getValor()); 
        builder.append("]");
        
        return builder.toString();
    }
   
    private boolean posicaoValida(int posicao) { 
        return posicao >= 0 && posicao <= this.tamanho; 
    }

	@Override
	public Iterator<T> iterator() {
		return new EDs.ListaEncadeada.Iterator<T>(this) {
		};
	}
}

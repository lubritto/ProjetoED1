
package Listas_Testes;
import EDs.Vetor.Vetor;

public class Vetor_Teste {
    
    public Vetor<Integer> Vetor = new Vetor<>();

    public void TodosOsTestes(){
        int quantidade = 20000;
        
        for (int i = 0; i < 4 ;i++){
        Inserir(quantidade);
        quantidade *= 10;
        }
    }
    
    public void Inserir(int quant){
        double inicio, fim;
        
        if (this.Vetor.NumeroDeSlots() < quant){
           this.Vetor = new Vetor<>(quant);
        }
        
        inicio = System.nanoTime();
        for (int i = 0; i < quant; i++){
            this.Vetor.adicionar(quant);
        }
        fim = System.nanoTime();
        
        System.out.format(String.format("Tempo gasto com o teste(Inserir)(%d) : %.2f", + quant ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
        Buscar();
    }
    
    public void Buscar(){
        System.out.println("Teste de Busca...");
        
        double inicio, fim;
        
        inicio = System.nanoTime();
             for (int i = 0; i < this.Vetor.tamanho(); i++){
                 this.Vetor.contem(i);
             }
        fim = System.nanoTime();
        
        System.out.format(String.format("Tempo gasto com o teste(Busca) de (%d) : %.2f", + this.Vetor.tamanho() ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
    }
}

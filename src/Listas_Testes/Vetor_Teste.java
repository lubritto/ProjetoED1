
package Listas_Testes;
import EDs.Vetor.Vetor;
import java.awt.BorderLayout;

public class Vetor_Teste {
    
    public Vetor<Integer> Vetor = new Vetor<>();

    public void TodosOsTestes(){
        int quantidade = 20000;
        System.out.println("\n|------------------------Vetor--------------------------|");
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
            this.Vetor.adicionar(i+1);
        }
        fim = System.nanoTime();
        
        System.out.format(String.format("Tempo gasto com o teste(Inserir) (%d) : %.2f", + quant ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
        
        if (this.Vetor.tamanho() == 20000000){
            Buscar();
        }
    }
    
    public void Buscar(){
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|------------------Teste de Busca...--------------------|");
        System.out.println("|Consiste em Buscar os inteiros '20.000' ; '200.000';---|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");
        
        double inicio, fim;
        int Quantidade_Procurar = 20000;
        
        inicio = System.nanoTime();
        
        while(Quantidade_Procurar != 200000000){
            if (this.Vetor.contem(Quantidade_Procurar)){
                fim = System.nanoTime();
                System.out.format(String.format("Tempo gasto com o teste(Busca) de (%d) : %.2f", + Quantidade_Procurar ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
                Quantidade_Procurar *= 10;
                inicio = System.nanoTime();
            }
        }
        
        Remover();
        
    }
    
    private void Remover(){
        double inicio, fim;
        
        int quantidade = 20000;
        
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-----------------Teste de Remoção...-------------------|");
        System.out.println("|Consiste em Remover os inteiros '20.000' ; '200.000';--|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Removendo...-------------------------------------------|\n");
        
        for (int i = 0; i < 4 ;i++){
            inicio = System.nanoTime();
            if(this.Vetor.removerValor(quantidade)){
            fim = System.nanoTime();
            System.out.format(String.format("Tempo gasto com o teste(Remoção) de (%d) : %.2f", + quantidade ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
            quantidade *= 10;
            }
        }
   }
}

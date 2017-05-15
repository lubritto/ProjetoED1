package benchmark;

import java.util.Scanner;
import Listas_Testes.Vetor_Teste;
import Listas_Testes.ListaEncadeada_Teste;

public class Benchmark {

    public static Vetor_Teste Vetor = new Vetor_Teste();
    public static ListaEncadeada_Teste ArrayLinked= new ListaEncadeada_Teste();
    
    public static void main(String[] args) {
        
        Benchmark inicio = new Benchmark();
        inicio.Inicio();
        // 
//        inicio = System.nanoTime();
//        
//        Array.add(0, 0);
//        
//        fim = System.nanoTime();
//        
//        System.out.println("O tempo para adicionar no inicio foi " + (fim - inicio) / 1000000D);
//        
//        inicio = System.nanoTime();
//        
//        Array.add(0);
//        
//        fim = System.nanoTime();
//        
//        System.out.println("O tempo para adicionar no fim foi " + (fim - inicio) / 1000000D);
    }
    
    private void Inicio(){
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|Lista de todas as Estruturas de Dados a serem testadas:|");
        System.out.println("|1ª- Vetor                                              |");
        System.out.println("|2ª- Lista Duplamente Encadeada                         |");
        System.out.println("|3ª- HashMap                                            |");
        System.out.println("|---------------Aperte ENTER para começar---------------|");
        String tecla = entrada.nextLine();
        
        Vetor.TodosOsTestes();
        ArrayLinked.TodosOsTestes();
    }

}

package benchmark;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import Listas_Testes.Vetor_Teste;

public class Benchmark {

    public static Vetor_Teste Vetor = new Vetor_Teste();
    
    public static void main(String[] args) {
        
        Benchmark inicio = new Benchmark();
        inicio.Inicio();
        
//        /* Array -> */ List<Integer> Array = new LinkedList<>();
//        double inicio, fim;
//        
//        inicio = System.nanoTime();        
//        for (int i = 0; i < 20000; i++) {
//            Array.add(i);
//        }
//        fim = System.nanoTime();
//        
//        System.out.format(String.format("O tempo para inserir todos os elementos foi: %.2f", + (fim - inicio) / 1000000)+" milissegundos");
        
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
    }

}

package benchmark;

import java.util.Scanner;
import benchmark.Lists_Tests.Vetor_Test;
import benchmark.Lists_Tests.DoubleLinked_Test;

public class Benchmark {

    public Vetor_Test Vetor = new Vetor_Test();
    public DoubleLinked_Test DoubleLinked = new DoubleLinked_Test();

    public static void main(String[] args) {

        Benchmark inicio = new Benchmark();
        inicio.Inicio();

        /**
         * inicio = System.nanoTime();
         *
         * Array.add(0, 0);
         *
         * fim = System.nanoTime();
         *
         * System.out.println("O tempo para adicionar no inicio foi " + (fim -
         * inicio) / 1000000D);
         *
         * inicio = System.nanoTime();
         *
         * Array.add(0);
         *
         * fim = System.nanoTime();
         *
         * System.out.println("O tempo para adicionar no fim foi " + (fim -
         * inicio) / 1000000D);
         *
         */
    }

    /**
     * Metodo inicio onde contém as opções de teste para o usuario escolher o
     * teste desajado
    */
    
    private void Inicio() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|Lista de todas as Estruturas de Dados a serem testadas:|");
        System.out.println("|1ª- Vetor                                              |");
        System.out.println("|2ª- Lista Duplamente Encadeada                         |");
        System.out.println("|3ª- HashMap                                            |");
        System.out.println("|--------------Digite a OPÇÃO para começar--------------|");
        int op = entrada.nextInt();

        switch (op) {

            case 1:
                Vetor.TodosOsTestes();
                Inicio();
                break;

            case 2:
                DoubleLinked.TodosOsTestes();
                Inicio();
                break;

            case 3:
                //HashMap.TodosOsTestes();
                //Inicio();
                //Teste
                break;

            default:
                System.out.println("Digite uma opção válida!");
                Inicio();

        }

    }

}

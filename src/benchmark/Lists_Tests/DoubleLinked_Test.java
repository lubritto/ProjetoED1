package benchmark.Lists_Tests;

import benchmark.Lists.DoubleLinkedList;

public class DoubleLinked_Test {

    public DoubleLinkedList<Integer> DoubleLinkedList = new DoubleLinkedList<>();

    double inicio, fim;
    int quantidade = 20000;

    /**
     * Um método chama o outro, fazendo com que todos os teste de inserção,
     * busca e remoção sejam finalizados.
     *
     * TodosOsTestes() - Método onde possui uma iteração que irá passar a
     * informação da quantidade do vetor para o método seguinte, e multiplicando
     * a quantidade por 10 para a proxima execução da iteração.
     */
    public void TodosOsTestes() {
        System.out.println("\n|-------------------Lista Encadeada---------------------|");

        for (int i = 0; i < 4; i++) {
            Inserir(quantidade);
            quantidade *= 10;
        }

    }

    /**
     * Inserir() - Método onde irá popular o vetor com a quantidade passada pelo
     * método anterior e após a inserção e feito uma verificaçao, se o tamanho
     * do vetor for igual a 20 milhões (número maximo de elementos que
     * utilizamos nesse teste) o método buscar é chamado, caso contrario,
     * voltará para o método anterior para a proxima iteração.
     */
    private void Inserir(int quant) {
        DoubleLinkedList.Clear();

        inicio = System.nanoTime();
        for (int i = 0; i < quant; i++) {
            DoubleLinkedList.Add(i + 1);
        }
        fim = System.nanoTime();
        PrintTest(quant, "Inserir");

        if (DoubleLinkedList.Size() == 20000000) {
            SearchElement();
        }
    }

    /**
     * SearchElement() - Método onde sera feita a busca por elemento e em
     * seguida o método de busca pelo indice é chamado.
     */
    private void SearchElement() {
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-------------Teste de Busca(Elemento)...---------------|");
        System.out.println("|Consiste em Buscar os inteiros '20.000' ; '200.000';---|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");

        quantidade = 20000;
        inicio = System.nanoTime();

        while (quantidade != 200000000) {
            if (DoubleLinkedList.Exists(quantidade)) {
                fim = System.nanoTime();
                PrintTest(quantidade, "Busca(Elemento)");
                quantidade *= 10;
                inicio = System.nanoTime();
            }
        }

        SearchIndex();
    }

    /**
     * SearchIndex() - Método onde sera feita a busca pelo indice e em seguida o
     * método remover e chamado.
     */
    private void SearchIndex() {
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|--------------Teste de Busca(Índice)...----------------|");
        System.out.println("|Consiste em Buscar os Elementos nos Índices '0';'19.999|");
        System.out.println("|'199.999'; '1.999.999'; '19.999.999' ------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");

        inicio = System.nanoTime();
        DoubleLinkedList.Get(0);
        fim = System.nanoTime();

        PrintTest(0, "Busca(Índice)");

        inicio = System.nanoTime();
        DoubleLinkedList.Get(19999);
        fim = System.nanoTime();

        PrintTest(19999, "Busca(Índice)");

        inicio = System.nanoTime();
        DoubleLinkedList.Get(199999);
        fim = System.nanoTime();

        PrintTest(199999, "Busca(Índice)");

        inicio = System.nanoTime();
        DoubleLinkedList.Get(1999999);
        fim = System.nanoTime();

        PrintTest(1999999, "Busca(Índice)");

        Remove();

    }

    /**
     * Remover() - Método onde será feita a remoçao dos elementos pelo indice no
     * inicio, meio e fim do vetor.
     */
    private void Remove() {

        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-----------------Teste de Remoção...-------------------|");
        System.out.println("|Consiste em Remover os inteiros '20.000' ; '200.000';--|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Removendo...-------------------------------------------|\n");

        quantidade = 20000;

        for (int i = 0; i < 4; i++) {

            inicio = System.nanoTime();
            //Valor pela metade declarado
            DoubleLinkedList.Remove(new Integer(quantidade / 2));
            fim = System.nanoTime();
            PrintTest(quantidade / 2, "Remoção");

            inicio = System.nanoTime();
            //Valor Original declarado
            DoubleLinkedList.Remove(new Integer(quantidade));
            fim = System.nanoTime();
            PrintTest(quantidade, "Remoção");

            quantidade *= 10;
        }

    }

    /**
     * PrintTest() - Método que possui como parametro um inteiro e uma String
     * onde irá imprimir na tela o tempo gasto em cada teste feito.
     */
    private void PrintTest(int quant, String modoTeste) {

        System.out.format(String.format("Tempo gasto com o teste(%s) (%d) : %.2f", modoTeste, +quant, (fim - inicio) / 1000000) + " milissegundos" + "\n");

    }

}

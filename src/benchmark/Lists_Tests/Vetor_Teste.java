package benchmark.Lists_Tests;

import EDs.Vetor.Vetor;

public class Vetor_Teste {

    public Vetor<Integer> Vetor = new Vetor<>();
    int quantidade = 20000;
    double inicio, fim;

    /**
     * Um método chama o outro, fazendo com que todos os teste de inserção,
     * busca e remoção sejam finalizados.
     *
     * TodosOsTestes() - Método onde possui uma iteração que irá passar a
     * informação da quantidade do vetor para o método seguinte, e multiplicando
     * a quantidade por 10 para a proxima execução da iteração.
     */
    public void TodosOsTestes() {

        System.out.println("\n|------------------------Vetor--------------------------|");

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

        if (this.Vetor.NumeroDeSlots() < quant) {
            this.Vetor = new Vetor<>(quant);
        }

        inicio = System.nanoTime();
        for (int i = 0; i < quant; i++) {
            this.Vetor.adicionar(i + 1);
        }
        fim = System.nanoTime();

        PrintTest(quant, "Inserir");

        if (this.Vetor.tamanho() == 20000000) {
            Buscar_Elemento();
        }

    }

    /**
     * Buscar_Elemento() - Método onde sera feita a busca por elemento e em
     * seguida o método de busca pelo indice é chamado.
     */
    private void Buscar_Elemento() {
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-------------Teste de Busca(Elemento)...---------------|");
        System.out.println("|Consiste em Buscar os inteiros '20.000' ; '200.000';---|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");

        quantidade = 20000;

        inicio = System.nanoTime();

        while (quantidade != 200000000) {

            if (this.Vetor.contem(quantidade)) {
                fim = System.nanoTime();
                PrintTest(quantidade, "Busca(Elemento)");
                quantidade *= 10;
                inicio = System.nanoTime();
            }

        }

        Buscar_Indice();

    }

    /**
     * Buscar_Indice() - Método onde sera feita a busca pelo indice e em seguida
     * o método remover e chamado.
     */
    private void Buscar_Indice() {

        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|--------------Teste de Busca(Índice)...----------------|");
        System.out.println("|Consiste em Buscar os Elementos nos Índices '0';'19.999|");
        System.out.println("|'199.999'; '1.999.999'; '19.999.999' ------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");

        inicio = System.nanoTime();
        this.Vetor.obter(0);
        fim = System.nanoTime();
        PrintTest(0, "Busca(Índice)");

        inicio = System.nanoTime();
        this.Vetor.obter(19999);
        fim = System.nanoTime();
        PrintTest(19999, "Busca(Índice)");

        inicio = System.nanoTime();
        this.Vetor.obter(199999);
        fim = System.nanoTime();
        PrintTest(199999, "Busca(Índice)");

        inicio = System.nanoTime();
        this.Vetor.obter(1999999);
        fim = System.nanoTime();
        PrintTest(1999999, "Busca(Índice)");

        Remover();

    }

    /**
     * Remover() - Método onde será feita a remoçao dos elementos pelo indice no
     * inicio, meio e fim do vetor.
     */
    private void Remover() {

        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-----------------Teste de Remoção...-------------------|");
        System.out.println("|Consiste em Remover os inteiros'0' ;20.000'; '200.000';|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Removendo...-------------------------------------------|\n");

        inicio = System.nanoTime();
        this.Vetor.remover(0);
        fim = System.nanoTime();

        PrintTest(0, "Remoção");

        quantidade = 20000;

        for (int i = 0; i < 4; i++) {

            inicio = System.nanoTime();
            //Valor pela metade declarado
            this.Vetor.removerValor(quantidade / 2);
            fim = System.nanoTime();
            PrintTest(quantidade / 2, "Remoção");

            //Valor Original declarado
            inicio = System.nanoTime();
            this.Vetor.removerValor(quantidade);
            fim = System.nanoTime();
            PrintTest(quantidade, "Remoção");

            quantidade *= 10;
        }

        System.out.println("|----------Todos os testes finalizados(Vetor)----------|");

    }

    /**
     * PrintTest() - Método que possui como parametro um inteiro e uma String
     * onde irá imprimir na tela o tempo gasto em cada teste feito.
     */
    private void PrintTest(int quant, String modoTeste) {

        System.out.format(String.format("Tempo gasto com o teste(%s) (%d) : %.2f", modoTeste, +quant, (fim - inicio) / 1000000) + " milissegundos" + "\n");

    }

}

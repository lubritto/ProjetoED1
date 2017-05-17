package benchmark.Lists_Tests;

import benchmark.Lists.Vetor;

public class Vetor_Test {

    public Vetor<Integer> Vetor = new Vetor<>();
    int quantidade = 20000;
    double inicio, fim;

    /**
     * Um mÃ©todo chama o outro, fazendo com que todos os teste de inserÃ§Ã£o,
     * busca e remoÃ§Ã£o sejam finalizados.
     *
     * TodosOsTestes() - MÃ©todo onde possui uma iteraÃ§Ã£o que irÃ¡ passar a
     * informaÃ§Ã£o da quantidade do vetor para o mÃ©todo seguinte, e multiplicando
     * a quantidade por 10 para a proxima execuÃ§Ã£o da iteraÃ§Ã£o.
     */
    public void TodosOsTestes() {

        System.out.println("\n|------------------------Vetor--------------------------|");

        for (int i = 0; i < 4; i++) {
            Inserir(quantidade);
            quantidade *= 10;
        }

    }

    /**
     * Inserir() - MÃ©todo onde irÃ¡ popular o vetor com a quantidade passada pelo
     * mÃ©todo anterior e apÃ³s a inserÃ§Ã£o e feito uma verificaÃ§ao, se o tamanho
     * do vetor for igual a 20 milhÃµes (nÃºmero maximo de elementos que
     * utilizamos nesse teste) o mÃ©todo buscar Ã© chamado, caso contrario,
     * voltarÃ¡ para o mÃ©todo anterior para a proxima iteraÃ§Ã£o.
     */
    private void Inserir(int quant) {
     
        if (Vetor.Length() < quant){
           Vetor = new Vetor<>(quant);
        }

        inicio = System.nanoTime();
        for (int i = 0; i < quant; i++) {
            Vetor.Add(i + 1);
        }
        fim = System.nanoTime();

        PrintTest(quant, "Inserir");

        if (Vetor.Size() == 20000000) {
            Buscar_Elemento();
        }

    }

    /**
     * Buscar_Elemento() - MÃ©todo onde sera feita a busca por elemento e em
     * seguida o mÃ©todo de busca pelo indice Ã© chamado.
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

            if (Vetor.Exists(quantidade)) {
                fim = System.nanoTime();
                PrintTest(quantidade, "Busca(Elemento)");
                quantidade *= 10;
                inicio = System.nanoTime();
            }

        }

        Buscar_Indice();

    }

    /**
     * Buscar_Indice() - MÃ©todo onde sera feita a busca pelo indice e em seguida
     * o mÃ©todo remover e chamado.
     */
    private void Buscar_Indice() {

        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|--------------Teste de Busca(Ã�ndice)...----------------|");
        System.out.println("|Consiste em Buscar os Elementos nos Ã�ndices '0';'19.999|");
        System.out.println("|'199.999'; '1.999.999'; '19.999.999' ------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");

        inicio = System.nanoTime();
        this.Vetor.Get(0);
        fim = System.nanoTime();
        PrintTest(0, "Busca(Ã�ndice)");

        inicio = System.nanoTime();
        this.Vetor.Get(19999);
        fim = System.nanoTime();
        PrintTest(19999, "Busca(Ã�ndice)");

        inicio = System.nanoTime();
        this.Vetor.Get(199999);
        fim = System.nanoTime();
        PrintTest(199999, "Busca(Ã�ndice)");

        inicio = System.nanoTime();
        this.Vetor.Get(1999999);
        fim = System.nanoTime();
        PrintTest(1999999, "Busca(Ã�ndice)");

        Remover();

    }

    /**
     * Remover() - MÃ©todo onde serÃ¡ feita a remoÃ§ao dos elementos pelo indice no
     * inicio, meio e fim do vetor.
     */
    private void Remover() {

        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-----------------Teste de RemoÃ§Ã£o...-------------------|");
        System.out.println("|Consiste em Remover os inteiros'0' ;20.000'; '200.000';|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Removendo...-------------------------------------------|\n");

        inicio = System.nanoTime();
        Vetor.Remove(0);
        fim = System.nanoTime();

        PrintTest(0, "RemoÃ§Ã£o");

        quantidade = 20000;

        for (int i = 0; i < 4; i++) {

            inicio = System.nanoTime();
            //Valor pela metade declarado
            this.Vetor.Remove(new Integer(quantidade / 2));
            fim = System.nanoTime();
            PrintTest(quantidade / 2, "RemoÃ§Ã£o");

            //Valor Original declarado
            inicio = System.nanoTime();
            this.Vetor.Remove(new Integer(quantidade));
            fim = System.nanoTime();
            PrintTest(quantidade, "RemoÃ§Ã£o");

            quantidade *= 10;
        }

        System.out.println("|----------Todos os testes finalizados(Vetor)----------|");

    }

    /**
     * PrintTest() - MÃ©todo que possui como parametro um inteiro e uma String
     * onde irÃ¡ imprimir na tela o tempo gasto em cada teste feito.
     */
    private void PrintTest(int quant, String modoTeste) {

        System.out.format(String.format("Tempo gasto com o teste(%s) (%d) : %.2f", modoTeste, +quant, (fim - inicio) / 1000000) + " milissegundos" + "\n");

    }

}

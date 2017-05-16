package benchmark.Lists_Tests;
import benchmark.Lists.DoubleLinkedList;

public class DoubleLinked_Test {
    
    public DoubleLinkedList<Integer> DoubleLinkedList = new DoubleLinkedList<>();
    
    double inicio, fim;
    int quantidade = 20000;
    
    public void TodosOsTestes(){
        System.out.println("\n|-------------------Lista Encadeada---------------------|");
        
        for (int i = 0; i < 4 ;i++){
            Inserir(quantidade);
            quantidade *= 10;
        }
        
    }
    
    private void Inserir(int quant){
        DoubleLinkedList.Clear();
        
        inicio = System.nanoTime();
        for (int i = 0; i < quant; i++){
            DoubleLinkedList.Add(i+1);
        }
        fim = System.nanoTime();
        PrintTest(quant, "Inserir");
        
        if (DoubleLinkedList.Size() == 20000000){
            SearchElement();
        }
    }
    
    private void SearchElement(){
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-------------Teste de Busca(Elemento)...---------------|");
        System.out.println("|Consiste em Buscar os inteiros '20.000' ; '200.000';---|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");
        
        quantidade = 20000;
        inicio = System.nanoTime();
        
        while(quantidade != 200000000){
            if (DoubleLinkedList.Exists(quantidade)){
                fim = System.nanoTime();
                PrintTest(quantidade, "Busca(Elemento)");
                quantidade *= 10;
                inicio = System.nanoTime();
            }
        }
        
        SearchIndex();
    }
    
    private void SearchIndex(){
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
//        for(int i = 0; i < 3 ; i++){
//            inicio = System.nanoTime();
//            DoubleLinkedList.Get(indice);
//            fim = System.nanoTime();
//            PrintTest(indice, "Busca(Índice)");
//            indice *= 10;

//        }

        Remove();
                
    }
    
    private void Remove(){
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-----------------Teste de Remoção...-------------------|");
        System.out.println("|Consiste em Remover os inteiros '20.000' ; '200.000';--|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Removendo...-------------------------------------------|\n");
        
        quantidade = 20000;
        
        for (int i = 0; i < 4 ;i++){
            inicio = System.nanoTime();
            DoubleLinkedList.RemoveEntity(quantidade);
            fim = System.nanoTime();
            PrintTest(quantidade, "Remoção");
            quantidade *= 10;
        }
    }
    
    private void PrintTest(int quant, String modoTeste){
        
        System.out.format(String.format("Tempo gasto com o teste(%s) (%d) : %.2f", modoTeste, + quant ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
        
    }
}

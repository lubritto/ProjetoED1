package benchmark.Testes;

import benchmark.Listas.Vetor;


public class Vetor_Test {
    
    private Vetor<Integer> Vetor = new Vetor<>();

    public void TodosOsTestes(){
        int quantidade = 20000;
        System.out.println("\n|------------------------Vetor--------------------------|");
        for (int i = 0; i < 4 ;i++){
            Inserir(quantidade);
            quantidade *= 10;
        }
    }
    
    private void Inserir(int quant){
        double inicio, fim;
        
        if (Vetor.Length() < quant){
           Vetor = new Vetor<>(quant);
        }
        
        inicio = System.nanoTime();
        for (int i = 0; i < quant; i++){
            Vetor.Add(i+1);
        }
        fim = System.nanoTime();
        
        System.out.format(String.format("Tempo gasto com o teste(Inserir) (%d) : %.2f", + quant ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
        
        if (Vetor.Size() == 20000000){
            Buscar_Elemento();
        }
    }
    
    private void Buscar_Elemento(){
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-------------Teste de Busca(Elemento)...---------------|");
        System.out.println("|Consiste em Buscar os inteiros '20.000' ; '200.000';---|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");
        
        double inicio, fim;
        int Quantidade_Procurar = 20000;
        
        inicio = System.nanoTime();
        
        while(Quantidade_Procurar != 200000000){
            if (Vetor.Exists(Quantidade_Procurar)){
                fim = System.nanoTime();
                System.out.format(String.format("Tempo gasto com o teste(Busca(Elemento)) de (%d) : %.2f", + Quantidade_Procurar ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
                Quantidade_Procurar *= 10;
                inicio = System.nanoTime();
            }
        }
        
        Buscar_Indice();
        
    }
    
    private void Buscar_Indice(){
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|--------------Teste de Busca(Ã�ndice)...----------------|");
        System.out.println("|Consiste em Buscar os Elementos nos Ã�ndices '0';'19.999|");
        System.out.println("|'199.999'; '1.999.999'; '19.999.999' ------------------|");
        System.out.println("|Buscando...--------------------------------------------|\n");
        
        double inicio, fim;
        
        int indice = 19999;
        
        inicio = System.nanoTime();
        Vetor.Get(0);
        fim = System.nanoTime();
        
        System.out.format(String.format("Tempo gasto com o teste(Busca(Ã�ndice)) de (0) : %.2f", + (fim - inicio) / 1000000)+" milissegundos" + "\n");
        
        for(int i = 0; i < 3 ; i++){
            inicio = System.nanoTime();
            Vetor.Get(indice);
            fim = System.nanoTime();
            System.out.format(String.format("Tempo gasto com o teste(Busca(Ã�ndice)) de (%d) : %.2f", + indice ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
            indice *= 10;
        }
        
        
        Remover();
        
    }
    
    private void Remover(){
        double inicio, fim;
        
        int quantidade = 20000;
        
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|-----------------Teste de RemoÃ§Ã£o...-------------------|");
        System.out.println("|Consiste em Remover os inteiros '20.000' ; '200.000';--|");
        System.out.println("|'2.000.000'; '20.000.000' -----------------------------|");
        System.out.println("|Removendo...-------------------------------------------|\n");
        
        for (int i = 0; i < 4 ;i++){
            inicio = System.nanoTime();
            Vetor.Remove(new Integer(quantidade));
            fim = System.nanoTime();
            System.out.format(String.format("Tempo gasto com o teste(RemoÃ§Ã£o) de (%d) : %.2f", + quantidade ,(fim - inicio) / 1000000)+" milissegundos" + "\n");
            quantidade *= 10;
            
        }
        
        System.out.println("|----------Todos os testes finalizados(Vetor)----------|");
        
   }
}

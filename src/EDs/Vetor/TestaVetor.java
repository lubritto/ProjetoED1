
package EDs.Vetor;

public class TestaVetor {
    
    public static void main(String[] args){
        
        Vetor<String> vetor = new Vetor();
        
        String nome1 = "Pedro";
        String nome2 = "João";
        String nome3 = "Ricard";
        String nome4 = "Roberto";
        vetor.adicionar(nome1);
        vetor.adicionar(nome2);
        vetor.adicionar(nome3);
        vetor.adicionar(1, nome4);
        
        System.out.println(vetor.tamanho());
        
        for (int i = 0; i < vetor.tamanho(); i++){
            System.out.println(vetor.obter(i));
        }
        System.out.println(vetor.contem(nome1));
        
        System.out.println(vetor.removerValor(nome2));
        
        for (int i = 0; i < vetor.tamanho(); i++){
            System.out.println(" | " + vetor.obter(i));
        }
    }
    
}

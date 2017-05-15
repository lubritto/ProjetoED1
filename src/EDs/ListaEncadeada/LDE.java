package EDs.ListaEncadeada;

/**
 * @author Edmário Vieira Souza
 */
public class LDE {
    
    public static void main(String[] args) {
        
        ListaDuplamenteEncadeada<String> testList = new ListaDuplamenteEncadeada<>();
        
        testList.adicionarNoInicio("test2");
        testList.adicionarFim("test3");
        testList.adicionarNoInicio("test4");
        
		System.out.println(testList);
		
		System.out.println(testList.adicionar(3, "valor"));	
	
		System.out.println(testList);
		
		testList.remover(0);
		
		System.out.println(testList);
		
		for (String string : testList) {
			System.out.println(string);
		}
	
    }
    
}

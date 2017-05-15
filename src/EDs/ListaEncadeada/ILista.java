package EDs.ListaEncadeada;

/**
 * @author Edmário Vieira Souza
 */
public interface ILista<Tipo> {
   
    public boolean adicionarFim(Tipo valor);
    public boolean adicionar(int posicao, Tipo valor);
    public Tipo obter(int posicao);
    public Tipo remover(int posicao);
    public boolean remover(Tipo valor);
    public boolean contem(Tipo valor);
    public int tamanho();
    public void limpar();

}

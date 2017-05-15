package EDs.ListaEncadeada;

/**
 * author Edmário Vieira Souza
 */

public class NoDuplamenteEncadeado<T> {
    
    private T valor;
    private NoDuplamenteEncadeado<T> proximo, anterior;

    public NoDuplamenteEncadeado(T valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
    
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoDuplamenteEncadeado<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplamenteEncadeado<T> proximo) {
        this.proximo = proximo;
    }

    public NoDuplamenteEncadeado<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplamenteEncadeado<T> anterior) {
        this.anterior = anterior;
    }
}

package EDs.ListaEncadeada;

public class Iterator<T> implements java.util.Iterator<T> {
	
	private ListaDuplamenteEncadeada<T> listaDuplamenteEncadeada;
	private int posicao;
	
	public Iterator(ListaDuplamenteEncadeada<T> listaDuplamenteEncadeada) {
		this.listaDuplamenteEncadeada = listaDuplamenteEncadeada;
	}

	@Override
	public boolean hasNext() {
		if ( !(this.listaDuplamenteEncadeada.obter(posicao) == null) && this.posicao < this.listaDuplamenteEncadeada.tamanho ) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		return this.listaDuplamenteEncadeada.obter(posicao++);
	}

}

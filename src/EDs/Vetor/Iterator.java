package EDs.Vetor;

public class Iterator<Tipo> implements java.util.Iterator<Tipo> {
		
	private int posicao;
	private Vetor<Tipo> vetor;
	
	public Iterator(Vetor<Tipo> vetor){
		this.vetor = vetor;
	}
	
	@Override
	public boolean hasNext() {
		if ( this.vetor.obter(posicao) != null && this.posicao <= this.vetor.tamanho()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Tipo next() {
		if (hasNext()) {
			return this.vetor.obter(posicao++);
		}
		return null;
	}
	
}

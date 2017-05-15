package benchmark.Iterators;

import java.util.Iterator;


public class VetorIterator<T> implements Iterator<T> {

	int counter = 0;
	int size;
	T[] entities;
	
	public VetorIterator(T[] entities, int size){
		this.entities = entities;
		this.size = size;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return counter < size;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		T entity = entities[counter];
		counter++;
		return entity;
	}

}

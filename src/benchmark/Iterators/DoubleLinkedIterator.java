package benchmark.Iterators;

import java.util.Iterator;

import benchmark.Lists.NoDoubleLinked;

public class DoubleLinkedIterator<T>  implements Iterator<T> {

	NoDoubleLinked<T> no;
	
	public DoubleLinkedIterator(NoDoubleLinked<T> first) {
		// TODO Auto-generated constructor stub
		no = first;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub	
		return no != null;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> newNo = no;
		no = no.next;
		
		return newNo.entity;
	}

}

package benchmark.Iterators;



import java.util.Iterator;

import benchmark.Lists.NoSimplyLinked;

public class SimplyLinkedIterator<T> implements Iterator<T> {

	NoSimplyLinked<T> no;
	
	public SimplyLinkedIterator(NoSimplyLinked<T> first) {
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
		NoSimplyLinked<T> newNo = no;
		no = no.next;
		
		return newNo.entity;
	}

}

package benchmark.Lists;

import java.util.Iterator;

import benchmark.Interfaces.IList;
import benchmark.Iterators.SimplyLinkedIterator;

public class SimplyLinkedList<T> implements IList<T>, Iterable<T> {

	NoSimplyLinked<T> First, Last;
	private int counter;
	
	public SimplyLinkedList() {

		First = null;
		Last = null;
		counter = 0;
	}

		
	@Override
	public void Add(T entity) {
		// TODO Auto-generated method stub
		NoSimplyLinked<T> newNo = new NoSimplyLinked<T>();
		newNo.entity = entity;
		
		if (First == null){
			First = Last = newNo;
		} else {
			Last.next = newNo;
			Last = newNo;		
		}
		
		counter++;
	}

	@Override
	public void Add(int position, T entity) {
		// TODO Auto-generated method stub
		NoSimplyLinked<T> newNo = new NoSimplyLinked<T>();
		newNo.entity = entity;
		
		NoSimplyLinked<T> no = First;
		
		for (int i = 0; i < position-1; i++) {
			no = no.next;
		}
		
		newNo.next = no.next;
		no.next = newNo;
		
		counter++;
	}

	@Override
	public void AddFirst(T entity) {
		// TODO Auto-generated method stub
		NoSimplyLinked<T> newNo = new NoSimplyLinked<T>();
		newNo.entity = entity;
		
		newNo.next = First;	
		First = newNo;
		
		counter++;
	}

	@Override
	public void Remove(int position) {
		// TODO Auto-generated method stub
		NoSimplyLinked<T> no = First;
		
		for (int i = 0; i < position-1; i++) {
			no = no.next;
		}
		
		no.next = no.next.next;

		counter--;
	}

	@Override
	public void RemoveFirst() {
		// TODO Auto-generated method stub
		
		First = First.next;
		counter--;
	}

	@Override
	public void RemoveLast() {
		// TODO Auto-generated method stub
		NoSimplyLinked<T> no = First;
		
		for (int i = 0; i < Size()-2; i++) {
			no = no.next;
		}
		
		Last = no;
		no.next = null;	
		counter--;
	}

	@Override
	public int Size() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public void Clear() {
		// TODO Auto-generated method stub
		First = null;
		Last = null;
		counter = 0;
	}

	@Override
	public boolean Exists(T entity) {
		// TODO Auto-generated method stub\
		
		NoSimplyLinked<T> no = First;
		
		for (int i = 0; i < Size(); i++) {
			if (no.entity.equals(entity)){
				return true;
			}
			no = no.next;
		}
		
		return false;
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SimplyLinkedIterator<T>(First);
	}

	@Override
	public void RemoveEntity(T entity) {
		// TODO Auto-generated method stub
		NoSimplyLinked<T> no = First;
		
		if (First.equals(entity)){
			RemoveFirst();
		} else if (Last.equals(entity)){
			RemoveLast();
		}
		
		for (int i = 0; i < Size()-1; i++) {
			if (no.next.entity.equals(entity)){
				no.next = no.next.next;
				counter--;
				return;
			}
			no = no.next;
		}
		
	}


	@Override
	public T Get(int position) {
		// TODO Auto-generated method stub
		NoSimplyLinked<T> no = First;
		
		for (int i = 0; i < position; i++) {
			no = no.next;
		}
		
		return no.entity;
	}


	@Override
	public String toString() {
		String x = "";
		NoSimplyLinked<T> no = First;
		for (int i = 0; i < Size(); i++) {
			x += no.entity + ", ";
			
			no = no.next;
		}
		
		return "[" + x + "]";
	}
	
	

}

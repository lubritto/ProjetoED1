package benchmark.Listas;

import java.util.Iterator;

import benchmark.Interfaces.IList;
import benchmark.Iterators.DoubleLinkedIterator;

public class DoubleLinkedList<T> implements IList<T>, Iterable<T>
{
	NoDoubleLinked<T> First, Last;
	private int counter;
	
	public DoubleLinkedList() {
		// TODO Auto-generated constructor stub
		First = null;
		Last = null;
		counter = 0;
		
	}

	@Override
	public void Add(T entity) {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> newNo = new NoDoubleLinked<T>();
		newNo.entity = entity;
		
		if (First == null){
			First = Last = newNo;
		} else {
			Last.next = newNo;
			newNo.back = Last;
			Last = newNo;
		}
		
		counter++;
	}

	@Override
	public void Add(int position, T entity) {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> newNo = new NoDoubleLinked<T>();
		newNo.entity = entity;
		
		NoDoubleLinked<T> no;
		
		if (position > Size()/2){
			no = Last;
			
			for (int i = Size(); i > position; i--) {
				no = no.back;
			}
			
			newNo.next = no.next;
			newNo.back = no;
			no.next = newNo;
			
		} else {			
			no = First;
			
			for (int i = 0; i < position-1; i++) {
				no = no.next;
			}
			
			newNo.next = no.next;
			newNo.back = no;
			no.next = newNo;		
		}
		
		counter++;
	}

	@Override
	public void AddFirst(T entity) {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> newNo = new NoDoubleLinked<T>();
		newNo.entity = entity;
		
		newNo.next = First;	
		First.back = newNo;
		First = newNo;
		
		counter++;
	}

	@Override
	public void Remove(int position) {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> no;
		
		if (position > Size()/2){
			no = Last;
			
			for (int i = Size(); i > position; i--) {
				no = no.back;
			}
			
			no.next = no.next.next;
			no.next.back = no;
			
		} else {
			no = First;
			
			for (int i = 0; i < position-1; i++) {
				no = no.next;
			}
			
			no.next = no.next.next;
			no.next.back = no;
			
		}
		
		
		counter--;
	}

	@Override
	public void RemoveFirst() {
		// TODO Auto-generated method stub
		First = First.next;
		First.back = null;
		counter--;
	}

	@Override
	public void RemoveLast() {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> no = Last.back;
		
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
		
		NoDoubleLinked<T> no = First;
		
		for (int i = 0; i < Size(); i++) {
			if (no.entity.equals(entity)){
				return true;
			}
			no = no.next;
		}
		
		return false;
	}

	@Override
	public void Remove(T entity) {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> no = First;
		
		if (First.equals(entity)){
			RemoveFirst();
		} else if (Last.equals(entity)){
			RemoveLast();
		}
		
		for (int i = 0; i < Size()-1; i++) {
			if (no.entity.equals(entity)){
				no.back.next = no.next;
				no.next.back = no;
				counter--;
				return;
			}
			no = no.next;
		}
	}

	@Override
	public T Get(int position) {
		// TODO Auto-generated method stub
		NoDoubleLinked<T> no = First;
		
		for (int i = 0; i < position; i++) {
			no = no.next;
		}
		
		return no.entity;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DoubleLinkedIterator<T>(First);
	}

	@Override
	public String toString() {
		String x = "";
		NoDoubleLinked<T> no = First;
		for (int i = 0; i < Size(); i++) {
			x += no.entity + ", ";
			
			no = no.next;
		}
		
		return "[" + x + "]";
	}
}

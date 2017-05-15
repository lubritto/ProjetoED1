package benchmark.Lists;

import java.util.Iterator;

import benchmark.Interfaces.IList;
import benchmark.Iterators.VetorIterator;

@SuppressWarnings("unchecked")
public class Vetor<T> implements IList<T>, Iterable<T> {

	public Vetor(){
		this.entities = (T[]) new Object[5];
	}
	
	public Vetor(int size) {
		this.entities = (T[]) new Object[size];
	}

	private int counter;
	private T[] entities;
	
	public void CheckResize(){
		if (counter < Length()){
			return;
		}
		
		T[] newList = (T[]) new Object[Length() + 5];
		
		for (int i = 0; i < Length(); i++) {
			newList[i] = entities[i];
		}
		
		entities = newList;
	}

	@Override
	public void Add(T entity) {
		// TODO Auto-generated method stub
		CheckResize();		
		entities[counter] = entity;
		counter++;
	}

	@Override
	public void Add(int position, T entity) {
		// TODO Auto-generated method stub
		CheckResize();	
		T element = null;
		
		for (int i = 0; i < Size()+1; i++) {
			if (i == position){
				element = entities[i];
				entities[i] = entity;
			} else if (i > position){
				entity = element;
				element = entities[i];
				entities[i] = entity;
			}		
		}
		counter++;
	}

	@Override
	public void AddFirst(T entity) {
		// TODO Auto-generated method stub
		T[] newList = (T[]) new Object[Length()];

		if (counter >= Length()){
			newList = (T[]) new Object[Length() + 5];
		}
			
		newList[0] = entity;
			
		for (int i = 0; i < Length()-1; i++) {
			newList[i+1] = entities[i];
		}
		
		entities = newList;
		counter++;
	}

	@Override
	public void Remove(int position) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Size(); i++) {
			if (i >= position){
				entities[i] = entities[i+1];
			}
		}	
		counter--;
	}

	@Override
	public void RemoveFirst() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Size(); i++) {
			entities[i] = entities[i+1];
		}	
		counter--;
	}

	@Override
	public void RemoveLast() {
		// TODO Auto-generated method stub
		counter--;
		entities[Size()] = null;
	}

	@Override
	public int Size() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public void Clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Size(); i++) {
			entities[i] = null;
		}
		counter = 0;
	}

	@Override
	public boolean Exists(T entity) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < Size(); i++) {
			if (entities[i].equals(entity))
				return true;
		}
		
		return false;
	}
	
	public int Length(){
		return entities.length;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new VetorIterator<T>(entities, Size());
	}
	
	@Override
	public void Remove(T entity) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < Size(); i++) {
			if (entities[i].equals(entity))
				Remove(i);
		}
	}

	@Override
	public T Get(int position) {
		// TODO Auto-generated method stub
		return entities[position];
	}
}

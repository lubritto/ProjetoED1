package benchmark.Interfaces;

public interface IList<T> {
	public void Add(T entity);
	public void Add(int position, T entity);
	public void AddFirst(T entity);
	
	public void Remove(int position);
	public void RemoveFirst();
	public void RemoveLast();
	public void Remove(T entity);
	
	public T Get(int position);
	
	public int Size();
	public void Clear();
	public boolean Exists(T entity);

}

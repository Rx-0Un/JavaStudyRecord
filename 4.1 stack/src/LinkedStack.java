
public class LinkedStack<T> implements Stack<T>
{
	private SinglyList<T> list;
	public boolean isEmpty()
	{
		return this.list.IsEmpty();
	}
	public LinkedStack()
	{
		this.list=new SinglyList<T>();
	}
	public void push(T x)
	{
		this.list.insert(0,x);
	}
	public T peek()
	{
		return this.list.get(0);
	}
	public T pop()
	{
		return this.list.remove(0);
	}
	public int getsize()
	{
		return list.length();
	}
	
}

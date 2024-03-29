

public final class SeqStack<T>	implements Stack<T> 
{
	private SeqList<T> list;
	public SeqStack(int length)
	{
		this.list=new SeqList<T>(length);
	}
	public SeqStack()
	{
		this(64);
	}
	public boolean isEmpty()
	{
		return this.list.isEmpty();
	}
	public void push(T x)
	{
		this.list.insert(x);
	}
	public T peek()
	{
		return this.list.get(list.size()-1);
	}
	public T pop()
	{
		return list.remove(list.size()-1);
	}
	public void toBinary(int x)
	{	
		SeqStack<Integer> stack=new SeqStack<Integer>();
		while(x!=0&&x!=1)
		{
			stack.push(x%2);
			x=x/2;
		}
		stack.push(x);
		while(list.isEmpty()!=true)
			System.out.println(stack.pop());
	}
}

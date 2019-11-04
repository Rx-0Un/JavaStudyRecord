
public class DoubleNode<T> 
{
	public T data;
	public DoubleNode<T> pres,next;
	public DoubleNode(T data,DoubleNode<T>pres,DoubleNode<T> next)
	{
		this.data=data;
		this.pres=pres;
		this.next=next;
	}
	public DoubleNode(T data)
	{
		this(data,null,null);
	}
	public DoubleNode()
	{
		this(null,null,null);
	}
	public String toString()
	{
		return this.data.toString();
	}
}

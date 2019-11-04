
public final class LinkedQueue<T> implements Queue<T> 
{
	private Node<T> front,rear;
	public LinkedQueue()
	{
		this.front=this.rear=null;
	}
	public boolean isEmpty()
	{
		return this.front==null&& this.rear==null;
	}
	public boolean add(T x)
	{
		if(x==null)
			return false;
		Node<T> q=new Node<T>(x,null);
		if(this.front==null)
			this.front=q;
		else 
			this.rear.next=q;
		this.rear=q;
		return true;
	}
	public T peek()
	{
		return this.isEmpty()?null:this.front.data;
	}
	public T poll()
	{
		if(isEmpty())
			return null;
		T x=this.front.data;
		this.front=this.front.next;
		if(this.front==null)
			this.rear=null;
		return x;
	}
	public LinkedQueue(T[] levellist) 
	{
		this();
		for(int i=0;i<levellist.length;i++)
		{
			this.add(levellist[i]);
		}
	}
	public void main(String[] arg)
	{
		String[] prelist={"A","B","C","D","E","F","G","H"};
		LinkedQueue<T> que=new LinkedQueue<T>();
//		for(int i=0;i<prelist.length;i++)
//		{	
//			que.add(prelist[i]);
//		}
		System.out.print(que.poll());
	}
}

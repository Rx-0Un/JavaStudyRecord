
public class CirDoublyList<T> 
{
	public DoubleNode<T> head;
	public CirDoublyList( )
	{
		this.head=new DoubleNode<T>();
		this.head.pres=this.head;
		this.head.next=this.head;
	}
	public CirDoublyList(T[] values)
	{
		this();		
		for(int i=0;i<values.length;i++)
		{
			insert(values[i]);
		}
	}
	public CirDoublyList(CirDoublyList<T> list)
	{
		this();                                           
	    
	    for (DoubleNode<T> p=list.head.next; p!=list.head; p=p.next) 
	    {    
	    	this.insert(p.data);               
	    }
	}
	public boolean isEmpty()
	{
		return this.head.next==this.head;
	}
	public int size()
	{
		if(this.isEmpty())
			return 0;
		int i=0;
		for(DoubleNode<T> p=this.head.next;p!=this.head;p=p.next)
		{	
			i++;
		}
		return i;
	}
	public T get(int i)
	{
		if(this.isEmpty())
			return null;
		DoubleNode<T> p=this.head.next;
		for(int j=0;j<i&&p!=this.head;j++)
		{
			p=p.next;
			if(j==i)
				return p.data;
		}
		return null;
	}
	public void set(int i,T x)
	{
		DoubleNode<T> p=this.head.next;
		for(int j=0;j<i&&p!=this.head;j++)
		{	if(j==i)
				p.data=x;
			p=p.next;
		}		
	}
	public DoubleNode<T> insert(int i,T x)
	{
		if(x==null)
		{
			throw new NullPointerException("x==null");
		}
		DoubleNode<T> front=this.head;
		for(int j=0;front.next!=this.head&&j<i;j++)
		{
			front=front.next;
		}
		DoubleNode<T> q=new DoubleNode<T>(x,front,front.next);
		front.next.pres=q;
		front.next=q;
		return q;
	}
	public DoubleNode<T> insert(T x)
	{
		if(x==null)
			throw new NullPointerException("x==null");
		DoubleNode<T> q=new DoubleNode<T>(x,head.pres,head);
		head.pres.next=q;
		head.pres=q;
		return q;
	}
	public String toPreviousString()
	{
		 String str=this.getClass().getName()+"{";
		 for(DoubleNode<T>p=this.head.pres;p!=this.head;p=p.pres)
		 {
			 str+=p.data.toString();
			 if(p.pres!=null)
				 str+=",";
		 }
		 return str+"}";
	}
	public String toString()
	{
	 String str=this.getClass().getName()+"{";
	 for(DoubleNode<T>p=this.head.next;p!=this.head;p=p.next)
	 {
		 str+=p.data.toString();
		 if(p.next!=null)
			 str+=",";
	 }
	 return str+"}";
	}	
}


public class DoublyList<T extends Comparable<?super T>> extends Object 
{
	public DoubleNode<T> head;
	public DoublyList()
	{
		this.head=new DoubleNode<T>();
		this.head.next=null;
		this.head.pres=null;
	}
	public int length()
	{
		int x=0;
		DoubleNode<T> p=this.head;
		while(p!=null)
		{
			p=p.next;
			x++;
		}
		return x;
	}
	public DoublyList(T[] values)
	{
	 this();
	 DoubleNode<T>rear=this.head;
	 for(int i=0;i<values.length;i++)
	 {	 
		 rear.next=new DoubleNode<T>(values[i],rear,null);
		 rear=rear.next;
	 }
	}
	public DoublyList(DoublyList<T> list)
	{
		this();                                           
	    DoubleNode<T> rear=this.head;
	    for (DoubleNode<T> p=list.head.next;  p!=null;  p=p.next) 
	    {   rear.next = new DoubleNode<T>(p.data, null,null);
	         rear = rear.next;                  
	    }
	}
	public DoubleNode<T> insert(T x,DoubleNode<T> p)
	{
		DoubleNode<T> q=new DoubleNode<T>(x,p.pres,p);
		p.pres.next=q;
		p.pres=q;
		return p;
	}
	public String toString()
	 {
		 String str=this.getClass().getName()+"{";
		 for(DoubleNode<T>p=this.head.next;p!=null;p=p.next)
		 {
			 str+=p.data.toString();
			 if(p.next!=null)
				 str+=",";
		 }
		 return str+")";
	 }
	public DoubleNode<T> remove(T x)
	{
		DoubleNode<T>p=this.head;
		for(int i=0;p.next!=null;i++)
		{	
			p=p.next;
			if(x.compareTo(p.data)==0)
			{
				p.pres.next=p.next;
				if(p.next!=null)
					p.next.pres=p.pres;
			}	
		 }
		 return null;
	}
	
}

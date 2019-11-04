
public class SinglyList<T> extends Object
{
	public Node<T> head;
	public SinglyList()
 {
	 this.head=new Node<T>();
 }
	public SinglyList(T[] values)
 {
	 this();
	 Node<T>rear=this.head;
	 for(int i=0;i<values.length;i++)
	 {	
		 rear.next=new Node<T>(values[i],null);
		 rear=rear.next;
	 }
 }
	public SinglyList(SinglyList<T> list)
	{
		this();                                           
	    Node<T> rear=this.head;
	    for (Node<T> p=list.head.next;  p!=null;  p=p.next) 
	    {   rear.next = new Node<T>(p.data, null);
	         rear = rear.next;                  
	    }
	} 
	public boolean IsEmpty()
	{
		return  this.head.next==null;
	}
	public T get(int i)
	 {
		 Node<T>p=this.head.next;
		 for(int j=0;p!=null&&j<i;j++)
				 p=p.next;
		 return (i>=0&&p!=null)?p.data:null;
	 }
	public String toString()
	 {
		 String str=this.getClass().getName()+"{";
		 for(Node<T>p=this.head.next;p!=null;p=p.next)
		 {
			 str+=p.data.toString();
			 if(p.next!=null)
			 str+=",";
		 }
		 return str+"}";
	 }
	public Node<T> insert(int i,T x)

	 {
		 if(x==null)
			 throw new NullPointerException("x==null");
		 Node<T>front=this.head;
		 for(int j=0;front.next!=null&&j<i;j++)
			 front=front.next;
		 front.next=new Node<T>(x,front.next);
		 return front.next;
	 }
	public	Node<T> insert(T x)
	 {
		 return insert(Integer.MAX_VALUE,x);
	 }
	public T remove(int i)
	 {
		 Node<T>front=this.head;
		 for(int j=0; front.next!=null && j<i; j++)
			 front=front.next;
		 if(i>=0&&front.next !=null)
		 {
			 T old=front.next.data;
			 front.next=front.next.next;
			 return old;
		 }
		 return null;	 
	 }
	public void clear()
	 {
		 this.head.next=null;
	 }
	public Node<T> Search(T key)
	 {
		 Node<T> p=this.head;
		 while(p!=null)
		 { 
			 
			 if(key.equals(p.data))
				 return p;
			p=p.next;
		 }
		 return null;	 
	 }
	public int iSearch(T key)
	{	
		int i=0;
		 Node<T> p=this.head;
		 for(i=0;p!=null;i++)
		 { 
			 
			 if(key.equals(p.data))
				 return i;
			p=p.next;
		 }
		 return -1;
	}
	public boolean contain(T key)
	 {
		 if(Search(key)!=null)
			 return true;
		 return false;
	 }
	public Node<T> insertDifferent(T x)
	 {	
		if(Search(x)!=null)
			return null;
		insert(x);
		return Search(x);
	 }
	public T remove(T key)

	 {
		 Node<T>p=this.head;
		 for(int i=0;p!=null;i++)
		 {	
			 p=p.next;
			 if(Search(key)!=null)
			 {
				 return remove(i);
			 }	
		 }
		 return null;
	 }
	public void concat(SinglyList<T> list)
	 {
	     Node<T> rear=this.head;
	     while (rear.next!=null) 
	             rear = rear.next;
	     rear.next = list.head.next;
	     list.head.next=null;
	 }
	public void concat(int i,SinglyList<T> list)
	{	
		Node<T> rear=list.head;
		Node<T> p=this.head;
		while(rear.next!=null)
			rear=rear.next;
		for(int j=0;j<i;j++)
		{	p=p.next;
			if(p.next==null)
				break;
		}
		rear.next=p.next;
		p.next=list.head.next;
	}
	public int length()
	{
		int x=0;
		Node<T> p=this.head;
		while(p!=null)
		{
			p=p.next;
			x++;
		}
		return x;
	}
	boolean addAll(int i,SinglyList<T>list)
	{
		if(i>list.length())
		{	this.concat(list);
			return false;
		}
		if(i<0)
		{	list.concat(this);
			return false;
		}
		this.concat(i, list);
		return true;
	}
	public SinglyList subList(int i, int n)
	{
		Node<T> p=this.head;
		SinglyList <T> list=new SinglyList<T>();
		for(int j=0; j<i+n&&p!=null;j++)
		{
			p=p.next;
		while(j>i&&j<i+n)
		{
			p.data=(T)list.head.next;
			list.head=list.head.next;
		}
			
		}
		return list;
	}
}
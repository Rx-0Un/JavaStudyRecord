
public class SortedSinglyListNO <T extends Comparable<?super T> >extends SinglyList<T>
{
	private	boolean asc;
	public SortedSinglyListNO()
	{
		super();
		this.asc=true;
	}
	public SortedSinglyListNO(boolean asc)
	{
		super();
		this.asc=asc;
	}
	public SortedSinglyListNO(T[] values)
	{	
		super();
		this.asc=true;
		for(int j=0;j<values.length;j++)
		{
			this.insert(values[j]);
		}
	}
	public SortedSinglyListNO(SortedSinglyList<T> list)
	{
		super(list);
		this.asc=true;
	}
	public SortedSinglyListNO(SinglyList<T> list)
	{	
		super();
		this.asc=true;
		for(Node<T>p=list.head.next; p!=null;p=p.next)
			this.insert(p.data);
	}
	public void set(int i,T x)
	{
		throw new java.lang.UnsupportedOperationException("set(int i,T x)");
	}	
	public Node<T> insert(int i,T x)
	{
		throw new UnsupportedOperationException("insert(int i,T x)");
	}
	public Node<T> insert(T x)
	{	
		Node<T>front=this.head,p=front.next;
		while(p!=null&&(x.compareTo(p.data)>0&&this.asc||x.compareTo(p.data)<0&&!this.asc))
		{
			front=p;
			p=p.next;
		}
		front.next=new Node<T>(x,p);
		return front.next;
	}
	public Node<T> Search(T key)
	{
		Node<T> p=this.head;
		while(p!=null&&key.compareTo(p.data)>0)
		{
			p=p.next;
			if(p.data==key)
				return p;
		}
		return null;
	}
	public Node<T> insertDifferent(T x)
	{
		
		if(Search(x)!=null)
			return null;
		else insert(x);
		return null;
	}
	public T remove(T key)
	{
		Node<T> p=this.head;
		if(key!=null)
		{
			while(key.compareTo(p.data)>0)
			{
				p=p.next;
				if(key.compareTo(p.data)==0)
				{
					p.data=null;
					return	key;
				}
			}
		}
		return null;
	}
	SortedSinglyListNO(SinglyList<T> list, boolean asc)
	{
		this.asc=asc;
		Node<T> p=list.head;
		while(p!=null)
		{
			p=p.next;
			this.insert(p.data);
		}
	}
}
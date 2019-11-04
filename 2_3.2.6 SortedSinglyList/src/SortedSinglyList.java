
public class SortedSinglyList<T extends Comparable<?super T> >extends SinglyList<T>
{
	public SortedSinglyList()
	{
		super();
	}
	public SortedSinglyList(T[] values)
	{
		super();
		for(int j=0;j<values.length;j++)
		{
			this.insert(values[j]);
		}
	}
	public SortedSinglyList(SortedSinglyList<T> list)
	{
		super(list);
	}
	public SortedSinglyList(SinglyList<T> list)
	{	
		super();
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
		while(p!=null&&x.compareTo(p.data)>0)
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

}

@SuppressWarnings("hiding")
public class PolySinglyList<T extends Comparable<? super T>&Addible<T>> extends SortedSinglyList<T> 
{
	public PolySinglyList()
	{
		super();
	}
	public PolySinglyList(T terms[])
	{
		this();
		for(int i=0;i<terms.length;i++)
			this.insert(terms[i]);
	}
	public PolySinglyList(PolySinglyList<T> list)
	{
		this();
		Node<T> p=list.head.next;
		while(p!=null)
		{	
			this.insert(p.data);
			p=p.next;
		}
	}
	public void addAll(PolySinglyList<T> list)
	{
		Node<T> q=list.head.next;
		Node<T> p=this.head.next;
		while(q!=null&&p!=null)
		{
			if(p.data.compareTo(q.data)==0)
				p.data.add(q.data);
//			else if(p==null&&q!=null)
//					this.insert(q.data);
			if(p.data.compareTo(q.data)>0&&p!=null)
				q=q.next;
			if(p.data.compareTo(q.data)<0&&q!=null)
				p=p.next;
		}
	}
	public static void main(String[] args)
	{
		
	}
}

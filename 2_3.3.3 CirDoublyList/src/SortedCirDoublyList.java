
public class SortedCirDoublyList<T extends Comparable<? super T>> extends CirDoublyList<T>
{
	public SortedCirDoublyList()
	{
		super();
	}
	public SortedCirDoublyList(T[] values)
	{
		this();		
		for(int i=0;i<values.length;i++)
		{
			insert(values[i]);
		}
	}
	public SortedCirDoublyList(SortedCirDoublyList<T> list)
	{
		
	}
	public DoubleNode<T> insert(T x)
	{
		if(this.isEmpty()||x.compareTo(this.head.pres.data)>0)
			return super.insert(x);
		DoubleNode<T> p=this.head.next;
		while(p!=head&&x.compareTo(x)>0)
			p=p.next;
		DoubleNode<T> q=new DoubleNode<T>(x,p.pres,p);
		p.pres.next=q;
		p.pres=q;
		return q;
	}
}

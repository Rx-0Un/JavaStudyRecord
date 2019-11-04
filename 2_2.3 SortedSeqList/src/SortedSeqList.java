
public class SortedSeqList<T extends Comparable<?super T>> extends SeqList<T> 
{
	public SortedSeqList()
	{
		super();
	}
	public SortedSeqList(int length)
	{
		super(length);
	}
	public SortedSeqList(T[] values)
	{
		super(values.length);
		for(int i=0;i<values.length;i++)
		{
			this.insert(values[i]);
		}
	}
	public int insert(T x)
	{
		int i=0;
		if(this.isEmpty()||x.compareTo(this.get(this.size()))>0)
			i=this.n;
		else
			while(i<this.n&&x.compareTo(this.get(i))>0)
				i++;
		super.insert(i,x);
		return i;
	}
	public void set(int i,T x)
	{
		throw new java.lang.UnsupportedOperationException("set(int i,T x)");
	}
	public int insert(int i,T x)
	{
		throw new UnsupportedOperationException("set(int i,T x)");
	}
	public int search(T key)
	{
		for(int i=0;i<this.n&&key.compareTo(this.get(i))>=0;i++)
			if(key.compareTo(this.get(i))==0)
				return i;
		return -1;
	}
	public SortedSeqList(SeqList<?extends T>list)
	{
		super();
		for(int i=0;i<list.n;i++)
			this.insert(list.get(i));
	}
}

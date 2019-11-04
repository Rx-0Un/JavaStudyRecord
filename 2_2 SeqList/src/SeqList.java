
public class SeqList<T> extends Object
{
	protected Object[] element;
	protected int n;
	public SeqList(int length)
	{
		this.element=new Object[length];
		this.n=0;
	}
	public SeqList()
	{ 
		this(64);
	}
	public SeqList(T[] values)
	{
		this(values.length);
		for(int i=0;i<values.length;i++)
			this.element[i]=values[i];
		this.n=element.length;
	}
	public boolean isEmpty()
	{
		return this.n==0;
	}
	public int size()
	{
		return this.n;
	}
	public T get (int i)
	{
		if(i>=0&&i<this.n)
			return(T)this.element;
		return null;
	}
	public void set(int i,T x)
	{
		if(x==null)
			throw new NullPointerException("x==null");
		if(i>=0&&i<this.n)
			this.element[i]=x;
		else throw new java.lang.IndexOutOfBoundsException(i+"");
		
	}
	public String toString()
	{
		String str=this.getClass().getName()+"(";
		if(this.n>0)
			str+=this.element[0].toString();
		for(int i=1;i<this.n;i++)
			str+=","+this.element[i].toString();
		return str+")";
	}
	public int insert(int i,T x)
	{
		if(x==null)
			throw new NullPointerException("x==null");
		if(i<0) i=0;
		if(i>this.n) i=this.n;
		Object[] source=this.element;
		if(this.n==element.length)
		{
			this.element=new Object[source.length*2];
			for(int j=0;j<i;j++)
			this.element[j]=source[j];
		}
		for(int j=this.n-1;j>=i;j--)
			this.element[j+1]=source[j];
		this.element[i]=x;
		this.n++;
		return i;
	}
	public T remove(int i)
	{
		if(this.n>0&&i>=0&&i<this.n)
		{
			T old= (T)this.element[i];
			for(int j=i;j<this.n-1;j++)
				this.element[j]=this.element[j+1];
			this.element[this.n-1]=null;
			this.n--;
			return old;
		}
		return null;
	}
	public void clear()
	{
		this.n=0;
	}
	public int  Search(T key)
	{
		for(int i=0;i<this.n;i++)
			if(key.equals(this.element[i]))
				return i;
		return -1;	
	}
	public int insertDifferent(T x) //插入不重复元素
	{
		if(Search(x)!=-1)
			{insert(this.Search(x),x);
				return 1;
			}
		else
			{
				insert(this.n,x);
				return -1;
			}
	}
	public T remove(T key)

	{
		if(Search(key)!=-1)
		{
			remove(Search(key));
			return key;
		}
		return null;
	}
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj instanceof SeqList<?>)
		{	
			SeqList<T>list=(SeqList<T>)obj;
			if(this.n==list.n)
			{
				for(int i=0;i<this.n;i++)
					if(!(this.get(i).equals(list.get(i))))
						return false;
				return true;
			}
		}
		return false;
	}
	void removeAll(T key)
	{	
		for(int i=0;i<this.n;i++)
		{
			if(Search(key)!=-1)
			{	int j=0;
				this.element[Search(key)]=this.element[j+1];
			}
		}
	}
	void replaceFirst(T key,T x)
	{
		if(Search(key)!=-1)
			remove(Search(key));
			insert(Search(key),x);
	}
	void replaceAll(T key,T x)
	{
		for(int i=0;i<this.n;i++)
		{
			if(Search(key)!=-1)
				remove(Search(key));
				insert(Search(key),x);
		}
	}
	void searchLast(T key)
	{	int j=0;
		for(int i=0;i<this.n;i++)
		{
			if(Search(key)!=-1)
				j=Search(key);
		}
		System.out.println(this.element[j]);
	}
	void removeLast(T key)
	{
		int j=0;
		for(int i=0;i<this.n;i++)
		{
			if(Search(key)!=-1)
				j=Search(key);
		}
		remove(j);
	}
	void replaceLast(T key,T x)
	{
		int j=0;
		for(int i=0;i<this.n;i++)
		{
			if(Search(key)!=-1)
				j=Search(key);
		}
		remove(j);
		insert(j, x);
	}
	public int insert(T x) 
	{	
		return this.insert(this.n,x);
	}
}

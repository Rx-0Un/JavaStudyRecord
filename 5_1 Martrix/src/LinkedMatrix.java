
public class LinkedMatrix 
{
	private int rows,colomns;
	SeqList<PolySinglyList<Triple>> rowlist;
	public LinkedMatrix(int m,int n)
	{
		if(m>0&&n>0)
		{
			this.rows=m;
			this.colomns=n;
			this.rowlist=new SeqList<PolySinglyList<Triple>>();
			for(int i=0;i<m;i++)
			{
				this.rowlist=new SeqList<PolySinglyList<Triple>>();	
			}
		}
		else throw new IllegalArgumentException("矩阵行列数不能<=0,m="+m+",n="+n);
	}
	public LinkedMatrix(int m)
	{
		this(m,m);
	}
	public LinkedMatrix(int m,int n,Triple[] tris)
	{
		this(m,n);
		for(int i=0;i<tris.length;i++)
		{
			this.set(tris[i]);
		}
	}
	private void set(Triple tri) 
	{
		int i=tri.row,j=colomns;
		if(i>=0&&i<this.rows&&i>=0&&j<this.colomns)
		{
			SortedSinglyList<Triple> link=this.rowlist.get(i);
			if(tri.value==0)
				link.remove(tri);
			else 
			{
				Node<Triple> find=link.Search(tri);
				if(find!=null)
					find.data.value=tri.value;
				else link.insert(tri);
			}
		}
		else throw new IndexOutOfBoundsException("i="+i+",j="+j);	
	}
	public void set(int i,int j,int x)
	{
		this.set(new Triple(i,j,x));
	}
	public int getRows()
	{
		return rows;
	}
	public int getColumns()
	{
		return colomns;
	}
}

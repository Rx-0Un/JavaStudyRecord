
public class Triple implements Comparable<Triple>,Addible<Triple>
{
	int row;
	int columm;
	int value;
	public Triple(int row,int comlum,int value)
	{
		this.row=row;
		this.columm=comlum;
		this.value=value;
	}
	public Triple()
	{
		this(0,0,0);
	}
	public Triple(Triple p)
	{
		this(p.row,p.columm,p.value);
	}
	public String toString()
	{
		return "("+row+","+columm+","+value+")";
	}
	public int compareTo(Triple tri)
	{
		if(this.row==tri.row&&this.columm==tri.columm)
			return 0;
		return (this.row<tri.row||this.row==tri.row)&&this.columm<tri.columm?-1:1;
	}
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		Triple t=new Triple();
//		if(obj instanceof Triple)
//			Triple t=(Triple) obj;
//			return t.row.equals(this.row)||t.colomm.equals(this.colomm);
		return false;
	}
	public void add(Triple term)
	{
		if(this.compareTo(term)==0)
			this.value+=term.value;
		else
			throw new IllegalArgumentException("两项的指数不同,不能相加.");
	}
	public boolean removable()
	{
		return this.value==0;
	}
	public Triple toSymmetry()
	{
		return new Triple(this.columm,this.row,this.value);
	}
	
}

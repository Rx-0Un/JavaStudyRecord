
public class MyStringBuffer implements java.io.Serializable
{
	private char[] value;
	private int n;
	public MyStringBuffer(int capacity)
	{
		this.value=new char[capacity];
		this.n=0;
	}
	public MyStringBuffer()
	{
		this(16);
	}
	public MyStringBuffer(String str)
	{
		this(str.length()+16);
		this.n=str.length();
		for(int i=0;i<this.n;i++)
			this.value[i]=str.charAt(i);
		
	}
	public int length()
	{
		return this.n;
	}
	public int capacity()
	{return this.value.length;
	}
	public synchronized String ToString()
	{
		return new String(this.value,0,this.n);
	}
	public synchronized char charAt(int i)
	{
		return this.value[i];
	}
	public void setCharAt(int i,char ch)
	{
		this.value[i]=ch;
	}
	public synchronized MyStringBuffer insert(int i, String str)
	{
		if(this.n==0&&i==0||this.n>0&&i>=0&&i<=this.n)
		{
			if(str==null)
				str="null";
			char[] temp=this.value;
			if(this.value.length<this.n+str.length())
			{	
				this.value=new char[(this.value.length+str.length())*2];
				for(int j=0;j<i;j++)	
					this.value[j]=temp[j];
			}
			for(int j=this.n-1;j>=i;j--)
				this.value[j+str.length()]=temp[j];
			for(int j=0;j<str.length();j++)
				this.value[i+j]=str.charAt(j);
			this.n+=str.length();
			return this;
		}
		else throw new StringIndexOutOfBoundsException("i="+i);
	}
	public synchronized MyStringBuffer insert(int i,MyStringBuffer shuf)
	{
		if(this.n==0&&i==0||this.n>0&&i>=0&&i<=this.n)
		{
			if(shuf==null)
				shuf=new MyStringBuffer("null");
			char[] temp=this.value;
			if(this.value.length<this.n+shuf.length())
			{	
				this.value=new char[(this.value.length+shuf.length())*2];
				for(int j=0;j<i;j++)	
					this.value[j]=temp[j];
			}
			for(int j=this.n-1;j>=i;j--)
				this.value[j+shuf.length()]=temp[j];
			for(int j=0;j<shuf.length();j++)
				this.value[i+j]=shuf.charAt(j);
			this.n+=shuf.length();
			return this;
		}
		else throw new StringIndexOutOfBoundsException("i="+i);
	}
	public synchronized MyStringBuffer insert(int i,boolean b)
	{
		return this.insert(i, b?"ture":"false");
	}
	public synchronized MyStringBuffer append(String str)
	{
		return this.insert(this.n, str);
	}
	public synchronized MyStringBuffer delect(int begin,int end)
	{
		if(begin>=0&&begin<this.n&&end>=0&&begin<=end)
		{
			if(end>this.n)
				end=this.n;
			for(int i=0;i<this.n-end;i++)
				this.value[begin+1]=this.value[end+1];
			this.n=end-begin;
			return this;
		}
		else throw new StringIndexOutOfBoundsException("begin="+begin+",end="+end+",end-begin"+(end-begin));
	}
	public StringBuffer toUpperCase(StringBuffer s)
	{
		int i=0;
		while(i<s.length())
		{
			if(s.charAt(i)>'a'&&s.charAt(i)<'z')
				s.setCharAt(i, (char) (s.charAt(i)-('Z'-'A')));
			i++;
		}
		return s;
	}
	public StringBuffer toLowerCase(StringBuffer s)
	{
		int i=0;
		while(i<s.length())
		{
			if(s.charAt(i)>'A'&&s.charAt(i)<'Z')
				s.setCharAt(i, (char) (s.charAt(i)+('z'-'a')));
		}
		return s;
	}
	public StringBuffer trim(StringBuffer s)
	 {   
        StringBuffer buffer=new StringBuffer();   
        int i=0;   
        char currentChar;   
        char ch=' ';
        while(i<s.length())   
        {   
            currentChar=s.charAt(i++);   
            if(currentChar!=ch) 
            	buffer.append(currentChar); 
        }
        return s;
    } 
	public boolean equals(StringBuffer s1,StringBuffer s2)
	{
		
		for(int j=0,i=0;i<s1.length()&&j<s2.length();j++,i++)
		{
			if(i!=j&&s1.charAt(i)!=s2.charAt(j))
				return false;
		}
		return true;
	}
	public boolean equalsIgnoreCase(StringBuffer s1,StringBuffer s2)
	{
		int j=0,i=0;
		toUpperCase(s1);toUpperCase(s2);
		while(i<=s1.length()&&j<s2.length())
		{
			if(i!=j&&s1.charAt(i)!=s2.charAt(j))
				return false;
			j++;
			i++;    
		}	
		return true;
	}
	public int compareTo(StringBuffer s1,StringBuffer s2)
	{
		int i=0,j=0;
		while(i<s1.length()&&j<s2.length())
		{		
			if(i!=j)
				return i-j;
			else	if(s1.charAt(i)!=s2.charAt(j))
						return s1.charAt(i)-s2.charAt(j);
				
			i++;j++;
		}
		return 0;
	}
	public int compareToIgnoreCase(StringBuffer s1,StringBuffer s2)
	{
		toUpperCase(s1);toUpperCase(s2);
		return this.compareTo(s1, s2);
	}
}


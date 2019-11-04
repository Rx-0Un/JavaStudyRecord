
public class TermX implements Comparable<TermX>,Addible<TermX>
{
	protected int coef,xexp;
	public TermX()
	{
		this(0,0);
	}
	public TermX(int coef,int  xexp)
	{
		this.coef=coef;
		this.xexp=xexp;
	}
	public TermX(TermX term)
	{
		this.coef=term.coef;
		this.xexp=term.xexp;
	}
	public TermX(String termstr)
	{
		String str=new String();
		String str1=new String();
		for(int i=0;i<termstr.length();i++)
		{
			while(termstr.charAt(i)!='x')
			{	
				str+=termstr.charAt(i);
				i++;
			}
			i++;
			if(termstr.charAt(i)=='^')
			{
				i++;
				while(i<termstr.length())
				{	str1+=termstr.charAt(i);
					i++;
					
				}
			}
		}	
		if("-".equals(str))
			coef=-1;
		else if("".equals(str))
				coef=1;
			else
				coef=Integer.parseInt(str);
		if(str1.equals(""))
			xexp=0;
			else xexp=Integer.parseInt(str1);
	}
	public String toString()
	{
		return (coef==1?null:(coef==-1?'-':coef))+(xexp==0?"x":("x^"+xexp));
		 
	}
	public static void main(String[] args)
	{
		String str= "6x^25";
		TermX term=new TermX(str);
		System.out.println(term.toString());
	}
}

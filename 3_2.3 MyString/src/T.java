
public class T
{
	public static StringBuffer toUpperCase(StringBuffer s)
	{
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>'a'&&s.charAt(i)<'z')
				s.setCharAt(i, (char)(s.charAt(i)-('Z'-'A')));
		}
		return s;	
	}
	public  StringBuffer toLowerCase(StringBuffer s)
	{
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>'A'&&s.charAt(i)<'Z')
				s.setCharAt(i, (char)(s.charAt(i)+('z'-'a')));
		}
		return s;		
	}
	StringBuffer trim(StringBuffer s)
	{
		
		return s;
	}
}

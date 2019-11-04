
public class SinglyList_reveres 
{
	public static<T> SinglyList<T> createReverse(T[] values)
	{
		SinglyList<T> list=new SinglyList<T>(values);
		return list;
	}
	public static <T> void reverse(SinglyList<T> list)
	{
		Node<T> front=list.head,p=list.head.next;
		while(p.next!=null)
		{	front=p;
			p=p.next;
		}
	}
}

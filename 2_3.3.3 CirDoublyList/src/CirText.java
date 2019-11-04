
public class CirText 
{
	public static void main(String[] args)
	{
		Integer[] a= {1,2,5,6,6,8,4,7};
		CirDoublyList<Integer> list1=new CirDoublyList<Integer>(a);
		CirDoublyList<Integer> list2=new CirDoublyList<Integer>(list1);
//		System.out.println(list1.toPreviousString());
//		System.out.println(list1.toString());
//		System.out.println(list1.head.pres);
		System.out.println(list2.toString());
		System.out.println(list1.size());
	}

}


public class DoubleLinkedText 
{
	public static void main(String[] args)
	{
		Integer[] a= {1,2,5,6,6,8,4,7};
		DoublyList<Integer> list=new DoublyList<Integer>(a);
//		list.remove((Integer)1);
		DoublyList<Integer> list1=new DoublyList<Integer>(list);
		System.out.println(list1.toString());
		
	}
}

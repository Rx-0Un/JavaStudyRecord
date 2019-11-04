
public class Text {
	public static void main(String arg[])
	{Integer a[]={1,2,2,5,3,4};
	SinglyList<Integer> list=new SinglyList<Integer>(a);
	System.out.println(list.toString());
//	SortedSinglyListNO<Integer> list=new SortedSinglyListNO<Integer>(a);
	SortedSinglyListNO<Integer> NO=new SortedSinglyListNO<Integer>(list, true);
	//    list.remove(new Integer(3));
//	list.insertDifferent(new Integer(6));
//	SinglyList<Integer> list2=new SinglyList<Integer>(a);
	list.insert(5);
//	list.insert(5,6);
	System.out.println(NO.toString());
	}
}

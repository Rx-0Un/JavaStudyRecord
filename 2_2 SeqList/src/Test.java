public class Test 
{
    public static void main(String args[]){
        Integer a[]={1,2,2,5,3,4};
        SeqList<Integer> list=new SeqList<Integer>(a);
        System.out.println(list.toString());
       list.remove(new Integer(3));
//        SeqList<Integer> list1=new SeqList<Integer>(a);
//        list.addAll(list1);
        System.out.println(list.toString());
    }
}





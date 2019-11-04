
public class BinaryTrees 
{
	private static int i=0;
	public static BinaryTree<String> createByGenlist(String genlist)
	{
		BinaryTree<String> bitree=new BinaryTree<String>();
		i=0;
		if(genlist.length()>0)
			bitree.root=create(genlist);
		return bitree;
	}
	private static BinaryNode<String> create(String genlist)
	{
		BinaryNode<String> p=null;
		char ch=genlist.charAt(i);
		if(ch=='^')
		{
			i++;
			return null;
		}
		int end=i;
		while(end<genlist.length()&&ch!='('&&ch!=')')
		{
			end++;
			ch=genlist.charAt(end);
		}
		String str=genlist.substring(i,end);
		i=end;
		p=new BinaryNode<String> (str);
		if(genlist.charAt(i)=='(')
		{
			i++;
			p.left=create(genlist);
			i++;
			p.right=create(genlist);
			i++;
		}
		return p;
	}
//	public static void main(String args[])
//	{
//		String genlist="AA(BB(DD(^,G),^),C(E,F(H,^)))";
//		BinaryTree<String>bitree=BinaryTrees.createByGenlist(genlist);
//		bitree.printGenlist();
//	}
	
}
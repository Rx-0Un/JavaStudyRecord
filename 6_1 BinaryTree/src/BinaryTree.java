import java.util.Arrays;

public  class BinaryTree<T> 
{
	public BinaryNode<T>root;
	public BinaryTree(BinaryTree<T>  tree)
	{
		this();
//		this.root=copy(tree.root);
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        LinkedStack<BinaryNode<T>> stack1 = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p1 = tree.root;
        this.root=new BinaryNode<T>();
        BinaryNode<T> p2 = this.root;
        if(p1.left==null&&p1.right==null)
            p2.data = p1.data;
        else {
            while(p1!=null||!stack.isEmpty()) {
                if(p1!=null) {
                    p2.data = p1.data;
                    //结点入栈
                    stack1.push(p2);
                    stack.push(p1);
                    p1 = p1.left;
                    //p1结点不为空，构建新的结点
                    if (p1 != null) {
                        //p2左结点为新的结点
                        p2.left = new BinaryNode<T>();
                        //p2指向左结点
                        p2 = p2.left;
                    }
                }else {
                    //结点出栈
                    p1 = stack.pop();
                    //指向右结点
                    p1 = p1.right;
                    p2 = stack1.pop();
                    //p1结点不为空，则构建新结点
                    if(p1!=null){
                        p2.right = new BinaryNode<T>();
                        p2 = p2.right;
                    }
                }
            }
        }
	}
	private BinaryNode<T> copy(BinaryNode<T> q)
	{
		if(q!=null&&q.data!=null)
		{
			BinaryNode<T> p=new BinaryNode<T>();
			p=new BinaryNode<T>(q.data);
			p.left=copy(q.left);
			p.right=copy(q.right);
			return p;
		}
		return null;
	}
	public BinaryTree(T data)
	{
		this.root.data=data;
	}
	public BinaryTree()
	{
		this.root=null;
	}
	public boolean isEmpty()
	{
		return this.root==null;
	}
	public BinaryNode<T> insert(T x)
	{
		return this.root=new BinaryNode<T>(x,this.root,null);
	}
	public BinaryNode<T> insert(BinaryNode<T> parent ,T x,boolean leftChild)
	{
		if(x==null)
			return null;
		if(leftChild)
			return parent.left=new BinaryNode<T>(x,parent.left,null);
		return parent.right=new BinaryNode<T>(x,null,parent.right);
	}
	public void remove(BinaryNode<T>parent ,boolean leftchild)
	{
		if(leftchild)
			parent.left=null;
		else parent.right=null;
	}
	public void clear()
	{
		this.root=null;
	}
	public void perorder()
	{
		perorder(this.root);
		System.out.println();
	}
	public void perorder(BinaryNode<T> p)
	{
		if(p!=null)
		{
			System.out.print(p.data.toString()+" ");
			perorder(p.left);
			perorder(p.right);
		}
	}
	public String toString()
	{
		return toString(this.root);
	}
	private String toString(BinaryNode<T> p)
	{
		if(p==null)
			return "^ ";
		return p.data.toString()+" "+toString(p.left)+toString(p.right);
	}
	public void inorder()
	{
		inorder(this.root);
		System.out.println();
	}
	public void inorder(BinaryNode<T> p)
	{
		if(p!=null)
		{
			inorder(p.left);
			System.out.print(p.data.toString()+" ");
			inorder(p.right);
		}
	}
	public void postorder()
	{
		postorder(this.root);
		System.out.println();
	}
	public void postorder(BinaryNode<T> p)
	{
		if(p!=null)
		{
			postorder(p.left);
			postorder(p.right);
			System.out.print(p.data.toString()+" ");
		}
	}
	public void levelorder()
	{
		System.out.print("层次遍历：");
		LinkedQueue<BinaryNode<T>>que=new LinkedQueue<BinaryNode<T>>();
		BinaryNode<T>p=this.root;
		while(p!=null)
		{
			System.out.print(p.data+" ");
			if(p.left!=null)
				que.add(p.left);
			if(p.right!=null)
				que.add(p.right);
			p=que.poll();
		}
		System.out.println();
	}
	public BinaryTree(T[] prelist)/* 数组构造二叉树*/
	{
		this.root=create(prelist);
	}
	private int a=0;
	private BinaryNode<T>create(T[] prelist) 
	{
		BinaryNode<T> p=null;
		if(a<prelist.length)
		{
			T elem=prelist[a];
			a++;
			if(elem!=null)
			{
				p=new BinaryNode<T>(elem);
				p.left=create(prelist);
				p.right=create(prelist);
			}
		}
		return p;
	}
	public int size() /*节点数*/
	{
		return size(this.root);
	}
	public int size(BinaryNode<T> p)
	{
		if(p==null)
			return 0;
		return 1+size(p.left)+size(p.right);
	}
	public int height()
	{
		return height(this.root);
	}
	private int height(BinaryNode<T> p)
	{
		if(p==null)
			return 0;
		return 1+(height(p.left)>height(p.right)?height(p.left):height(p.right));
	}
	public void preorderTraverse()
	{
		System.out.print("先根遍历次序（非递归）：");
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> p=this.root;
		while(p!=null||!stack.isEmpty())
			if(p!=null)
			{
				System.out.print(p.data+" ");
				stack.push(p);
				p=p.left;
			}
			else
			{
				System.out.print("^ ");
				p=stack.pop();
				p=p.right;
			}
	}
	public void heightTraverse()
	{
		System.out.print("返回二叉树的高度（非递归）: ");
		LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
		BinaryNode<T>p=this.root;
		int i=1,j=1;
		while(p!=null||!stack.isEmpty())
		{	
			if(p!=null)
			{	
				stack.push(p);
				i++;
				p=p.left;
			}
			else
			{
				p=stack.pop();
				i--;
				p=p.right;
			}
			if(j<i)
				j=i;
//			if(stack.getsize()>i)
//				i=stack.getsize();
		}
		System.out.println(j);
	}
//	public BinaryTree<T> createComplete(T[] levellist)
//	{
//		this.root=new BinaryNode<T>(levellist[0],null,null);
//		BinaryNode<T> p=this.root;
//		LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>();
//		for(int i=0;i<levellist.length;i++)
//		{
//			
//			que.add(levellist[i]);
//		}
//		for(int i=0;que.isEmpty();i++)
//		{	
//			p=que.peek();
//			p.left=new BinaryNode<T>(levellist[i],null,null);
//			p.right=new BinaryNode<T>(levellist[i+1],null,null);
//		}
//		return this;
//	}
	public void diameter(BinaryTree<T> bitree) /*返回直径*/
	{
		this.diameter(bitree.root);
		System.out.println();
	}
	private void diameter(BinaryNode<T> p)
	{
		if(p!=null)
		{	
			System.out.print(1+height(p.left)+height(p.right));
		}
	}
	public void printGenList()
	{
		System.out.print("二叉树的广义表表示");
		printGenList(this.root);
		System.out.println();
	}
	public void printGenList(BinaryNode<T> p)
	{
		if(p==null)
			System.out.print("^");
		else
		{
			System.out.print(p.data.toString());
			if(p.left!=null||p.right!=null)
			{
				System.out.print("(");
				printGenList(p.left);
				System.out.print(",");
				printGenList(p.right);
				System.out.print(")");
			}
		}
	}
	public BinaryTree(T prelist[], T inlist[])   /*先跟中跟次序创建二叉树*/
	{
		this();
		if(prelist!=null&&inlist!=null&&inlist.length!=0&&prelist!=null)
		{	
			T a[]=null;T b[]=null;
			
			this.root=new BinaryNode<T>(prelist[0]);
			
			if(srearch(prelist[0],inlist)>0)
			{
				b=Arrays.copyOfRange(inlist,0,srearch(prelist[0],inlist));	
				a=Arrays.copyOfRange(prelist, 1, b.length+1);
				BinaryTree<T> tree=new BinaryTree<T>(a,b);
				this.root.left=new BinaryNode<T>(tree.root);
			}
			
			if((inlist.length-srearch(prelist[0],inlist))>1)
			{	
				a=null;b=null;
				b=Arrays.copyOfRange(inlist,srearch(prelist[0],inlist)+1, inlist.length);
				a=Arrays.copyOfRange(prelist,prelist.length-b.length,prelist.length);
				BinaryTree<T> tree=new BinaryTree<T>(a,b);
				
				this.root.right=new BinaryNode<T>(tree.root);
			}
		}
	}
//	public BinaryNode<T> max()
//	{
//		BinaryNode<T> max=new BinaryNode<T>();
//		return	max(this.root,max);
//	}
//	public BinaryNode<T> max(BinaryNode<T> p,BinaryNode<T> max)
//	{
//		if()
//			max=new BinaryNode<T>(p);
//		if(p!=null)
//		{
//			if()
//				max=new BinaryNode<T>(max(p.left,max));
//			if()
//				max=new BinaryNode<T>(max(p.right,max));
//		}
//		return max;
//	}
	public int srearch(T x,T list[])
	{
		for(int i=0;i<list.length;i++)
		{	
			if(list[i]==x)
				return i;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		String[] prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
//		String[] prelist={"A", "B" ,"C" ,"D" ,"E" ,"F" ,"G" ,"H"};
		BinaryTree<String>bitree=new BinaryTree<String>(prelist);
//		System.out.print("先根次序遍历二叉树：");bitree.perorder();
//		System.out.println("先根次序遍历二叉树： "+bitree.toString());
//		System.out.print("中根次序遍历二叉树    ");bitree.inorder();
//		System.out.print("后跟次序遍历二叉树");bitree.postorder();
	
		BinaryTree<String>bit=new BinaryTree<String>(bitree);
		bit.perorder();
		
//		bitree.insert(bitree.root.left,"X",true);
//		bitree.insert(bitree.root.right,"Y",false);
//		bitree.insert("Z");
		
//		System.out.println(bitree.size());
//		System.out.println(bitree.height());
//		bitree.preorderTraverse();
//		System.out.println();
//		bitree.heightTraverse();
//		bitree.levelorder();
//	
		
//		System.out.print(bitree.create(prelist));
//	    System.out.println(	bitree.diameter());
//		bitree.perorder();
//		bitree.printGenList();
//		bitree.diameter(bitree);
		
//		String[] prelist={"A","B","D","G","C","E","F","H"};
//		String[] inlist= {"D","G","B","A","E","C","H","F"};
//		BinaryTree<String>bitree=new BinaryTree<String>(prelist,inlist);
//		System.out.print("先根次序遍历二叉树：");bitree.perorder();
	}
}

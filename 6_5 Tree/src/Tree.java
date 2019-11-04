
public class Tree<T> 
{
	public TreeNode<T> root;
	public Tree()
	{
		this.root=null;
	}
	public boolean isEmpty()
	{
		return this.root.sibling==null;
	}
	public int level(T key)
	{
		return level(key,this.root);
	}
	private int level(T key,TreeNode<T> p)
	{
		if(p.data==key)
			return p.level;
		return	level(key,p.child);
	}
	public int size()
	{
		return size(this.root);
	}
	private int size(TreeNode<T> p)
	{
		if(p==null)
			return 0;
		return size(p.child)+size(p.sibling)+size(p.parent);
	}
	public int height()
	{
		return height(this.root);
	}
	private int height(TreeNode<T> p)
	{
		if(p==null)
			return 0;
		return height(p)<height(p.sibling)?height(p.sibling):1+height(p.child);
	}
	public void preorder()
	{
		preorder(this.root);
		System.out.println();
	}
	private void preorder(TreeNode<T> p)
	{
		if(p!=null)
		{	
			System.out.print(p.data.toString()+" ");
			preorder(p.child);
			preorder(p.sibling);
		}
	}
	public void postorder()
	{
		preorder(this.root);
		System.out.println();
	}
	public void postorder(TreeNode<T> p)
	{
		if(p!=null)
		{
			preorder(p.child);
			System.out.print(p.data.toString()+" ");
			preorder(p.sibling);
		}
	}
	public void levelorder()
	{
		levelorder(this.root);
		System.out.println();
	}
	private void levelorder(TreeNode<T> p)
	{
		if(p!=null)
		{
			preorder(p.child);
			preorder(p.sibling);
			System.out.print(p.data.toString()+" ");
		}
	}
	public TreeNode<T> insertRoot(T x)
	{
		this.root=new TreeNode<T>( x,1);
		return this.root;
	}
	public TreeNode<T> insertChild(TreeNode<T> p,T x,int i)
	{
		for(int j=0;j<i&&p!=null;j++)
		{
			p=p.child;
		}
		p=new TreeNode<T>(x);
		return p;
	}
	public TreeNode<T> search(T key)
	{
		if(key==null)
			throw new NullPointerException("key==null");
		return search(key,this.root);
	}
	private TreeNode<T> search(T key,TreeNode<T> p)
	{
		if(p!=null)
		{	
			if(key==p.data)
				return p;
			if(key==search(key,p.child))
				return search(key,p.child);
			if(key==search(key,p.sibling))
				return search(key,p.sibling);
		}
		return null;
	}
	public void remove(TreeNode<T> p,int i)
	{
		for(int j=0;j<i&&p!=null;j++)
		{
			p=p.child;
		}
		p=new TreeNode<T>(null);
	}
	public void clear()
	{
		this.root=new TreeNode<T>(null);
	}
//	public T remove(T key)
//	{
//		TreeNode<T> p=this.search(key);
//		
//	}
}

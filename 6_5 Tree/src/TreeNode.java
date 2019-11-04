
public class TreeNode<T> implements Comparable<Integer>
{
	public T data;
	public TreeNode<T>parent,child,sibling;
	public int level;
	public TreeNode(T data,int level,TreeNode<T> parent,TreeNode<T> child,TreeNode<T> sibling)
	{
		this.data=data;
		this.level=level;
		this.parent=parent;
		this.child=child;
		this.sibling=sibling;
	}
	public TreeNode(T data,int level)
	{
		this(data,level,null,null,null);
	}
	public String toString()
	{
		return "data="+data+",parent="+parent+",child="+child+",sibling="+sibling+"levek="+level;
	}
	public boolean isLeaf()
	{
		return parent==null;
	}
	public TreeNode(T data)
	{
		this(data,0);
	}
	
	public int compareTo(Integer p) 
	{
		
	}

}

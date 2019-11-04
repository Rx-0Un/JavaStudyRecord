public class BinaryNode<T> 
{
	public T data;
	public BinaryNode<T>left,right;
	public BinaryNode()
	{
		this(null,null,null);
	}
	public BinaryNode(T data,BinaryNode<T>left,BinaryNode<T> right)
	{
		this.data=data;
		this.left=left;
		this.right=right;
	}
	public BinaryNode(T data)
	{
		this(data,null,null);
	}
	public String toString()
	{
		return this.data.toString();
	}
	public boolean isleaf()
	{
		return this.left==null&&this.right==null;
	}
	public BinaryNode(BinaryNode<T> node)
	{
		this(node.data,node.left,node.right);
	}
//	public BinaryNode(T data)
//	{
//		this.data=data;
//	}
	

}
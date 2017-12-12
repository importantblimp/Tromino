package board;

public class Pair<T,V>
{
	private final T left;
	private final V right;
	
	public Pair(T left, V right)
	{
		this.left = left;
		this.right = right;
	}
	
	public T left()
	{
		return left;
	}
	
	public V right()
	{
		return right;
	}
	
	@Override
	public boolean equals(Object o)
	{
		boolean isEqual = false;
		
		if (o instanceof Pair)
		{
			Pair p = (Pair) o;
			isEqual = this.left.equals(p.left) && this.right.equals(p.right);
		}
		
		return isEqual;
	}
}

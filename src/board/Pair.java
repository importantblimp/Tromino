package board;

/**
 * A generic class for pairs of things.
 * There are two things, a left and a right, both are final and should not be mutable.
 * 
 * @param <T> The left element.
 * @param <V> The right element.
 */
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
	
	/**
	 * @return True iff the left of both pairs are equal and the right of both pairs are equal.
	 */
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

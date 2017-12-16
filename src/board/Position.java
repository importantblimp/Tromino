package board;

/**
 * An integer (x, y) position on a plane.
 * Positions may be positive or negative.
 * 
 * Once created positions may not be modified.
 * Positions to the left, right, up, or down of a position are not necessarily valid positions on the board. 
 */
public class Position
{
	private final int x;
	private final int y;
	
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * The position 1 unit above (in the y direction) p.
	 * @param p The existing position
	 * @return The position above p.
	 */
	public static Position up(Position p)
	{
		return new Position(p.getX(), p.getY() + 1);
	}
	
	/**
	 * The position 1 unit below (in the y direction) p.
	 * @param p The existing position
	 * @return The position below p.
	 */
	public static Position down(Position p)
	{
		return new Position(p.getX(), p.getY() - 1);
	}
	
	/**
	 * The position 1 unit to the left (in the x direction) p.
	 * @param p The existing position
	 * @return The position left of p.
	 */
	public static Position left(Position p)
	{
		return new Position(p.getX() - 1, p.getY());
	}
	
	/**
	 * The position 1 unit to the right (in the x direction) p.
	 * @param p The existing position
	 * @return The position right of p.
	 */
	public static Position right(Position p)
	{
		return new Position(p.getX() + 1, p.getY());
	}
	
	/**
	 * @return The x component of the position.
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * @return The y component of the position.
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Determine whether this point is within the rectangle formed by a and b.
	 * The order of a and b does not matter.
	 * @param a One of the corners of the rectangle.
	 * @param b One of the corners of the rectangle.
	 * @return True iff:
	 * This position is between the bottom left of the rectangle formed by a and b (inclusive)
	 * and the top right of the rectangle formed by a and b (exclusive); false otherwise.
	 * 
	 *    a          b
	 * (0, 0) and (4, 4) for a position of (0, 0) is true.
	 * (0, 0) and (4, 4) for a position of (4, 4) is false.
	 * (4, 0) and (0, 4) for a position of (0, 0) is true.
	 * (4, 0) and (0, 4) for a position of (0, 4) is false.
	 */
	public boolean between(Position a, Position b)
	{
		Position start = new Position(Math.min(a.x, b.x), Math.min(a.y, b.y));
		Position end = new Position(Math.max(a.x, b.x), Math.max(a.y, b.y));
		
		return start.getX() <= this.getX() && this.getX() < end.getX() && start.getY() <= this.getY() && this.getY() < end.getY();
	}
	
	/**
	 * @return True iff the x and y of o are equal to this position.
	 */
	@Override
	public boolean equals(Object o)
	{
		boolean equalTo = false;
		
		if (o instanceof Position)
		{
			Position p = (Position) o;
			equalTo = p.getX() == this.getX() && p.getY() == this.getY();
		}
		
		return equalTo;
	}
	
	/**
	 * The string form of a Postion is:
	 * (x, y)
	 * with no new line, and a space between the x and y values.
	 */
	@Override
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}
}

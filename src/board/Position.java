package board;

public class Position
{
	private final int x;
	private final int y;
	
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Position up(Position p)
	{
		return new Position(p.getX(), p.getY() + 1);
	}
	
	public static Position down(Position p)
	{
		return new Position(p.getX(), p.getY() - 1);
	}
	
	public static Position left(Position p)
	{
		return new Position(p.getX() - 1, p.getY());
	}
	
	public static Position right(Position p)
	{
		return new Position(p.getX() + 1, p.getY());
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	
	public boolean between(Position a, Position b)
	{
		Position start = new Position(Math.min(a.x, b.x), Math.min(a.y, b.y));
		Position end = new Position(Math.max(a.x, b.x), Math.max(a.y, b.y));
		
		return start.getX() <= this.getX() && this.getX() < end.getX() && start.getY() <= this.getY() && this.getY() < end.getY();
	}
	
	
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
	
	@Override
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}
}

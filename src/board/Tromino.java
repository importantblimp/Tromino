package board;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public enum Tromino implements Function<Position, List<Position>>
{
	UR (p -> {
		List<Position> l = new ArrayList<>();
		l.add(new Position(p.getX() - 1, p.getY()));
		l.add(p);
		l.add(new Position(p.getX(), p.getY() - 1));
		return l;
	}),
	
	UL (p -> {
		List<Position> l = new ArrayList<>();
		l.add(new Position(p.getX() - 1, p.getY()));
		l.add(new Position(p.getX() - 1, p.getY() - 1));
		l.add(p);
		return l;
	}),
	
	LR (p -> {
		List<Position> l = new ArrayList<>();
		l.add(p);
		l.add(new Position(p.getX(), p.getY() - 1));
		l.add(new Position(p.getX() - 1, p.getY() - 1));
		return l;
	}),
	
	LL (p -> {
		List<Position> l = new ArrayList<>();
		l.add(new Position(p.getX() - 1, p.getY()));
		l.add(new Position(p.getX() - 1, p.getY() - 1));
		l.add(new Position(p.getX(), p.getY() - 1));
		return l;
	});
	
	
	private final Function<Position, List<Position>> func;
	 
	private Tromino(Function<Position, List<Position>> func)
	{
		this.func = func;
	}
	
	@Override
	public List<Position> apply(Position t)
	{
		return func.apply(t);
	}
}

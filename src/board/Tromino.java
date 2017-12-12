package board;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 
 * A tromino is represented by the positions of it's three squares.
 * The position for each square is counted from the bottom left to the top right
 * and stretches exactly 1 square.
 * The squares are counted from the top left in a clockwise direction.
 * 
 * UR -> Upper right
 * UL -> Upper left
 * LR -> Lower right
 * LL -> Lower left
 * 
 * The function associated with the tromino returns the starting positions of the squares
 * that it is comprised of given some position on the board.
 * 
 * 
 * Upper right has it's corner facing the upper right  
 *   __
 *    /|
 *   /
 *  /
 *  
 *  The 'starting position' for the tromino is always the center.
 * 
 * The UR square is therefore:
 * 
 * _______a______b
 * |      |      |
 * |      |      |
 * c______d______e
 *        |      |
 *        |      |
 *        f______|
 *        
 * Where d is the given starting position, (c,a) is the first square in the tromino,
 * although it is only counted from c. (d,b) is the second, and (f,e) is the third.
 * Again, both being counted only from their starting postiions.
 * 
 * 
 * 
 * Similarly, UL is:
 * 
 *  __
 * |\
 *   \
 *    \
 * 
 * _______a______b
 * |      |      |
 * |      |      |
 * c______d______e
 * |      |
 * |      |
 * f______|
 * 
 * Where again d is the starting position. The three positions are:
 * c
 * d
 * f
 */
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
		l.add(p);
		l.add(new Position(p.getX() - 1, p.getY() - 1));
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
		l.add(new Position(p.getX(), p.getY() - 1));
		l.add(new Position(p.getX() - 1, p.getY() - 1));
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

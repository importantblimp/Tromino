package board;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 
 * A tromino is represented by the positions of it's three squares.
 * Each square is defined by it's bottom left, with it's top right being
 * implicit and 1 position away in the x and y direction.
 * The squares of a tromino are counted from the top left square in a clockwise direction.
 * 
 * UR -> Upper right
 * UL -> Upper left
 * LR -> Lower right
 * LL -> Lower left
 * 
 * The function associated with the tromino returns the starting position of the squares
 * that it is comprised of relative to some position on the board.
 * 
 * Upper right has it's corner facing the upper right  
 *   __
 *    /|
 *   /
 *  /
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
 * UR is centered at d, c is the first square in the tromino, d is the second,
 * and f is the third.
 * a, b, and e are the top right of the first, second, and third squares respectively and
 * are implicit.
 * 
 * For example an upper right tromino at position (1,2) will have squares at (0, 2), (1, 2), (1, 1).
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
 * Where again d is the starting position of the tromino. The three positions of the squares are:
 * c
 * d
 * f
 * 
 * LL is the only tromino that does not have a square starting at it's centre:
 * 
 *    /
 *   /
 * |/__
 * 
 * _______a
 * |      |
 * |      |
 * b______c______d
 * |      |      |
 * |      |      |
 * e______f______|
 * 
 * c is the staring position of the tromino, and the three positions of the squares are:
 * b
 * f
 * e
 * 
 * Note that f comes before e because the squares are counted clockwise from the top left.
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

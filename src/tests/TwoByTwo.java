package tests;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import board.Main;
import board.Pair;
import board.Position;
import board.Tromino;

/**
 * A set of tests covering the four base cases for tromino tiling:
 * A deficient square at:
 * Top left
 * Top right
 * Bottom right
 * Bottom left
 * and their respective solutions.
 * 
 * The naming convention is:
 * state_property_solution
 * 
 * For example
 * deficientSquare_ZeroOne_LowerRight
 * means the deficient square is at (0, 1) and the solution is a LR tromino.  
 */
public class TwoByTwo
{
	@Test
	public void deficientSquare_ZeroZero_UpperRight()
	{
		Main m = new Main(2, new Position(0, 0));
		Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0, 0), new Position(2, 2));
		
		assertTrue(p.get().left().equals(new Position(1, 1)));
		assertTrue(p.get().right().equals(Tromino.UR));
	}
	
	@Test
	public void deficientSquare_OneZero_UpperLeft()
	{
		Main m = new Main(2, new Position(1, 0));
		Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0, 0), new Position(2, 2));
		
		assertTrue(p.get().left().equals(new Position(1, 1)));
		assertTrue(p.get().right().equals(Tromino.UL));
	}
	
	@Test
	public void deficientSquare_OneOne_LowerLeft()
	{
		Main m = new Main(2, new Position(1, 1));
		Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0, 0), new Position(2, 2));
		
		assertTrue(p.get().left().equals(new Position(1, 1)));
		assertTrue(p.get().right().equals(Tromino.LL));
	}
	
	@Test
	public void deficientSquare_ZeroOne_LowerRight()
	{
		Main m = new Main(2, new Position(0, 1));
		Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0, 0), new Position(2, 2));
		
		assertTrue(p.get().left().equals(new Position(1, 1)));
		assertTrue(p.get().right().equals(Tromino.LR));
	}
	
	@Test
	public void notTwoByTwo_IllegalArgumentException_IsThrown()
	{
		Main m = new Main(4, new Position(1, 1));
		
		try
		{
			Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0,0), new Position(4,4));
		}
		catch (IllegalArgumentException e)
		{
			return;
		}

		fail("An illegal argument exception should have been thrown for a non 2x2 board");
	}
	
	@Test
	public void deficientSquareOutOfBounds_IllegalStateException_IsThrown()
	{
		Main m = new Main(4, new Position(3, 3)); // Legal board
		
		try
		{
			// Legal locations within board, but does not contain a deficient square 
			Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0,0), new Position(2,2));
		}
		catch (IllegalStateException e)
		{
			return;
		}

		fail("An illegal state exception should have been thrown for a non present deficient square in provided region");
	}
}

package tests;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import board.Main;
import board.Pair;
import board.Position;
import board.Tromino;

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
	public void deficientSquare_IsTrominoPiece_LLOneOne_LL()
	{
		Main m = new Main(4, new Position(3, 3));
		
		m.addTromino(Tromino.LL, new Position(2, 2));
		
		Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0, 0), new Position(2, 2));
		
		assertTrue(p.get().left().equals(new Position(1, 1)));
		assertTrue(p.get().right().equals(Tromino.LL));
	}
	
	@Test
	public void deficientSquare_IsTrominoPiece_LLOneOne_LR()
	{
		Main m = new Main(4, new Position(3, 3));
		
		m.addTromino(Tromino.LL, new Position(2, 2));
		
		Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(2, 0), new Position(4, 2));
		
		assertTrue(p.get().left().equals(new Position(3, 1)));
		assertTrue(p.get().right().equals(Tromino.LR));
	}
	
	@Test
	public void deficientSquare_IsTrominoPiece_LLOneOne_UL()
	{
		Main m = new Main(4, new Position(3, 3));
		
		m.addTromino(Tromino.LL, new Position(2, 2));
		
		Optional<Pair<Position, Tromino>> p = m.tileTwoByTwo(new Position(0, 2), new Position(2, 4));
		
		assertTrue(p.get().left().equals(new Position(1, 3)));
		assertTrue(p.get().right().equals(Tromino.UL));
	}
	
	
	
	
	
}

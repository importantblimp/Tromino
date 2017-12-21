package board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.Map.Entry;

import javax.swing.JPanel;

public class Canvas extends JPanel
{
	private final Main board;

	private List<Color> colours;

	public Canvas(Main board, Dimension windowSize, List<Color> colours)
	{
		this.colours = colours;
		this.board = board;
		
		setSize(windowSize);
	}

	/**
	 * Generate colours for colouring trominos.
	 * @param squareDimenions The size of the board in squares.
	 * @param rgb A function that produces a colour based on the order in the list.
	 * 0, the first input, is the first colour in the list. 1, the second input, 
	 * is the second colour and so on.
	 * @return Newly generated colours.
	 */
	public static List<Color> generateColours(Dimension boardSize, Function<Integer, Color> rgb)
	{
		List<Color> c = new ArrayList<>();
		
		// In an n x m board there are (n x m) / 3 trominos because each tromino is made up of 3 pieces.
		for (int i = 0; i < (boardSize.width * boardSize.height) / 3; i++)
		{
			c.add(rgb.apply(i));
		}

		return c;
	}

	/**
	 * Draw each of the generated trominos using generated colours.
	 */
	public void paint(Graphics gra)
	{
		Dimension squareSize = new Dimension(getSize().width / board.getBoardDimensions().width, getSize().height / board.getBoardDimensions().height);
		
		gra.setColor(Color.black);
		gra.fillRect(0, 0, getSize().width, getSize().height);

		Iterator<Color> q = colours.iterator();

		for (Entry<Position, Tromino> e : board.getTrominoes().entrySet())
		{
			gra.setColor(q.next());
			for (Position p : e.getValue().apply(e.getKey()))
			{
				gra.fillRect(p.getX() * squareSize.width,
						
						// Graphics in Java are drawn from the top left (0,0), but we consider (0,0) to be the bottom left
						// so we need to reverse the y axis. To get to the bottom we use getSize.heigh - ...
						// and we need - squareSize.height because each square is drawn from the top left corner.
						getSize().height - p.getY() * squareSize.height - squareSize.height,
						
						squareSize.width,
						squareSize.height);
			}
		}
	}
}

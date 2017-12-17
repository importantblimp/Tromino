package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A basic graphical display for a tromino board.
 * The view tiles the board after creating it using Main.tile.
 */
public class View extends JFrame
{
	private final Canvas canvas;
	private final Main m;
	private final Dimension board;
	//private final Dimension squareSize;
	
	private final Dimension windowSize;
	
	public View(int boardSize, Position missing)
	{
		super("Tromino tilier");
		
		windowSize = new Dimension(1000, 1000);
		
		m = new Main(boardSize, missing);
		board = new Dimension(boardSize, boardSize);
		
		canvas = new Canvas();
		
		setLayout(new BorderLayout());
		
		add(canvas, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(windowSize);
		
		setResizable(false);
		setVisible(true);
	}
	
	private class Canvas extends JPanel
	{
		private final Dimension squareSize;
		private final int borderSize;
		
		private List<Color> colours;
		
		public Canvas()
		{
			borderSize = 50;
			setSize(windowSize.width - (2*borderSize), windowSize.height - (2*borderSize));
			
			squareSize = new Dimension(getSize().width / board.width, getSize().height / board.height);
			
			colours = generateColours(board.width);
			
			m.tile();
		}
		
		/**
		 * Generate random colours in a mid-range.
		 * In this case, 30-255 for rgb.
		 * @param squareDimenions The size of the board in squares.
		 * @return Newly generated colours.
		 */
		private List<Color> generateColours(int squareDimenions)
		{
			List<Color> c = new ArrayList<>();
			Random rand = new Random();
			
			for (int i = 0; i < (squareDimenions * squareDimenions) / 3; i++)
			{
				int x = 30;
				int y = 225;
				c.add(new Color(x + rand.nextInt(y), x + rand.nextInt(y), x + rand.nextInt(y)));
			}
			
			return c;
		}
		
		/**
		 * Draw each of the generated trominos using generated colours.
		 */
		public void paint(Graphics gra)
		{
			gra.setColor(Color.black);
			gra.fillRect(0, 0, windowSize.width, windowSize.height);

			Iterator<Color>q = colours.iterator();
			
			for (Entry<Position, Tromino> e : m.getTrominoes().entrySet())
			{
				gra.setColor(q.next());
				for (Position p : e.getValue().apply(e.getKey()))
				{
					gra.fillRect(borderSize + (p.getX() * squareSize.width), (getSize().height - (p.getY() * squareSize.height)) - borderSize, squareSize.width, -squareSize.height);
				}
			}
		}
	}
}

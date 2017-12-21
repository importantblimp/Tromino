package board;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * A basic graphical display for a tromino board.
 * The view tiles the board after creating it using Main.tile.
 */
public class View extends JFrame
{
	public View(Canvas canvas)
	{
		super("Tromino tilier");

		setSize(canvas.getSize());
		
		setLayout(new BorderLayout());
		add(canvas, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);
		setVisible(true);
	}
}

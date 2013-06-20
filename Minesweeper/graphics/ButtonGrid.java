package graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

import game.*;

@SuppressWarnings("serial")
public class ButtonGrid extends JPanel implements ActionListener {
	static JPanel panel = new JPanel();
	Button[][] bGrid;
	JButton[][] grid;
	int width;
	int length;
	Game game;
	
	public ButtonGrid(Game g, int w, int l) {
		width = w;
		length = l;
		game = g;
		setLayout(new GridLayout(width,length));
		bGrid = new Button[width][length];
		grid = new JButton[width][length];
		for(int y = 0; y < length; y++) {
			for(int x = 0; x < width; x++) {
				try {
					bGrid[x][y] = new Button(game.getsq(x, y));
					grid[x][y] = bGrid[x][y].getJB();
					grid[x][y].addActionListener(this);
					add(grid[x][y]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		setVisible(true);
		setSize(new Dimension(35*width,35*length));
	}
	
	public void click(int x, int y) {
		int i = game.reveal(x, y);
		grid[x][y] = bGrid[x][y].getJB();
		if(i == -1)
			for(Square sq : game.getMines() ) {
				int r = sq.getRow();
				int c = sq.getCol();
				grid[r][c] = bGrid[r][c].getJB();
			}
		if(i == 0)
			for(Square sq : game.surroundings(game.getsq(x, y)) ) {
				int r = sq.getRow();
				int c = sq.getCol();
				grid[r][c] = bGrid[r][c].getJB();
				GUI.newGame();
			}
		
	}

	public static JPanel returnPanel() {
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
}
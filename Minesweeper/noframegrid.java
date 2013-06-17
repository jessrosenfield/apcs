import javax.imageio.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.IOException;

public class noframegrid extends JPanel implements ActionListener
{
	static JPanel panel = new JPanel();
	JButton[][] grid;
	public noframegrid(int width, int length)
	{
		setLayout(new GridLayout(width,length));
		grid = new JButton[width][length];
		//panel.setResizable(false);
		for(int y = 0; y < length; y++)
		{
			for(int x = 0; x < width; x++)
			{
				grid[x][y] = new JButton("");   
				add(grid[x][y]);
			}
		}

		//panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid[width-1][length-1].addActionListener(this);
		Image img;
		ImageIcon imgi=null;
		//panel.pack(); 
		setVisible(true);
		setSize(new Dimension(500,500));
		try {
			img = ImageIO.read(getClass().getResource("Stone.png"));
			imgi = new ImageIcon(img);
		}catch (IOException e){}
		for(int r = 0; r < length; r++)
		{
			for(int c = 0; c < width; c++)
			{
				JButton b = grid[r][c]; 
				if(imgi!=null)
					b.setIcon(imgi);
			}
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if ("click0,0".equals(e.getActionCommand()))
		{
			Image img;
			ImageIcon imgi=null;
			//frame.pack(); 
			try {
				img = ImageIO.read(getClass().getResource("Stone2.png"));
				imgi = new ImageIcon(img);
			}catch (IOException c){}
		}
	}

	public static JPanel returnPanel()
	{
		return panel;
	}

	public static void main(String[] args)
	{
		new noframegrid(9,9);
	}
}
package draw.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private int [] graphData;
	
	public GraphPanel() 
	{
		graphData = new int [] {2,100,666,14,18,22};
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.DARK_GRAY);
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		for(int i = 0; i < graphData.length; i++)
		{
			int height = this.getHeight()/graphData.length;
			int width = (int)((graphData[i] / 200.00) * this.getWidth());
			int xPos = 0;
			int yPos = height * i;
			
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int alpha = (int) (Math.random() * 256);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(new Rectangle(xPos, yPos, width, height));
		}
		
	}
}

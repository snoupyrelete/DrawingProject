package draw.view;

import java.awt.Dimension;

import javax.swing.JFrame;


import draw.controller.DrawController;

public class DrawingFrame extends JFrame
{
	private DrawController baseController;
	private DrawingPanel mainPanel;
	
	public DrawingFrame(DrawController baseController) 
	{
		super();
		this.baseController = baseController;
		mainPanel = new DrawingPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(mainPanel);
		this.setTitle("Drawing Window");
		this.setResizable(true);
		this.setSize(new Dimension(700, 700));
		this.setVisible(true);
	}
}

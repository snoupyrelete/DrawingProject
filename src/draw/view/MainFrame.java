package draw.view;

import java.awt.Dimension;

import javax.swing.JFrame;


import draw.controller.DrawController;

public class MainFrame extends JFrame {

	private DrawController baseController;
	private MainPanel mainPanel;
	
	public MainFrame(DrawController baseController) {
		super();
		this.baseController = baseController;
		mainPanel = new MainPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(mainPanel);
		this.setTitle("Drawing window");
		this.setSize(new Dimension(750, 500));
		this.setVisible(true);
	}
}

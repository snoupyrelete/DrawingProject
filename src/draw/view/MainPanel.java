package draw.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import draw.controller.DrawController;

public class MainPanel extends JPanel {
	
	private SpringLayout baseLayout;
	private DrawController baseController;
	
	public MainPanel(DrawController baseController)
	{
		super();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}

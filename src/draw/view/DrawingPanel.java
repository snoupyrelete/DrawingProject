package draw.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import draw.controller.DrawController;

public class DrawingPanel extends JPanel {

	private ShapePanel shapePanel;
	private JButton rectangleButton;
	private JButton circleButton;
	private JButton ellipseButton;
	private JButton triangleButton;
	private JButton polygonButton;
	
	private SpringLayout baseLayout;
	private DrawController baseController;
	
	public DrawingPanel(DrawController baseController)
	{
		super();
		this.baseController = baseController;
		
		shapePanel = new ShapePanel(baseController);
		rectangleButton = new JButton("Draw Rectangles");
		circleButton = new JButton("Draw Circles");
		ellipseButton = new JButton("Draw Ellipses");
		triangleButton = new JButton("Draw Triangles");
		polygonButton = new JButton("Draw Polygons");
		
		
		baseLayout = new SpringLayout();
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(600, 600));
		
		this.add(rectangleButton);
		this.add(circleButton);
		this.add(ellipseButton);
		this.add(triangleButton);
		this.add(polygonButton);

		
		this.add(shapePanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, 0, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 250, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, ellipseButton, -6, SpringLayout.NORTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, polygonButton, -6, SpringLayout.NORTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, triangleButton, -7, SpringLayout.NORTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, circleButton, -6, SpringLayout.NORTH, rectangleButton);
	}
	
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
			
		});
		
		circleButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircles();
			}
			
		});
		
		ellipseButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipses();
			}
			
		});
		
		triangleButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangles();
			}
			
		});
		
		polygonButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygons();
			}
		});
	}
}

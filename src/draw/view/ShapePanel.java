package draw.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import draw.controller.DrawController;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class ShapePanel extends JPanel {
	
	private DrawController baseController;
	private ArrayList<Shape> rectangleList;
	private ArrayList<Shape> triangleList;
	private ArrayList<Shape> circleList;
	private ArrayList<Shape> ellipseList;
	private ArrayList<Shape> polygonList;
	private ArrayList<ArrayList <Shape>> shapes;
	
	
	public ShapePanel(DrawController baseController)
	{
		super();
		this.baseController = baseController;
		
		rectangleList = new ArrayList<Shape>();
		triangleList = new ArrayList<Shape>();
		circleList = new ArrayList<Shape>();
		ellipseList = new ArrayList<Shape>();
		polygonList = new ArrayList<Shape>();
		shapes = new ArrayList<ArrayList <Shape>>();
		
		shapes.add(rectangleList);
		shapes.add(triangleList);
		shapes.add(circleList);
		shapes.add(polygonList);
		shapes.add(ellipseList);
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setMinimumSize(new Dimension(250, 500));
	}
	
	private Color getRandomColor()
	{
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		int alpha = (int) (Math.random() * 255);
		
		return new Color(red, green, blue,alpha);
	}
	
	/*
	 * Add shapes 
	 */
	
	public void addTriangles()
	{
		if(triangleList.size() > 500)
		{
			triangleList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int vertexCount = 3;
			int [] xVertices = new int[vertexCount];
			int [] yVertices = new int[vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner = (int) (Math.random() * this.getWidth());
				int yCorner = (int) (Math.random() * this.getWidth());
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			triangleList.add(current);
		}
		this.repaint();
	}
	
	public void addPolygons()
	{
		if(triangleList.size() > 500)
		{
			triangleList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int vertexCount = (int) (Math.random() * 7) + 4;
			int [] xVertices = new int[vertexCount];
			int [] yVertices = new int[vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner = (int) (Math.random() * this.getWidth());
				int yCorner = (int) (Math.random() * this.getWidth());
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			triangleList.add(current);
		}
		this.repaint();
	}
	
	public void addEllipses()
	{
		if(ellipseList.size() > 500)
		{
			ellipseList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int width = (int) (Math.random() * 50) * 2 + 1;
			int height = (int) (Math.random() * 50) + 3;
			int xCorner = (int) (Math.random() * this.getWidth() - 15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, width, height);
			ellipseList.add(current);
		}
		this.repaint();
	}
	
	public void addCircles()
	{
		if(circleList.size() > 500)
		{
			circleList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int radius = (int) (Math.random() * 25) + 2;
			int xCorner = (int) (Math.random() * this.getWidth() - 15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, radius, radius);
			circleList.add(current);
		}
		this.repaint();
	}
	
	public void addRectangles()
	{
		if(rectangleList.size() > 500)
		{
			rectangleList.clear();
		}
		
		for(int index = 0; index < 500; index++)
		{
			int width = (int) (Math.random() * 120) + 1;
			int height = (int) (Math.random() * 150) + 15;
			int xCorner = (int) (Math.random() * this.getWidth() - 15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			
			Rectangle currentRectangle = new Rectangle(xCorner, yCorner, width, height);
			rectangleList.add(currentRectangle);	
		}
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		Graphics2D drawingGraphics = (Graphics2D) graphics;
		for(ArrayList<Shape> currentList : shapes) 
		{
			drawShapes(currentList, drawingGraphics);
		}
	}
	
	private void drawShapes(ArrayList<Shape> shapeList, Graphics2D graphics)
	{
		for(Shape currentShape : shapeList)
		{
			graphics.setColor(getRandomColor());
			int strokeWidth = (int) (Math.random() * 10) + 1;
			graphics.setStroke(new BasicStroke(strokeWidth));
			
			
			int random  = (int) (Math.random() * 35);
			if(random % 5 == 0 || random % 7 == 0)
			{
				graphics.fill(currentShape);
				graphics.setColor(getRandomColor());
				graphics.draw(currentShape);
			}
			else
			{
				graphics.draw(currentShape);
			}
		}
	}
}

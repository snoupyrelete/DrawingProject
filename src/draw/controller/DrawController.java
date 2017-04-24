package draw.controller;

import draw.view.DrawingFrame;

public class DrawController
{
	private DrawingFrame appFrame;
	
	public DrawController()
	{
		this.appFrame = new DrawingFrame(this);
	}
}

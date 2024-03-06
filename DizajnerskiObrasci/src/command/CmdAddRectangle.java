package command;


import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

public class CmdAddRectangle implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Rectangle rectangle;
	private ArrayList<Shape> list;

	public CmdAddRectangle(DrawingModel model, Rectangle rectangle) {
		//super();
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		//rectangle.setSelected(false);
		model.add(rectangle);
		
	}

	@Override
	public void unexecute() {
		model.remove(rectangle);
		
	}
	@Override
	public void overrideModel(DrawingModel model) {
		this.model = model;
		
	}

	@Override
	public void overrideListShapes(ArrayList<Shape> list) {
		this.list = list;
		
	}
	public String toString() {
		return rectangle.toString();
	}

}

package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

public class CmdDeleteRectangle implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Rectangle rectangle;
	private int index;
	private ArrayList<Shape> list;

	public CmdDeleteRectangle(DrawingModel model, Rectangle rectangle) {
		//super();
		this.model = model;
		this.rectangle = rectangle;
		index = model.getShapes().indexOf(rectangle);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		model.remove(rectangle);
		
	}

	@Override
	public void unexecute() {
		model.addIndex(index, rectangle);
		
	}
	@Override
	public void overrideModel(DrawingModel model) {
		this.model = model;
		
	}

	@Override
	public void overrideListShapes(ArrayList<Shape> list) {
		this.list = list;
		
	}
}

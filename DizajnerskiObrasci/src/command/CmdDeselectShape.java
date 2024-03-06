package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdDeselectShape implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Shape shape;
	private DrawingModel model;
	private ArrayList<Shape> list;

	public CmdDeselectShape(Shape shape) {
		//super();
		this.shape = shape;
	}

	@Override
	public void execute() {
		shape.setSelected(false);
		
	}

	@Override
	public void unexecute() {
		shape.setSelected(true);
		
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

package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdDeleteCircle implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Circle circle;
	private int index;
	private ArrayList<Shape> list;

	public CmdDeleteCircle(DrawingModel model, Circle circle) {
		//super();
		this.model = model;
		this.circle = circle;
		index = model.getShapes().indexOf(circle);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		model.remove(circle);
		
	}

	@Override
	public void unexecute() {
		model.addIndex(index, circle);
		
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
		return circle.toString();
	}

}

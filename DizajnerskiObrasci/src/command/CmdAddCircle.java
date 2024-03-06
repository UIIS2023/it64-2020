package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdAddCircle implements Command, Serializable {
	//private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Circle circle;
	private ArrayList<Shape> list;

	public CmdAddCircle(DrawingModel model, Circle circle) {
		//super();
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		//circle.setSelected(false);
		model.add(circle);

	}

	@Override
	public void unexecute() {
		model.remove(circle);
		
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

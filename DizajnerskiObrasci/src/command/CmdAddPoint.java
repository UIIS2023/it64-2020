package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Point;
import shapes.Shape;

public class CmdAddPoint implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Point point;
	private ArrayList<Shape> list;

	public CmdAddPoint(DrawingModel model, Point point) {
		//super();
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		//point.setSelected(false);
		model.add(point);
		
	}

	@Override
	public void unexecute() {
		model.remove(point);
		
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
		return point.toString();
	}

}

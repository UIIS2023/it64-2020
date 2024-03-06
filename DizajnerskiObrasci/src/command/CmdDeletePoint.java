package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Point;
import shapes.Shape;

public class CmdDeletePoint implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Point point;
	private int index;
	private ArrayList<Shape> list;

	public CmdDeletePoint(DrawingModel model, Point point) {
		//super();
		this.model = model;
		this.point = point;
		index = model.getShapes().indexOf(point);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		model.remove(point);
		
	}

	@Override
	public void unexecute() {
		model.addIndex(index, point);
		
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

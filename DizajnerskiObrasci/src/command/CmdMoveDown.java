package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdMoveDown implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Shape shape;
	private ArrayList<Shape> list;
	private DrawingModel model;

	public CmdMoveDown(Shape shape, ArrayList<Shape> list) {
		//super();
		this.shape = shape;
		this.list = list;
	}

	@Override
	public void execute() {
		int position = list.indexOf(shape);

		if (position > 0) {
			Shape s = list.remove(position);
			list.add(position - 1, s);
			//Collections.swap(list, position, position-1);
		}
		
	}

	@Override
	public void unexecute() {
		int position = list.indexOf(shape);

		if (position < list.size() - 1) {
			Shape s = list.remove(position);
			list.add(position + 1, s);
			//Collections.swap(list, position, position+1);
		}
		
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

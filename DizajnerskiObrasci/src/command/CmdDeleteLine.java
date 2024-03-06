package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Line;
import shapes.Shape;

public class CmdDeleteLine implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Line line;
	private int index;
	private ArrayList<Shape> list;

	public CmdDeleteLine(DrawingModel model, Line line) {
		//super();
		this.model = model;
		this.line = line;
		index = model.getShapes().indexOf(line);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		model.remove(line);
		
	}

	@Override
	public void unexecute() {
		model.addIndex(index,line);
		
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

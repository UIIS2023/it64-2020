package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Line;
import shapes.Shape;

public class CmdAddLine implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Line line;
	private ArrayList<Shape> list;

	public CmdAddLine(DrawingModel model, Line line) {
		//super();
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		//line.setSelected(false);
		model.add(line);
		
	}

	@Override
	public void unexecute() {
		model.remove(line);
		
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
		return line.toString();
	}

}

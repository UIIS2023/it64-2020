package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Donut;
import shapes.Shape;

public class CmdAddDonut implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Donut donut;
	private ArrayList<Shape> list;

	public CmdAddDonut(DrawingModel model, Donut donut) {
		//super();
		this.model = model;
		this.donut = donut;
	}

	@Override
	public void execute() {
		//donut.setSelected(false);
		model.add(donut);
		
	}

	@Override
	public void unexecute() {
		model.remove(donut);
		
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
		return donut.toString();
	}


}

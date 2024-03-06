package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Donut;
import shapes.Shape;

public class CmdDeleteDonut implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private Donut donut;
	private int index;
	private ArrayList<Shape> list;

	public CmdDeleteDonut(DrawingModel model, Donut donut) {
		//super();
		this.model = model;
		this.donut = donut;
		index = model.getShapes().indexOf(donut);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		model.remove(donut);
		
	}

	@Override
	public void unexecute() {
		model.addIndex(index, donut);
		
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

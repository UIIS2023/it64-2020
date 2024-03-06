package command;

import java.io.Serializable;
import java.util.ArrayList;

import adapter.HexagonAdapter;
import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdDeleteHexagon implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private DrawingModel model;
	private HexagonAdapter hexagon;
	private int index;
	private ArrayList<Shape> list;

	public CmdDeleteHexagon(DrawingModel model, HexagonAdapter hexagon) {
		//super();
		this.model = model;
		this.hexagon = hexagon;
		index = model.getShapes().indexOf(hexagon);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		model.remove(hexagon);
		
	}

	@Override
	public void unexecute() {
		model.addIndex(index, hexagon);
		
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

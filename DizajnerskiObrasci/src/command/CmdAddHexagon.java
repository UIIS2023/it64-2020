package command;

import java.io.Serializable;
import java.util.ArrayList;

import adapter.HexagonAdapter;
import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdAddHexagon implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;

	private DrawingModel model;
	private HexagonAdapter hexagon;
	private ArrayList<Shape> list;
	
	public CmdAddHexagon(DrawingModel model, HexagonAdapter hexagon) {
		//super();
		this.model = model;
		this.hexagon = hexagon;
	}

	@Override
	public void execute() {
		//hexagon.setSelected(false);
		model.add(hexagon);
		
	}

	@Override
	public void unexecute() {
		model.remove(hexagon);
		
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
		return hexagon.toString();
	}
}

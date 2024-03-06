package command;

import java.io.Serializable;
import java.util.ArrayList;

import adapter.HexagonAdapter;
import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdUpdateHexagon implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;

	private HexagonAdapter oldHexagon, newHexagon;
	private HexagonAdapter original = new HexagonAdapter();
	private ArrayList<Shape> list;

	private DrawingModel model;
	private int index;
	
	public CmdUpdateHexagon(HexagonAdapter oldHexagon, HexagonAdapter newHexagon, DrawingModel model) {
		//super();
		this.oldHexagon = oldHexagon;
		this.newHexagon = newHexagon;
		this.model = model;
		index = model.getShapes().indexOf(oldHexagon);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}
	@Override
	public void execute() {
		
		original = oldHexagon.clone();
		
		oldHexagon.setX(newHexagon.getX());
		oldHexagon.setY(newHexagon.getY());
		oldHexagon.setColor(newHexagon.getColor());
		oldHexagon.setInnerColor(newHexagon.getInnerColor());
		try {
			oldHexagon.setRadius(newHexagon.getRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*newHexagon.setSelected(true);
		oldHexagon.setSelected(false);
		
		model.remove(oldHexagon);
		model.addIndex(index, newHexagon);*/
		
	}
	@Override
	public void unexecute() {
		
		oldHexagon.setX(original.getX());
		oldHexagon.setY(original.getY());
		oldHexagon.setColor(original.getColor());
		oldHexagon.setInnerColor(original.getInnerColor());
		try {
			oldHexagon.setRadius(original.getRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*newHexagon.setSelected(false);
		oldHexagon.setSelected(true);
		
		model.remove(newHexagon);
		model.addIndex(index, oldHexagon);*/
		
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
		return oldHexagon.toString() + " TO: " + newHexagon.toString();
	}
}

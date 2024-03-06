package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdUpdateCircle implements Command, Serializable {
	//private static final long serialVersionUID = 6539685248167757695L;
	
	private Circle oldCircle, newCircle;
	private Circle original = new Circle();
	private ArrayList<Shape> list;

	private DrawingModel model;
	private int index ;

	public CmdUpdateCircle(Circle oldCircle, Circle newCircle, DrawingModel model) {
		//super();
		this.oldCircle = oldCircle;
		this.newCircle = newCircle;
		this.model = model;
		index = model.getShapes().indexOf(oldCircle);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		//setovanje vrednosti originala
		/*original.getCenter().setX(oldCircle.getCenter().getX());
		original.getCenter().setY(oldCircle.getCenter().getY());
		original.setColor(oldCircle.getColor());
		original.setInnerColor(oldCircle.getInnerColor());
		try {
			original.setRadius(oldCircle.getRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//OVO
		
		original = oldCircle.clone();
		
		//postavljenje novih vrednosti za oldCircle
		oldCircle.getCenter().setX(newCircle.getCenter().getX());
		oldCircle.getCenter().setY(newCircle.getCenter().getY());
		oldCircle.setColor(newCircle.getColor());
		oldCircle.setInnerColor(newCircle.getInnerColor());
		try {
			oldCircle.setRadius(newCircle.getRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*newCircle.setSelected(true);
		oldCircle.setSelected(false);
		
		model.remove(oldCircle);
		model.addIndex(index, newCircle);*/
	}

	@Override
	public void unexecute() {
		//vracanje starih vrednosti koje su sacuvane na original
		oldCircle.getCenter().setX(original.getCenter().getX());
		oldCircle.getCenter().setY(original.getCenter().getY());
		oldCircle.setColor(original.getColor());
		oldCircle.setInnerColor(original.getInnerColor());
		try {
			oldCircle.setRadius(original.getRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*newCircle.setSelected(false);
		oldCircle.setSelected(true);
		
		model.remove(newCircle);
		model.addIndex(index, oldCircle);*/	
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
		return  oldCircle.toString() + " TO: " + newCircle.toString();
	}

}

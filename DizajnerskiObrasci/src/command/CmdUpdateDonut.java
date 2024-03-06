package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Donut;
import shapes.Shape;

public class CmdUpdateDonut implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Donut oldDonut, newDonut;
	private Donut original = new Donut();
	private ArrayList<Shape> list;

	private DrawingModel model;
	private int index;

	public CmdUpdateDonut(Donut oldDonut, Donut newDonut,  DrawingModel model) {
		//super();
		this.oldDonut = oldDonut;
		this.newDonut = newDonut;
		this.model = model;
		index = model.getShapes().indexOf(oldDonut);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		// setovanje vrednosti za original
		/*original.getCenter().setX(oldDonut.getCenter().getX());
		original.getCenter().setY(oldDonut.getCenter().getY());
		original.setColor(oldDonut.getColor());
		original.setInnerColor(oldDonut.getInnerColor());
		try {
			original.setRadius(oldDonut.getRadius());
			original.setInnerRadius(oldDonut.getInnerRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		original = oldDonut.clone();
		
		//setovanje vrednosti novog Donuta
		oldDonut.getCenter().setX(newDonut.getCenter().getX());
		oldDonut.getCenter().setY(newDonut.getCenter().getY());
		oldDonut.setColor(newDonut.getColor());
		oldDonut.setInnerColor(newDonut.getInnerColor());
		try {
			oldDonut.setRadius(newDonut.getRadius());
			oldDonut.setInnerRadius(newDonut.getInnerRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*newDonut.setSelected(true);
		oldDonut.setSelected(false);
		
		model.remove(oldDonut);
		model.addIndex(index, newDonut);*/
	}

	@Override
	public void unexecute() {
		//vracamo vrednosti iz original donuta	
		oldDonut.getCenter().setX(original.getCenter().getX());
		oldDonut.getCenter().setY(original.getCenter().getY());
		oldDonut.setColor(original.getColor());
		oldDonut.setInnerColor(original.getInnerColor());
		try {
			oldDonut.setRadius(original.getRadius());
			oldDonut.setInnerRadius(original.getInnerRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*newDonut.setSelected(false);
		oldDonut.setSelected(true);
		
		model.remove(newDonut);
		model.addIndex(index, oldDonut);*/
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
		return oldDonut.toString() + " TO: " + newDonut.toString();
	}
}

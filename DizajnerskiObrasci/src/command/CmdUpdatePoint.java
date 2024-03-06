package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Point;
import shapes.Shape;

public class CmdUpdatePoint implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Point oldPoint, newPoint;
	private Point original = new Point();
	private ArrayList<Shape> list;

	private DrawingModel model;
	private int index;

	public CmdUpdatePoint(Point oldPoint, Point newPoint, DrawingModel model) {
		//super();
		this.oldPoint = oldPoint;
		this.newPoint = newPoint;
		this.model = model;
		index = model.getShapes().indexOf(oldPoint);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		//ovde postavljamo vrednosti u original kako bi zapamtili
		/*original.setX(oldPoint.getX());
		original.setY(oldPoint.getY());
		original.setColor(oldPoint.getColor());
		
		//ovde dajemo vrednosti za novu tacku 
		oldPoint.setX(newPoint.getX());
		oldPoint.setY(newPoint.getY());
		oldPoint.setColor(newPoint.getColor());
		*/
		original = oldPoint.clone();
		
		oldPoint.setX(newPoint.getX());
		oldPoint.setY(newPoint.getY());
		oldPoint.setColor(newPoint.getColor());
		
		/*newPoint.setSelected(true);
		oldPoint.setSelected(false);
		
		model.remove(oldPoint);
		model.addIndex(index, newPoint);*/
	}

	@Override
	public void unexecute() {
		//ovde koristimo nas original kako bi vratili vrednosti 
		oldPoint.setX(original.getX());
		oldPoint.setY(original.getY());
		oldPoint.setColor(original.getColor());	
		
		newPoint.setSelected(false);
		oldPoint.setSelected(true);
		
		/*model.remove(newPoint);
		model.addIndex(index, oldPoint);*/
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
		return oldPoint.toString() + " TO: " + newPoint.toString();
	}

}

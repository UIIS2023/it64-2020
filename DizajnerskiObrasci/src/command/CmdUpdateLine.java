package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Line;
import shapes.Shape;

public class CmdUpdateLine implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Line oldLine, newLine;
	private Line original = new Line();
	private ArrayList<Shape> list;

	private DrawingModel model;
	private int index;

	public CmdUpdateLine(Line oldLine, Line newLine, DrawingModel model) {
		//super();
		this.oldLine = oldLine;
		this.newLine = newLine;
		this.model = model;
		index = model.getShapes().indexOf(oldLine);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		//stavljamo vrednosti u original za staru tacku, kako bi mogla da se koristi za UNDO
		/*original.getStartPoint().setX(oldLine.getStartPoint().getX());
		original.getStartPoint().setY(oldLine.getStartPoint().getY());
		original.getEndPoint().setX(oldLine.getEndPoint().getX());
		original.getEndPoint().setY(oldLine.getEndPoint().getY());
		original.setColor(oldLine.getColor());
		*/
		original = oldLine.clone();
		
		//setovali vrednosti za novu liniju
		oldLine.getStartPoint().setX(newLine.getStartPoint().getX());
		oldLine.getStartPoint().setY(newLine.getStartPoint().getY());
		oldLine.getEndPoint().setX(newLine.getEndPoint().getX());
		oldLine.getEndPoint().setY(newLine.getEndPoint().getY());
		oldLine.setColor(newLine.getColor());
		
		/*newLine.setSelected(true);
		oldLine.setSelected(false);
		
		model.remove(oldLine);
		model.addIndex(index, newLine);*/
	}

	@Override
	public void unexecute() {
		// vracamo vrednosti 
		oldLine.getStartPoint().setX(original.getStartPoint().getX());
		oldLine.getStartPoint().setY(original.getStartPoint().getY());
		oldLine.getEndPoint().setX(original.getEndPoint().getX());
		oldLine.getEndPoint().setY(original.getEndPoint().getY());
		oldLine.setColor(original.getColor());
		
		/*newLine.setSelected(false);
		oldLine.setSelected(true);
		
		model.remove(newLine);
		model.addIndex(index, oldLine);*/
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
		return oldLine.toString() + " TO: " + newLine.toString();
	}
}

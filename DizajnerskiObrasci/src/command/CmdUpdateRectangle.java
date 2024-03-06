package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

public class CmdUpdateRectangle implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Rectangle oldRectangle, newRectangle;
	private Rectangle original = new Rectangle();
	private ArrayList<Shape> list;

	private DrawingModel model;
	private int index ;

	public CmdUpdateRectangle(Rectangle oldRectangle, Rectangle newRectangle, DrawingModel model) {
		//super();
		this.oldRectangle = oldRectangle;
		this.newRectangle = newRectangle;
		this.model = model;
		index = model.getShapes().indexOf(oldRectangle);
		if(index==-1) {
			index=model.getShapes().size();
		}
	}

	@Override
	public void execute() {
		//setovane vrednosti za original
		/*original.getUpperLeftPoint().setX(oldRectangle.getUpperLeftPoint().getX());
		original.getUpperLeftPoint().setY(oldRectangle.getUpperLeftPoint().getY());
		original.setHeight(oldRectangle.getHeight());
		original.setWidth(oldRectangle.getWidth());
		original.setColor(oldRectangle.getColor());
		original.setInnerColor(oldRectangle.getInnerColor());*/
		
		original = oldRectangle.clone();
		
		//dajemo nove vrednosti za oldRectangle
		oldRectangle.getUpperLeftPoint().setX(newRectangle.getUpperLeftPoint().getX());
		oldRectangle.getUpperLeftPoint().setY(newRectangle.getUpperLeftPoint().getY());
		oldRectangle.setHeight(newRectangle.getHeight());
		oldRectangle.setWidth(newRectangle.getWidth());
		oldRectangle.setColor(newRectangle.getColor());
		oldRectangle.setInnerColor(newRectangle.getInnerColor());
		
		/*newRectangle.setSelected(true);
		oldRectangle.setSelected(false);
		
		model.remove(oldRectangle);
		model.addIndex(index, newRectangle);*/
	}

	@Override
	public void unexecute() {
		//resetujemo vrednosti koje su sacuvane u originalu
		oldRectangle.getUpperLeftPoint().setX(original.getUpperLeftPoint().getX());
		oldRectangle.getUpperLeftPoint().setY(original.getUpperLeftPoint().getY());
		oldRectangle.setHeight(original.getHeight());
		oldRectangle.setWidth(original.getWidth());
		oldRectangle.setColor(original.getColor());
		oldRectangle.setInnerColor(original.getInnerColor());
		
		/*newRectangle.setSelected(false);
		oldRectangle.setSelected(true);
		
		model.remove(newRectangle);
		model.addIndex(index, oldRectangle);*/
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
		return oldRectangle.toString() + " TO: " + newRectangle.toString();
	}
}

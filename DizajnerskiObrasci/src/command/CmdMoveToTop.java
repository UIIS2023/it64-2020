package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdMoveToTop implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Shape shape;
	private ArrayList<Shape> list;
	private int position; // sluzi nam za pracenje shape u listi

	private DrawingModel model;

	public CmdMoveToTop(Shape shape, ArrayList<Shape> list) {
		//super();
		this.shape = shape;
		this.list = list;
		this.position = list.indexOf(shape);
	}

	@Override
	public void execute() {
		shape = list.remove(position); // obrisi poziciju na kojoj je taj shape
		list.add(list.size() , shape); // dodaj ga na kraj liste 
		//Collections.swap(list, position, list.size()-1);
	}

	@Override
	public void unexecute() {
		shape = list.remove(list.size() - 1); // obrisi onaj sto si stavio na vrh
		list.add(position, shape); // vrati ga na poziciju gde je bio
		//Collections.swap(list, list.size()-1, position);
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

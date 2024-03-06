package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdMoveToBottom implements Command, Serializable {
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Shape shape;
	private ArrayList<Shape> list;
	private int position;

	private DrawingModel model;

	public CmdMoveToBottom(Shape shape, ArrayList<Shape> list) {
		//super();
		this.shape = shape;
		this.list = list;
		this.position = list.indexOf(shape);
	}

	@Override
	public void execute() {
		shape = list.remove(position); // obrisi shape sa te pozicije
		list.add(0, shape); // dodaj ga na pocetak
		//Collections.swap(list, position, 0);
	}

	@Override
	public void unexecute() {
		shape = list.remove(0); // obrisi ga sa pocetka
		list.add(position, shape); // totaj ga gde je bio
		//Collections.swap(list, 0, position);
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

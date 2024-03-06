package command;

import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public interface Command {
	
	void execute();
	
	void unexecute();

	//Potrebno za deserializaciju (ne iscrtava bez ovoga)
	void overrideModel(DrawingModel model);
	//Potrebno zbog serijalizacije
	void overrideListShapes(ArrayList<Shape> list);

}

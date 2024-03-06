package command;

import java.io.Serializable;
import java.util.ArrayList;

import mvc.DrawingModel;
import shapes.Circle;
import shapes.Shape;

public class CmdRedo implements Command, Serializable {
	
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Command cmd;
	private DrawingModel model;
	private ArrayList<Shape> list;
	public CmdRedo(Command cmd) {
		this.cmd = cmd;
	}

	@Override
	public void execute() {
		cmd.execute();
		
	}

	@Override
	public void unexecute() {
		cmd.unexecute();
		
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

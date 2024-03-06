package command;

import java.awt.Color;

import mvc.DrawingModel;
import shapes.Point;

public class Test {

	public static void main(String[] args) {
		Point point1 = new Point(10,10,Color.RED);
		Point point2 = new Point(20,20,Color.RED);
		DrawingModel model = new DrawingModel();
		
		CmdUpdatePoint cmd = new CmdUpdatePoint(point1, point2, model);
		cmd.execute();
		
		System.out.println(point1);
		
		cmd.unexecute();
		
		System.out.println(point1);

	}

}

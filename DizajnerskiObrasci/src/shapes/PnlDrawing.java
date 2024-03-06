package shapes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class PnlDrawing extends JScrollPane {

	private ArrayList<Shape> shapes;

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	private PnlDrawing(){
		shapes = new ArrayList<>();
	}

	private static PnlDrawing instance;

	public static PnlDrawing getInstance(){
		if(instance == null) {
			instance = new PnlDrawing();
		}
			return instance;
	}

	@Override
	public void paint(Graphics g) { 
		super.paint(g);
		Iterator<Shape> it = this.shapes.iterator();
		while(it.hasNext()) {
			it.next().draw(g);
		}
	}
}


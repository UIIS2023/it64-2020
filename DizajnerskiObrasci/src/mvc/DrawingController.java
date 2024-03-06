package mvc;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import adapter.HexagonAdapter;
import command.CmdAddCircle;
import command.CmdAddDonut;
import command.CmdAddHexagon;
import command.CmdAddLine;
import command.CmdAddPoint;
import command.CmdAddRectangle;
import command.CmdDeleteCircle;
import command.CmdDeleteDonut;
import command.CmdDeleteHexagon;
import command.CmdDeleteLine;
import command.CmdDeletePoint;
import command.CmdDeleteRectangle;
import command.CmdMoveDown;
import command.CmdMoveToBottom;
import command.CmdMoveToTop;
import command.CmdMoveUp;
import command.CmdRedo;
import command.CmdUpdateCircle;
import command.CmdUpdateDonut;
import command.CmdUpdateHexagon;
import command.CmdUpdateLine;
import command.CmdUpdatePoint;
import command.CmdUpdateRectangle;
import command.Command;
import command.CmdDeselectShape;
import command.CmdSelectShape;
import command.CmdUndo;
import drawings.ActiveButton;
import drawings.ActiveShape;
import drawings.DlgCircle;
import drawings.DlgDelete;
import drawings.DlgDonut;
import drawings.DlgHexagon;
import drawings.DlgLine;
import drawings.DlgPoint;
import drawings.DlgRectangle;
import hexagon.Hexagon;
import observer.EnableDisableBtn;
import shapes.Circle;
import shapes.Donut;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Shape;
import strategy.StategySaveSerialization;
import strategy.StrategyLog;

public class DrawingController implements Serializable {
	
	private EnableDisableBtn enableLeftRightFrame;

	private DrawingFrame frame;
	private DrawingModel model;
	private ActiveButton activeButton;
	private ActiveShape activeShape;
	private Shape selectedShape;
	private List<Shape> selectedShapes;
	private boolean firstClick = true;
	private int xCordinate, yCordinate, x1Cordinate, y1Cordinate;
	private Color color;
	private Color innerColor;
	//mora k zbog selekcije samo 1 kada imaju iste x i y koordinate
	private Shape k;
	private List<Shape> selectedShapeDelAll;
	
	//za serialization
	private static final long serialVersionUID = 6539685248167757695L;
	
	private Stack<Command> undoStack, redoStack;
	//
	private Stack<Command> allStack = new Stack<Command>();

	public DrawingController(DrawingModel drawingModel, DrawingFrame drawingFrame) {
		this.model = drawingModel;
		this.frame = drawingFrame;
		this.enableLeftRightFrame = new EnableDisableBtn(frame.getLeftFrame(), frame.getRightFrame());
		model.addObserver(enableLeftRightFrame);
		//proba
		this.activeButton = ActiveButton.None;
		this.activeShape = ActiveShape.None;
		this.selectedShape = null;
		
		this.selectedShapes = model.getShapes();
		this.selectedShapeDelAll = new ArrayList<>();
		
		//undo/redo
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
		
		//Color i innercolor
		color = new Color(0,0,0);
		innerColor  = new Color(255,255,255,1);
		
		//enable UndoRedo
		chechUndoRedo();
		//firstClick
		//firstClick=false; //zbog izmena zakomentarisano ovo je potrebno kada pokrecem preko aplikacije
	}
	//MOuseCLICKED
	public void mouseClick(MouseEvent arg0) {
		
		//xCordinate = arg0.getX();
		//yCordinate = arg0.getY();
		if(activeButton==activeButton.Add) {
		
		if(frame.getLeftFrame().selectedButton() == "Point")
		{
			xCordinate = arg0.getX();
			yCordinate = arg0.getY();
			activeShape=activeShape.Point;
			openAddDialog(xCordinate, yCordinate, 0,0);
		}
		else if(frame.getLeftFrame().selectedButton() == "Line") {
			activeShape=activeShape.Line;
			if(firstClick) {
				xCordinate = arg0.getX();
				yCordinate = arg0.getY();
			}
			else {
				x1Cordinate = arg0.getX();
				y1Cordinate = arg0.getY();
				openAddDialog(xCordinate, yCordinate, x1Cordinate, y1Cordinate);
			}
			firstClick = !firstClick;	
		}else if(frame.getLeftFrame().selectedButton() == "Rectangle") {
			activeShape=activeShape.Rectangle;
			xCordinate = arg0.getX();
			yCordinate = arg0.getY();
			openAddDialog(xCordinate, yCordinate, 0,0);
		}else if(frame.getLeftFrame().selectedButton() == "Circle") {
			activeShape=activeShape.Circle;
			xCordinate = arg0.getX();
			yCordinate = arg0.getY();
			openAddDialog(xCordinate, yCordinate, 0,0);
		}else if(frame.getLeftFrame().selectedButton() == "Donut") {
			activeShape=activeShape.Donut;
			xCordinate = arg0.getX();
			yCordinate = arg0.getY();
			openAddDialog(xCordinate, yCordinate, 0,0);
		}else if(frame.getLeftFrame().selectedButton() == "Hexagon") {
			activeShape=activeShape.Hexagon;
			xCordinate = arg0.getX();
			yCordinate = arg0.getY();
			openAddDialog(xCordinate, yCordinate, 0,0);
		}
	}
		if(activeButton==activeButton.Select) {
			setSelectedShape(null);
			//selectedShapes = new ArrayList();
			xCordinate = arg0.getX();
			yCordinate = arg0.getY();
			boolean anyShapeClicked = false;
			
			ArrayList<Shape> allShapes = model.getShapes();
			// k se stavlja na poslednji sa istim koordinatama
			for(Shape s : allShapes) {
				if(s.contains(xCordinate, yCordinate)) {
					k=s;
				}
				
			}
			if(k!=null) {//mora zato sto puca kad se klikne van oblika
				if(k.contains(xCordinate, yCordinate)) {
					anyShapeClicked = true;
					int sIndex = selectedShapes.indexOf(k);
					k.setSelected(!k.isSelected());
					selectedShapes.set(sIndex, k);
					if(k.isSelected()) {
						setSelectedShape(k);
						CmdSelectShape cmd = new CmdSelectShape(k);
						cmd.execute();
						undoStack.push(cmd);
						allStack.push(cmd);
						redoStack.clear();
						frame.getLogFrame().getModel().addElement("Select: " + k.toString());
					} else {
						//setSelectedShape(null);
						CmdDeselectShape cmdD = new CmdDeselectShape(k);
						cmdD.execute();
						undoStack.push(cmdD);
						allStack.push(cmdD);
						redoStack.clear();
						frame.getLogFrame().getModel().addElement("Deselect: " + k.toString());
					}
				}
			}
			//
			/*for (Shape s  : allShapes) {
				if(s.contains(xCordinate, yCordinate)) {
					anyShapeClicked = true;
					int sIndex = selectedShapes.indexOf(s);
					s.setSelected(!s.isSelected());
					selectedShapes.set(sIndex, s);
					if(s.isSelected()) {
						setSelectedShape(s);
						CmdSelectShape cmd = new CmdSelectShape(s);
						cmd.execute();
						undoStack.push(cmd);
						frame.getLogFrame().getModel().addElement("Select: " + s.toString());						
					} else {
						//setSelectedShape(null);
						CmdDeselectShape cmdD = new CmdDeselectShape(s);
						cmdD.execute();
						undoStack.push(cmdD);
						frame.getLogFrame().getModel().addElement("Deselect: " + s.toString());
					}
				} */
				/*else {
					//setSelectedShape(null);
					CmdDeselectShape cmdD = new CmdDeselectShape(s);
					cmdD.execute();
					undoStack.push(cmdD);
					frame.getLogFrame().getModel().addElement("Deselect," + s.toString());
				}*/
		//OVA ZAGRADA ZA FOR}
			
			if(!anyShapeClicked) {
				List<Shape> selectedTmp = selectedShapes;
				for(int i = 0; i < selectedTmp.size(); i++) {
					if(selectedShapes.get(i).isSelected()) {
						Shape tmp = selectedShapes.get(i);
						tmp.setSelected(false);
						selectedShapes.set(i, tmp);
						CmdDeselectShape cmdD = new CmdDeselectShape(tmp);
						cmdD.execute();
						undoStack.push(cmdD);
						allStack.push(cmdD);
						redoStack.clear();
						frame.getLogFrame().getModel().addElement("Deselect: " + tmp.toString());
					}/*
						Shape tmp = selectedShapes.get(i);
						tmp.setSelected(false);
						selectedShapes.set(i, tmp);
						/*CmdDeselectShape cmdD = new CmdDeselectShape(tmp);
						cmdD.execute();
						undoStack.push(cmdD);
						frame.getLogFrame().getModel().addElement("Deselect," + tmp.toString());
					*/
				}
			}
			
			
			frame.repaint();//moras ponovo da iscrtas na platnu
			model.notifyObservers();
			//UndoRedo
			chechUndoRedo();
		  }
}
	
	public void openAddDialog(int xCordinate, int yCordinate, int x1Cordinate, int y1Cordinate) {
		if(activeShape == activeShape.Point) {
			DlgPoint dialog = new DlgPoint(xCordinate, yCordinate, this.color);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Point");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Line) {
			DlgLine dialog = new DlgLine(xCordinate, yCordinate, x1Cordinate, y1Cordinate, this.color);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Line");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Rectangle) {
			DlgRectangle dialog = new DlgRectangle(xCordinate, yCordinate, 0, 0, this.color, this.innerColor);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Rectangle");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Circle) {
			DlgCircle dialog = new DlgCircle(xCordinate, yCordinate, 0, this.color, this.innerColor);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Circle");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Donut) {
			DlgDonut dialog = new DlgDonut(xCordinate, yCordinate, 0, 0, this.color, this.innerColor);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Donut");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Hexagon) {
			DlgHexagon dialog = new DlgHexagon(xCordinate, yCordinate, 0, this.color, this.innerColor);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Hexagon");
			dialog.setVisible(true);
		}
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
/*
	public void openAddDialog(int xCordinate, int yCordinate, int x1Cordinate, int y1Cordinate) {
		if(activeShape == activeShape.Point) {
			DlgPoint dialog = new DlgPoint(xCordinate, yCordinate, Color.BLACK);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Point");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Line) {
			DlgLine dialog = new DlgLine(xCordinate, yCordinate, x1Cordinate, y1Cordinate, Color.BLACK);
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Line");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Rectangle) {
			DlgRectangle dialog = new DlgRectangle(xCordinate, yCordinate, 0, 0, Color.BLACK, new Color(238, 238, 238, 0));
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Rectangle");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Circle) {
			DlgCircle dialog = new DlgCircle(xCordinate, yCordinate, 0, Color.BLACK, new Color(238, 238, 238, 0));
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Circle");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Donut) {
			DlgDonut dialog = new DlgDonut(xCordinate, yCordinate, 0, 0, Color.BLACK, new Color(238, 238, 238, 0));
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Donut");
			dialog.setVisible(true);
		}
		if(activeShape == activeShape.Hexagon) {
			DlgHexagon dialog = new DlgHexagon(xCordinate, yCordinate, 0, Color.BLACK, new Color(238,238,238,0));
			dialog.setController(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Hexagon");
			dialog.setVisible(true);
		}
		frame.repaint();
	}
*/
	public void openModifyDialog() {
		//
		for (Shape s  : model.getShapes()) {
			if(s.isSelected()) {
				setSelectedShape(s);
			}
		}
		//
		if(selectedShape != null) {
			if(selectedShape.getClass() == Point.class) {
				Point p = (Point)selectedShape;
				DlgPoint dialog = new DlgPoint(p.getX(), p.getY(), p.getColor(), p);
				dialog.setController(this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setTitle("Modify Point");
				dialog.setVisible(true);
			}
		}

		if(selectedShape != null) {
			if(selectedShape.getClass() == Line.class) {
				Line l = (Line)selectedShape;
				DlgLine dialog = new DlgLine(l.getStartPoint().getX(), l.getStartPoint().getY(), l.getEndPoint().getX(), l.getEndPoint().getY(), l.getColor(), l);
				dialog.setController(this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setTitle("Modify Line");
				dialog.setVisible(true);
			}
		}
		if(selectedShape != null) {
			if(selectedShape.getClass() == Rectangle.class) {
				Rectangle r = (Rectangle)selectedShape;
				DlgRectangle dialog = new DlgRectangle(r.getUpperLeftPoint().getX(), r.getUpperLeftPoint().getY(), r.getWidht(), r.getHeight(), r.getColor(), r.getInnerColor(), r);
				dialog.setController(this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setTitle("Modify Rectangle");
				dialog.setVisible(true);
			}
		}

		if(selectedShape != null) {
			if(selectedShape.getClass() == Circle.class) {
				Circle c = (Circle)selectedShape;
				DlgCircle dialog = new DlgCircle(c.getCenter().getX(), c.getCenter().getY(), c.getRadius(), c.getColor(), c.getInnerColor(), c);
				dialog.setController(this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setTitle("Modify Circle");
				dialog.setVisible(true);
			}
		}
		if(selectedShape != null) {
			if(selectedShape.getClass() == Donut.class) {
				Donut d = (Donut)selectedShape;
				DlgDonut dialog = new DlgDonut(d.getCenter().getX(), d.getCenter().getY(), d.getRadius(), d.getInnerRadius(), d.getColor(), d.getInnerColor(), d);
				dialog.setController(this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setTitle("Modify Donut");
				dialog.setVisible(true);
			}
		}
		if(selectedShape != null) {
			if(selectedShape.getClass() == HexagonAdapter.class) {
				HexagonAdapter h = (HexagonAdapter) selectedShape;
				DlgHexagon dialog = new DlgHexagon(h.getX(), h.getY(), h.getRadius(), h.getColor(), h.getInnerColor(), h);
				dialog.setController(this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setTitle("Modify Hexagon");
				dialog.setVisible(true);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No shape selected", "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}

	public void deleteSelectedShape() {
		// OVO MORA DA BI ZAPAMTIO KOJI JE SELEKTOVAN OPET DA PRODJE KROZ OBLIKE
		for (Shape s  : model.getShapes()) {
			if(s.isSelected()) {
				setSelectedShape(s);			
			}
		}
		//
		if(selectedShape != null) {
			
			DlgDelete dialog = new DlgDelete(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Are you sure you want to delete shape?");
			dialog.setVisible(true);
			
			//model.getShapes().remove(selectedShape);
			frame.getView().paint(frame.getView().getGraphics());
		}else
		{
			JOptionPane.showMessageDialog(null, "No shape selected", "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void executeDeleteShape() {
		for(int i = 0; i < model.getShapes().size(); i++)
		{
			if(model.getShapes(i).isSelected())
			{
				Shape s = model.getShapes(i); 
				
				if(s instanceof Point)
				{
					Point p = (Point) s;
					CmdDeletePoint cmd = new CmdDeletePoint(this.model, p);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					frame.getLogFrame().getModel().addElement("Delete: " + p.toString());
					redoStack.clear();
					//selectedShape.setSelected(false);
				}
				if(s instanceof Line)
				{
					Line l = (Line) s;
					CmdDeleteLine cmd = new CmdDeleteLine(this.model, l);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					frame.getLogFrame().getModel().addElement("Delete: " + l.toString());
					redoStack.clear();
					//selectedShape.setSelected(false);
				}
				if(s instanceof Rectangle)
				{
					Rectangle r = (Rectangle) s;
					CmdDeleteRectangle cmd = new CmdDeleteRectangle(this.model, r);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					frame.getLogFrame().getModel().addElement("Delete: " + r.toString());
					redoStack.clear();
					//selectedShape.setSelected(false);
				}
				if(s instanceof Donut)
				{
					Donut d = (Donut) s;
					CmdDeleteDonut cmd = new CmdDeleteDonut(this.model, d);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					frame.getLogFrame().getModel().addElement("Delete: " + d.toString());
					redoStack.clear();
					//selectedShape.setSelected(false);
					break;
				}
				if(s instanceof Circle)
				{
					Circle c = (Circle) s;
					CmdDeleteCircle cmd = new CmdDeleteCircle(this.model, c);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					frame.getLogFrame().getModel().addElement("Delete: " + c.toString());
					redoStack.clear();
					//selectedShape.setSelected(false);
				}
				if(s instanceof HexagonAdapter) {
					HexagonAdapter h = (HexagonAdapter) s;
					CmdDeleteHexagon cmd = new CmdDeleteHexagon(this.model, h);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					frame.getLogFrame().getModel().addElement("Delete: " + h.toString());
					redoStack.clear();
					//selectedShape.setSelected(false);
				}
			}
		}
		//UndoRedo
			chechUndoRedo();
			model.notifyObservers();
			frame.repaint();
	}

	public void deleteAllShapes() {
		/*if(model.getShapes().size() >= 2) {
			model.getShapes().clear();
			frame.getView().paint(frame.getView().getGraphics());
		}*/
		for (Shape s  : model.getShapes()) {
			if(s.isSelected()) {
				System.out.println(s);
				selectedShapeDelAll.add(s);			
			}
			else {
				continue;
			}
		}
		if(selectedShapeDelAll.size() >= 2) {
			while(selectedShapeDelAll.size() != 0) {
				for(int i = 0; i < selectedShapeDelAll.size(); i++)
				{
						//Shape s = model.getShapes(i); 
					Shape s = selectedShapeDelAll.get(i);
					System.out.println(s);	
						if(s instanceof Point)
						{
							Point p = (Point) s;
							CmdDeletePoint cmd = new CmdDeletePoint(this.model, p);
							cmd.execute();
							undoStack.push(cmd);
							frame.getLogFrame().getModel().addElement("Delete: " + p.toString());
							//selectedShape.setSelected(false);
						}
						if(s instanceof Line)
						{
							Line l = (Line) s;
							CmdDeleteLine cmd = new CmdDeleteLine(this.model, l);
							cmd.execute();
							undoStack.push(cmd);
							frame.getLogFrame().getModel().addElement("Delete: " + l.toString());
							//selectedShape.setSelected(false);
						}
						if(s instanceof Rectangle)
						{
							Rectangle r = (Rectangle) s;
							CmdDeleteRectangle cmd = new CmdDeleteRectangle(this.model, r);
							cmd.execute();
							undoStack.push(cmd);
							frame.getLogFrame().getModel().addElement("Delete: " + r.toString());
							//selectedShape.setSelected(false);
						}
						if(s instanceof Donut)
						{
							Donut d = (Donut) s;
							CmdDeleteDonut cmd = new CmdDeleteDonut(this.model, d);
							cmd.execute();
							undoStack.push(cmd);
							frame.getLogFrame().getModel().addElement("Delete: " + d.toString());
							//selectedShape.setSelected(false);
							break;
						}
						if(s instanceof Circle)
						{
							Circle c = (Circle) s;
							CmdDeleteCircle cmd = new CmdDeleteCircle(this.model, c);
							cmd.execute();
							undoStack.push(cmd);
							frame.getLogFrame().getModel().addElement("Delete: " + c.toString());
							//selectedShape.setSelected(false);
							break;
						}
						if(s instanceof HexagonAdapter) {
							HexagonAdapter h = (HexagonAdapter) s;
							CmdDeleteHexagon cmd = new CmdDeleteHexagon(this.model, h);
							cmd.execute();
							undoStack.push(cmd);
							frame.getLogFrame().getModel().addElement("Delete: " + h.toString());
							//selectedShape.setSelected(false);
						}
						System.out.println("AAA");
						selectedShapeDelAll.remove(i);
					}
			}
		}
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
	public void drawPoint(int xCord, int yCord, Color color)
	{
		Point point = new Point(xCord, yCord, color);
		frame.getLogFrame().getModel().addElement("Add:" + point.toString());
		CmdAddPoint cmd = new CmdAddPoint(this.model, point);
		cmd.execute();
		undoStack.push(cmd);
		allStack.push(cmd);
		redoStack.clear();
		//model.getShapes().add(point); //umesto ovoga idemo preko Cmd obrazca !!!!
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
	public void modifyPoint(int xCord, int yCord, Color color, Point point) {
		//prolazimo kroz niz, onaj koji je selektovan taj je stari point
		for(int i = 0; i < model.getShapes().size(); i++)
		{
			if(model.getShapes(i).isSelected())
			{
				Shape old = model.getShapes(i);
				if(old instanceof Point) {
					Point oldPoint = (Point) old;
					Point newPoint = new Point();
					
					newPoint.setX(xCord);
					newPoint.setY(yCord);
					newPoint.setColor(color);
					
					frame.getLogFrame().getModel().addElement("Modify: " + oldPoint.toString() + " to: " + newPoint.toString());
					CmdUpdatePoint cmd = new CmdUpdatePoint(oldPoint, newPoint, model);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					redoStack.clear();
				}
			}	
		}
		//
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
	public void drawLine(int xCord, int yCord, int x1Cord, int y1Cord, Color color)
	{
		Line line = new Line(new Point(xCord, yCord),new Point( x1Cord, y1Cord), color);
		frame.getLogFrame().getModel().addElement("Add: " + line.toString());
		CmdAddLine cmd = new CmdAddLine(this.model, line);
		cmd.execute();
		undoStack.push(cmd);
		allStack.push(cmd);
		redoStack.clear();
		//model.getShapes().add(line);
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
	public void modifyLine(int xCord, int yCord, int x1Cord, int y1Cord, Color color, Line line)
	{
		/*
		line.setStartPoint(new Point(xCord, yCord));
		line.setEndPoint(new Point(x1Cord, y1Cord));
		line.setColor(color);
		
		Line copy = line.clone();
		CmdUpdateLine cmd = new CmdUpdateLine(copy, line);
		cmd.execute();
		undoStack.push(cmd);
		*/
		
		for(int i = 0; i < model.getShapes().size(); i++)
		{
			if(model.getShapes(i).isSelected())
			{
				Shape old = model.getShapes(i);
				if(old instanceof Line) {
					Line oldLine = (Line) old;
					Line newLine = new Line();					
					
					newLine.setStartPoint(new Point(xCord, yCord));
					newLine.setEndPoint(new Point(x1Cord, y1Cord));
					newLine.setColor(color);
					
					frame.getLogFrame().getModel().addElement("Modify: " + oldLine.toString() + " to: " + newLine.toString());
					CmdUpdateLine cmd = new CmdUpdateLine(oldLine, newLine, model);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					redoStack.clear();
				}
			}	
		}
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
	public void drawRectangle(int xCord, int yCord, int height,  int width, Color color, Color innerColor)
	{
		Rectangle rectangle = new Rectangle(new Point(xCord, yCord), height, width, color, innerColor);
		frame.getLogFrame().getModel().addElement("Add: " + rectangle.toString());
		CmdAddRectangle cmd = new CmdAddRectangle(this.model, rectangle);
		cmd.execute();
		undoStack.push(cmd);
		allStack.push(cmd);
		redoStack.clear();
		//model.getShapes().add(rectangle);
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
	public void modifyRectangle(int xCord, int yCord, int height,  int width, Color color, Color innerColor, Rectangle rectangle)
	{
		/*
		rectangle.setUpperLeftPoint(new Point(xCord, yCord));
		rectangle.setHeight(height);
		rectangle.setWidth(width);
		rectangle.setColor(color);
		rectangle.setInnerColor(innerColor);
		
		Rectangle copy = rectangle.clone();*/
		
		for(int i = 0; i < model.getShapes().size(); i++)
		{
			if(model.getShapes(i).isSelected())
			{
				Shape old = model.getShapes(i);
				if(old instanceof Rectangle) {
					
					Rectangle oldRectangle = (Rectangle) old;
					Rectangle newRectangle = new Rectangle();
					
					newRectangle.setUpperLeftPoint(new Point(xCord, yCord));
					newRectangle.setHeight(height);
					newRectangle.setWidth(width);
					newRectangle.setColor(color);
					newRectangle.setInnerColor(innerColor);
					
					frame.getLogFrame().getModel().addElement("Modify: " + oldRectangle.toString() + " to: " + newRectangle.toString());
					CmdUpdateRectangle cmd = new CmdUpdateRectangle(oldRectangle, newRectangle, model);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					redoStack.clear();
					break;
				}
			}
		}
		
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	
	public void drawCircle(int xCord, int yCord, int r, Color color, Color innerColor) {
		Circle circle = new Circle(new Point(xCord, yCord), r, color, innerColor);
		frame.getLogFrame().getModel().addElement("Add: " + circle.toString());
		CmdAddCircle cmd = new CmdAddCircle(this.model, circle);
		cmd.execute();
		undoStack.push(cmd);
		allStack.push(cmd);
		redoStack.clear();
		//model.getShapes().add(circle);
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}

	public void modifyCircle(int xCord, int yCord, int r, Color color, Color innerColor, Circle circle) {
		/*
		circle.setCenter(new Point(xCord, yCord));
		circle.setColor(color);
		circle.setInnerColor(innerColor);
		try {
			circle.setRadius(r);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Circle copy = circle.clone();
		*/
		

		for(int i = 0; i < model.getShapes().size(); i++)
		{
			if(model.getShapes(i).isSelected())
			{
				Shape old = model.getShapes(i);
				if(old instanceof Circle)
				{			
					Circle oldCircle = (Circle) old;
					Circle newCircle = new Circle();
					
					newCircle.setCenter(new Point(xCord, yCord));
					newCircle.setColor(color);
					newCircle.setInnerColor(innerColor);
					try {
						newCircle.setRadius(r);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					frame.getLogFrame().getModel().addElement("Modify: " + oldCircle.toString() + " to: " + newCircle.toString());
					CmdUpdateCircle cmd = new CmdUpdateCircle(oldCircle, newCircle, model);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					redoStack.clear();
					break;
				}
			}
		}
		
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
	}
	public void drawDonut(int xCord, int yCord, int r, int innerR, Color color, Color innerColor)
	{
		try {
			Donut donut = new Donut(new Point(xCord,yCord), r, innerR, color, innerColor);
			frame.getLogFrame().getModel().addElement("Add: " + donut.toString());
			CmdAddDonut cmd = new CmdAddDonut(this.model, donut);
			cmd.execute();
			undoStack.push(cmd);
			allStack.push(cmd);
			redoStack.clear();
			//model.getShapes().add(donut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
			
	}
	
	public void modifyDonut(int xCord, int yCord, int r, int innerR, Color color, Color innerColor, Donut donut)
	{
		/*
		donut.setCenter(new Point(xCord, yCord));
		donut.setColor(color);
		donut.setInnerColor(innerColor);
		try {
			donut.setRadius(r);
			donut.setInnerRadius(innerR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Donut copy = donut.clone();*/
		
		for(int i = 0; i < model.getShapes().size(); i++)
		{
			if(model.getShapes(i).isSelected())
			{
				Shape old = model.getShapes(i);
				if(old instanceof Donut)
				{
					Donut oldDonut = (Donut) old;
					Donut newDonut = new Donut();
					
					newDonut.setCenter(new Point(xCord, yCord));
					newDonut.setColor(color);
					newDonut.setInnerColor(innerColor);
					try {
						newDonut.setRadius(r);
						newDonut.setInnerRadius(innerR);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					frame.getLogFrame().getModel().addElement("Modify: " + oldDonut.toString() + " to: " + newDonut.toString());
					CmdUpdateDonut cmd = new CmdUpdateDonut(oldDonut, newDonut, model);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					redoStack.clear();
					break;
				}
			}
		}
		
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
		
	}
	
	public void drawHexagon(int xCord, int yCord, int radius, Color color, Color innerColor) {
		
		HexagonAdapter hexagon = new HexagonAdapter(new Point(xCord,yCord), radius, color, innerColor);
		frame.getLogFrame().getModel().addElement("Add: " + hexagon.toString());
		CmdAddHexagon cmd = new CmdAddHexagon(this.model, hexagon);
		cmd.execute();
		undoStack.push(cmd);
		allStack.push(cmd);
		redoStack.clear();
	}
	
	public void modifyHexagon(int xCord, int yCord, int radius, Color color, Color innerColor, HexagonAdapter hexagon) {
		for(int i = 0; i < model.getShapes().size(); i++)
		{
			if(model.getShapes(i).isSelected())
			{
				Shape old = model.getShapes(i);
				if(old instanceof HexagonAdapter)
				{
					HexagonAdapter oldHexagon = (HexagonAdapter) old;
					HexagonAdapter newHexagon = new HexagonAdapter();
					
					newHexagon.setX(xCord);
					newHexagon.setY(yCord);
					newHexagon.setColor(color);
					newHexagon.setInnerColor(innerColor);
					try {
						newHexagon.setRadius(radius);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					
					frame.getLogFrame().getModel().addElement("Modify: " + oldHexagon.toString() + " to: " + newHexagon.toString());
					CmdUpdateHexagon cmd = new CmdUpdateHexagon(oldHexagon, newHexagon, model);
					cmd.execute();
					undoStack.push(cmd);
					allStack.push(cmd);
					redoStack.clear();
					break;
				}
			}
		}	
		//UndoRedo
		chechUndoRedo();
		frame.repaint();
		
	}
	
	public ActiveButton getActiveButton() {
		return activeButton;
	}

	public void setActiveButton(ActiveButton activeButton) {
		this.activeButton = activeButton;
	}

	public ActiveShape getActiveShape() {
		return activeShape;
	}

	public void setActiveShape(ActiveShape activeShape) {
		this.activeShape = activeShape;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}
	/*
	public void deselectShape(Shape selectedShape) {
		this.selectedShape = null;
	}*/
	//COLOR FROM LEFTFRAME
	public Color setColor(Color btnColor) {
		return this.color = btnColor;
	}
	
	// INNERCOLOR FROM LEFTFRAME
		public Color setInnerColor(Color btnColor) {
			return this.innerColor = btnColor;
		}
	
	
	//ACTIVE BUTTONS
	public void setActiveButtonNone() {
		activeButton = activeButton.None;
	}
	public void setActiveButtonAdd() {
		activeButton = activeButton.Add;
	}
	public void setAcitveButtonSelect() {
		activeButton = activeButton.Select;
	}
	
	//UNDO REDO
	public Stack<Command> getUndoStack() {
		return undoStack;
	}
	
	public void undo() {
		if(!undoStack.isEmpty())
		{
			//frame.getRightFrame().getUndo().setEnabled(true);
			Command cmd = undoStack.pop();
			CmdUndo cmdU = new CmdUndo(cmd);
			cmd.unexecute();
			redoStack.push(cmd);
			allStack.push(cmdU);
			frame.getLogFrame().getModel().addElement("Undo: " + cmd.toString());
		}
		else
		{
			//frame.getRightFrame().getUndo().setEnabled(false);
			JOptionPane.showMessageDialog(null, "Undo cant be used", "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
		// da opet selektuje oblik 
		for (Shape s  : model.getShapes()) {
			if(s.isSelected()) {
				setSelectedShape(s);
			}
		}
		//
		//UndoRedo
		chechUndoRedo();
		model.notifyObservers();
		frame.repaint();
	}
	
	public void redo() {
		if (!redoStack.empty()) {
			//frame.getRightFrame().getRedo().setEnabled(true);
			Command cmd = redoStack.pop();
			CmdRedo cmdD = new CmdRedo(cmd);
			cmd.execute();			
			undoStack.push(cmd);
			allStack.push(cmdD);
			frame.getLogFrame().getModel().addElement("Redo: " + cmd.toString());
		}
		else
		{
			//frame.getRightFrame().getRedo().setEnabled(false);
		}
		// da opet selektuje oblik 
				for (Shape s  : model.getShapes()) {
					if(s.isSelected()) {
						setSelectedShape(s);
					}
				}
				//
		//UndoRedo
		chechUndoRedo();
		model.notifyObservers();
		frame.repaint();
	}
	
	//MoveUP :
	public void moveUp() {
		for(Shape s : model.getShapes()) {
			if(s.isSelected()) {
				CmdMoveUp cmd = new CmdMoveUp(s, model.getShapes());
				cmd.execute();
				undoStack.push(cmd);
				allStack.push(cmd);
				redoStack.clear();
				frame.getLogFrame().getModel().addElement("Move Up: " + cmd.toString());
				break;
			}
		}
		//UndoRedo
		chechUndoRedo();
		model.notifyObservers();
		frame.repaint();
		
	}
	
	//MoveDown
	public void moveDown() {
		for(Shape s : model.getShapes()) {
			if(s.isSelected()) {
				CmdMoveDown cmd = new CmdMoveDown(s, model.getShapes());
				cmd.execute();
				undoStack.push(cmd);
				allStack.push(cmd);
				redoStack.clear();
				frame.getLogFrame().getModel().addElement("Move Down: " + cmd.toString());
				break;
			}
		}
		//UndoRedo
		chechUndoRedo();
		model.notifyObservers();
		frame.repaint();
	}
	
	//MoveToTop
	public void moveToTop() {
		for(Shape s : model.getShapes()) {
			if(s.isSelected()) {
				CmdMoveToTop cmd = new CmdMoveToTop(s, model.getShapes());
				cmd.execute();
				undoStack.push(cmd);
				allStack.push(cmd);
				redoStack.clear();
				frame.getLogFrame().getModel().addElement("To Top: " + cmd.toString());
				break;
			}
		}
		//UndoRedo
		chechUndoRedo();
		model.notifyObservers();
		frame.repaint();
	}
	
	//MoveToBottom
	public void moveToBottom() {
		for(Shape s : model.getShapes()) {
			if(s.isSelected()) {
				CmdMoveToBottom cmd = new CmdMoveToBottom(s, model.getShapes());
				cmd.execute();
				undoStack.push(cmd);
				allStack.push(cmd);
				redoStack.clear();
				frame.getLogFrame().getModel().addElement("To Bottom: " + cmd.toString());
				break;
			}
		}
		//UndoRedo
		chechUndoRedo();
		model.notifyObservers();
		frame.repaint();
	}
	
	public void chechUndoRedo() {
		if(undoStack.size()==0) {
			frame.getRightFrame().getUndo().setEnabled(false);
		}
		else {
			frame.getRightFrame().getUndo().setEnabled(true);
		}
		
		if(redoStack.size()==0) {
			frame.getRightFrame().getRedo().setEnabled(false);
		}else{
			frame.getRightFrame().getRedo().setEnabled(true);
		}
	}
	
	//Log and Serialization
	public void saveLog() {
		//DODATO
		//Stack<Command> allStack2 = new Stack<Command>();
		/*for(int i = 0; i <= allStack.size(); i++) {
			Command cmd = allStack.pop();
			cmd.unexecute();
			allStack2.push(cmd);
		}*/
		/*while(allStack.size() != 0) {
			Command cmd = allStack.pop();
			cmd.unexecute();
			allStack2.push(cmd);
		}*/
		/*for(Command c : allStack) {
            allStack2.push(c);
        }*/
		//izvrsi sve od poslednje
		for(int i = allStack.size()-1; i >= 0; i--) {
			allStack.get(i).unexecute();
		}
		StrategyLog ssl = new StrategyLog(frame.getLogFrame(), undoStack, redoStack, frame, model, allStack);
		ssl.saveStrategy();
		//uradi sve od prve
		for(int i = 0; i <= allStack.size()-1; i++) {
			allStack.get(i).execute();
		}
	}
	public void loadLog() {
		StrategyLog ssl = new StrategyLog(frame.getLogFrame(), undoStack, redoStack, frame, model, allStack);
		ssl.loadStrategy();
		chechUndoRedo();
	}
	public void saveSerialization() {
		StategySaveSerialization sss = new StategySaveSerialization(undoStack, redoStack, frame, model);
		sss.saveStrategy();
	}
	public void loadSerialization() {
		StategySaveSerialization sss = new StategySaveSerialization(undoStack, redoStack, frame, model);
		sss.loadStrategy();
		chechUndoRedo();
	}
}

package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape implements Cloneable {
	
	private Point startPoint;
	private Point endPoint;
	private Color color;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, Color color){
		this(startPoint, endPoint);
		this.color = color;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public Point getStartPoint() {
		return startPoint; //this.startPoint
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public boolean contains(int x, int y) {
		return startPoint.distance(x, y) + endPoint.distance(x, y) - this.length() <= 2;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line)obj;
			if(startPoint.equals(pomocna.startPoint) && endPoint.equals(pomocna.endPoint))
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	
	public String toString() {
		return "Line: " + ("("+startPoint.getX()+", "+startPoint.getY()+")") + "-->" + ("("+endPoint.getX()+", "+endPoint.getY()+")") + " Color: " + color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getStartPoint().getX() - 2, getStartPoint().getY()-2, 4, 4);
			g.drawRect(getEndPoint().getX() - 2, getEndPoint().getY() - 2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (this.length() - ((Line)o).length());
		}
		return 0;
	}
	
	public Line clone() {
		/*
		try {
			Line line = (Line) super.clone();
			return line;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		*/
		Point startP = new Point(this.getStartPoint().getX(), this.getStartPoint().getY());
		Point endP = new Point(this.getEndPoint().getX(), this.getEndPoint().getY());
		
		Line line = new Line(startP, endP, getColor());
		/*
		line.getStartPoint().setX(this.getStartPoint().getX());
		line.getStartPoint().setY(this.getStartPoint().getY());
		line.getEndPoint().setX(this.getEndPoint().getX());
		line.getEndPoint().setY(this.getEndPoint().getY());
		line.setColor(color);*/
		
		return line;
	}
	
}


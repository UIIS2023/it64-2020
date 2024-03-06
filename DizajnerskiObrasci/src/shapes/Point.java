package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape implements Cloneable {
	private int x; //samo vidljive u okviru klase Point
	private int y;
	private Color color;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	//konstruktori:
	public Point() {
		
	}
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public Point(int x, int y, Color color, boolean selected) {
		this(x, y, color);
		this.selected = selected;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pomocna = (Point)obj;
			if(this.x == pomocna.x && this.y == pomocna.y)
				return true;
			else 
				return false;
		}else
			return false;
	}
	
	public boolean contains (int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy *dy);
		//return Math.sqrt(dx * dx + dy * dy);
		return d;
	}		
	public String toString() {
		return "Point: " + "(" + x + ", " + y + ")" + " Color: " + color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y + 2, x, y - 2);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y = this.y + byY;
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			return (int) (this.distance(0, 0) - ((Point)o).distance(0, 0));
		}
		return 0;
	}
	
	public Point clone() {
		/*
		try {
			Point point = (Point) super.clone();
			return point;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		*/
		Point point = new Point();
		point.setX(this.getX());
		point.setY(this.getY());
		point.setColor(this.color);
		return point;
	}
	
}


package adapter;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.Circle;
import shapes.Point;
import shapes.Shape;

public class HexagonAdapter extends Shape {
	
	private Hexagon hexagon = new Hexagon(0, 0, 0);
	
	public HexagonAdapter () {
		
	}

	public HexagonAdapter(Hexagon hexagon) {
		super();
		this.hexagon = hexagon;
	}
	
	public HexagonAdapter(Point p, int radius) {
		hexagon = new Hexagon(p.getX(),  p.getY(), radius);
	}
	
	public HexagonAdapter(Point p, int radius, Color color) {
		this(p, radius);
		this.setColor(color);
	}
	public HexagonAdapter(Point p, int radius, Color color, Color innerColor)
	{
		this(p, radius, color);
		this.setInnerColor(innerColor);
	}
	public Color getInnerColor() {
		return hexagon.getAreaColor();
	}
	public void setInnerColor(Color innerColor) {
		hexagon.setAreaColor(innerColor);
	}
	public Color getColor() {
		return hexagon.getBorderColor();
	}
	public void setColor(Color color) {
		hexagon.setBorderColor(color);
	
	}
	
	public int getX() {
		return hexagon.getX();
	}
	public int getY() {
		return hexagon.getY();
	}
	public void setX(int x) {
		hexagon.setX(x);
	}
	public void setY(int y) {
		hexagon.setY(y);
	}
	public int getRadius() {
		return hexagon.getR();
	}
	public void setRadius(int radius) {
		hexagon.setR(radius);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getX() - 2, getY() - 2, 4, 4);
			g.drawRect(getX() - getRadius() - 2, getY() - 2, 4, 4);
			g.drawRect(getX() + getRadius() - 2, getY() - 2, 4, 4);
			
			g.drawRect((int)(getX() - getRadius() * Math.cos(Math.PI/3)*1.1), (int)(getY() - getRadius() * Math.cos(Math.PI/3)*1.78), 4, 4);
			g.drawRect((int)(getX() + getRadius() * Math.cos(Math.PI/3)), (int)(getY() - getRadius() * Math.cos(Math.PI/3)*1.78), 4, 4);
			
			g.drawRect((int)(getX() - getRadius() * Math.cos(Math.PI/3)*1.05), (int)(getY() + getRadius() * Math.cos(Math.PI/3)*1.70), 4, 4);
			g.drawRect((int)(getX() + getRadius() * Math.cos(Math.PI/3)), (int)(getY() + getRadius() * Math.cos(Math.PI/3)*1.70), 4, 4);
			
		}
		
	}
	public String toString() {
		return "Hexagon: " + "center: (" + getX() + ", " + getY() + " ) " + "radius: " + getRadius() + " Color: "
				+ getColor() + " InnerColor: " + getInnerColor();
	}
	
	public HexagonAdapter clone() {
		
		Point point = new Point(this.getX(), this.getY());
		
		HexagonAdapter hexagon = new HexagonAdapter(point, getRadius(), this.getColor(), this.getInnerColor());
		
		return hexagon;
		
	}

}

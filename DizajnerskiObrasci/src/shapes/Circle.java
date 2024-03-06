package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape implements Cloneable {
	
	protected Point center;
	protected int radius;
	protected Color color;
	protected Color innerColor;

	//konstruktori:
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius, Color color, Color innerColor) {
		this.center = center;
		this.radius = radius;
		this.color = color;
		this.innerColor = innerColor;
	}
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Circle(Point center, int radius, Color color, Color innerColor, boolean selected) {
		this(center, radius, color, innerColor);
		this.selected = selected;
	}
	
	public Circle(Point center, int radius, Color color) {
		this.center = center;
		this.radius = radius;
		this.color = color;
	}
	

	public double area() {
		return Math.PI * radius * radius;
	}
	
	public double circumference() {
		return 2 * radius * Math.PI;
	}
	
	public Point getCenter() {
		return center;//this.center
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) throws Exception {
		if(radius < 0) {
			throw new Exception("Radius ne moze biti manji od 0 !");
		}
		this.radius = radius;
	}
	
	public boolean contains (int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	//overloading
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if(this.center.equals(pomocna.center) && this.radius == pomocna.radius)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public String toString() {
		return "Circle: " + "center: " + "(" +center.getX() + ", " + center.getY() + ")" + ", " + "radius: " + radius 
				+ " color: " + color.toString() + " innerColor: " + innerColor.toString();
	}

	@Override
	public void draw(Graphics g) {
		g.clearRect(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
		g.setColor(color);
		g.drawOval(center.getX() - radius, center.getY() - radius, radius + radius, radius + radius);
		g.setColor(innerColor);
		g.fillOval(center.getX() - radius + 1, center.getY() - radius + 1, radius+radius - 2, radius+radius - 2);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			
		}
		
	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			return (int) (this.area() - ((Circle)o).area());
		}
		return 0;
	}
	
	public Circle clone() {
		/*
		try {
			Circle circle = (Circle) super.clone();
			return circle;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		*/
		Point point = new Point(this.getCenter().getX(), this.getCenter().getY());
		
		Circle circle = new Circle(point, getRadius(), this.getColor(), this.getInnerColor());
		/*circle.getCenter().setX(this.getCenter().getX());
		circle.getCenter().setY(this.getCenter().getY());
		circle.setColor(this.getColor());
		circle.setInnerColor(this.getInnerColor());
		try {
			circle.setRadius(this.getRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return circle;
	}
	
}
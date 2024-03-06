package shapes;


import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape implements Cloneable {
	
	private Point upperLeftPoint;
	private int height;
	private int width;
	private Color color;
	private Color innerColor;
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

	public int getWidth() {
		return width;
	}
	
	//konstruktori
	
	public Rectangle() {
		
	}
	
	
	
	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}
	
    public Rectangle(Point upperLeftPoint, int height, int width, Color color) {
		this(upperLeftPoint, height, width);
		this.color = color;
		
	}
    
    public Rectangle(Point upperLeftPoint, int height, int width, Color color, Color innerColor) {
    	this(upperLeftPoint, height, width, color);
    	this.innerColor = innerColor;
    }
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		this.selected = selected;
	}
	public int area() {
		return width * height;
	}
	
	public int circumference() {
		return 2 * width + 2 * height;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	public int getHeight() {
		return height;//this.height
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidht() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle)obj; //kastovanje
			if(this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width && this.height == height)
				return true;
			else
				return false;
		}else
			return false;		
	}
	
	public boolean contains(int x, int y) {
		return (upperLeftPoint.getX() <= x && upperLeftPoint.getX() + width >= x && upperLeftPoint.getY() <= y && upperLeftPoint.getY() + height >= y);
	}
	
	public boolean contains (Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	public String toString() {
		return "Rectangle: " + "Upper Left Point: " + "(" + upperLeftPoint.getX() + ", " + upperLeftPoint.getY() + ")"+ ", " + "width: " + width + ", " + "height: " + height + " , Color: " + color + " , InnerColor: " + innerColor;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		g.setColor(innerColor);
		g.fillRect(upperLeftPoint.getX() + 1, upperLeftPoint.getY() + 1, width - 1, height - 1);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() - 2, getUpperLeftPoint().getY() - 2, 4, 4);
			g.drawRect(getUpperLeftPoint().getX() + width - 2, getUpperLeftPoint().getY() - 2, 4, 4);
			g.drawRect(getUpperLeftPoint().getX() - 2, getUpperLeftPoint().getY() + height - 2, 4, 4);
			g.drawRect(getUpperLeftPoint().getX() + width - 2, getUpperLeftPoint().getY() + height - 2, 4, 4);
			
		}
		
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return this.area() - ((Rectangle)o).area();
		}
		return 0;
	}
	
	public Rectangle clone() {
		/*
		try {
			Rectangle rectangle = (Rectangle) super.clone();
			return rectangle;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		*/
		
		Point upperLeftP = new Point(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY());
		
		Rectangle rectangle = new Rectangle(upperLeftP, getHeight(), getWidth(), getColor(), getInnerColor());
		/*rectangle.getUpperLeftPoint().setX(this.getUpperLeftPoint().getX());
		rectangle.getUpperLeftPoint().setY(this.getUpperLeftPoint().getY());
		rectangle.setHeight(this.getHeight());
		rectangle.setWidth(this.getWidth());
		rectangle.setColor(this.getColor());
		rectangle.setInnerColor(this.getInnerColor());
		*/
		return rectangle;
		
	}
	
}

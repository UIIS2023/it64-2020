package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle implements Cloneable {

	//Prosirujemo klasu Circle i time nasledjuje sva obelezja klase Circle 
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center ,int radius, int innerRadius) throws Exception {
		super(center, radius, Color.BLACK);
		if(innerRadius < 0 || innerRadius >= radius) {
			throw new Exception("InnerRadius ne moze biti manji od 0 ili veci od Radiusa !");
		}
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color) throws Exception {
		super(center, radius, color);
		if(innerRadius < 0 || innerRadius >= radius) {
			throw new Exception("InnerRadius ne moze biti manji od 0 ili veci od Radiusa !");
		}
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) throws Exception {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	public Donut(Point center, int radius, int innerRadius, Color color, Color innerColor) throws Exception {
		super(center, radius, color, innerColor);
		if(innerRadius < 0 || innerRadius >= radius) {
			throw new Exception("InnerRadius ne moze biti manji od 0 ili veci od Radiusa !");
		}
		this.innerRadius = innerRadius;
		
	}
	
	@Override
	public double area() {
		
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	@Override
	public boolean contains(int x, int y) {
		
		return super.contains(x, y) && getCenter().distance(x, y) >= innerRadius;
	}

	@Override
	public boolean contains(Point p) {
		
		return this.contains(p.getX(), p.getY());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut pomocna = (Donut)obj;
			if(getCenter().equals(pomocna.getCenter()) && getRadius() == pomocna.getRadius() && innerRadius == pomocna.getInnerRadius())
				return true;
			else 
				return false;
		}else
		return false;
	}

	@Override
	public String toString() {
		
		//return "Donut: " + super.toString() + ", innerRadius" + innerRadius;
		return "Donut: " + "center: " + "(" + center.getX() + ", " + center.getY() + ")" + ", " + "radius: " + radius  + ", innerRadius: " + innerRadius
				+ " color: " + color + " innerColor: " + innerColor;
	}
	
	public int getInnerRadius(){
		return this.innerRadius;
	}
	public void setInnerRadius(int innerRadius) throws Exception {
		if(innerRadius < 0 || innerRadius >= this.radius) {
			throw new Exception("InnerRadius ne moze biti manji od 0 ili veci od Radiusa !");
		}
		this.innerRadius = innerRadius;
	}
	
	
	@Override
	public void setRadius(int radius) throws Exception {
		if(radius < this.innerRadius) {
			throw new Exception("Radiuse ne moze biti manji od InnerRadiusa !");
		}
		super.setRadius(radius);
	}
	
	@Override
	public void draw(Graphics g) {
		/*super.draw(g);		
		g.setColor(color);
		g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
		Color c = new Color(238, 238, 238);
		g.setColor(c);
		g.fillOval(center.getX() - innerRadius + 1, center.getY() - innerRadius + 1, 2 * innerRadius - 2, 2 * innerRadius - 2);
		
		if(selected) {
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			
		}
	*/
		Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        java.awt.Shape outer = new Ellipse2D.Double(getCenter().getX() - getRadius(), getCenter().getY() - getRadius(), 2*getRadius(),2*getRadius());
        java.awt.Shape inner = new Ellipse2D.Double(getCenter().getX() - getInnerRadius(), getCenter().getY() - getInnerRadius(), 2*getInnerRadius(),2*getInnerRadius());

        Area cwc = new Area( outer );
        cwc.subtract( new Area(inner) );

        g2d.setColor(getInnerColor());
        g2d.fill(cwc);
        g2d.setColor(getColor());
        g2d.draw(cwc);

        g2d.dispose();
        
        if(isSelected()) {
        	//selected(g);
        	g.setColor(color.blue);
        	//unustrasnji krug
        	g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			//spoljasnji
			g.drawRect(getCenter().getX() - radius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + radius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - radius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + radius - 2, 4, 4);
        }
	}
	
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			return (int) (this.area() - ((Donut)o).area());
		}
		return 0;
	}
	
	public Donut clone() {
		/*
		Donut donut = (Donut) super.clone();
		
		return donut;*/
		
		/*Donut donut = null;
		try {
			donut = new Donut(this.center, this.radius, this.innerRadius);
			donut.getCenter().setX(this.getCenter().getX());
			donut.getCenter().setY(this.getCenter().getY());
			donut.setColor(this.getColor());
			donut.setInnerColor(this.getInnerColor());
			donut.setRadius(this.getRadius());
			donut.setInnerRadius(this.getInnerRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Point point = new Point(this.getCenter().getX(), this.getCenter().getY());
		
		Donut donut = null;
		try {
			donut = new Donut(point, getRadius(), getInnerRadius(), getColor(), getInnerColor());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return donut;
	}
	
}


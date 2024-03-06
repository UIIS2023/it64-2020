package mvc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import observer.Observable;
import observer.Observer;
import shapes.Shape;

public class DrawingModel implements Observable, Serializable {
	//dodato Array
	private ArrayList<Shape> shapes = new ArrayList<>();
	//lista za bracenje dostupnih BTNa
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void add(Shape p) {
		shapes.add(p);
	}
	public void remove(Shape p) {
		shapes.remove(p);
	}
	public void addIndex(int index, Shape p) {
		shapes.add(index, p);
	}
	/*public void removeIndex(int index, Shape p) {
		shapes.remove(index, p);
	}*/
	//Array
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	public Shape getShapes(int i)
	{
		return shapes.get(i);
	}
	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
		
	}
	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
		
	}
	@Override
	public void notifyObservers() {
		//pretrazujemo selektovane oblike
		int i = 0;
		for(int j=0; j<shapes.size(); j++) {
			if (shapes.get(j).isSelected()) 
				i++;
		}
		for (Observer o: observers) {
			o.updateBtn(i);
		}
		
	}
}

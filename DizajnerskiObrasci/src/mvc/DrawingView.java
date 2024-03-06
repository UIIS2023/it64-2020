package mvc;
import java.awt.Graphics;
import java.util.Iterator;
import shapes.Shape;
import javax.swing.JScrollPane;

public class DrawingView extends JScrollPane {
	private DrawingModel model = new DrawingModel(); //sa aspekta aplikacije ne treba, ali da bi imali window builder u Frame morali smo da inicijalizujemo

	public void setModel(DrawingModel model) {
		this.model = model;
	}
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = model.getShapes().iterator();//importuje se iz java.util paketa ne iz AWT!!!
		//parametar z aprojekat samo ide shapes, ovako treba View da izgleda za moju app
		while(it.hasNext()) {
			it.next().draw(g);
		}
		//repaint(); //za ponovno iscrtavanje
	}
}
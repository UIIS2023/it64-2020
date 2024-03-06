package strategy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import command.Command;
import mvc.DrawingFrame;
import mvc.DrawingModel;

public class StategySaveSerialization implements StrategyHandler, Serializable {
	

	private Stack<Command> undoStack;
	private Stack<Command> redoStack;
	private DrawingFrame frame;
	private DrawingModel model;

	public StategySaveSerialization(Stack<Command> undoStack,Stack<Command> redoStack, DrawingFrame frame, DrawingModel model) {
		this.undoStack = undoStack;
		this.redoStack = redoStack;
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void saveStrategy() {
		
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
		chooser.setDialogTitle("Select a folder");

		if (chooser.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();

			File f = new File(path + ".ser");
			ObjectOutputStream oos = null;
			try {
	            // Create a file to save the serialized object
				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));

	            // Write the object to the file
				if(undoStack.size() == 0) {
	            	oos.writeObject(redoStack);
	            }else {
	                oos.writeObject(undoStack);
	            }

	            // Close the streams
	            oos.close();
	            
	            System.out.println("Object serialized successfully!");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		
	}

	@Override
	public void loadStrategy() {
		Stack<Command> loadStack = new Stack<>();
		Stack<Command> loadStackHolder = null;
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
		chooser.setDialogTitle("Select a folder");

		if (chooser.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();
			
			File f = new File(path);
			ObjectInputStream ois = null;
		try {
			
            // Open the file to read the serialized object
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));

            // Read the object from the file
            loadStackHolder = (Stack<Command>) ois.readObject();

            // Close the streams
            ois.close();
            for(Command c : loadStackHolder) {
            	undoStack.push(c);
            }
            System.out.println("Object deserialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		//Okretanje stacka
		while(loadStackHolder.size() != 0) {
        	Command c = loadStackHolder.pop();
        	loadStack.push(c);
		}

		while(loadStack.size() != 0) {
        	Command cmd = loadStack.pop();
        	cmd.overrideModel(model);
        	cmd.overrideListShapes(model.getShapes());
			cmd.execute();
			
			//frame.getLogFrame().getModel().addElement("Deserialize: " + cmd.toString());
			frame.repaint();
			undoStack.clear();
        }
		
	}
}

}

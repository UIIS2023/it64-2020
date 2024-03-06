package strategy;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import command.CmdAddPoint;
import command.Command;
import frames.LogFrame;
import mvc.DrawingFrame;
import mvc.DrawingModel;
import shapes.Circle;
import shapes.Point;
import shapes.Shape;

public class StrategyLog implements StrategyHandler {
	private LogFrame logFrame;
	private Stack<Command> undoStack;
	private Circle oldCircle = new Circle();
	private Circle newCircle = new Circle();
	private Stack<Command> redoStack;
	private DrawingModel model;
	private DrawingFrame frame;
	private Stack<Command> allStack;
	private Shape selectedShape;

	public StrategyLog(LogFrame logFrame, Stack<Command> undoStack,Stack<Command> redoStack, DrawingFrame frame, DrawingModel model,Stack<Command> allStack) {
		this.logFrame = logFrame;
		this.undoStack = undoStack;
		this.redoStack = redoStack;
		this.allStack = allStack;
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void saveStrategy() {
		/*
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
		chooser.setDialogTitle("Select a folder");

		if (chooser.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();

			File f = new File(path + ".txt"); //.json

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {

				for (int i = 0; i < logFrame.getModel().getSize(); i++) {
					bw.write(logFrame.getModel().getElementAt(i) + "\n");//  \n
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
		chooser.setDialogTitle("Select a folder");

		if (chooser.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();

			File f = new File(path + ".txt");
			ObjectOutputStream oos = null;
			try {
	            // Create a file to save the serialized object
				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));

	            // Write the object to the file
				oos.writeObject(allStack);
				/*if(undoStack.size() == 0) {
	            	oos.writeObject(redoStack);
	            }else {
	                oos.writeObject(undoStack); //undoStack
	            }*/

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
		/*JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
		chooser.setDialogTitle("Select a folder");

		if (chooser.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();
			
			File f = new File(path);
			
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
				
				String line = br.readLine();
				
				while(line != null) {
					//load(line);
					//logFrame.getModel().addElement(line.toString());
					frame.getLogFrame().getModel().addElement(line);
					System.out.println(line);
					commandList = commandList + line + "\n";
					line = br.readLine();
				}
				load(commandList);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		/*Stack<Command> loadStack = new Stack<>();
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
            
          //Okretanje stacka
    		while(loadStackHolder.size() != 0) {
            	Command c = loadStackHolder.pop();
            	loadStack.push(c);
    		}
            
            for(Command c : loadStack) {
            	redoStack.push(c);
            }
            System.out.println("Object deserialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		while(loadStack.size() != 0) {
        	Command cmd = loadStack.pop();
        	cmd.overrideModel(model);
			cmd.execute();
			
			frame.getLogFrame().getModel().addElement("Deserialize: " + cmd.toString());
			//frame.repaint();
			
        }
	}*/
		//HAOS
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
            while(loadStackHolder.size() != 0) {
            	Command c = loadStackHolder.pop();
            	loadStack.push(c);
    		}
            for(Command c : loadStack) {
                redoStack.push(c);
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
        	for (Shape s  : model.getShapes()) {
				if(s.isSelected()) {
					s.setSelected(false);
				}
			}
        	//OVO JE PRAVILO PROBLEM POSTO SE IZVRSE SVE KOMANDE!!!
			//cmd.execute();
        	//
			
			frame.getLogFrame().getModel().addElement("Deserialize: " + cmd.toString());
			//frame.repaint();
			
        }
		
	}	
}
	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

}

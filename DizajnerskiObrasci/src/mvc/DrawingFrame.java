package mvc;
import javax.swing.JDialog;
import javax.swing.JFrame;

import drawings.DlgDelete;
import frames.LeftFrame;
import frames.LogFrame;
import frames.RightFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingFrame extends JFrame{
	private DrawingController controller;
	private DrawingView view = new DrawingView();
	
	private LogFrame logFrame;
	private RightFrame rightFrame;
	private LeftFrame leftFrame;
	public DrawingFrame() {	
		
		logFrame = new LogFrame();
		rightFrame = new RightFrame();
		leftFrame = new LeftFrame();
		
		setTitle("IT 64/2020 Popovic Lazar");
		setSize(1000,800);
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(rightFrame, BorderLayout.EAST);
		getContentPane().add(leftFrame, BorderLayout.WEST);
		getContentPane().add(logFrame, BorderLayout.SOUTH);
		//!!!!
		view.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				controller.mouseClick(arg0);
			}
			
		});
		
		leftFrame.getTglbtnPoint().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setActiveButtonAdd();
				
			}
			
		});
		
		leftFrame.getTglbtnLine().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setActiveButtonAdd();
				
			}
			
		});
		
		leftFrame.getTglbtnRectangle().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setActiveButtonAdd();
				
			}
			
		});
		
		leftFrame.getTglbtnCircle().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setActiveButtonAdd();
				
			}
			
		});
		leftFrame.getTglbtnDonut().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setActiveButtonAdd();
				
			}
			
		});
		leftFrame.getTglbtnHexagon().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setActiveButtonAdd();
				
			}
			
		});
		
		leftFrame.getTglbtnSelect().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setAcitveButtonSelect();
				
			}
			
		});
		
		leftFrame.getTglbtnModify().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.openModifyDialog();
				
			}
			
		});
		
		leftFrame.getTglbtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				controller.deleteSelectedShape();
				
			}
			
		});
		
		leftFrame.getTglbtnDeleteAll().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.deleteAllShapes();
				
			}
			
		});
		
		leftFrame.getBtnColor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setColor(leftFrame.getBtnColor().getBackground());
			}
			
		});
		
		rightFrame.getUndo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undo();
				
			}
			
		});
		rightFrame.getRedo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.redo();
				
			}
			
		});
		
		rightFrame.getToTop().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveToTop();
				
			}
			
		});
		
		rightFrame.getToBottom().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveToBottom();
				
			}
			
		});
		
		rightFrame.getUp().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveUp();
				
			}
			
		});
		
		rightFrame.getDown().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveDown();
				
			}
			
		});
		
		rightFrame.getSaveLog().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.saveLog();
				
			}
			
		});
		
		rightFrame.getLoadLog().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.loadLog();
				
			}
			
		});
		
		rightFrame.getSaveSerialization().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.saveSerialization();
				
			}
			
		});
		
		rightFrame.getLoadSerialization().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.loadSerialization();
				
			}
			
		});
	}
	
	public DrawingView getView() {
		return view;
	}
	public void setController(DrawingController controller) {
		this.controller = controller;
		this.leftFrame.setController(controller);
	}
	public RightFrame getRightFrame() {
		return this.rightFrame;
	}
	public LeftFrame getLeftFrame() {
		return this.leftFrame;
	}
	public LogFrame getLogFrame() {
		return logFrame;
	}
	
}

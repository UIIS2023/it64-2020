package mvc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import drawings.ActiveButton;
import drawings.ActiveShape;
import drawings.DlgDelete;
import shapes.Line;
import shapes.Point;
import shapes.Shape;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class Application {
	
	private static int xCordinate = 0;
	private static int yCordinate = 0;
	private static int x1Cordinate = 0;
	private static int y1Cordinate = 0;
	private static boolean isFirst = true;
	
	public static void main(String[] args) {
		DrawingModel drawingModel = new DrawingModel();
		DrawingFrame drawingFrame = new DrawingFrame();
		drawingFrame.getView().setModel(drawingModel);
		
		DrawingController drawingController = new DrawingController(drawingModel, drawingFrame);
		drawingFrame.setController(drawingController);
		
		//initializeView(drawingFrame, drawingModel, drawingController);
		
		drawingFrame.setSize(1000,800);
		drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawingFrame.setVisible(true);
	}

	public static void initializeView(DrawingFrame drawingFrame, DrawingModel drawingModel, DrawingController drawingController) {
		//Line l1 = new Line(new Point(100, 100), new Point (200,200));
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		drawingFrame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{121, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblShapes = new JLabel("Shapes:");
		GridBagConstraints gbc_lblShapes = new GridBagConstraints();
		gbc_lblShapes.insets = new Insets(0, 0, 5, 0);
		gbc_lblShapes.gridx = 0;
		gbc_lblShapes.gridy = 1;
		panel.add(lblShapes, gbc_lblShapes);

		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Add){
					drawingController.setActiveShape(ActiveShape.Point);;
				}
			}
		});
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		btnGroup.add(tglbtnPoint);
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 2;
		panel.add(tglbtnPoint, gbc_tglbtnPoint);

		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Add){
					drawingController.setActiveShape(ActiveShape.Line);
				}
			}
		});
		btnGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnLine.gridx = 0;
		gbc_tglbtnLine.gridy = 3;
		panel.add(tglbtnLine, gbc_tglbtnLine);

		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Add){
					drawingController.setActiveShape(ActiveShape.Rectangle);
				}
			}
		});
		btnGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnRectangle.gridx = 0;
		gbc_tglbtnRectangle.gridy = 4;
		panel.add(tglbtnRectangle, gbc_tglbtnRectangle);

		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Add){
					drawingController.setActiveShape(ActiveShape.Circle);
				}
			}
		});
		btnGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnCircle.gridx = 0;
		gbc_tglbtnCircle.gridy = 5;
		panel.add(tglbtnCircle, gbc_tglbtnCircle);

		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Add){
					drawingController.setActiveShape(ActiveShape.Donut);
				}
			}
		});
		btnGroup.add(tglbtnDonut);
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDonut.gridx = 0;
		gbc_tglbtnDonut.gridy = 6;
		panel.add(tglbtnDonut, gbc_tglbtnDonut);
		
		JToggleButton tglbtnHexagon = new JToggleButton("Hexagon");
		tglbtnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Add)
				{
					drawingController.setActiveShape(ActiveShape.Hexagon);
				}
			}
		});
		btnGroup.add(tglbtnHexagon);
		GridBagConstraints gbc_tglbtnHexagon = new GridBagConstraints();
		gbc_tglbtnHexagon.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnHexagon.gridx = 0;
		gbc_tglbtnHexagon.gridy = 7;
		panel.add(tglbtnHexagon, gbc_tglbtnHexagon);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 8;
		panel.add(verticalStrut, gbc_verticalStrut);

		JLabel lblOptions = new JLabel("Options:");
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.insets = new Insets(0, 0, 5, 0);
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 9;
		panel.add(lblOptions, gbc_lblOptions);

	    JToggleButton tglbtnAdd = new JToggleButton("Add");
		tglbtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Add) {
					drawingController.setActiveButton(ActiveButton.None);
				}else {
					drawingController.setActiveButton(ActiveButton.Add);
				}


			}
		});
		ButtonGroup btnGroup1 = new ButtonGroup();
		btnGroup1.add(tglbtnAdd);
		GridBagConstraints gbc_tglbtnAdd = new GridBagConstraints();
		gbc_tglbtnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnAdd.gridx = 0;
		gbc_tglbtnAdd.gridy = 10;
		panel.add(tglbtnAdd, gbc_tglbtnAdd);

		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == drawingController.getActiveButton().Modify) {
					drawingController.setActiveButton(ActiveButton.None);
				}else {
					drawingController.setActiveButton(ActiveButton.Modify);
					drawingController.openModifyDialog();
				}
			}
		});
		btnGroup1.add(tglbtnModify);
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnModify.gridx = 0;
		gbc_tglbtnModify.gridy = 11;
		panel.add(tglbtnModify, gbc_tglbtnModify);

		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == ActiveButton.Delete) {
					drawingController.setActiveButton(ActiveButton.None);
				}else {
					drawingController.setActiveButton(ActiveButton.Delete);
					if(drawingController.getSelectedShape() != null) {
						DlgDelete dialog = new DlgDelete();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setTitle("Are you sure you want to delete shape?");
						dialog.setVisible(true);
						//ovo sam dodao da vidimo hoce brisati
						drawingController.deleteSelectedShape();
						//
					}
					else {
						JOptionPane.showMessageDialog(null, "No shape selected", "Warning", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnGroup1.add(tglbtnDelete);
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDelete.gridx = 0;
		gbc_tglbtnDelete.gridy = 12;
		panel.add(tglbtnDelete, gbc_tglbtnDelete);

		JToggleButton tglbtnDeleteAll = new JToggleButton("Delete All");
		tglbtnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingController.getActiveButton() == drawingController.getActiveButton().DeleteAll) {
					drawingController.setActiveButton(ActiveButton.None);
				}else {
					drawingController.setActiveButton(ActiveButton.DeleteAll);
					drawingController.deleteAllShapes();
				}
			}
		});
		btnGroup1.add(tglbtnDeleteAll);
		GridBagConstraints gbc_tglbtnDeleteAll = new GridBagConstraints();
		gbc_tglbtnDeleteAll.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDeleteAll.gridx = 0;
		gbc_tglbtnDeleteAll.gridy = 13;
		panel.add(tglbtnDeleteAll, gbc_tglbtnDeleteAll);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 14;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 15;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JButton btnColor = new JButton("");
		btnColor.setPreferredSize(new Dimension(70,20));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnColor.setBackground(pickColor(btnColor.getBackground()));
			}
		});
		btnColor.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 0;
		gbc_btnColor.gridy = 16;
		panel.add(btnColor, gbc_btnColor);
		
		JButton btnInnerColor = new JButton("");
		btnInnerColor.setPreferredSize(new Dimension(70,20));
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInnerColor.setBackground(pickColor(btnColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.gridx = 0;
		gbc_btnInnerColor.gridy = 17;
		panel.add(btnInnerColor, gbc_btnInnerColor);

		//Help Button
		/*
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Help\n"
						+ "For creating Point you need to go on button Add than to a button Point and than select where you want to add a Point on screen.\n\n"
						+ "For creating Line you need to go on button Add than to a button Line and select to Points on screen where you want to draw a Line.\n\n"
						+ "For creating Rectangle you need to go on button Add than to a button Rectangle and select UpperLeftPoint of your Rectangle on screen than add Width and Height.\n\n"
						+ "For creating Circle you need to go on button Add than to a button Circle and select Center of you Circle on screen and than add Radius.\n\n"
						+ "For creating Donut you need to go on button Add than to a button Donut and select Center of your Donut on screen than you need to add Radius and InnerRadius of your Donut.\n\n"
						, "Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.gridx = 0;
		gbc_btnHelp.gridy = 16;
		panel.add(btnHelp, gbc_btnHelp);
        */
		
		JScrollPane scrollPane = new JScrollPane();
		drawingFrame.getView().addMouseListener(new MouseAdapter() {
			 @Override public void mouseClicked(MouseEvent e) {			 
			if(drawingController.getActiveButton() == ActiveButton.Add) {
				if(drawingController.getActiveShape() != ActiveShape.Line) {
					xCordinate = e.getX();
					yCordinate = e.getY();
					drawingController.openAddDialog(xCordinate, yCordinate, 0, 0);
				}
				else {
					if(isFirst) {
						xCordinate = e.getX();
						yCordinate = e.getY();
					}
					else {
						x1Cordinate = e.getX();
						y1Cordinate = e.getY();
						drawingController.openAddDialog(xCordinate, yCordinate, x1Cordinate, y1Cordinate);
					}
					isFirst = !isFirst;		
				}
				return;
			}
			else {
				drawingController.setSelectedShape(null);
				xCordinate = e.getX();
				yCordinate = e.getY();
				for (Shape s  : drawingModel.getShapes()) {
					if(s.contains(xCordinate, yCordinate)) {
						drawingController.setSelectedShape(s);
					}
					s.setSelected(false);
				}
				if(drawingController.getSelectedShape() != null) {
					Shape selectedShapeTmp = drawingController.getSelectedShape();
					selectedShapeTmp.setSelected(true);
					drawingController.setSelectedShape(selectedShapeTmp);
				}
				drawingFrame.paint(drawingFrame.getGraphics());
			}
			}
		}
		);
		contentPane.add(drawingFrame.getView(), BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{120, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblUndoRedo = new JLabel("Undo / Redo");
		GridBagConstraints gbc_lblUndoRedo = new GridBagConstraints();
		gbc_lblUndoRedo.insets = new Insets(0, 0, 5, 0);
		gbc_lblUndoRedo.gridx = 0;
		gbc_lblUndoRedo.gridy = 1;
		panel_1.add(lblUndoRedo, gbc_lblUndoRedo);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawingController.undo();
				
			}
		});
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 5, 0);
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 2;
		panel_1.add(btnUndo, gbc_btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawingController.redo();
				
			}
		});
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 5, 0);
		gbc_btnRedo.gridx = 0;
		gbc_btnRedo.gridy = 3;
		panel_1.add(btnRedo, gbc_btnRedo);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 4;
		panel_1.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JLabel lblChangePosition = new JLabel("Change of Position");
		GridBagConstraints gbc_lblChangePosition = new GridBagConstraints();
		gbc_lblChangePosition.insets = new Insets(0, 0, 5, 0);
		gbc_lblChangePosition.gridx = 0;
		gbc_lblChangePosition.gridy = 5;
		panel_1.add(lblChangePosition, gbc_lblChangePosition);
		
		JButton btnMoveToTop = new JButton("To Top");
		btnMoveToTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawingController.moveToTop();
				
			}
		});
		GridBagConstraints gbc_btnMoveToTop = new GridBagConstraints();
		gbc_btnMoveToTop.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveToTop.gridx = 0;
		gbc_btnMoveToTop.gridy = 6;
		panel_1.add(btnMoveToTop, gbc_btnMoveToTop);
		
		JButton btnMoveToBottom = new JButton("To Bottom");
		btnMoveToBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawingController.moveToBottom();
				
			}
		});
		GridBagConstraints gbc_btnMoveToBottom = new GridBagConstraints();
		gbc_btnMoveToBottom.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveToBottom.gridx = 0;
		gbc_btnMoveToBottom.gridy = 7;
		panel_1.add(btnMoveToBottom, gbc_btnMoveToBottom);
		
		JButton btnMoveUp = new JButton("Up");
		btnMoveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawingController.moveUp();
				
			}
		});
		GridBagConstraints gbc_btnMoveUp = new GridBagConstraints();
		gbc_btnMoveUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveUp.gridx = 0;
		gbc_btnMoveUp.gridy = 8;
		panel_1.add(btnMoveUp, gbc_btnMoveUp);
		
		JButton btnMoveDown = new JButton("Down");
		btnMoveDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawingController.moveDown();
				
			}
		});
		GridBagConstraints gbc_btnMoveDown = new GridBagConstraints();
		gbc_btnMoveDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveDown.gridx = 0;
		gbc_btnMoveDown.gridy = 9;
		panel_1.add(btnMoveDown, gbc_btnMoveDown);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 10;
		panel_1.add(verticalStrut_4, gbc_verticalStrut_4);
		
		JLabel lblSerializationLog = new JLabel("Serialization / Log");
		GridBagConstraints gbc_lblSerializationLog = new GridBagConstraints();
		gbc_lblSerializationLog.insets = new Insets(0, 0, 5, 0);
		gbc_lblSerializationLog.gridx = 0;
		gbc_lblSerializationLog.gridy = 11;
		panel_1.add(lblSerializationLog, gbc_lblSerializationLog);
		
		JButton btnSaveLog = new JButton("Save Log");
		GridBagConstraints gbc_btnSaveLog = new GridBagConstraints();
		gbc_btnSaveLog.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveLog.gridx = 0;
		gbc_btnSaveLog.gridy = 12;
		panel_1.add(btnSaveLog, gbc_btnSaveLog);
		
		JButton btnLoadLog = new JButton("Load Log");
		GridBagConstraints gbc_btnLoadLog = new GridBagConstraints();
		gbc_btnLoadLog.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadLog.gridx = 0;
		gbc_btnLoadLog.gridy = 13;
		panel_1.add(btnLoadLog, gbc_btnLoadLog);
		
		JButton btnSaveSerialization = new JButton("Save Serialization");
		GridBagConstraints gbc_btnSaveSerialization = new GridBagConstraints();
		gbc_btnSaveSerialization.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveSerialization.gridx = 0;
		gbc_btnSaveSerialization.gridy = 14;
		panel_1.add(btnSaveSerialization, gbc_btnSaveSerialization);
		
		JButton btnLoadSerialization = new JButton("Load Serialization");
		GridBagConstraints gbc_btnLoadSerialization = new GridBagConstraints();
		gbc_btnLoadSerialization.gridx = 0;
		gbc_btnLoadSerialization.gridy = 15;
		panel_1.add(btnLoadSerialization, gbc_btnLoadSerialization);
		JList lstShapes = new JList();
		scrollPane.setViewportView(lstShapes);
	}
	
	public static Color pickColor(Color old) {
		//bacao error zato sto je samo new bilo, ne sme posto je rezervisana rec
		Color newColor = JColorChooser.showDialog(null, "Pick color", old);
		if (newColor != null)
			return newColor;
		else
			return old;
	}
	
}

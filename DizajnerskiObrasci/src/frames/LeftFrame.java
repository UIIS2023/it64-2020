package frames;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

import mvc.DrawingController;
import mvc.DrawingModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeftFrame extends JPanel implements ActionListener {
	
	DrawingController controller;
	private DrawingModel model;
	
	private ButtonGroup toggleShapes = new ButtonGroup();
	private ButtonGroup toggleOptions = new ButtonGroup();
	
	private JToggleButton tglbtnPoint, tglbtnLine, tglbtnRectangle, tglbtnCircle, tglbtnDonut, tglbtnHexagon, tglbtnSelect, tglbtnModify, tglbtnDelete, tglbtnDeleteAll; 
	private JButton btnColor, btnInnerColor;
	
	public LeftFrame() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblShape = new JLabel("Shapes:");
		GridBagConstraints gbc_lblShape = new GridBagConstraints();
		gbc_lblShape.insets = new Insets(0, 0, 5, 0);
		gbc_lblShape.gridx = 1;
		gbc_lblShape.gridy = 1;
		add(lblShape, gbc_lblShape);
		
		tglbtnPoint = new JToggleButton("Point");
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnPoint.gridx = 1;
		gbc_tglbtnPoint.gridy = 2;
		add(tglbtnPoint, gbc_tglbtnPoint);
		toggleShapes.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 3;
		add(tglbtnLine, gbc_tglbtnLine);
		toggleShapes.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnRectangle.gridx = 1;
		gbc_tglbtnRectangle.gridy = 4;
		add(tglbtnRectangle, gbc_tglbtnRectangle);
		toggleShapes.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Circle");
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnCircle.gridx = 1;
		gbc_tglbtnCircle.gridy = 5;
		add(tglbtnCircle, gbc_tglbtnCircle);
		toggleShapes.add(tglbtnCircle);
		
		tglbtnDonut = new JToggleButton("Donut");
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDonut.gridx = 1;
		gbc_tglbtnDonut.gridy = 6;
		add(tglbtnDonut, gbc_tglbtnDonut);
		toggleShapes.add(tglbtnDonut);
		
		tglbtnHexagon = new JToggleButton("Hexagon");
		GridBagConstraints gbc_tglbtnHexagon = new GridBagConstraints();
		gbc_tglbtnHexagon.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnHexagon.gridx = 1;
		gbc_tglbtnHexagon.gridy = 7;
		add(tglbtnHexagon, gbc_tglbtnHexagon);
		toggleShapes.add(tglbtnHexagon);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 8;
		add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel lblOptions = new JLabel("Options:");
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.insets = new Insets(0, 0, 5, 0);
		gbc_lblOptions.gridx = 1;
		gbc_lblOptions.gridy = 9;
		add(lblOptions, gbc_lblOptions);
		
		tglbtnSelect = new JToggleButton("Select");
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.gridx = 1;
		gbc_tglbtnSelect.gridy = 10;
		add(tglbtnSelect, gbc_tglbtnSelect);
		toggleOptions.add(tglbtnSelect);
		
		tglbtnModify = new JToggleButton("Modify");
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnModify.gridx = 1;
		gbc_tglbtnModify.gridy = 11;
		add(tglbtnModify, gbc_tglbtnModify);
		toggleOptions.add(tglbtnModify);
		//Observer
		tglbtnModify.setEnabled(false);
		
		tglbtnDelete = new JToggleButton("Delete");
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDelete.gridx = 1;
		gbc_tglbtnDelete.gridy = 12;
		add(tglbtnDelete, gbc_tglbtnDelete);
		toggleOptions.add(tglbtnDelete);
		//Observer
		tglbtnDelete.setEnabled(false);
		
		tglbtnDeleteAll = new JToggleButton("Delete All");
		GridBagConstraints gbc_tglbtnDeleteAll = new GridBagConstraints();
		gbc_tglbtnDeleteAll.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDeleteAll.gridx = 1;
		gbc_tglbtnDeleteAll.gridy = 13;
		add(tglbtnDeleteAll, gbc_tglbtnDeleteAll);
		toggleOptions.add(tglbtnDeleteAll);
		//Observer
		tglbtnDeleteAll.setEnabled(false);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 14;
		add(verticalStrut_2, gbc_verticalStrut_2);
		
		JLabel lblColors = new JLabel("Colors:");
		GridBagConstraints gbc_lblColors = new GridBagConstraints();
		gbc_lblColors.insets = new Insets(0, 0, 5, 0);
		gbc_lblColors.gridx = 1;
		gbc_lblColors.gridy = 15;
		add(lblColors, gbc_lblColors);
		
		btnColor = new JButton("");
		btnColor.setActionCommand("Color");
		btnColor.addActionListener(this);
		
		btnColor.setPreferredSize(new Dimension(70,20));
		btnColor.setBackground(Color.BLACK); //setujemo ivicu na CRNO
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 16;
		add(btnColor, gbc_btnNewButton);
		
		btnInnerColor = new JButton("");
		btnInnerColor.setActionCommand("Inner Color");
		btnInnerColor.addActionListener(this);
		
		btnInnerColor.setPreferredSize(new Dimension(70,20));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 17;
		add(btnInnerColor, gbc_btnNewButton_1);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 18;
		add(verticalStrut_3, gbc_verticalStrut_3);
	}
	
	public String selectedButton() {
		
		if(tglbtnPoint.isSelected()) {
			return "Point";
		}
		else if(tglbtnLine.isSelected()) {
			return "Line";
		}
		else if(tglbtnRectangle.isSelected()) {
			return "Rectangle";
		}
		else if(tglbtnCircle.isSelected()) {
			return "Circle";
		}
		else if(tglbtnDonut.isSelected()) {
			return "Donut";
		}
		else if(tglbtnHexagon.isSelected()) {
			return "Hexagon";
		}else
		{
			return null;
		}
	}
	
	public Color pickColor(Color oldColor) {
		Color newColor = JColorChooser.showDialog(null, "Select Color", oldColor);
		if(newColor!=null)
			return newColor;
		else {
			return oldColor;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("Color")){
			Color color  = pickColor(btnColor.getBackground());
			btnColor.setBackground(color);
			controller.setColor(color);
		}
		if(action.equals("Inner Color")) {
			Color inner = pickColor(btnInnerColor.getBackground());
			btnInnerColor.setBackground(inner);
			controller.setInnerColor(inner);
		}
	}
	
	
	public JToggleButton getTglbtnModify() {
		return tglbtnModify;
	}

	public JToggleButton getTglbtnDeleteAll() {
		return tglbtnDeleteAll;
	}

	public JToggleButton getTglbtnDelete() {
		return tglbtnDelete;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public JToggleButton getTglbtnHexagon() {
		return tglbtnHexagon;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public JButton getBtnColor() {
		return btnColor;
	}
	
	public DrawingController getController() {
		return controller;
	}
	
	public void setController(DrawingController drawingController) {
		this.controller = drawingController;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	

}

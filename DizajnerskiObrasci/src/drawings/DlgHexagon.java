package drawings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import adapter.HexagonAdapter;
import hexagon.Hexagon;
import mvc.DrawingController;

public class DlgHexagon extends JDialog implements ActionListener {
	
	private final JPanel contentPanel = new JPanel();

	private int xCord;
	private int yCord;
	private int Radius;
	private Color color;
	private Color innerColor;
	//izmena na HexagonAdapter
	private HexagonAdapter hexagon;
	private DrawingController controller;
	
	public DrawingController getController() {
		return controller;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public DlgHexagon(int xPar, int yPar, int radius, Color color, Color innerColor, HexagonAdapter hexagon) {
		this(xPar, yPar, radius, color, innerColor);
		this.hexagon=hexagon;
	}
	
	public DlgHexagon(int xPar, int yPar, int radius, Color color, Color innerColor) {
		//super();
		this.xCord = xPar;
		this.yCord = yPar;
		this.Radius = radius;
		this.color = color;
		this.innerColor = innerColor;
		
		setBounds(100, 100, 250, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		//
		//JPanel contentPanel = new JPanel();
		//getContentPane().add(contentPanel, BorderLayout.CENTER);
		//
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 1;
			gbc_verticalStrut.gridy = 0;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblCenterX = new JLabel("Center X:");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 2;
			gbc_lblCenterX.gridy = 1;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			JTextPane textPaneCenterX = new JTextPane();
			textPaneCenterX.setText(String.valueOf(xCord));
			textPaneCenterX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneCenterX.getText().matches("[0-9]*")){
						if(!textPaneCenterX.getText().isBlank())
							xCord = Integer.parseInt(textPaneCenterX.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The x input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneCenterX = new GridBagConstraints();
			gbc_textPaneCenterX.gridwidth = 4;
			gbc_textPaneCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneCenterX.fill = GridBagConstraints.BOTH;
			gbc_textPaneCenterX.gridx = 3;
			gbc_textPaneCenterX.gridy = 1;
			contentPanel.add(textPaneCenterX, gbc_textPaneCenterX);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut.gridx = 7;
			gbc_horizontalStrut.gridy = 1;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			JLabel lblCenterY = new JLabel("Center Y:");
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 2;
			gbc_lblCenterY.gridy = 2;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			JTextPane textPaneCenterY = new JTextPane();
			textPaneCenterY.setText(String.valueOf(yCord));
			textPaneCenterY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneCenterY.getText().matches("[0-9]*")){
						if(!textPaneCenterY.getText().isBlank())
							yCord = Integer.parseInt(textPaneCenterY.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The y input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneCenterY = new GridBagConstraints();
			gbc_textPaneCenterY.gridwidth = 4;
			gbc_textPaneCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneCenterY.fill = GridBagConstraints.BOTH;
			gbc_textPaneCenterY.gridx = 3;
			gbc_textPaneCenterY.gridy = 2;
			contentPanel.add(textPaneCenterY, gbc_textPaneCenterY);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut.gridx = 7;
			gbc_horizontalStrut.gridy = 2;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 2;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			JTextPane textPaneRadius = new JTextPane();
			textPaneRadius.setText(String.valueOf(Radius));
			textPaneRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneRadius.getText().matches("[0-9]*")){
						if(!textPaneRadius.getText().isBlank()) 
							Radius = Integer.parseInt(textPaneRadius.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The radius input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneRadius = new GridBagConstraints();
			gbc_textPaneRadius.gridwidth = 4;
			gbc_textPaneRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneRadius.fill = GridBagConstraints.BOTH;
			gbc_textPaneRadius.gridx = 3;
			gbc_textPaneRadius.gridy = 3;
			contentPanel.add(textPaneRadius, gbc_textPaneRadius);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut.gridx = 7;
			gbc_horizontalStrut.gridy = 3;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 4;
			gbc_verticalStrut.gridy = 4;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.setActionCommand("Color");
			btnColor.addActionListener(this);
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.gridwidth = 3;
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.gridx = 3;
			gbc_btnColor.gridy = 5;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JButton btnInnerColor = new JButton("Inner Color");
			btnInnerColor.setActionCommand("Inner Color");
			btnInnerColor.addActionListener(this);
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.gridwidth = 3;
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 3;
			gbc_btnInnerColor.gridy = 6;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}


	public int getxCord() {
		return xCord;
	}


	public void setxCord(int xCord) {
		this.xCord = xCord;
	}


	public int getyCord() {
		return yCord;
	}


	public void setyCord(int yCord) {
		this.yCord = yCord;
	}


	public int getRadius() {
		return Radius;
	}


	public void setRadius(int radius) {
		Radius = radius;
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


	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("Cancel")){
			this.dispose();
		}
		if(action.equals("OK")){
			if(hexagon != null) {
				this.controller.modifyHexagon(xCord, yCord, Radius, color, innerColor, hexagon);
			} else {
				this.controller.drawHexagon(xCord, yCord, Radius, color, innerColor);
			}
			this.dispose();
		}
		if(action.equals("Color")){
			this.color = JColorChooser.showDialog(this,"Select a color", color);
		}
		if(action.equals("Inner Color")) {
			this.innerColor = JColorChooser.showDialog(this,"Select a color", innerColor);
		}
		
	}
}

package drawings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.DrawingController;
import shapes.Donut;
import shapes.PnlDrawing;
import shapes.Point;

import java.awt.GridBagLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextPane;

public class DlgDonut extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	
	private int xCord;
	private int yCord;
	private int radius;
	private int innerRadius;
	private Color color;
	private Color innerColor;
	private Donut donut;
	private DrawingController controller;
	
	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
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
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		/*try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Donut");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	//}
	
	public DlgDonut(int xPar, int yPar, int radiusPar, int innerRadiusPar, Color colorPar, Color innerColor, Donut donut) {
		this(xPar, yPar, radiusPar, innerRadiusPar, colorPar, innerColor);
		this.donut = donut;
	}
	
	/**
	 * Create the dialog.
	 */
	public DlgDonut(int xPar, int yPar, int radiusPar, int innerRadiusPar, Color color, Color innerColor) {
		this.xCord = xPar;
		this.yCord = yPar;
		this.radius = radiusPar;
		this.innerRadius = innerRadiusPar;
		this.color = color;
		this.innerColor = innerColor;
		setBounds(100, 100, 250, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			textPaneRadius.setText(String.valueOf(radius));
			textPaneRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneRadius.getText().matches("[0-9]*")){
						if(!textPaneRadius.getText().isBlank()) 
							radius = Integer.parseInt(textPaneRadius.getText());
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
			JLabel lblInRadius = new JLabel("InnerRadius:");
			GridBagConstraints gbc_lblInRadius = new GridBagConstraints();
			gbc_lblInRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInRadius.gridx = 2;
			gbc_lblInRadius.gridy = 4;
			contentPanel.add(lblInRadius, gbc_lblInRadius);
		}
		{
			JTextPane textPaneInnerRadius = new JTextPane();
			textPaneInnerRadius.setText(String.valueOf(innerRadius));
			textPaneInnerRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneInnerRadius.getText().matches("[0-9]*")){
						if(!textPaneInnerRadius.getText().isBlank()) 
							innerRadius = Integer.parseInt(textPaneInnerRadius.getText());
					}
					else{
						JOptionPane.showMessageDialog(null, "The InnerRadius input is invalid");
					}
					if(innerRadius >= radius)
					{
						JOptionPane.showMessageDialog(null, "The InnerRadius input cant be bigger or equal with radius!");
						textPaneInnerRadius.setText("0");
					}
				}
			});
			GridBagConstraints gbc_textPaneInnerRadius = new GridBagConstraints();
			gbc_textPaneInnerRadius .gridwidth = 4;
			gbc_textPaneInnerRadius .insets = new Insets(0, 0, 5, 5);
			gbc_textPaneInnerRadius .fill = GridBagConstraints.BOTH;
			gbc_textPaneInnerRadius .gridx = 3;
			gbc_textPaneInnerRadius .gridy = 4;
			contentPanel.add(textPaneInnerRadius , gbc_textPaneInnerRadius );
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut.gridx = 7;
			gbc_horizontalStrut.gridy = 4;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 4;
			gbc_verticalStrut.gridy = 5;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.setActionCommand("Color");
			btnColor.addActionListener(this);
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.gridx = 4;
			gbc_btnColor.gridy = 6;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JButton btnInnerColor = new JButton("Inner Color");
			btnInnerColor.setActionCommand("InnerColor");
			btnInnerColor.addActionListener(this);
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 4;
			gbc_btnInnerColor.gridy = 7;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("Cancel")) {
			this.dispose();
		}
		if(action.equals("OK")) {
			/*PnlDrawing drawing = PnlDrawing.getInstance();
			Donut d = null;
			try {
				d = new Donut(new Point(xCord, yCord), radius, innerRadius, color, innerColor);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}*/
			if(donut != null) {
				/*donut.setCenter(new Point(xCord, yCord));
				donut.setColor(color);
				donut.setInnerColor(innerColor);
				try {
					donut.setRadius(radius);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					donut.setInnerRadius(innerRadius);
				} catch (Exception e1) {
					e1.printStackTrace();
				}*/
				this.controller.modifyDonut(xCord, yCord, radius, innerRadius, color, innerColor, donut);
			}
			else {
				/*if(d != null)
					drawing.getShapes().add(d);*/
				this.controller.drawDonut(xCord, yCord, radius, innerRadius, color, innerColor);
			}
			//drawing.paint(drawing.getGraphics());
			this.dispose();
		}
		if(action.equals("Color")) {
			this.color = JColorChooser.showDialog(this, "Select a color", color);
		}
		if(action.equals("InnerColor")) {
			this.innerColor = JColorChooser.showDialog(this, "Select a color", innerColor);
		}
		
	}

	public DrawingController getController() {
		return controller;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}
	
	

}
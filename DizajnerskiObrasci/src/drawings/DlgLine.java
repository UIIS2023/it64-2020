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
import shapes.Line;
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

public class DlgLine extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	
	private int xCord;
	private int yCord;
	private int x1Cord;
	private int y1Cord;
	private Color color;
	private Line line;
	private DrawingController controller;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public int getX1Cord() {
		return x1Cord;
	}

	public void setX1Cord(int x1Cord) {
		this.x1Cord = x1Cord;
	}

	public int getY1Cord() {
		return y1Cord;
	}

	public void setY1Cord(int y1Cord) {
		this.y1Cord = y1Cord;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Line");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public DlgLine(int xPar, int yPar, int x1Par, int y1Par, Color colorPane, Line line) {
		this(xPar, yPar, x1Par, y1Par, colorPane);
		this.line = line;
	}
	
	/**
	 * Create the dialog.
	 */
	public DlgLine(int xPar, int yPar, int x1Par, int y1Par, Color colorPane) {
		this.xCord = xPar;
		this.yCord = yPar;
		this.x1Cord = x1Par;
		this.y1Cord = y1Par;
		this.color = colorPane;
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
			JLabel lblStartX = new JLabel("Start X:");
			GridBagConstraints gbc_lblStartX = new GridBagConstraints();
			gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartX.gridx = 2;
			gbc_lblStartX.gridy = 1;
			contentPanel.add(lblStartX, gbc_lblStartX);
		}
		{
			JTextPane textPaneStartX = new JTextPane();
			textPaneStartX.setText(String.valueOf(xCord));
			textPaneStartX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneStartX.getText().matches("[0-9]*")){
						if(!textPaneStartX.getText().isBlank())
							xCord = Integer.parseInt(textPaneStartX.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The x input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneStartX = new GridBagConstraints();
			gbc_textPaneStartX.gridwidth = 4;
			gbc_textPaneStartX.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneStartX.fill = GridBagConstraints.BOTH;
			gbc_textPaneStartX.gridx = 3;
			gbc_textPaneStartX.gridy = 1;
			contentPanel.add(textPaneStartX, gbc_textPaneStartX);
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
			JLabel lblStartY = new JLabel("Start Y:");
			GridBagConstraints gbc_lblStartY = new GridBagConstraints();
			gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartY.gridx = 2;
			gbc_lblStartY.gridy = 2;
			contentPanel.add(lblStartY, gbc_lblStartY);
		}
		{
			JTextPane textPaneStartY = new JTextPane();
			textPaneStartY.setText(String.valueOf(yCord));
			textPaneStartY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneStartY.getText().matches("[0-9]*")){
						if(!textPaneStartY.getText().isBlank())
							yCord = Integer.parseInt(textPaneStartY.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The y input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneStartY = new GridBagConstraints();
			gbc_textPaneStartY.gridwidth = 4;
			gbc_textPaneStartY.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneStartY.fill = GridBagConstraints.BOTH;
			gbc_textPaneStartY.gridx = 3;
			gbc_textPaneStartY.gridy = 2;
			contentPanel.add(textPaneStartY, gbc_textPaneStartY);
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
			JLabel lblEndX = new JLabel("End X:");
			GridBagConstraints gbc_lblEndX = new GridBagConstraints();
			gbc_lblEndX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndX.gridx = 2;
			gbc_lblEndX.gridy = 3;
			contentPanel.add(lblEndX, gbc_lblEndX);
		}
		{
			JTextPane textPaneEndX = new JTextPane();
			textPaneEndX.setText(String.valueOf(x1Cord));
			textPaneEndX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneEndX.getText().matches("[0-9]*")){
						if(!textPaneEndX.getText().isBlank())
							x1Cord = Integer.parseInt(textPaneEndX.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The End x input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneEndX = new GridBagConstraints();
			gbc_textPaneEndX.gridwidth = 4;
			gbc_textPaneEndX.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneEndX.fill = GridBagConstraints.BOTH;
			gbc_textPaneEndX.gridx = 3;
			gbc_textPaneEndX.gridy = 3;
			contentPanel.add(textPaneEndX, gbc_textPaneEndX);
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
			JLabel lblEndY = new JLabel("End Y:");
			GridBagConstraints gbc_lblEndY = new GridBagConstraints();
			gbc_lblEndY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndY.gridx = 2;
			gbc_lblEndY.gridy = 4;
			contentPanel.add(lblEndY, gbc_lblEndY);
		}
		{
			JTextPane textPaneEndY = new JTextPane();
			textPaneEndY.setText(String.valueOf(y1Cord));
			textPaneEndY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneEndY.getText().matches("[0-9]*")){
						if(!textPaneEndY.getText().isBlank())
							y1Cord = Integer.parseInt(textPaneEndY.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The y input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneEndY = new GridBagConstraints();
			gbc_textPaneEndY.gridwidth = 4;
			gbc_textPaneEndY.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneEndY.fill = GridBagConstraints.BOTH;
			gbc_textPaneEndY.gridx = 3;
			gbc_textPaneEndY.gridy = 4;
			contentPanel.add(textPaneEndY, gbc_textPaneEndY);
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
			JButton btnColor = new JButton("Color");
			btnColor.setActionCommand("Color");
			btnColor.addActionListener(this);
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.gridwidth = 3;
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.gridx = 3;
			gbc_btnColor.gridy = 6;
			contentPanel.add(btnColor, gbc_btnColor);
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
			//PnlDrawing drawing = PnlDrawing.getInstance();
			//Line l = new Line(new Point(xCord, yCord), new Point(x1Cord, y1Cord), color);
			if(line != null) {
				/*line.setStartPoint(new Point(xCord, yCord));
				line.setEndPoint(new Point(x1Cord, y1Cord));
				line.setColor(color);*/
				this.controller.modifyLine(xCord, yCord, x1Cord, y1Cord, color, line);
			}
			else {
				//drawing.getShapes().add(l);
				this.controller.drawLine(xCord, yCord, x1Cord, y1Cord, color);
			}
			//drawing.paint(drawing.getGraphics());
			this.dispose();
		}
		if(action.equals("Color")) {
			this.color = JColorChooser.showDialog(this,"Select a color", color);
		}
		
	}

	public DrawingController getController() {
		return controller;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}
	
	

}
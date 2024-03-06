package drawings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import shapes.PnlDrawing;
import shapes.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.DrawingController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextPane;

public class DlgPoint extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Add Point");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	private int xCord;
	private int yCord;
	private Color color;
	private Point point;
	private DrawingController controller;

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public DlgPoint(int xPar, int yPar, Color colorPar, Point point) {
		this(xPar, yPar, colorPar);
		this.point = point;
	}


	/**
	 * Create the dialog.
	 */
	public DlgPoint(int xPar, int yPar, Color colorPar) {
		this.xCord = xPar;
		this.yCord = yPar;
		this.color = colorPar;
		setBounds(100, 100, 250, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{1, 34, 10, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{1, 14, 14, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 0;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 2;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			JTextPane textPaneX = new JTextPane();
			textPaneX.setText(String.valueOf(xCord));
			textPaneX.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneX.getText().matches("[0-9]*")){
						if(!textPaneX.getText().isBlank())
							xCord = Integer.parseInt(textPaneX.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The x input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneX = new GridBagConstraints();
			gbc_textPaneX.gridwidth = 3;
			gbc_textPaneX.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneX.fill = GridBagConstraints.BOTH;
			gbc_textPaneX.gridx = 3;
			gbc_textPaneX.gridy = 1;
			contentPanel.add(textPaneX, gbc_textPaneX);
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
			JLabel lblY = new JLabel("Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 2;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			JTextPane textPaneY = new JTextPane();
			textPaneY.setText(String.valueOf(yCord));
			textPaneY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneY.getText().matches("[0-9]*")){
						if(!textPaneY.getText().isBlank())
							yCord = Integer.parseInt(textPaneY.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The y input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneY = new GridBagConstraints();
			gbc_textPaneY.gridwidth = 3;
			gbc_textPaneY.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneY.fill = GridBagConstraints.BOTH;
			gbc_textPaneY.gridx = 3;
			gbc_textPaneY.gridy = 2;
			contentPanel.add(textPaneY, gbc_textPaneY);
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
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 4;
			gbc_verticalStrut.gridy = 3;
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
			gbc_btnColor.gridy = 4;
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
			//Point p = new Point(xCord, yCord, color);
			if(point != null) {
				/*point.setX(xCord);
				point.setY(yCord);
				point.setColor(color);*/
				this.controller.modifyPoint(xCord, yCord, color, point);
			}
			else {
				//drawing.getShapes().add(p);
				this.controller.drawPoint(xCord, yCord, color);
			}
			//drawing.paint(drawing.getGraphics());
			this.dispose();
		}
		if(action.equals("Color")) {
			this.color = JColorChooser.showDialog(this, "Select a color", color);
		}
		
	}
	
	public DrawingController getController() {
		return controller;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

}
package stack;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import shapes.PnlDrawing;
import shapes.Point;
import shapes.Rectangle;

public class DlgStack extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	
	private int xCord;
	private int yCord;
	private int width;
	private int height;
	
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
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
		

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
	
		setBounds(100, 100, 250, 300);
		setModal(true);
		setTitle("Add Rectangle");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			JLabel lblUpperLeftX = new JLabel("UpperLeftPoint X:");
			GridBagConstraints gbc_lblUpperLeftX = new GridBagConstraints();
			gbc_lblUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftX.gridx = 2;
			gbc_lblUpperLeftX.gridy = 1;
			contentPanel.add(lblUpperLeftX, gbc_lblUpperLeftX);
		}
		{
			JTextPane textPaneUpperLeftX = new JTextPane();
			textPaneUpperLeftX.setText(String.valueOf(xCord));
			textPaneUpperLeftX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneUpperLeftX.getText().matches("[0-9]*")){
						if(!textPaneUpperLeftX.getText().isBlank())
							xCord = Integer.parseInt(textPaneUpperLeftX.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The x input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneUpperLeftX = new GridBagConstraints();
			gbc_textPaneUpperLeftX.gridwidth = 4;
			gbc_textPaneUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneUpperLeftX.fill = GridBagConstraints.BOTH;
			gbc_textPaneUpperLeftX.gridx = 3;
			gbc_textPaneUpperLeftX.gridy = 1;
			contentPanel.add(textPaneUpperLeftX, gbc_textPaneUpperLeftX);
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
			JLabel lblUpperLeftY = new JLabel("UpperLeftPoint Y:");
			GridBagConstraints gbc_lblUpperLeftY = new GridBagConstraints();
			gbc_lblUpperLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftY.gridx = 2;
			gbc_lblUpperLeftY.gridy = 2;
			contentPanel.add(lblUpperLeftY, gbc_lblUpperLeftY);
		}
		{
			JTextPane textPaneUpperLeftY = new JTextPane();
			textPaneUpperLeftY.setText(String.valueOf(yCord));
			textPaneUpperLeftY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneUpperLeftY.getText().matches("[0-9]*")){
						if(!textPaneUpperLeftY.getText().isBlank())
							yCord = Integer.parseInt(textPaneUpperLeftY.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The y input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneUpperLeftY = new GridBagConstraints();
			gbc_textPaneUpperLeftY.gridwidth = 4;
			gbc_textPaneUpperLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneUpperLeftY.fill = GridBagConstraints.BOTH;
			gbc_textPaneUpperLeftY.gridx = 3;
			gbc_textPaneUpperLeftY.gridy = 2;
			contentPanel.add(textPaneUpperLeftY, gbc_textPaneUpperLeftY);
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
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 2;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			JTextPane textPaneWidth = new JTextPane();
			textPaneWidth.setText(String.valueOf(width));
			textPaneWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneWidth.getText().matches("[0-9]*")){
						if(!textPaneWidth.getText().isBlank()) 
							width = Integer.parseInt(textPaneWidth.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The width input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneWidth = new GridBagConstraints();
			gbc_textPaneWidth.gridwidth = 4;
			gbc_textPaneWidth.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneWidth.fill = GridBagConstraints.BOTH;
			gbc_textPaneWidth.gridx = 3;
			gbc_textPaneWidth.gridy = 3;
			contentPanel.add(textPaneWidth, gbc_textPaneWidth);
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
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 2;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			JTextPane textPaneHeight = new JTextPane();
			textPaneHeight.setText(String.valueOf(height));
			textPaneHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					if(textPaneHeight.getText().matches("[0-9]*")){
						if(!textPaneHeight.getText().isBlank()) 
							height = Integer.parseInt(textPaneHeight.getText());
					}else{
						JOptionPane.showMessageDialog(null, "The height input is invalid");
					}
				}
			});
			GridBagConstraints gbc_textPaneHeight = new GridBagConstraints();
			gbc_textPaneHeight.gridwidth = 4;
			gbc_textPaneHeight.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneHeight.fill = GridBagConstraints.BOTH;
			gbc_textPaneHeight.gridx = 3;
			gbc_textPaneHeight.gridy = 4;
			contentPanel.add(textPaneHeight, gbc_textPaneHeight);
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
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
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
			FrmStack stack = FrmStack.getInstance();
			DefaultListModel<String> dlm = stack.getDlm();
			dlm.add(0, "UpperLeft : (" + xCord + ", " + yCord + "), width : " + width + ", height: " + height);
			stack.paint(stack.getGraphics());
			this.dispose();
		}
		
	}


}


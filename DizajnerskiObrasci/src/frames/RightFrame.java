package frames;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;

public class RightFrame extends JPanel {
	
	private JButton btnUndo, btnRedo, btnToTop, btnToBottom, btnUp, btnDown, btnSaveLog, btnLoadLog, btnSaveSerialization, btnLoadSerialization;
	
	public RightFrame() {
		setSize(150,1000);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 0;
		add(verticalStrut_2, gbc_verticalStrut_2);
		
		JLabel lblUndoRedo = new JLabel("Undo / Redo");
		GridBagConstraints gbc_lblUndoRedo = new GridBagConstraints();
		gbc_lblUndoRedo.insets = new Insets(0, 0, 5, 0);
		gbc_lblUndoRedo.gridx = 1;
		gbc_lblUndoRedo.gridy = 1;
		add(lblUndoRedo, gbc_lblUndoRedo);
		
		btnUndo = new JButton("Undo");
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 5, 0);
		gbc_btnUndo.gridx = 1;
		gbc_btnUndo.gridy = 2;
		add(btnUndo, gbc_btnUndo);
		
		//btnUndo.setEnabled(false);
		
		btnRedo = new JButton("Redo");
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 5, 0);
		gbc_btnRedo.gridx = 1;
		gbc_btnRedo.gridy = 3;
		add(btnRedo, gbc_btnRedo);
		
		//btnRedo.setEnabled(false);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 4;
		add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel lblChangePosition = new JLabel("Change of Position:");
		GridBagConstraints gbc_lblChangePosition = new GridBagConstraints();
		gbc_lblChangePosition.insets = new Insets(0, 0, 5, 0);
		gbc_lblChangePosition.gridx = 1;
		gbc_lblChangePosition.gridy = 5;
		add(lblChangePosition, gbc_lblChangePosition);
		
		btnToTop = new JButton("To Top");
		GridBagConstraints gbc_btnToTop = new GridBagConstraints();
		gbc_btnToTop.insets = new Insets(0, 0, 5, 0);
		gbc_btnToTop.gridx = 1;
		gbc_btnToTop.gridy = 6;
		add(btnToTop, gbc_btnToTop);
		//Observer
		btnToTop.setEnabled(false);
		
		btnToBottom = new JButton("To Bottom");
		GridBagConstraints gbc_btnToBottom = new GridBagConstraints();
		gbc_btnToBottom.insets = new Insets(0, 0, 5, 0);
		gbc_btnToBottom.gridx = 1;
		gbc_btnToBottom.gridy = 7;
		add(btnToBottom, gbc_btnToBottom);
		//Observer
		btnToBottom.setEnabled(false);
		
		btnUp = new JButton("Up");
		GridBagConstraints gbc_btnUp = new GridBagConstraints();
		gbc_btnUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnUp.gridx = 1;
		gbc_btnUp.gridy = 8;
		add(btnUp, gbc_btnUp);
		//Observer
		btnUp.setEnabled(false);
		
		btnDown = new JButton("Down");
		GridBagConstraints gbc_btnDown = new GridBagConstraints();
		gbc_btnDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnDown.gridx = 1;
		gbc_btnDown.gridy = 9;
		add(btnDown, gbc_btnDown);
		//Observer
		btnDown.setEnabled(false);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 10;
		add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblNewLabel = new JLabel("Serialization/Log");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 11;
		add(lblNewLabel, gbc_lblNewLabel);
		
		btnSaveLog = new JButton("Save Log");
		GridBagConstraints gbc_btnSaveLog = new GridBagConstraints();
		gbc_btnSaveLog.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveLog.gridx = 1;
		gbc_btnSaveLog.gridy = 12;
		add(btnSaveLog, gbc_btnSaveLog);
		
		btnLoadLog = new JButton("Load Log");
		GridBagConstraints gbc_btnLoadLog = new GridBagConstraints();
		gbc_btnLoadLog.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadLog.gridx = 1;
		gbc_btnLoadLog.gridy = 13;
		add(btnLoadLog, gbc_btnLoadLog);
		
		btnSaveSerialization = new JButton("Save Serialization");
		GridBagConstraints gbc_btnSaveSerialization = new GridBagConstraints();
		gbc_btnSaveSerialization.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveSerialization.gridx = 1;
		gbc_btnSaveSerialization.gridy = 14;
		add(btnSaveSerialization, gbc_btnSaveSerialization);
		
		btnLoadSerialization = new JButton("Load Serialization");
		GridBagConstraints gbc_btnLoadSerialization = new GridBagConstraints();
		gbc_btnLoadSerialization.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadSerialization.gridx = 1;
		gbc_btnLoadSerialization.gridy = 15;
		add(btnLoadSerialization, gbc_btnLoadSerialization);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 16;
		add(verticalStrut_3, gbc_verticalStrut_3);
	}

	public JButton getUndo() {
		return btnUndo;
	}

	public JButton getRedo() {
		return btnRedo;
	}

	public JButton getToTop() {
		return btnToTop;
	}

	public JButton getToBottom() {
		return btnToBottom;
	}

	public JButton getUp() {
		return btnUp;
	}

	public JButton getDown() {
		return btnDown;
	}

	public JButton getLoadSerialization() {
	return btnLoadSerialization;
	}

	public JButton getSaveSerialization() {
		return btnSaveSerialization;
	}

	public JButton getLoadLog() {
		return btnLoadLog;
	}

	public JButton getSaveLog() {
		return btnSaveLog;
	}
	
	

}

package drawings;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.DrawingController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDelete extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton, cancelButton;
	private DrawingController controller;
	public DlgDelete(DrawingController controller) {
		this();
		this.controller = controller;
	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DlgDelete dialog = new DlgDelete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DlgDelete() {
		setBounds(100, 100, 300, 200);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Yes");
				okButton.addActionListener(this);
				okButton.setActionCommand("Yes");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("No");
				cancelButton.setActionCommand("No");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	
	public JButton getOkButton() {
		return okButton;
	}



	public JButton getCancelButton() {
		return cancelButton;
	}



	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("No")){
			this.dispose();
		}
		if(action.equals("Yes")) {
		    controller.executeDeleteShape();
			this.dispose();
		}

	}
}

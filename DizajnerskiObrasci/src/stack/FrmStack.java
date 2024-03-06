package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}

	private JList lstRectangle;
	
	public JList getLstRectangle() {
		return lstRectangle;
	}

	public void setLstRectangle(JList lstRectangle) {
		this.lstRectangle = lstRectangle;
	}

	private ArrayList<Rectangle> rectangles = new ArrayList<>();
	
	private static FrmStack instance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public static FrmStack getInstance() {
		if(instance == null) {
			instance = new FrmStack();
		}
		return instance;
	}
	
	private FrmStack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IT 64/2020 Popovic Lazar");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{89, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 0;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 2;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JButton btnAddRectangle = new JButton("Add Rectangle");
		btnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dialog = new DlgStack();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setTitle("Add Rectangle");
                dialog.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_btnAddRectangle = new GridBagConstraints();
		gbc_btnAddRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddRectangle.gridx = 0;
		gbc_btnAddRectangle.gridy = 3;
		panel.add(btnAddRectangle, gbc_btnAddRectangle);
		
		JButton btnDeleteRectangle = new JButton("Delete Rectangle");
		btnDeleteRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dlm.getSize() != 0)
					dlm.remove(0);
			}
		});
		GridBagConstraints gbc_btnDeleteRectangle = new GridBagConstraints();
		gbc_btnDeleteRectangle.gridx = 0;
		gbc_btnDeleteRectangle.gridy = 4;
		panel.add(btnDeleteRectangle, gbc_btnDeleteRectangle);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		lstRectangle = new JList();
		lstRectangle.setModel(dlm);
		scrollPane.add(lstRectangle);
		scrollPane.setViewportView(lstRectangle);

		
		}

}

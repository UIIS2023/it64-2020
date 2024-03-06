package sort;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import shapes.Rectangle;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private ArrayList<Rectangle> rectangles = new ArrayList();
	public ArrayList<Rectangle> getRectangles() {
		return rectangles;
	}

	public void setRectangles(ArrayList<Rectangle> rectangles) {
		this.rectangles = rectangles;
	}

	private ArrayList<Integer> areaRectangles = new ArrayList();
	private JList lstRectangle;
	
	public JList getLstRectangle() {
		return lstRectangle;
	}

	public void setLstRectangle(JList lstRectangle) {
		this.lstRectangle = lstRectangle;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}
	
	private static FrmSort instance = null;

	public static FrmSort getInstance() {
		if(instance == null) {
			instance = new FrmSort();
		}
		return instance;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = getInstance();
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
	
	
	private FrmSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("IT 64/202 Popovic Lazar");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
				DlgSort dialog = new DlgSort();
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
		
		JButton btnSortRectangles = new JButton("Sort");
		btnSortRectangles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//rectangles.size() = 5
				for(int i = 0; i < rectangles.size() - 1; i++) {
					// i = 0;
					for(int j = 0; j < rectangles.size() - i - 1; j++) {
						// j=0
						// j=1
						// j=2
						// j=3
						if(rectangles.get(j).area() > rectangles.get(j + 1).area()) {
							Rectangle tmp = rectangles.get(j);
							rectangles.set(j, rectangles.get(j+1));
							rectangles.set(j + 1, tmp);
						}
					}
				}
				dlm.clear();
				for(Rectangle r : rectangles) {
					dlm.add(dlm.getSize(), r.toString());
				}
			}
		});
		GridBagConstraints gbc_btnSortRectangles = new GridBagConstraints();
		gbc_btnSortRectangles.gridx = 0;
		gbc_btnSortRectangles.gridy = 4;
		panel.add(btnSortRectangles, gbc_btnSortRectangles);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		lstRectangle = new JList();
		lstRectangle.setModel(dlm);
		scrollPane.add(lstRectangle);
		scrollPane.setViewportView(lstRectangle);
		}
	}

package drawings;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.MultipleGradientPaint.ColorSpaceType;

import javax.swing.border.MatteBorder;

import shapes.Circle;
import shapes.Donut;
import shapes.Line;
import shapes.PnlDrawing;
import shapes.Point;
import shapes.Rectangle;
import shapes.Shape;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class MainWindow extends JFrame implements MouseListener {

    private JPanel contentPane;
    private int xCordinate;
    private int yCordinate;
    private int x1Cordinate;
    private int y1Cordinate;
    private final ButtonGroup btnGroup = new ButtonGroup();
    private final ButtonGroup btnGroup1 = new ButtonGroup();
    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    private ActiveButton activeButton = ActiveButton.None;
    private ActiveShape activeShape = ActiveShape.None;
    private PnlDrawing d;
    private boolean isFirst;
    private JToggleButton tglbtnAdd;
    private Shape selectedShape;
    
    private static MainWindow instance;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = getInstance();
                    frame.setVisible(true);
                    frame.setTitle("IT 64/2020 Popovic Lazar");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static MainWindow getInstance() {
    	if (instance == null) {
    		instance = new MainWindow();
    	}
    	return instance;
    }
    
    /**
     * Create the frame.
     */
    private MainWindow() {
    	selectedShape = null;
    	isFirst = true;
        d = PnlDrawing.getInstance();
        Line l1 = new Line(new Point(100, 100), new Point (200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        contentPane.add(panel, BorderLayout.WEST);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{121, 0};
        gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblShapes = new JLabel("Shapes:");
        GridBagConstraints gbc_lblShapes = new GridBagConstraints();
        gbc_lblShapes.insets = new Insets(0, 0, 5, 0);
        gbc_lblShapes.gridx = 0;
        gbc_lblShapes.gridy = 1;
        panel.add(lblShapes, gbc_lblShapes);

        JToggleButton tglbtnPoint = new JToggleButton("Point");
        tglbtnPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(activeButton == ActiveButton.Add){
                    activeShape = ActiveShape.Point;
                }
            }
        });
        btnGroup.add(tglbtnPoint);
        GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
        gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnPoint.gridx = 0;
        gbc_tglbtnPoint.gridy = 2;
        panel.add(tglbtnPoint, gbc_tglbtnPoint);

        JToggleButton tglbtnLine = new JToggleButton("Line");
        tglbtnLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(activeButton == ActiveButton.Add){
                    activeShape = ActiveShape.Line;
                }
            }
        });
        btnGroup.add(tglbtnLine);
        GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
        gbc_tglbtnLine.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnLine.gridx = 0;
        gbc_tglbtnLine.gridy = 3;
        panel.add(tglbtnLine, gbc_tglbtnLine);

        JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
        tglbtnRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(activeButton == ActiveButton.Add){
                    activeShape = ActiveShape.Rectangle;
                }
            }
        });
        btnGroup.add(tglbtnRectangle);
        GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
        gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnRectangle.gridx = 0;
        gbc_tglbtnRectangle.gridy = 4;
        panel.add(tglbtnRectangle, gbc_tglbtnRectangle);

        JToggleButton tglbtnCircle = new JToggleButton("Circle");
        tglbtnCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(activeButton == ActiveButton.Add){
                    activeShape = ActiveShape.Circle;
                }
            }
        });
        btnGroup.add(tglbtnCircle);
        GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
        gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnCircle.gridx = 0;
        gbc_tglbtnCircle.gridy = 5;
        panel.add(tglbtnCircle, gbc_tglbtnCircle);

        JToggleButton tglbtnDonut = new JToggleButton("Donut");
        tglbtnDonut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(activeButton == ActiveButton.Add){
                    activeShape = ActiveShape.Donut;
                }
            }
        });
        btnGroup.add(tglbtnDonut);
        GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
        gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnDonut.gridx = 0;
        gbc_tglbtnDonut.gridy = 6;
        panel.add(tglbtnDonut, gbc_tglbtnDonut);

        Component verticalStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
        gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
        gbc_verticalStrut.gridx = 0;
        gbc_verticalStrut.gridy = 7;
        panel.add(verticalStrut, gbc_verticalStrut);

        JLabel lblOptions = new JLabel("Options:");
        GridBagConstraints gbc_lblOptions = new GridBagConstraints();
        gbc_lblOptions.insets = new Insets(0, 0, 5, 0);
        gbc_lblOptions.gridx = 0;
        gbc_lblOptions.gridy = 8;
        panel.add(lblOptions, gbc_lblOptions);

        tglbtnAdd = new JToggleButton("Add");
        tglbtnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(activeButton == ActiveButton.Add) {
                    activeButton= ActiveButton.None;
                }else {
                    activeButton = ActiveButton.Add;
                }
                

            }
        });
        btnGroup1.add(tglbtnAdd);
        GridBagConstraints gbc_tglbtnAdd = new GridBagConstraints();
        gbc_tglbtnAdd.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnAdd.gridx = 0;
        gbc_tglbtnAdd.gridy = 9;
        panel.add(tglbtnAdd, gbc_tglbtnAdd);

        JToggleButton tglbtnModify = new JToggleButton("Modify");
        tglbtnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(activeButton == activeButton.Modify) {
                    activeButton = ActiveButton.None;
                }else {
                    activeButton = ActiveButton.Modify;
                    openModifyDialog();
                }
            }
        });
        btnGroup1.add(tglbtnModify);
        GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
        gbc_tglbtnModify.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnModify.gridx = 0;
        gbc_tglbtnModify.gridy = 10;
        panel.add(tglbtnModify, gbc_tglbtnModify);

        JToggleButton tglbtnDelete = new JToggleButton("Delete");
        tglbtnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(activeButton == activeButton.Delete) {
                    activeButton = ActiveButton.None;
                }else {
                    activeButton = ActiveButton.Delete;
                    if(selectedShape != null) {
                    	DlgDelete dialog = new DlgDelete();
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        dialog.setTitle("Are you sure you want to delete shape?");
                        dialog.setVisible(true);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "No shape selected", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        btnGroup1.add(tglbtnDelete);
        GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
        gbc_tglbtnDelete.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnDelete.gridx = 0;
        gbc_tglbtnDelete.gridy = 11;
        panel.add(tglbtnDelete, gbc_tglbtnDelete);

        JToggleButton tglbtnDeleteAll = new JToggleButton("Delete All");
        tglbtnDeleteAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(activeButton == activeButton.DeleteAll) {
                    activeButton = ActiveButton.None;
                }else {
                    activeButton = ActiveButton.DeleteAll;
                    deleteAllShapes();
                }
            }
        });
        btnGroup1.add(tglbtnDeleteAll);
        GridBagConstraints gbc_tglbtnDeleteAll = new GridBagConstraints();
        gbc_tglbtnDeleteAll.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnDeleteAll.gridx = 0;
        gbc_tglbtnDeleteAll.gridy = 12;
        panel.add(tglbtnDeleteAll, gbc_tglbtnDeleteAll);

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
        gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
        gbc_verticalStrut_1.gridx = 0;
        gbc_verticalStrut_1.gridy = 13;
        panel.add(verticalStrut_1, gbc_verticalStrut_1);

        Component verticalStrut_2 = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
        gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
        gbc_verticalStrut_2.gridx = 0;
        gbc_verticalStrut_2.gridy = 14;
        panel.add(verticalStrut_2, gbc_verticalStrut_2);

        JButton btnHelp = new JButton("Help");
        btnHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Help\n"
                                + "For creating Point you need to go on button Add than to a button Point and than select where you want to add a Point on screen.\n\n"
                                + "For creating Line you need to go on button Add than to a button Line and select to Points on screen where you want to draw a Line.\n\n"
                                + "For creating Rectangle you need to go on button Add than to a button Rectangle and select UpperLeftPoint of your Rectangle on screen than add Width and Height.\n\n"
                                + "For creating Circle you need to go on button Add than to a button Circle and select Center of you Circle on screen and than add Radius.\n\n"
                                + "For creating Donut you need to go on button Add than to a button Donut and select Center of your Donut on screen than you need to add Radius and InnerRadius of your Donut.\n\n"
                        , "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        GridBagConstraints gbc_btnHelp = new GridBagConstraints();
        gbc_btnHelp.gridx = 0;
        gbc_btnHelp.gridy = 15;
        panel.add(btnHelp, gbc_btnHelp);

        JScrollPane scrollPane = new JScrollPane();
        d.addMouseListener(this);
        contentPane.add(d, BorderLayout.CENTER);
        JList lstShapes = new JList();
        scrollPane.setViewportView(lstShapes);
        
    }
    
    private void OpenAddDialog() {
    	if(activeShape == activeShape.Point) {
    		DlgPoint dialog = new DlgPoint(xCordinate, yCordinate, Color.BLACK);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Add Point");
            dialog.setVisible(true);
    	}
    	if(activeShape == activeShape.Line) {
    		DlgLine dialog = new DlgLine(xCordinate, yCordinate, x1Cordinate, y1Cordinate, Color.BLACK);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Add Line");
            dialog.setVisible(true);
    	}
    	if(activeShape == activeShape.Rectangle) {
    		DlgRectangle dialog = new DlgRectangle(xCordinate, yCordinate, 0, 0, Color.BLACK, new Color(238, 238, 238, 0));
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Add Rectangle");
            dialog.setVisible(true);
    	}
    	if(activeShape == activeShape.Circle) {
    		DlgCircle dialog = new DlgCircle(xCordinate, yCordinate, 0, Color.BLACK, new Color(238, 238, 238, 0));
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Add Circle");
            dialog.setVisible(true);
    	}
    	if(activeShape == activeShape.Donut) {
    		DlgDonut dialog = new DlgDonut(xCordinate, yCordinate, 0, 0, Color.BLACK, new Color(238, 238, 238, 0));
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Add Donut");
            dialog.setVisible(true);
    	}
    	
    	
    }

    public void openModifyDialog() {
    	if(selectedShape != null) {
    		if(selectedShape.getClass() == Point.class) {
    			Point p = (Point)selectedShape;
    			DlgPoint dialog = new DlgPoint(p.getX(), p.getY(), p.getColor(), p);
    			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setTitle("Add Point");
                dialog.setVisible(true);
    		}
    	}
    	
    	if(selectedShape != null) {
    		if(selectedShape.getClass() == Line.class) {
    			Line l = (Line)selectedShape;
    			DlgLine dialog = new DlgLine(l.getStartPoint().getX(), l.getStartPoint().getY(), l.getEndPoint().getX(), l.getEndPoint().getY(), l.getColor(), l);
    			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setTitle("Add Line");
                dialog.setVisible(true);
    		}
    	}
    	if(selectedShape != null) {
    		if(selectedShape.getClass() == Rectangle.class) {
    			Rectangle r = (Rectangle)selectedShape;
    			DlgRectangle dialog = new DlgRectangle(r.getUpperLeftPoint().getX(), r.getUpperLeftPoint().getY(), r.getWidht(), r.getHeight(), r.getColor(), r.getInnerColor(), r);
    			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setTitle("Add Rectangle");
                dialog.setVisible(true);
    		}
    	}
    	
    	if(selectedShape != null) {
    		if(selectedShape.getClass() == Circle.class) {
        		Circle c = (Circle)selectedShape;
        		DlgCircle dialog = new DlgCircle(c.getCenter().getX(), c.getCenter().getY(), c.getRadius(), c.getColor(), c.getInnerColor(), c);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setTitle("Add Circle");
                dialog.setVisible(true);
        	}
    	}
    	if(selectedShape != null) {
    		if(selectedShape.getClass() == Donut.class) {
    			Donut d = (Donut)selectedShape;
    			DlgDonut dialog = new DlgDonut(d.getCenter().getX(), d.getCenter().getY(), d.getRadius(), d.getInnerRadius(), d.getColor(), d.getInnerColor(), d);
    			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setTitle("Add Donut");
                dialog.setVisible(true);
    		}
    	}
    	
    }
    
    public void deleteSelectedShape() {
    	if(selectedShape != null) {
    		d.getShapes().remove(selectedShape);
    		d.paint(d.getGraphics());
    	}
    }
    
    public void deleteAllShapes() {
    	if(selectedShape != null) {
    		d.getShapes().clear();
    		d.paint(d.getGraphics());
    	}
    }
    
	@Override
	public void mouseClicked(MouseEvent e) {
		if(activeButton == ActiveButton.Add) {
			if(activeShape != ActiveShape.Line) {
				xCordinate = e.getX();
				yCordinate = e.getY();
				OpenAddDialog();
			}
			else {
				if(isFirst) {
					xCordinate = e.getX();
					yCordinate = e.getY();
				}
				else {
					x1Cordinate = e.getX();
					y1Cordinate = e.getY();
					OpenAddDialog();
				}
				isFirst = !isFirst;
			}
			return;
		}
		else {
			selectedShape = null;
			xCordinate = e.getX();
			yCordinate = e.getY();
			for (Shape s  : d.getShapes()) {
				if(s.contains(xCordinate, yCordinate)) {
					selectedShape = s;
				}
				s.setSelected(false);
			}
			if(selectedShape != null) {
				selectedShape.setSelected(true);
			}
			d.paint(d.getGraphics());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


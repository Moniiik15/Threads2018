package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnStartIndividual;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnClear;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/image/nota.jpg")));
		setTitle("Threads");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.WEST);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(100, 100));
			panel.setLayout(null);
			panel.add(getBtnStart());
			panel.add(getBtnStop());
			panel.add(getBtnClear());
			
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(50, 40));
			panel_1.add(getBtnStartIndividual());
		}
		return panel_1;
	}
	private JButton getBtnStartIndividual() {
		if (btnStartIndividual == null) {
			btnStartIndividual = new JButton("Start individual threads");
		}
		return btnStartIndividual;
	}
	
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("");
			btnStart.setBounds(18, 5, 63, 39);
			
			ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/image/play.png"));
			Image img = icon.getImage() ;  
			Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( newimg );
			btnStart.setIcon(icon);
			
		}
		return btnStart;
	}
	
	
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("");
			btnStop.setBounds(18, 60, 63, 39);
			ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/image/stop.png"));
			Image img = icon.getImage() ;  
			Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( newimg );
			btnStop.setIcon(icon);
			
		}
		return btnStop;
	}
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("");
			btnClear.setBounds(18, 139, 63, 39);
			ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/image/clear.png"));
			Image img = icon.getImage() ;  
			Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( newimg );
			btnClear.setIcon(icon);
		
		}
		return btnClear;
	}
}

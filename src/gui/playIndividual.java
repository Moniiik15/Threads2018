package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test.Test;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class playIndividual extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private static JTextArea textArea;
	private JPanel panel;
	private JButton btnStartPatti;
	private JButton btnStartBruce;
	private JButton btnStartChoir;
	private JButton btnStopPatti;
	private JButton btnStopBruce;
	private JButton btnStopChoir;
	
	
	Test t=new Test();
	private JButton btnClear;
	private JButton btnRefresh;
	
	/**
	 * Create the frame.
	 */
	public playIndividual(MainWindow mw) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(playIndividual.class.getResource("/image/nota.jpg")));
		setTitle("Play individual");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.WEST);
		
		t.initializeSingingInThreads();
		t.startNewWindow();
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public static JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(200, 100));
			panel.setLayout(null);
			panel.add(getBtnStartPatti());
			panel.add(getBtnStartBruce());
			panel.add(getBtnStartChoir());
			panel.add(getBtnStopPatti());
			panel.add(getBtnStopBruce());
			panel.add(getBtnStopChoir());
			panel.add(getBtnClear());
			panel.add(getBtnRefresh());
		}
		return panel;
	}
	private JButton getBtnStartPatti() {
		if (btnStartPatti == null) {
			btnStartPatti = new JButton("Start Patti");
			btnStartPatti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t.startPatti();
					btnStartPatti.setEnabled(false);
				}
			});
			btnStartPatti.setBounds(15, 16, 115, 29);
		}
		return btnStartPatti;
	}
	private JButton getBtnStartBruce() {
		if (btnStartBruce == null) {
			btnStartBruce = new JButton("Start Bruce");
			btnStartBruce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t.startBruce();
					btnStartBruce.setEnabled(false);
				}
			});
			btnStartBruce.setBounds(15, 54, 115, 29);
		}
		return btnStartBruce;
	}
	private JButton getBtnStartChoir() {
		if (btnStartChoir == null) {
			btnStartChoir = new JButton("Start Choir");
			btnStartChoir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t.startChoir();
					btnStartChoir.setEnabled(false);
				}
			});
			btnStartChoir.setBounds(15, 92, 115, 29);
		}
		return btnStartChoir;
	}
	private JButton getBtnStopPatti() {
		if (btnStopPatti == null) {
			btnStopPatti = new JButton("Stop Patti");
			btnStopPatti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t.stopPatti();
					
					
				}
			});
			btnStopPatti.setBounds(15, 169, 115, 29);
		}
		return btnStopPatti;
	}
	private JButton getBtnStopBruce() {
		if (btnStopBruce == null) {
			btnStopBruce = new JButton("Stop Bruce");
			btnStopBruce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t.stopBruce();
					
				}
			});
			btnStopBruce.setBounds(15, 204, 115, 29);
		}
		return btnStopBruce;
	}
	private JButton getBtnStopChoir() {
		if (btnStopChoir == null) {
			btnStopChoir = new JButton("Stop Choir");
			btnStopChoir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t.stopChoir();
					
				}
			});
			btnStopChoir.setBounds(15, 239, 115, 29);
		}
		return btnStopChoir;
	}
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(null);
				}
			});
			btnClear.setBounds(15, 307, 63, 39);
			ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/image/clear.png"));
			Image img = icon.getImage() ;  
			Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( newimg );
			btnClear.setIcon(icon);
		}
		return btnClear;
	}
	private JButton getBtnRefresh() {
		if (btnRefresh == null) {
			btnRefresh = new JButton("");
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t.stopPatti();
					t.stopBruce();
					t.stopChoir();
					
					t.initializeSingingInThreads();
					t.startNewWindow();
					btnStartPatti.setEnabled(true);
					btnStartBruce.setEnabled(true);
					btnStartChoir.setEnabled(true);
				}
			});
			btnRefresh.setBounds(117, 307, 57, 39);
			ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/image/refresh.jpg"));
			Image img = icon.getImage() ;  
			Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( newimg );
			btnRefresh.setIcon(icon);
		}
		return btnRefresh;
	}
}

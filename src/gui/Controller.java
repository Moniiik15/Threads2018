package gui;

import java.awt.EventQueue;

import test.Test;

public class Controller {

	private static Test t = new Test();

	public static Test getT() {
		return t;
	}

	public void setT(Test t) {
		Controller.t = t;
	}
	
	private static Test t1=new Test();
	

	public static Test getT1() {
		return t1;
	}

	public static void setT1(Test t1) {
		Controller.t1 = t1;
	}

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

}

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

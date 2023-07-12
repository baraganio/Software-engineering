package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Application;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Application app = new Application();
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // look and feel
		
		MainWindow frame = new MainWindow(app);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

package diceroller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DiceGUI {

	private static void buildGUI() {
		JFrame frame = new JFrame("Dice Roller");
		JPanel mainPanel = new JPanel();

		DiceService ds = new DiceService();
		mainPanel.add(ds.getGUIPanel());
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				buildGUI();
			}
		});
	}
}

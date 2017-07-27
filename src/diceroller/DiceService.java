package diceroller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.*;

public class DiceService {

	private static final long serialVersionUID = -2369479439538666263L;

	private JComboBox numOfDice;
	private JPanel dicePanel;
	private JButton rollEmButton;

	public JPanel getGUIPanel() {
		JPanel panel = new JPanel();
		dicePanel = new JPanel();
		JLabel rollResults = new JLabel("Number of dice ");
		rollEmButton = new JButton("Roll 'em!");
		String[] choices = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		numOfDice = new JComboBox(choices);
		numOfDice.addActionListener(new NumOfDiceListener());
		RollEmListener rel = new RollEmListener();
		rollEmButton.addActionListener(rel);
		rollEmButton.addKeyListener(rel);
		panel.add(rollResults);
		panel.add(numOfDice);
		panel.add(rollEmButton);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		mainPanel.add(panel, gbc1);

		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		mainPanel.add(dicePanel, gbc2);

		return mainPanel;
	}

	private int[] rollTheDice(int numOfDiceToRoll) {
		int[] diceRolled = new int[numOfDiceToRoll];
		for (int i = 0; i < numOfDiceToRoll; i++) {
			int r = (int) (Math.random() * 6 + 1);
			diceRolled[i] = r;
		}
		return diceRolled;
	}

	private void bringUpTheDice() {
		String selection = (String) numOfDice.getSelectedItem();
		int[] rollResult = rollTheDice(Integer.parseInt(selection));
		dicePanel.removeAll();
		dicePanel.add(Dice.castTheDice(rollResult));
		dicePanel.validate();
		dicePanel.repaint();
		SwingUtilities.windowForComponent(dicePanel).pack();
		rollEmButton.requestFocus();
	}

	private class RollEmListener implements ActionListener, KeyListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			bringUpTheDice();
		}

		@Override
		public void keyPressed(KeyEvent ke) {
			if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
				bringUpTheDice();
			}
		}

		@Override
		public void keyReleased(KeyEvent ke) {
		}

		@Override
		public void keyTyped(KeyEvent ke) {
		}
	}

	private class NumOfDiceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			rollEmButton.requestFocus();
		}

	}
}

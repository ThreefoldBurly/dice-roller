package diceroller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Dice extends JPanel {

	private static final long serialVersionUID = 8323586196033662459L;

	public final static Color RIM_COLOR = new Color(83, 80, 72);
	public final static Color FILL_COLOR = new Color(183, 176, 158);
	public final static Color DOTS_COLOR = new Color(72, 60, 30);

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(50, 50);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(RIM_COLOR);
		g.fillRoundRect(10, 10, 30, 30, 4, 4);
		g.setColor(FILL_COLOR);
		g.fillRoundRect(11, 11, 28, 28, 2, 2);
	}

	public static JPanel castTheDice(int[] diceCast) {
		JPanel dicePanel = new JPanel();

		for (int dieNum : diceCast) {
			switch (dieNum) {
				case 1:
					Dice dieOne = new DiceOne();
					dicePanel.add(dieOne);
					break;
				case 2:
					Dice dieTwo = new DiceTwo();
					dicePanel.add(dieTwo);
					break;
				case 3:
					Dice dieThree = new DiceThree();
					dicePanel.add(dieThree);
					break;
				case 4:
					Dice dieFour = new DiceFour();
					dicePanel.add(dieFour);
					break;
				case 5:
					Dice dieFive = new DiceFive();
					dicePanel.add(dieFive);
					break;
				case 6:
					Dice dieSix = new DiceSix();
					dicePanel.add(dieSix);
					break;
			}
		}
		return dicePanel;
	}
}

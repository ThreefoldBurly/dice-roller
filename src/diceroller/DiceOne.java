package diceroller;

import java.awt.Graphics;

public class DiceOne extends Dice {

	private static final long serialVersionUID = 867531687632708754L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(DOTS_COLOR);
		g.fillOval(22, 22, 6, 6);
	}

}

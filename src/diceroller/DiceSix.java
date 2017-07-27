package diceroller;

import java.awt.Graphics;

public class DiceSix extends Dice {

	private static final long serialVersionUID = 867531687632708754L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(DOTS_COLOR);
		g.fillOval(13, 13, 6, 6);
		g.fillOval(22, 13, 6, 6);
		g.fillOval(31, 13, 6, 6);
		g.fillOval(13, 31, 6, 6);
		g.fillOval(22, 31, 6, 6);
		g.fillOval(31, 31, 6, 6);
	}

}

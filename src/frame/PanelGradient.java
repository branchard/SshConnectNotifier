package frame;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;


public class PanelGradient extends JPanel
{

	private static final long	serialVersionUID	= 8334369610498563446L;

	private Color				couleur1;
	
	private Color				couleur2;
	
	public PanelGradient(Color couleur1, Color couleur2)
	{
		this.couleur1 = couleur1;
		this.couleur2 = couleur2;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(new Point(0, 0), couleur1, new Point(getWidth(), getHeight()), couleur2);
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
	
}

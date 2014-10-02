package frame;

import javax.swing.JWindow;

public class Notifieur extends Thread
{
	private JWindow	fenetre;
	
	public Notifieur(String titre, String message, TypeNotification type)
	{
		fenetre = new FenetreNotification(titre, message, type);
	}
	
	@Override
	public void run()
	{
		fenetre.setVisible(true);
		try
		{
			Thread.sleep(20000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		fenetre.setVisible(false);
		fenetre.dispose();
	}
	
}

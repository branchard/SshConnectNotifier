package main;

import frame.Notifieur;
import frame.TypeNotification;

public class Main
{
	
	public static void main(String[] args)
	{
		final String MY_USER_NAME = System.getProperty("user.name");
		
		String buffer = null;
		
		while(true)
		{
			buffer = Utils.checkWhoConnect(MY_USER_NAME);
			if(buffer != null)
			{
				Notifieur notifieur = new Notifieur("Alert ssh", "Connection ssh de: " + Utils.getName(buffer) + "<br/>Nom de machine: " + Utils.getMachineName(buffer), TypeNotification.ERREUR);
				notifieur.start();
				Utils.fork(Utils.getMachineName(buffer), Utils.getName(buffer));
				try
				{
					Thread.sleep(30000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
					break;
				}
			}
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				break;
			}
		}
	}
	
}

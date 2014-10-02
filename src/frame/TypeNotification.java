package frame;

import java.awt.Color;

public class TypeNotification
{

	public static TypeNotification	ERREUR		= new TypeNotification(Color.red, Color.WHITE);

	public static TypeNotification	INFO		= new TypeNotification(new Color(100, 100, 255), Color.WHITE);

	public static TypeNotification	VALIDATION	= new TypeNotification(Color.GREEN, Color.WHITE);

	private Color					couleur1;

	private Color					couleur2;

	public TypeNotification(Color couleur1, Color couleur2)
	{
		this.couleur1 = couleur1;
		this.couleur2 = couleur2;
	}

	public Color getCouleur1()
	{
		return couleur1;
	}

	public Color getCouleur2()
	{
		return couleur2;
	}
	
}

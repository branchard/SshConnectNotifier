package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class FenetreNotification extends JWindow
{

	private static final long	serialVersionUID	= 227309878747520841L;
	
	public FenetreNotification(String titre, String texte, TypeNotification type)
	{
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize().getSize();
		setAlwaysOnTop(true);
		setSize(200, 200);
		JPanel panel = new PanelGradient(type.getCouleur1(), type.getCouleur2());
		panel.setBorder(BorderFactory.createEtchedBorder(1, Color.BLACK, Color.LIGHT_GRAY));
		panel.setLayout(new BorderLayout());
		JEditorPane p = new JEditorPane();
		p.setOpaque(false);
		p.setContentType("text/html");
		p.setText(genereHtml(titre, texte));
		panel.add(p);
		add(panel);
		setLocation((int) d.getWidth() - 220, (int) d.getHeight() - 220);
	}
	
	private String genereHtml(String titre, String texte)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body style='font-family:Calibri;font-size:10px;'>");
		sb.append("<table border='1px' width='100%'>");
		sb.append("<tr>");
		sb.append("<th style='font-size:13px;font-weight:bold;' align='center'>");
		sb.append(titre + "<hr />");
		sb.append("</th>");
		sb.append("</tr>");
		sb.append("	<tr>");
		sb.append("	<td align='center'>");
		sb.append(texte);
		sb.append("</td>");
		sb.append("	</tr>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("	</html>");
		return sb.toString();
	}
	
}

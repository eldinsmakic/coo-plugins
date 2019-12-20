package fil.coo.file.listeners.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import fil.coo.file.FileChecker;
import fil.coo.file.FileEvent;
import fil.coo.file.listeners.FileListener;
import plugin.Plugin;

/**
 * <b>JMenuFileListener</b> is a JMenu with an implementation of a FileListener
 * When a FileEvent occur (adding or removing a file of a specified directory)
 * <b>JMenuFileListener</b> will add or removed (depending of the event) a (new) JMenuItemPlugin (for more information {@link fil.coo.file.listeners.gui.JMenuItemPlugin} ).
 * These JMenuItemPlugin when selected will change a String contain in a JTextArea.
 * 
 * 
 * @see fil.coo.file.listeners.FileListener
 * @author smakic and perrot
 *
 */
public class JMenuFileListener extends JMenu implements FileListener 
{

	
	JTextArea mainJTextArea;
	/**
	 * When Create Link the menu with the JTextArea to manipulate it
	 * @param txt : Name of the JMenu
	 * @param mainJText : JTextArea to manipulate
	 */
	public JMenuFileListener(String txt,JTextArea mainJText)
	{
		super(txt);
	
		this.mainJTextArea = mainJText;
	}
	
	public void fileAdded(FileEvent e) 
	{
		final Plugin p = PluginToJMenuItemFactory.FACTORY.buildPluginFromString(e.getFileName());
		JMenuItemPlugin menuItem = new JMenuItemPlugin(p);
		menuItem.addActionListener(new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				mainJTextArea.setText(p.transform(mainJTextArea.getText()));
				
			}
		});
		
		if (menuItem != null)
		{
			
			this.add(menuItem);
		  
		}
		
	}

	public void fileRemoved(FileEvent e) 
	{
		
		String s = e.getFileName();
		Component[] sons = this.getMenuComponents();
		JMenuItemPlugin p;
		Plugin plugin = PluginToJMenuItemFactory.FACTORY.buildPluginFromString(s);
		int length = sons.length;
		int i = 0;
		for (i = 0 ; i < length ; i++)
		{
			p = (JMenuItemPlugin)sons[i];

			if(p.isTheRightMenuItemToDestroy(plugin.getLabel()))
			{
				this.remove(p);
			}
				
		}
		
	}
	

}

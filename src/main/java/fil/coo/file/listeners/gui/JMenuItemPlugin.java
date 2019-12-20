package fil.coo.file.listeners.gui;

import java.awt.Container;

import javax.swing.JMenuItem;

import plugin.Plugin;

/**
 * <b>JMenuItemPlugin</b> is a JMenuItem with a Plugin in it (for more information {@link plugin.Plugin } )
 * Is a certain word is just a plugin wrap in a JMenuItem, interacting with the JMenuItem will be interacting with the plugin.
 * This MenuItem will have the label of a plugin as Name, when clicked will transform a text in A JTextArea ( see JMenuFileListener for more information on this part {@link fil.coo.file.listeners.gui.JMenuFileListener})
 * The transformation depend of the plugin gived to the JMenuItemPlugin.
 * @author smakic and perrot
 *
 */
public class JMenuItemPlugin extends JMenuItem
{
	private Plugin plugin;
	
	/**
	 * 
	 * @param plugin : plugin to add
	 */
	public JMenuItemPlugin(Plugin plugin)
	{
		super();
		this.plugin = plugin;
		this.setText(this.plugin.getLabel());
		this.setVisible(true);
	}
	
	/**
	 * Compare a FileName with his own Plugin to see if the fileName will create the same Plugin
	 * @deprecated
	 * @param s : the FileName to compare to plugin
	 */
	public void destroyHimselfIfPlugin(String s)
	{
		if(plugin.getLabel() == s)
		{
			Container c = this.getParent();
			c.remove(this);
			System.out.println("destroying himself..");
		}
			
		
	}
	
	/**
	 * See if <b>s</b> is the same as the plugin's label (private Variable)
	 * @param s The Label of a plugin
	 * @return True if the same Label name else false
	 */
	public boolean isTheRightMenuItemToDestroy(String s)
	{

		return plugin.getLabel().equals(s);
	}
}

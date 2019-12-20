package fil.coo.file.listeners.gui;

import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import javax.swing.AbstractAction;

import plugin.Plugin;

/**
 * Factory that create Plugin and his more advanced state a JMenuItem from a string (generaly a fileName)
 * 
 * @author smakic and perrot
 *
 */
public class PluginToJMenuItemFactory 
{
	public final static PluginToJMenuItemFactory FACTORY = new PluginToJMenuItemFactory();
	
	/**
	 * Return a Plugin from a FileName S
	 * @param s : Filename to convert to a plugin
	 * @return a fresh new plugin
	 */
	public Plugin buildPluginFromString(String s)
	{
		Class<?> c;
		Constructor<?> t ;
		Plugin p ;
		
		try 
		{
			c = Class.forName("plugins."+s.substring(0, s.lastIndexOf(".")));
		
			 t = c.getConstructor();
			 p = (Plugin) t.newInstance();
			 return p;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Return a JMenuItem from a FileName S
	 * @param s : Filename to convert to a plugin
	 * @return a new JMenuItemPlugin 
	 */
	public JMenuItemPlugin buildJMenuItemFromString(String s)
	{
		Plugin p = this.buildPluginFromString(s);
		JMenuItemPlugin res;
		res  = new JMenuItemPlugin(p);
		
		
		res.setAction(new AbstractAction() {
			
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) 
			{
				System.out.println(e.toString());
				
			}
		});
		
		return res;
		
	}
}

package fil.coo.file.lister;

import java.io.File;
import java.io.FilenameFilter;
import plugin.Plugin;

/**
 * <b>ListFilePluginFilter</b> will sort files that are Plugin ( for more information {@link plugin.Plugin })
 * 
 * @author smakic and perrot
 * @see fil.coo.file.lister.ListFile
 */
public class ListFilePluginFilter implements ListFile,FilenameFilter
{
	private final String DIRECTORY;
	

	/**
	 * 
	 * @param directory : the directory to sort files
	 */
	public ListFilePluginFilter(String directory)
	{
		this.DIRECTORY = directory;
	}
	
	public String[] getListOfFiles()
	{
		File file = null;
		file = new File(this.DIRECTORY);
		if (file.exists())
			return listPlugin(file.list(this));
		return null;
	}

	public boolean accept(File dir, String name)
	{
		return name.matches(".+(.class)$");
	}
	
	/**
	 * will return only fileName that are Plugins
	 * 	 is invoked in {@link #getListOfFiles()}
	 * @param listFile : listFile to sort
	 * @return sorted String Array with String (fileName) that are Plugins
	 */
	public String[] listPlugin(String[] listFile)
	{
		String[] result;
		int length = 0;
		int iterator = 0;
		boolean hasAPlugin = false;
		int[] tab = new int[listFile.length];
	
	
		String currentFile = null;
		for (iterator = 0 ; iterator< listFile.length ; iterator++)
		{
			currentFile = cutingExtensionOfFileName(listFile[iterator]);
			if(isPlugin(currentFile))
			{
				tab[length] = iterator + 1;
				length++;
				hasAPlugin = true;
			
			}

		}
		if (!hasAPlugin)
			return null;
		
		result = new String[length];
		length = 0;
		for (int i : tab)
		{
			if( i > 0)
			{
				result[length] = listFile[i-1];
				length++;
				
			}
			
			
		}
	
		return result;
	}
	/**
	 * Cut extension of Classe file
	 * @param name : name of the file
	 * @return the name of the file without his extension
	 */
	public String cutingExtensionOfFileName(String name)
	{
		return name.substring(0, name.lastIndexOf("."));
	}
	
	/**
	 * Return if a Filename (name) can be a Plugin
	 * @param name : fileName
	 * @return True if the FileName can be a Plugin else false
	 */
	public boolean isPlugin(String name)
	{
		Class<?> c ;
		try 
		{
			c = Class.forName("plugins."+name);
			return Plugin.class.isAssignableFrom(c);
		} 
		catch (Exception e) 
		{
		
			return false;
		}
		catch(NoClassDefFoundError e) {
			e.printStackTrace();
			return false;
		}
	}
}

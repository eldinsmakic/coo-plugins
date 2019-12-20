package fil.coo.file.lister;

import java.io.File;
import java.io.FilenameFilter;

/**
 *  ListFileBeginingWithCInFolder will sort a directories a get all files with a ".class" extension
 * 	@author smakic and perrot
 * 
 *  @see fil.coo.file.lister.ListFile 
 *
 */
public class ListFileWithClassExtensionInFolder implements ListFile,FilenameFilter 
{

private final String DIRECTORY;


	/**
	 * 
	 * @param directory : the directory to sort files.
	 */
	public ListFileWithClassExtensionInFolder(String directory)
	{
		this.DIRECTORY = directory;
	}
	
	public String[] getListOfFiles()
	{
		File file = null;
		file = new File(this.DIRECTORY);
		if (file.exists())
			return file.list(this);
		return null;
	}

	public boolean accept(File dir, String name)
	{
		return name.matches(".*[.]class$");
	}
}

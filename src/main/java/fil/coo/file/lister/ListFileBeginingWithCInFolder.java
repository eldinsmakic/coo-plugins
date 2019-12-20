package fil.coo.file.lister;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * 	ListFileBeginingWithCInFolder will sort a directories a get all files which begin with a "C"
 * 	@author smakic and perrot
 *  
 * 	@see fil.coo.file.lister.ListFile 
 */
public class ListFileBeginingWithCInFolder implements ListFile,FilenameFilter
{
	private final String DIRECTORY;
	
	
	/**
	 * 
	 * @param directory : the directory to sort files.
	 */
	public ListFileBeginingWithCInFolder(String directory)
	{
		this.DIRECTORY = directory;
	}
	
	public String[] getListOfFiles()
	{
		File file = null;
		file = new File(this.DIRECTORY);
		if (file.exists())
			return file.list(this);
		System.out.println(file.getAbsolutePath());
		return null;
	}

	public boolean accept(File dir, String name)
	{
		return name.matches("^[cC].+");
	}
}

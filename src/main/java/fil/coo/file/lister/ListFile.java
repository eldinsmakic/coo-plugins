package fil.coo.file.lister;

/**
 * ListFile interface is used to represent all the class which will sort 
 *	files in directories.
 * @author smakic and perrot
 *	
 */
public interface ListFile 
{
	/**
	 * Return a list of FileName from a regex match of a directory
	 * @return a String array fill with Filename 
	 */
	String[] getListOfFiles();
}

package fil.coo.file.listeners;

import fil.coo.file.FileEvent;

/**
 * PrintFileListener will print on the console when a file is added
 * @author smakic and perrot
 * 
 * @see fil.coo.file.listeners.FileListener
 *
 */
public class PrintFileListener implements FileListener
{
	
	/**
	 * When invoked will print the named of the file added
	 * {@link #fileAdded(FileEvent)}
	 * 
	 * {@inheritDoc}
	 */
	public void fileAdded(FileEvent e) 
	{
		System.out.println("-  File added " + e.getFileName());
		
	}

	/**
	 * When invoked will print the named of the file removed
	 * {@link #fileRemoved(FileEvent)}
	 * 
	 * {@inheritDoc}
	 */
	public void fileRemoved(FileEvent e) 
	{
		System.out.println("-  File removed " + e.getFileName());
		
	}

}

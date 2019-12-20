package fil.coo.file.listeners;

import fil.coo.file.FileEvent;

/**
 * 
 * 	
 * 
 * 
 *	The Filelistener interface is used for receiving action events.
 * 	The class that is interested in processing an action event implements this interface,
 *  and the object created with that class is registered with a component,
 *   When the action event occurs, 
 *   that object's fileAdded method is invoked.
 *   @author smakic and perrot
 */
public interface FileListener 
{
	/**
	 * Method that will be invoked when a file is added in a FileChecker
	 * 
	 * @param e : New fileEvent that contain the file which raised the event
	 *
	 */
	public void fileAdded(FileEvent e);

	
	/**
	 * Method that will be invoked when a file is removed in a FileChecker
	 *
	 * @param e : New fileEvent that contain the file which raised the event
	 * 
	 */
	public void fileRemoved(FileEvent e);
	
}

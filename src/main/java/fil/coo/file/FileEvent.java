package fil.coo.file;

import java.awt.AWTEvent;
import java.awt.Event;
import java.awt.event.MouseEvent;

/**
 * A semantic event which indicates that a File-defined action occurred. 
 * This high-level event is generated by a modification of a directories content (such as a File) when the modification action occurs (such as file being added/removed). 
 * The event is passed to every FileListener object that registered to receive such events using the component's fileAdded method or FileRemoved method.

 * @author smakic and perrot
 *
 */
public class FileEvent 
{
	private final String fileName;
	public final int FILEADDED = 1 ;
	public final int FILEREMOVED = 0;
	/***
	 * 
	 * @param name : name of the file that generate the event
	 */
	public FileEvent(String name)
	{
		this.fileName = name;
	}
	
	/**
	 *  Get the name of file which raised the event
	 * @return name of the file
	 */
	public String getFileName()
	{
		return this.fileName;
		
	}
}

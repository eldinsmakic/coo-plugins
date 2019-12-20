
package fil.coo.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import fil.coo.file.listeners.FileListener;
import fil.coo.file.lister.ListFile;


/**
 * Class FileChecker Is an observable,
 * checking every n seconds if the filenameFilter gived new file or removed,
 * if so FileChecker will tell to the observers the event that occured
 * @author smakic and perrot
 *
 */
public class FileChecker implements ActionListener
{
	private List<FileListener> observers;
	private String[] files;
	private ListFile filenameFilter;
	private javax.swing.Timer timer;
	
	/**
	 * The constructor use a FilenameFilter to get a list of files's name on a directory,
	 * can see more on how to use it {@link java.io.FilenameFilter}
	 * 
	 * 
	 * @param filenameFilter : FilenameFilter of the good directory
	 * @param time : number of millisecond to wait for checking again the directory
	 */
	public FileChecker(ListFile filenameFilter,int time)
	{
		this.filenameFilter = filenameFilter;
		this.files = null;
		this.observers = new ArrayList<FileListener>();
		this.timer = new Timer(time, this);
		this.timer.start();
	}
	
	/**
	 * Will add new observers, here observers are fileListener 
	 * When new file is added or removed, these observers will be notified of that event
	 * 
	 * @see fil.coo.file.listeners.FileListener
	 * 
	 * @param fileListener : fileListener to add 
	 */
	public void addFileListener(FileListener fileListener)
	{
		this.observers.add(fileListener);
	}
	
	/**
	 * Will removed an observers, here observers are fileListener 
	 * When new file is added or removed, these observers will be notified of that event
	 * 
	 * @see fil.coo.file.listeners.FileListener
	 * 
	 * @param fileListener : fileListener to remove
	 */
	public void removeFileListerner(FileListener fileListener)
	{
		this.observers.remove(fileListener);
	}

	
	public void actionPerformed(ActionEvent arg0) 
	{
		
		String [] result;
		boolean isPresent = false;
		if (this.files == null)
		{
			this.files = this.filenameFilter.getListOfFiles();
			if (this.files ==  null) return;
			for (String s : this.files)
			{
				this.fireFileAdded(s);
			}
				
		}
		else
		{ 
			
			String [] fileInDirectory = this.filenameFilter.getListOfFiles();
			for (String s: this.files)
			{
				for(String s2 : fileInDirectory)
				{
					if (s2.equals(s))
						isPresent = true;
				}
					if(!isPresent)
						this.fireFileRemoved(s);
					isPresent = false;
			}
			for (String s: fileInDirectory)
			{
				for (String s2 : this.files)
				{
					if (s2.equals(s))
						isPresent = true;
				}
					if (!isPresent)
						this.fireFileAdded(s);
					isPresent = false;
			}
			this.files = fileInDirectory;
		}
		
	}
	
	/**
	 * Will invoked the method fileAdded of the observers when a file is added to the directory
	 * @param file : the file that was added 
	 */
	protected void fireFileAdded(String file)
	{	
		FileEvent event = new FileEvent(file);
		for (FileListener f : this.observers)
		{
			
			f.fileAdded(event);
		}
	}
	
	/**
	 * Will invoked the method fileRemoved of the observers when a file is removed to the directory
	 * @param file : the file that was removed
	 */
	protected void fireFileRemoved(String file)
	{

		FileEvent event = new FileEvent(file);
		for (FileListener f : this.observers)
		{
			
			f.fileRemoved(event);
		}
	}
	
}

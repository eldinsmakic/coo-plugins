package fil.coo.file;

import fil.coo.file.lister.ListFile;

public class FileCheckerMock extends FileChecker
{
	boolean isFireFileAdded = false;
	boolean isFireFileRemoved = false;
	boolean isNewFileAdded = false;
	boolean isFileRemoved = false;

	public FileCheckerMock(ListFile filenameFilter, int time) 
	{
		super(filenameFilter, time);

	}
	
	@Override
	public void fireFileAdded(String file)
	{
		super.fireFileAdded(file);
		this.isFireFileAdded = true;
	}
	
	@Override
	public void fireFileRemoved(String file)
	{
		super.fireFileRemoved(file);
		this.isFileRemoved = true;
	}
	

}

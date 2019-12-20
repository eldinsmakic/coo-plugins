package fil.coo.file;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import fil.coo.file.listeners.FileListener;
import fil.coo.file.listeners.PrintFileListener;
import fil.coo.file.lister.ListFile;
import fil.coo.file.lister.ListFileWithClassExtensionInFolder;

public class FileCheckerTest 
{
	private static final String PATH = "test_extensions/";
	private FileCheckerMock fileChecker;
	private ListFile listFile;
	private FileListener fileList1;
	private FileListener fileList2;
	
	@Before
	public void initTest()
	{
		listFile = new ListFileWithClassExtensionInFolder("plugins");
		
		fileList1 = new PrintFileListener();
		fileList2 = new PrintFileListener();
	}
	
	@Test
	public void testFileChecker() 
	{
		fileChecker =  new FileCheckerMock(listFile,2000);
		assertTrue(fileChecker != null);
		
	}

	

	@Test
	public void testActionPerformedNewFileAdded() 
	{
		File file1,file2;
		fileChecker = new FileCheckerMock(listFile,2000);
		assertFalse(fileChecker.isFireFileAdded);
		file1 = new File(this.PATH + "hello.class");
		
		
	}

	@Test
	public void testFireFileAdded() {
	
	}

	@Test
	public void testFireFileRemoved() {
		
	}

}

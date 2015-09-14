package edf.nnb.docscanner;

import java.io.File;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//take the directory path from the command line argument and pass to directory manager
		try
		{
		DirectoryManager theDirectoryManager = new DirectoryManager(args[0]);
		
		//call the getFiles method to iterate through the directory
		List<File> theList = theDirectoryManager.getAllFiles(true);
		
		DataWriter theDataWriter = new DataWriter("D:\\directoryTest");
		
		theDataWriter.writeToCSV(theList);
		}
		catch (Exception e)
		{
			//add exception handling code
		}
		
		

	}

}

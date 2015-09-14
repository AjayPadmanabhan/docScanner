package edf.nnb.docscanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class DataWriter {
	//declare the constant comma character
	public static final String CHAR_COMMA = ",";
	
	//declare the constant output file name
	public static final String FILE_NAME = "\\output.csv";
	
	//declare the file object to be assigned to the parent directory
	static File outputDirectory;
	

	//This class will write the data to various locations based on constructor. Can include DB connections or text file locations
	public DataWriter(String writeLocation)
	{
		try
		{
			File f = new File(writeLocation);
			if (f.exists() && f.isDirectory())
			{
			outputDirectory = new File(writeLocation);
			
			}
			else 
			{
				//INSERT CODE TO HANDLE INVALID PATH
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void writeToCSV(List<File> fileList) throws Exception
	{
		//Open a printwriter to create and write to the csv file 
		PrintWriter thePrintWriter = new PrintWriter(outputDirectory.getAbsolutePath() + FILE_NAME);
		
		//iterate through each file in the file list
		for(File f : fileList)
		{
			//write to the file
			thePrintWriter.println(f.getAbsolutePath() + CHAR_COMMA + MD5Checksum.getMD5Checksum(f.getAbsolutePath()) + CHAR_COMMA + FileScanner.getExtension(f.getAbsolutePath()));
			thePrintWriter.flush();
		}
		
		//Close the connection to the output file
		thePrintWriter.close();
		
	}
	
	
	
	
}

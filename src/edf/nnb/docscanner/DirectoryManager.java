package edf.nnb.docscanner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryManager {
	
	private static File theDirectory;
	static List<File> fileList;
	
	//constructor for the DirectoryManager object 
	public DirectoryManager(String path)
	{
		theDirectory = new File(path);
		
		fileList = new ArrayList<File>();
	}
	
	
	public static List<File> getAllFiles(Boolean isRecursive)
	{
		try 
		{
		getFiles(isRecursive);
		return fileList;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	//this method initialises the directory scan for 1 level of structure
	private static void getFiles(Boolean isRecursive)
	{
		for (File file : theDirectory.listFiles())
		{
			if(file.isDirectory())
			{
				if(isRecursive)
				{
				getFilesRecursive(file);
				}
			}
			else
			{
				System.out.println(file.getAbsolutePath());
				fileList.add(file);
			}
		}
	}
	
	
	//this method will recursively scan all sub directories
	private static void getFilesRecursive(File thisDirectory)
	{
		for(File file : thisDirectory.listFiles())
		{
			if(file.isDirectory())
			{
				getFilesRecursive(file);
			}
			else
			{
				System.out.println(file.getAbsolutePath());
				fileList.add(file);
			}
		}
	}
	
	
	
	
	
	

}

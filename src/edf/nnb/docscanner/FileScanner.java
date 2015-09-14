package edf.nnb.docscanner;

import org.apache.poi.*;
import org.apache.commons.io.*;



public class FileScanner {

	public static String getExtension(String fileName)
	{
		String ext = FilenameUtils.getExtension(fileName);
		
		return ext;
	}
	
	public static String searchProtectiveMarking(String fileName)
	{
		String ext = FilenameUtils.getExtension(fileName);
		return null;
	}
}

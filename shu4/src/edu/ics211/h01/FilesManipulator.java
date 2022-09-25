/*
 * square roots calculator and file reader 
 * @author Chien-Hua Shu
 * @assignment homework 1 
 * @data August 25, 2022
 * @bugs none
 */
package edu.ics211.h01;
import java.io.*;

public class FilesManipulator {
	
// files reader method
 public static int FileReader(String FileName) {
	 
	 // create a new File object to get the input
	 File file =  new File(FileName); 
	 
	 
	 //conditional statement for checking the validity of the files 
	 if(!file.exists()) {
		 throw new RuntimeException(FileName + " File is not existed");
	 }
	 else if (file.isDirectory()) {
		 throw new RuntimeException(FileName + " is the directory not the file");
		 
	 }
	 // return the total characters in the file 
	 return (int)file.length();
 }
 /*
  * This is a testing method
  * 
 public static Boolean testing(String FileName) {
	 File file =  new File(FileName);
	 return file.getAbsolutePath().isDirectory();
 }
 */
 
//alternative method 
public static int BufferedFileReader(String Filename) {
	BufferedReader reader;
	String line;
	int totalChars = 0;
	try {
		reader = new BufferedReader(new FileReader(Filename));
		while((line = reader.readLine()) != null) {
			line += reader.readLine();
			totalChars += line.length();
		}
		reader.close();
	} catch(IOException e) {
		System.out.println("error occur");
		System.exit(1);
	}
return totalChars;
}
}

package Alice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class aliceTextFile {

	public static void createFile(String fileName) {
		PrintWriter outStream = null;

		try {
			outStream = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("FILE COULD NOT BE CREATED! " + fileName + "\nERROR MESSAGE: " + e.getMessage());
		} finally {
			outStream.close();
			System.out.println("FILE SUCCESSFULLY CREATED!" + fileName);
		}
	}

	public static void writeToNewFile(String fileName, String text) {
		PrintWriter outStream = null;

		try {
			outStream = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("Could not create the file: " + fileName + "\nMessage " + e.getMessage());
		} finally {
			if (outStream != null) {
				outStream.close();
				System.out.println("FILE " + fileName + " HAS BEEN SUCESSFULLY CREATED");
			}
		}

	}

	public static void storeSentenceToFile(String fileName, String text) {
		PrintWriter outStream = null;
		try{
			outStream = new PrintWriter(new FileOutputStream(fileName, true));//true tells computer we want to keep previous content
			outStream.println(text);//append to the file
		}catch(FileNotFoundException e){
			System.err.println("Could not append to the file "+fileName+ " MESSAGE: "+e.getMessage());
		}
		finally{//do clean up
			if(outStream != null){
				outStream.close();
			}
		}
		
	}

	public static String readFile(String fileName) {
		Scanner inStream = null;
		String fileContents = "";

		try {
			inStream = new Scanner(new File(fileName));
			while (inStream.hasNextLine()) {
				fileContents += inStream.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			System.err.println("Could not read file: " + fileName + "\nMESSAGE: " + e.getMessage());
		} finally {
			if (inStream != null) {
				inStream.close();
			}
		}
		return fileContents;
	}

}

package src.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import src.main.StreamDriver;

public class Main {

	public static void main(String[] args) throws IOException {
		// firstbenchmarking
		/*
		 * int numberOfStreams = 3; int methodType = 4; int bufferSize = 1024 * 8; int
		 * fileSize = 1; String operationType = "R"; File myFile=new
		 * File("C:\\Users\\buse\\Desktop\\NEW\\"); if(myFile.exists()) {
		 * myFile.delete(); } String writing_path = myFile.getAbsolutePath(); String[]
		 * reading_path = { writing_path + "\\0.txt", writing_path + "\\1.txt",
		 * writing_path + "\\2.txt" };
		 * 
		 * long start = System.nanoTime(); StreamDriver driver = new
		 * StreamDriver(numberOfStreams, methodType, bufferSize, operationType, 1,
		 * reading_path); long end = System.nanoTime(); long duration = (end - start);
		 * double seconds = (double) duration / 1000000000.0; System.out.println(seconds
		 * + " seconds");
		 */

//*********************************************************************************
		// second benchmarking

		int bufferSize = 1024;
		int methodType = 4;
		int numberOfd = 10;
		String operationType = "RW";
		String path = "C:\\Users\\buse\\Desktop\\buse1.txt";

		Sort ex = new Sort(methodType, bufferSize, operationType, path);
		List<String> myList = ex.ExternalMainFunc();
		System.out.println(myList.size());
		Merge newMerge = new Merge(bufferSize, methodType, "RW", numberOfd);
		newMerge.mergeFirstPhase(myList);

	}
	/*
	 * create mkdir File myFile=new File("streamFiles/Files/"); if(myFile.exists())
	 * { myFile.delete(); } else { boolean result=myFile.mkdir();
	 * System.out.println(result); } String mainPath=myFile.getAbsolutePath();
	 * String[] reading_path = {mainPath+"\\0.txt"}; System.out.println(mainPath);
	 */
}

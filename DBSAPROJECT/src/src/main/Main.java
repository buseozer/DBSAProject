package src.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import src.main.StreamDriver;

public class Main {

	public static void main(String[] args) throws IOException {

		// firstbenchmarking

		int numberOfStreams = 1;
		int methodType = 4;
		int bufferSize = 1024 * 8;
		int fileSize = 5;
		String operationType = "W";
		File myFile = new File("C:\\Users\\buse\\Desktop\\BigFile\\");
		if (myFile.exists()) {
			myFile.delete();
		}
		String writing_path = myFile.getAbsolutePath();
		// String[] reading_path = { writing_path + "\\0.txt", writing_path + "\\1.txt",
		// writing_path + "\\2.txt" };

		long start = System.nanoTime();
		StreamDriver driver = new StreamDriver(numberOfStreams, methodType, bufferSize, operationType, fileSize,
				writing_path);
		long end = System.nanoTime();
		long duration = (end - start);
		double seconds = (double) duration / 1000000000.0;
		System.out.println(seconds + " seconds");

		// second benchmarking

		int numberOfd = 64;
		String operationType2 = "RW";
		String path = "C:\\Users\\buse\\Desktop\\BigFile0.txt";

		Sort ex = new Sort(methodType, bufferSize, operationType2, path);
		List<String> myList = ex.ExternalMainFunc();
		System.out.println(myList.size());
		Merge newMerge = new Merge(bufferSize, methodType, "RW", numberOfd);
		newMerge.mergeFirstPhase(myList);

	}

}

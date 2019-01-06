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
		int bufferSize = 1024 * 16;
		int minFileSize = 1;
		int maxFileSize = 1000; 
		String operationType = "W"; //When change operationType, change the last parameter of StreamDriver's constructor
		int maxK = 30;

		long start;
		long end;
		long duration;
		double seconds;

		new File("streamFiles/Files/").mkdirs();

		int u = 2;
		for (int fileSize = minFileSize; fileSize <= maxFileSize; fileSize *= u) {
			u = u == 5 ? 2 : 5;
			String writing_path = "streamFiles\\Files\\" + fileSize + "_";

			String[] reading_path = new String[maxK];
			
			for (int j = 0; j < maxK; j++) {
				reading_path[j] = writing_path + j + ".txt";
			}

			for (int i = 0; i <= maxK; i += 5) {
				if (i == 0)
					numberOfStreams = 1;
				else
					numberOfStreams = i;

				start = System.nanoTime();
				StreamDriver driver = new StreamDriver(numberOfStreams, methodType, bufferSize, operationType, fileSize, writing_path);
				end = System.nanoTime();
				duration = (end - start);
				seconds = (double) duration / 1000000000.0;
				System.out.println("numberOfStreams = " + numberOfStreams + ", methodType = " + methodType + ", bufferSize = "
								+ bufferSize + " , operationType = " + operationType + ", fileSize = " + fileSize);
				System.out.println(seconds + " seconds");
			}
		}

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

package test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import src.main.Merge;
import src.main.Sort;

public class Benchmark2 {
	static int bufferSize = 4096;
	// M = size main memory available
	static int M = bufferSize/4;
	static int method = 4;
	// d = number of streams to merge [2,5,10,20,40,60,80,100,200,1000,1024]
	static int numberOfd = 2;
	static String operationType = "RW";
	static String path = "";
	// N = size input file (>500KB)
	// N (1MB.txt) = 1024KB =  1MB
	// N (5MB.txt) = 5120KB = 5MB
	// N (100MB.txt) = 102400KB = 100MB
	// N (250MB.txt) = 256000KB = 250MB
	// N (500MB.txt) = 512000KB = 500MB
	// N (1GB.txt) = 1048576KB = 1GB
	
	public static void main(String[] args) throws IOException {
		path = "streamFiles\\FilesForB2\\1MB.txt";
		
		
			long start = System.nanoTime();
			Sort ex = new Sort(method, bufferSize, operationType, path);
			List<String> myList = ex.ExternalMainFunc();
			Merge newMerge = new Merge(bufferSize, method, "RW", numberOfd);
			newMerge.mergeFirstPhase(myList);

			long end = System.nanoTime();

			long duration = (end - start);
			double seconds = (double) duration / 1000000000.0;
			System.out.println("Buffer size = " + bufferSize + " ---> M = " + M + " ---> d = " + numberOfd +  " ---> Speed = " + seconds + " seconds");
	}
}
package test;

import java.io.IOException;
import java.util.List;

import src.main.Merge;
import src.main.Sort;

public class Benchmark2 {
	static int bufferSize = 4096;
	// M = size main memory available = (StreamDriver) availableMemory = bufferSize / 4;
	static int M = bufferSize/4;
	static int method = 4;
	// d = number of streams to merge
	//static int numberOfd=10;
	//static int[] ds= {2,5,10,20,40,80,100,200};
	static int d =2;
	static String operationType = "RW";
	static String path = "C:\\Users\\GTM\\eclipse-workspace\\DSA_Project_new\\streamFiles\\Files\\0.txt";
	// N = size input file (>500KB)
	// N (0.txt) = 1024KB =  1MB
	// N (4.txt) = 2048KB = 2MB
	// N (7.txt) = 4096KB = 4MB
	// N (5.txt) = 5120KB = 5MB
	// N (6.txt) = 10240KB = 10MB
	
	public static void main(String[] args) throws IOException {
		//for(int d=0;d<ds.length; d++) {

			long start = System.nanoTime();

			Sort ex = new Sort(method, bufferSize, operationType, path);
			List<String> myList = ex.ExternalMainFunc();
			Merge newMerge = new Merge(bufferSize, method, "RW", d);
			newMerge.mergeFirstPhase(myList);

			long end = System.nanoTime();

			long duration = (end - start);
			double seconds = (double) duration / 1000000000.0;
			System.out.println("Buffer size = " + bufferSize + " ---> M = " + M + " ---> d = " + d +  " ---> Speed = " + seconds + " seconds");
		//}
	}
}

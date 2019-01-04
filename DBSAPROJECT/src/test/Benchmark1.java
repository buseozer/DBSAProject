package test;

import java.io.IOException;

public class Benchmark1 {
	public static void main(String[] args) throws IOException {

		long startTime = System.nanoTime();

		// method
		System.out.println("H1234264540!#!%&/");

		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		// nanoseconds
		System.out.println(duration + " nanoseconds");

		// seconds precision
		double seconds = (double) duration / 1000000000.0;
		System.out.println(seconds + " seconds");

		int[] kStreams = { 1, 5, 10, 15, 20, 25, 30 };
		String[] path = { "C:\\Users\\buse\\Desktop\\buse3.txt" };

		for (int k : kStreams) {

		}
	}
}

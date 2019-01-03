package src.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import src.main.QueueObject;
import src.main.StreamDriver;
import src.input.InputStreamAbs;
import src.output.OutputStreamAbs;

public class Merge {
	public String operationType;
	public String inputFile;
	public int bufferSize;
	public int methodType;
	public int fileTracker;
	public int availableMemory;
	public int numberOfd;

	public Merge(int bufferSize, int methodType, String operationType, int d) {
		this.bufferSize = bufferSize;
		this.methodType = methodType;
		this.operationType = operationType;
		availableMemory = bufferSize / 4;
		fileTracker = 1000000000;
		numberOfd = d;
	}

	public List<String> mergeFirstPhase(List<String> file) throws IOException {// sort classından gelecek

		while (file.size() != 1) {
			System.out.println("MergeFirstPhase, first file size  :" + file.size());
			List<String> newFiles = mergeFunc(file);
			return mergeFirstPhase(newFiles);
		}
		return file;
	}

	public List<String> mergeFunc(List<String> file) throws IOException {

		List<String> outList = new ArrayList<>();// return list
		List<String> passList = new ArrayList<>(); // take as many elements as d and call merge()
		int length = file.size();
		int counter = 0;
		int difference;
		while (counter != length) {
			difference = length - counter;
			if (difference >= (numberOfd)) {

				for (int i = 0; i < numberOfd; i++) {
					passList.add(file.get(counter));
					counter++;

				}

			} else if (difference < numberOfd) {
				for (int i = 0; i < difference; i++) {
					passList.add(file.get(counter));
					counter++;
				}
			}
			System.out.println("mergeFunc, now merger is called: passList: " + passList.size());
			String newPath = merger(passList, fileTracker);
			System.out.println("after merger file  :" + newPath);
			passList.clear();
			fileTracker++;
			outList.add(newPath);
		}

		return outList;
	}

	public String merger(List<String> passList, int fileNum) throws IOException {

		PriorityQueue<QueueObject> priorityList = new PriorityQueue<>(); // store data in the priority queue
		String[] myArr = new String[passList.size()];
		myArr = passList.toArray(myArr);
		int readValue;
		int output_length = 0;

		StreamDriver<Object> driver = new StreamDriver<>(passList.size(), methodType, bufferSize, operationType, myArr);

		if (driver.inputStreamList.size() > 0) {

			for (InputStreamAbs file : driver.inputStreamList) {
				file.open(); // open all files and read the first element and put in the priority list
				readValue = file.read();
				if (readValue == 1)
					continue;
				priorityList.add(new QueueObject(file, (int) readValue));
			}
		}
		OutputStreamAbs output = driver.createOutputType(fileNum); // pass fileNum
		output.create();

		while (!priorityList.isEmpty()) {
			QueueObject obj = priorityList.poll();// get the min value in the priority queue
			readValue = obj.value;// take the value of object
			output.write(readValue); // write it down in a output file
			readValue = obj.input.read();
			if (!obj.input.endOfStream()) {
				priorityList.add(new QueueObject(obj.input, (int) readValue));
			}
			output_length++;

		}

		for (InputStreamAbs file : driver.inputStreamList) {
			file.close();
		}
		output.close();
		return output.returnPath();

	}
	/*
	 * public void clearFile(String file) { File myFile = new File(file); boolean
	 * result = myFile.delete(); if (result)
	 * System.out.println("Successfully deleted"); else
	 * System.out.println("Not deleted");
	 * 
	 * }
	 */

}
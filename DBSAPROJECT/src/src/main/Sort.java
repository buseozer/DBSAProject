package src.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import src.input.InputStreamAbs;
import src.output.OutputStreamAbs;

public class Sort {

	String operationType;
	public String inputFile;
	public int bufferSize;
	public int methodType;

	public Sort(int methodType,int bufferSize,String operationType,String inputFile) {
		this.methodType=methodType;
		this.bufferSize=bufferSize;
		this.inputFile=inputFile;
		this.operationType=operationType;

	}

	public List<String> ExternalMainFunc() throws IOException {
		
		StreamDriver streamD = new StreamDriver(1,methodType, bufferSize,operationType,inputFile);
		//StreamDriver driver3 = new StreamDriver(1, 4, 4096,"RW","C:\\Users\\buse\\Desktop\\buse1.txt" );
		List<String> outputfiles=streamD.divideBigIntoFiles();
		return(sortThemAll(outputfiles));
		

	}

	public List<String> sortThemAll(List<String> listOfPath) throws IOException {
		
		List<String> outputfiles = new ArrayList<>();
		for (int i = 0; i < listOfPath.size(); i++) {
			
			String newPath=sort(listOfPath.get(i),i);// bu path de bu numarayla
			outputfiles.add(newPath);
		}
		return outputfiles;
	}

	public String sort(String path, int fileNum) throws IOException {// path for reading, fileNum for writing

		StreamDriver streamDriver = new StreamDriver<>(1, methodType, bufferSize,operationType, path);
		return (sortFileWithStream(streamDriver, path, fileNum));
	}

	// open, sort, write and return the path
	public String sortFileWithStream(StreamDriver streamdr, String path, int fileNum)
			throws FileNotFoundException, IOException {

		PriorityQueue<Integer> priorityList = new PriorityQueue<>();

		int cnt = 0;
		int value;
		InputStreamAbs firstFile = (InputStreamAbs) streamdr.inputStreamList.get(0);
		firstFile.open();
		while (cnt != (bufferSize / 4)) {
			value = firstFile.read();
			if (value == 1) {
				continue;
			}
			priorityList.add(value);
			cnt++;
		}
		firstFile.close();
		File file = new File(path);
		file.delete();
		OutputStreamAbs output = streamdr.createOutputType(fileNum);
		output.create();
		while (!priorityList.isEmpty()) {
			int writeValue = priorityList.poll();
			output.write(writeValue);
		}
		output.close();
		return output.returnPath();

	}
}

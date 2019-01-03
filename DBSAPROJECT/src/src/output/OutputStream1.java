package src.output;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import src.output.OutputStreamAbs;
import src.main.GenerateRandom;

public class OutputStream1 implements OutputStreamAbs {
	DataOutputStream dataOut;
	FileOutputStream fileOut;

	public String path;
	int counter;
	int benchmarkNumber;
	int fileSize;

	public OutputStream1(String path, int fileNum, int fileSize, int benchmarkNumber) throws FileNotFoundException {
		this.path = path + Integer.toString(fileNum) + ".txt";
		this.benchmarkNumber = benchmarkNumber;
		this.fileSize = fileSize;
		int counter = 0;
	}

	public void create() throws FileNotFoundException {
		fileOut = new FileOutputStream(path);
		dataOut = new DataOutputStream(fileOut);

	}

	public void write() throws IOException {
		dataOut.writeInt(GenerateRandom.generateRandomList());
		counter++;

	}

	public boolean isDone() {
		if (counter < fileSize * 262144)
			return false;
		else
			return true;
	}

	@Override
	public void write(int value) throws IOException {
		System.out.println("nothing");
	}

	@Override
	public void close() throws IOException {
		fileOut.close();
		dataOut.close();
	}

	@Override
	public String returnPath() {
		return path;
	}
}

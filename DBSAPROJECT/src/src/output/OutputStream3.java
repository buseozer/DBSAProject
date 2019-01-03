package src.output;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import src.main.GenerateRandom;

public class OutputStream3 implements OutputStreamAbs {
	DataOutputStream dataOut;
	BufferedOutputStream bufferedOut;
	FileOutputStream fileOut;

	public String path;
	int bufferSize;
	int counter;
	int benchmarkNumber;
	int fileSize;

	public OutputStream3(String path, int bufferSize, int fileNum, int fileSize, int benchmarkNumber)
			throws FileNotFoundException {
		this.path = path + Integer.toString(fileNum) + ".txt";
		this.bufferSize = bufferSize;
		this.benchmarkNumber = benchmarkNumber;
		this.fileSize = fileSize;
		int counter = 0;
	}

	@Override
	public void create() throws FileNotFoundException {

		fileOut = new FileOutputStream(path);
		bufferedOut = new BufferedOutputStream(fileOut, bufferSize);
		dataOut = new DataOutputStream(bufferedOut);

	}

	@Override
	public void write(int value) throws IOException {
		dataOut.writeInt(value);
		counter++;
	}

	@Override
	public void close() throws IOException {
		bufferedOut.flush();
		fileOut.close();
		dataOut.close();
		bufferedOut.close();
	}

	@Override
	public String returnPath() {
		return path;
	}

	@Override
	public void write() throws IOException {
		try {
			dataOut.writeInt(GenerateRandom.generateRandomList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter++;
	}



	@Override
	public boolean isDone() {
		if (counter <fileSize*262144)
			return false;
		else
			return true;
	}
	


}

package src.output;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import src.main.GenerateRandom;

public class OutputStream2 implements OutputStreamAbs {

	DataOutputStream dataOut;
	BufferedOutputStream bufferedOut;
	FileOutputStream fileOut;

	String path;
	int fileSize;
	int counter;
	int benchmarkNumber;

	public OutputStream2(String path, int fileNum, int fileSize, int benchmarkNumber) throws FileNotFoundException {
		this.path = path + Integer.toString(fileNum) + ".txt";
		this.benchmarkNumber = benchmarkNumber;
		this.fileSize = fileSize;
		int counter = 0;
	}

	public void create() throws FileNotFoundException {
		fileOut = new FileOutputStream(path);
		bufferedOut = new BufferedOutputStream(fileOut);
		dataOut = new DataOutputStream(bufferedOut);
	}

	public void write() {
		try {
			dataOut.writeInt(GenerateRandom.generateRandomList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter++;
	}

	public void write(int value) throws IOException {
		System.out.println("nothing");
	}

	public boolean isDone() {
		if (counter < fileSize*262144 )
			return false;
		else
			return true;
	}

	public void close() throws IOException {
		bufferedOut.flush();
		fileOut.close();
		dataOut.close();
	}

	@Override
	public String returnPath() {
		return path;
	}
}

package src.input;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStream3 implements InputStreamAbs {

	public FileInputStream fileInput;
	public BufferedInputStream bufferedInput;
	public DataInputStream dataInput;
	String path;
	int bufferSize;

	public InputStream3(String path, int bufferSize) {
		this.path = path;
		this.bufferSize = bufferSize;
	}

	@Override
	public void open() throws FileNotFoundException {
		fileInput = new FileInputStream(path);
		bufferedInput = new BufferedInputStream(fileInput, bufferSize);
		dataInput = new DataInputStream(bufferedInput);
	}

	@Override
	public int read() throws IOException {
		int value = 1;
		if (!endOfStream()) {
			value = dataInput.readInt();
			System.out.println(value);
		} else {
			close();
		}

		return value;
	}

	@Override
	public boolean endOfStream() throws IOException {
		if (dataInput.available() > 4)
			return false;
		else
			return true;
	}

	@Override
	public void close() throws IOException {
		fileInput.close();
		dataInput.close();
	}

	public String returnPath() {
		return path;
	}

}

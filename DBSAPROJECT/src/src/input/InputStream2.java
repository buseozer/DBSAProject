package src.input;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStream2 implements InputStreamAbs {

	FileInputStream fileInput;
	DataInputStream dataInput;
	BufferedInputStream bufferedInput;
	String path;

	public InputStream2(String path) {
		this.path = path;
	}

	@Override
	public void open() throws FileNotFoundException {
		fileInput = new FileInputStream(path);
		bufferedInput = new BufferedInputStream(fileInput);
		dataInput = new DataInputStream(bufferedInput);
	}

	@Override
	public int read() throws IOException {
		int value = dataInput.readInt();
		return value;
	}

	@Override
	public boolean endOfStream() throws IOException {
		if (dataInput.available() >= 4)
			return false;
		else
			return true;
	}

	@Override
	public void close() throws IOException {
		fileInput.close();
		dataInput.close();
	}

	@Override
	public String returnPath() {
		return path;
	}

}

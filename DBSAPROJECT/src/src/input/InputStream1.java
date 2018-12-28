package src.input;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStream1 implements InputStreamAbs {
	FileInputStream fileInput;
	DataInputStream dataInput;
	String path;

	public InputStream1(String path) {
		this.path = path;
	}

	@Override
	public void open() throws FileNotFoundException {

		fileInput = new FileInputStream(path);
		dataInput = new DataInputStream(fileInput);

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
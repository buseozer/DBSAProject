package src.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class InputStream4 implements InputStreamAbs {
	File file;
	FileChannel fileChannel;
	MappedByteBuffer buffer;

	String path;
	int bufferSize;
	int lenght;
	int currentPt;

	public InputStream4(String path, int bufferSize) {
		this.path = path;
		this.bufferSize = bufferSize;
		currentPt = 0;
	}

	@Override
	public void open() throws IOException {
		file = new File(path);
		fileChannel = new RandomAccessFile(file, "r").getChannel();
		buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, bufferSize);
		lenght = ((int) file.length()) / 4;
		buffer.load();
	}

	@Override
	public int read() throws IOException {
		int value = 1;

		if (!endOfStream()) {
			if (buffer.hasRemaining()) {
				value = buffer.getInt();
				// System.out.println(value);
				currentPt++;

			} else {
				buffer.clear();
				buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, currentPt * 4, bufferSize);

			}
		} else {
			close();

		}
		return value;

	}

	@Override
	public boolean endOfStream() throws IOException {
		if (lenght > currentPt)
			return false;
		else
			return true;
	}

	@Override
	public void close() throws IOException {
		buffer.clear();
		fileChannel.close();

	}

	@Override
	public String returnPath() {
		return path;
	}
}

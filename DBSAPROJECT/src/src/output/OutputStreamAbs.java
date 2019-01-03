package src.output;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OutputStreamAbs {
	
	public void create() throws FileNotFoundException, IOException;
	
	public void write() throws IOException;

	public void write(int value) throws IOException;

	public void close() throws IOException;

	public String returnPath();

	boolean isDone();

}

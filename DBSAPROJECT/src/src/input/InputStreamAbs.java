package src.input;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InputStreamAbs {
	
	public void open() throws FileNotFoundException, IOException;

	public int read() throws IOException;

	public boolean endOfStream() throws IOException;
	
	public void close() throws IOException;
	public String returnPath();


}

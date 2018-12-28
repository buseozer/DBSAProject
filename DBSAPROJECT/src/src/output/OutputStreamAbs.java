package src.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;



public interface OutputStreamAbs {
	//create, write, close()
	public void create() throws FileNotFoundException, IOException;
	public void write(int value) throws IOException;
	public void close() throws IOException;
	public String returnPath();
	public void write() throws IOException;
	boolean isDone();
	
	
}

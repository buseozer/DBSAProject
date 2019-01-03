package src.input;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InputStreamAbs {

	public void open() throws FileNotFoundException, IOException; //open a stream 

	public int read() throws IOException; // read an integer

	public boolean endOfStream() throws IOException; //check whether or not it is the end of stream

	public void close() throws IOException; // close a stream

	public String returnPath(); //return the current path

}

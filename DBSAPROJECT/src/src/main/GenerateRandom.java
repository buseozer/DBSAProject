package src.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandom {
  
public static int count=0;
	public static int generateRandomList() {
		
		Random ran = new Random();
		int randomNumber= (int) (Math.random() * Integer.MAX_VALUE);
		return randomNumber;
	}
}
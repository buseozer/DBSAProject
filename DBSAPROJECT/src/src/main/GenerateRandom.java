package src.main;

public class GenerateRandom {

	public static int count = 0;

	public static int generateRandomList() {// generate values between [MIN_INT_VAL, MAX_INT_VAL]
		
		int max_value = Integer.MAX_VALUE;
		int randomNumber = (int) ((Math.random() * max_value * 2) - max_value);

		return randomNumber;
	}
}
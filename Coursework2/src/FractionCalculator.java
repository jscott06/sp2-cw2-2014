import java.util.Scanner;

public class FractionCalculator {
	static Scanner input = new Scanner(System.in);
	final static String DELIMITER = " ";
	static String[] splittedString;
	
	public static void main(String[] args) {
			
		String input = getInput();
		FractionCalculator calc = new FractionCalculator();
		calc.splitBySpaces(input);
	}
	
	public static String getInput(){
		String i;
		System.out.println("Type in:");
		i = input.nextLine();
		return i;
	}

	public String[] splitBySpaces(String string) {
		splittedString = string.split(DELIMITER);
		return splittedString;
	}
}

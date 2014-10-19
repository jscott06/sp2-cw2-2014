import java.util.Scanner;

public class FractionCalculator {
	static Scanner input = new Scanner(System.in);
	final static String SPACE = " ";
	final static String SLASH = "/";
	static String[] splittedString;
	static FractionCalculator calc = new FractionCalculator();
	
	public static void main(String[] args) {
			
		String input = getInput();
		calc.splitBySpaces(input);
	}
	
	public static String getInput(){
		String i;
		System.out.println("Type in:");
		i = input.nextLine();
		return i;
	}
	
	public String[] split(String string, String delimitator) {
		splittedString = string.split(delimitator);
		return splittedString;
	}

	public String[] splitBySpaces(String string) {
		splittedString = split(string, SPACE);
		return splittedString;
	}
	public String[] splitBySlash(String string) {
		splittedString = split(string, SLASH);
		return splittedString;
	}

	public int[] toNumber(String[] stringArray) {
		int[] numberArray = new int[2];
		numberArray[0] = Integer.parseInt(stringArray[0]);
		numberArray[1] = Integer.parseInt(stringArray[1]);
		return numberArray;
	}

	public Fraction toFraction(int[] numberArray) {
		Fraction frac = new Fraction(numberArray[0], numberArray[1]);
		return frac;
	}

	public Object calculate(Fraction memory, String operation, Fraction fraction) {
		Fraction result = new Fraction(1, 1);
		switch (operation) {
        case "+":  
      	  	result = memory.add(fraction);
        	  break;
        case "-":  
        	result = memory.subtract(fraction);
        	  break;
		}
		return result;
	}	
}

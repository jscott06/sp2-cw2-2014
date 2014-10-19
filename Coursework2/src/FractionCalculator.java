import java.util.Scanner;

public class FractionCalculator {
	
	final static String SPACE = " ";
	final static String SLASH = "/";
	public String[] splittedString;
	public String operator = "not initialised";
	public Fraction memory;
	
	public static void main(String[] args) {
		
//		String input = getInput();
//		String input = "1/4 + 1/4 + 1/4";
//		splittedString = split(input, " ");
//		calc.readAndCalculate(splittedString);
//		System.out.println(calc.getMemory());
//		System.out.println("END");
//		String input2 = "1/5 + 1/5 + 1/5";
//		splittedString = split(input2, " ");
//		calc.readAndCalculate(splittedString);
//		System.out.println(getMemory());
		
	}
	
	public static String getInput(){
		Scanner scanner = new Scanner(System.in);
		String i;
		System.out.println("Type in:");
		i = scanner.nextLine();
		scanner.close();
		return i;
	}
	
	public String[] split(String string, String delimitator) {
		splittedString = string.split(delimitator);
		return splittedString;
	}

//	public String[] splitBySpaces(String string) {
////		System.out.println(string);
//		splittedString = split(string, SPACE);
//		return splittedString;
//	}
//	public String[] splitBySlash(String string) {
//		splittedString = split(string, SLASH);
//		return splittedString;
//	}

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

	public Fraction calculate(Fraction memory, String operation, Fraction fraction) {
		Fraction result = new Fraction(1, 1);
		switch (operation) {
        case "+":  
      	  	result = memory.add(fraction);
        	break;
        case "-":  
        	result = memory.subtract(fraction);
        	break;
        case "*":  
        	result = memory.multiply(fraction);
        	break;
        case "/":  
        	result = memory.divide(fraction);
        	break;
		}
		return result;
	}

	public Fraction operateOnMemory(Fraction memory, String operation) {
		Fraction result = new Fraction(1, 1);
		switch (operation) {
        case "abs":  
      	  	result = memory.abs();
        	break;
        case "negate":  
        	result = memory.negate();
        	break;
		}
		return result;
	}
	
	public void setOperator(String operator){
		this.operator = operator;
	}
	
	public String getOperator(){
		return operator;
	}
	
	public void setMemory(Fraction fraction){
		this.memory = fraction;
	}
	
	public Fraction getMemory(){
		return memory;
	}

	public void readAndCalculate(String[] input) {
		// add here do-while loop for keeping asking input using new operator values "continue" and "Q"
		for (String i : input) {
			switch (i) {
	        case "+":  
	      	  	setOperator("+");
	        	break;
	        case "-":  
	        	setOperator("-");
	        	break;
	        case "*":  
	        	setOperator("*");
	        	break;
	        case "/":  
	        	setOperator("/"); // refactor
	        	break;
	        default: 
	        	String[] stringNumAndDen = split(i, "/");
	        	int[] numAndDen = toNumber(stringNumAndDen);
	        	Fraction f = toFraction(numAndDen); // refactor
	        	if (getOperator() == "not initialised") {
	            	setMemory(f);
	            	setOperator("");
	            	System.out.println("HERERERERERER");
	        	} else {
		        	setMemory(calculate(getMemory(), getOperator(), f));
	        	}
	        	break;
			}
			System.out.print("Input");
			System.out.println(i);
			System.out.print("Memory:");
			System.out.println(getMemory());
		}
	}

}

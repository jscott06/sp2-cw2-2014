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

	public int[] toNumber(String[] stringArray) {
		int[] numberArray = new int[2];
		
		numberArray[0] = Integer.parseInt(stringArray[0]);
		if (stringArray.length == 1) {
			numberArray[1] = 1;
		} else {
			numberArray[1] = Integer.parseInt(stringArray[1]);
		}
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

	public void operateOnMemory(String operation) {
		switch (operation) {
        case "abs":  
        case "A":
        case "a":
        	setMemory(getMemory().abs());
        	break;
        case "neg":  
        case "N":
        case "n":
        	setMemory(getMemory().negate());
        	break;
        case "clear":  
        case "C":
        case "c":
        	setMemory(clear());
        	break;
		}
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
	
	public Fraction clear(){
		return new Fraction(0);
	}

	public void readAndCalculate(String[] input) {
		// add here do-while loop for keeping asking input using new operator values "continue" and "Q"
		for (String i : input) {
			switch (i) {
	        case "+": // no break
	        case "-":
	        case "*":
	        case "/":
	        	setOperator(i);
	        	break;
	        case "neg": // no break
	        case "N":
	        case "n":
	        case "abs":
	        case "a":
	        case "A":
	        case "clear":  
	        case "C":
	        case "c":
	        	operateOnMemory(i);
	        	break;
	        default: 
	        	String[] stringNumAndDen = split(i, "/");
	        	int[] numAndDen = toNumber(stringNumAndDen);
	        	Fraction f = toFraction(numAndDen); // refactor
	        	if (getOperator() == "not initialised") {
	            	setMemory(f);
	            	setOperator("");
	        	} else {
		        	setMemory(calculate(getMemory(), getOperator(), f));
	        	}
	        	break;
			}
//			System.out.print("Input");
//			System.out.println(i);
//			System.out.print("Memory:");
//			System.out.println(getMemory());
		}
	}

}

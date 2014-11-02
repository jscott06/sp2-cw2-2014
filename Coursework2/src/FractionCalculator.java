import java.util.Scanner;

public class FractionCalculator {
	
	final static String SPACE = " ";
	final static String SLASH = "/";
	public static String[] splittedString;
	public String operator = "not initialised";
	public Fraction memory;
	public static Fraction ZERO = new Fraction(0);
	
	public static void main(String[] args) {
		
		FractionCalculator calc = new FractionCalculator();
		// Set value to Zero
		calc.setMemory(ZERO);
		// Welcome Message
		System.out.println("Welcome, you are using Jacopo Scotti's calculator");
		
		// add here do-while loop for keeping asking input using new operator values "continue" and "Q"
		String input = getInput();
		
		splittedString = split(input, " ");
		calc.readAndCalculate(splittedString);		
		System.out.println("Final result: " + calc.getMemory());

		// TODO
		// - Allow multi line input with loop and break character
		// - Wrap everything (Input, Read input, Split input, Calculate, Return Total and ask input in a single method
		// - Create a printing method that returns what to print (Testable)
		// - if there is already an operator saved on memory raise exception and quit (ie 1 + + 1 not allowed)
		
		// remaining main method requisites
		/*
		5. If any kind of exception occurs (except the end of input), print the word "Error",
		reset the calculator to its initial state, and discard the remainder of the input line,
		6. For an end of input exception just print the word "Goodbye" and exit the program.
		*/
	}
	
	public static String getInput(){
		Scanner scanner = new Scanner(System.in);
		String i;
		System.out.println("Type in:");
		i = scanner.nextLine();
		scanner.close();
		return i;
	}
	
	public static String[] split(String string, String delimitator) {
		return string.split(delimitator);
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
		Fraction f = new Fraction(numberArray[0], numberArray[1]);
		return f;
	}

	public void calculate(Fraction memory, String operation, Fraction fraction) {
		switch (operation) {
        case "+":  
      	  	setMemory(memory.add(fraction));
        	break;
        case "-":  
        	setMemory(memory.subtract(fraction));
        	break;
        case "*":  
        	setMemory(memory.multiply(fraction));
        	break;
        case "/":  
        	setMemory(memory.divide(fraction));
        	break;
		}
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
		return ZERO;
	}
	
	public Fraction inputToFraction(String stringFraction){
		String[] stringNumAndDen = split(stringFraction, "/");
    	int[] numAndDen = toNumber(stringNumAndDen);
    	Fraction f = toFraction(numAndDen); // refactor
		return f;
	}
	
	public void initialiseOrOperateOnMemory(String input){
		if (getOperator() == "not initialised") {
        	setMemory(inputToFraction(input));
        	setOperator("");
    	} else {
        	calculate(getMemory(), getOperator(), inputToFraction(input));
    	}
	}

	public void readAndCalculate(String[] inputLine) {
		for (String element : inputLine) {
			
			if (element.matches("[-*/+]{1}")){
				// I learnt how to use regular expressions here: http://www.regexr.com/
				// all the operations
				setOperator(element);
			} else if (element.matches("((neg)|(N)|(abs)|(a)|(A)|(clear)|(C)|(c)){1}")) {
				// all the functions
				operateOnMemory(element);
			} else if (element.matches("(-{0,1}[0-9]+\\/{1}-{0,1}[1-9]+)|(-{0,1}[0-9]+)")) {
				// every fraction negative or positive with denominator!= 0 + whole numbers
	        	initialiseOrOperateOnMemory(element);
			} else if (element.matches("((q)|(Q)|(quit)){1}")) {
				// Raise an exception
				System.out.println("You decided to quit"); 
				// TODO this needs to quit the calculator and stop to ask user input
			} else {
				// Stop processing any remaining input, set the value in the calculator to zero,
				// and raise an exception
				setMemory(ZERO);
				System.out.println("Error");
				break;
			}
		}
		//print the final result of calculating the input line
		System.out.println("Result at the end of the line: " + getMemory());
	}
}

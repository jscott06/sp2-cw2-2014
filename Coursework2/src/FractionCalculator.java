import java.util.Scanner;

public class FractionCalculator {
	
	final static String SPACE = " ";
	final static String SLASH = "/";
	public static String[] splittedString;
	public String operator = "not initialised";
	public Fraction memory;
	public static Fraction ZERO = new Fraction(0);
	public static Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		FractionCalculator calc = new FractionCalculator();
		calc.setMemory(ZERO); // Set value to Zero

		calc.requestUserInput();
		// TODO
		// - Wrap everything (Input, Read input, Split input, Calculate, Return Total and ask input in a single method
		// remaining main method requisites
		/*
		6. For an end of input exception just print the word "Goodbye" and exit the program.
		*/ // DO NOT PRINT TOTAL IF QUITTING FOR AN ERROR
	}
	
	public static String getInput(){
		String i;
		System.out.println("Type in:");
		i = scanner.nextLine();
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
		setOperator("");
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
		setOperator("");
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
    	} else {
        	calculate(getMemory(), getOperator(), inputToFraction(input));
    	}
		setOperator("");
	}

	public void readAndCalculate(String[] inputLine) {
		for (String element : inputLine) {
			// I learnt how to use regular expressions here: http://www.regexr.com/
			if (getOperator() != "" && (element.matches("([-*/+]){1}"))) {
				// do not allow the input of more than 1 operator in sequence
				setMemory(ZERO);
				System.out.println("Error");
				break;
			} else if (element.matches("[-*/+]{1}")) {
				// all the operations
				setOperator(element);
			} else if (element.matches("((neg)|(N)|(abs)|(a)|(A)|(clear)|(C)|(c)){1}")) {
				// all the functions
				operateOnMemory(element);
			}else if (element.matches("(-{0,1}[0-9]+\\/{1}-{0,1}[1-9]+)|(-{0,1}[0-9]+)")) {
				// every fraction negative or positive with denominator!= 0 + whole numbers
	        	initialiseOrOperateOnMemory(element);
			} else if (element.matches("((q)|(Q)|(quit)){1}")) {
				// Raise an exception
				System.out.println("Goodbye"); 
				setOperator(element); 
				break;
			} else {
				// Stop processing any remaining input, set the value in the calculator to zero,
				// and raise an exception
				setMemory(ZERO);
				System.out.println("Error");
				setOperator("q"); 
				break;
			}
		}
		//print the final result of calculating the input line
		System.out.println("Result at the end of the line: " + getMemory());
	}
	
	public void requestUserInput(){ // TO TEST USER INPUT
		System.out.println("Welcome, you are using Jacopo Scotti's calculator");
		String input;

		while (!operator.matches("((q)|(Q)|(quit)){1}")){ // when operator is different from q keep asking user input
			input = getInput();
			splittedString = split(input, " ");
			readAndCalculate(splittedString);		
			System.out.println("result: " + getMemory());
		}
		scanner.close();
	}
}

import java.util.Scanner;

public class FractionCalculator {
	
	final static String SPACE = " ";
	final static String SLASH = "/";
	public static String[] splittedString;
	public String operator = "not initialised";
	public Fraction memory = new Fraction(0);
	
	public static void main(String[] args) {
		
		String input = getInput();
		splittedString = split(input, " ");
		FractionCalculator calc = new FractionCalculator();
		calc.readAndCalculate(splittedString);
		System.out.println(calc.getMemory());
		System.out.println("END");
		
		// TODO
		// - Allow multi line input with loop and break character
		// - Print total everytime memory is being 'touched'
		// - Wrap everything (Input, Read input, Split input, Calculate, Return Total and ask input in a single method
		
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
		Fraction frac = new Fraction(numberArray[0], numberArray[1]);
		return frac;
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
		return new Fraction(0);
	}

	public void readAndCalculate(String[] input) {
		// add here do-while loop for keeping asking input using new operator values "continue" and "Q"
		for (String i : input) {
			if (i.matches("[-*/+]{1}")){
				// all the operations
				setOperator(i);
			} else if (i.matches("((neg)|(N)|(abs)|(a)|(A)|(clear)|(C)|(c)){1}")) {
				// all the functions
				operateOnMemory(i);
			} else if (i.matches("(-{0,1}[0-9]+\\/{1}-{0,1}[1-9]+)|(-{0,1}[0-9]+)")) {
				// every fraction negative or positive with denominator!= 0 + whole numbers
				String[] stringNumAndDen = split(i, "/");
	        	int[] numAndDen = toNumber(stringNumAndDen);
	        	Fraction f = toFraction(numAndDen); // refactor
	        	if (getOperator() == "not initialised") {
	            	setMemory(f);
	            	setOperator("");
	        	} else {
		        	calculate(getMemory(), getOperator(), f);
	        	}
			} else {
				System.out.println("Unexpected input");
				break;
			}
//			System.out.print("Input");
//			System.out.println(i);
//			System.out.print("Memory:");
//			System.out.println(getMemory());
		}
	}

}

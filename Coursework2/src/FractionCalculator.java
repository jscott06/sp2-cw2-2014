import java.util.Scanner;

public class FractionCalculator {
	final static String SPACE = " ";
	final static String SLASH = "/";
	final static String EMPTY = "";
	final static String NOT_INITIALISED = "not initialised";
	final static String ERROR = "Error";
	final static String GOODBYE = "Goodbye";
	final static String WELCOME_MESSAGE = "Welcome, you are using Jacopo Scotti's calculator."
										+ "\nRemember to separate every element with a space.";
	final static String ASK_INPUT = "Type in:";
	final static String HOW_TO_QUIT = "Type 'Q', 'q' or 'quit' for quitting";
	final static String RESULT = "Result: ";
	final static Fraction FRACTION_ZERO = new Fraction(0);
	final static int ZERO = 0;
	final static int ONE = 1;
	
	private static String[] splittedString;
	private static String input;
	private static Scanner scanner = new Scanner(System.in);
	private String operator = NOT_INITIALISED;
	private Fraction memory;
	
	public static void main(String[] args) {
		
		FractionCalculator calc = new FractionCalculator();
		calc.setMemory(FRACTION_ZERO); // Set value to Zero
		calc.requestUserInput();
	}
	
	public void requestUserInput(){
		print(WELCOME_MESSAGE);
		print(HOW_TO_QUIT);
		// when operator is different from q keep asking user input
		while (!isQuitException(getOperator())){
			input = getInput();
			splittedString = split(input, SPACE);			
			readAndCalculate(splittedString);
			if (getOperator() != ERROR) {
				print(RESULT + getMemory());
				print(HOW_TO_QUIT);
			}
		}
		scanner.close();
	}
	
	public void readAndCalculate(String[] inputLine) {
		if (isNumberOrFraction(inputLine[ZERO])) {
			setMemory(FRACTION_ZERO);
			setOperator(NOT_INITIALISED);
		}
		for (String element : inputLine) {
			
			if (!isEmpty(getOperator()) && (isMathOperator(element))) {
				// do not allow the input of more than 1 operator in sequence
				setMemory(FRACTION_ZERO);
				print(ERROR);
				break;
			} else if (isMathOperator(element)) {
				setOperator(element);
			} else if (isFunction(element)) {
				operateOnMemory(element);
			} else if (isNumberOrFraction(element)) {
	        	initialiseOrOperateOnMemory(element);
			} else if (isQuit(element)) {
				print(GOODBYE); 
				setOperator(element); 
				break;
			} else {
				// Stop processing any remaining input, set the value in the calculator to zero,
				// and raise an exception
				setMemory(FRACTION_ZERO);
				print(ERROR);
				setOperator(ERROR); 
				break;
			}
		}
		// Removes last operator from memory 
		ignoreLastOperation(inputLine[inputLine.length - ONE]);
	}
	
	public static void print(String toPrint){
		System.out.println(toPrint);
	}
	public static String getInput(){ 
		// Asks user input and returns it
		String i;
		print(ASK_INPUT);
		i = scanner.nextLine();
		return i;
	}
	
	public static String[] split(String string, String delimitator) {
		// Splits string by delimitator and returns it
		return string.split(delimitator);
	}

	public int[] toNumber(String[] stringArray) {
		int[] numberArray = new int[2];
		numberArray[ZERO] = Integer.parseInt(stringArray[ZERO]);
		
		if (stringArray.length == ONE) { 
		// If stringArray is an integer assigns 1 to denom
			numberArray[ONE] = ONE;
		} else {
			numberArray[ONE] = Integer.parseInt(stringArray[ONE]);
		}
		return numberArray;
	}

	public Fraction toFraction(int[] numberArray) {
		// Creates a fraction using the 2 int elements of numberArray
		Fraction f = new Fraction(numberArray[ZERO], numberArray[ONE]);
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
		clearOperator();
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
		clearOperator();
	}
	
	public void clearOperator(){
		setOperator(EMPTY);
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
		return FRACTION_ZERO;
	}
	
	public Fraction inputToFraction(String stringFraction){
		String[] stringNumAndDen = split(stringFraction, SLASH);
    	int[] numAndDen = toNumber(stringNumAndDen);
    	Fraction f = toFraction(numAndDen); 
		return f;
	}
	
	public void initialiseOrOperateOnMemory(String input){
		if (getOperator() == NOT_INITIALISED) {
			// If first element of the array, assigns it to memory
        	setMemory(inputToFraction(input));
    	} else {
    		// Calls the calculate method with fraction1-OPERATOR-fraction2
        	calculate(getMemory(), getOperator(), inputToFraction(input));
    	}
		clearOperator();
	}
	
	// I learnt how to use regular expressions here: http://www.regexr.com/
	private boolean isMathOperator(String i){
		// Checks if string is one of the Math Operators
		if (i.matches("[-*/+]{1}")) return true;
		return false;
	}
	private boolean isFunction(String i){
		// Checks if string is one of the Functions
		if (i.matches("((n)|(neg)|(N)|(abs)|(a)|(A)|(clear)|(C)|(c)){1}")) return true;
		return false;
	}
	private boolean isNumberOrFraction(String i){
		// Every fraction negative or positive with denominator!= 0 + whole numbers
		if (i.matches("(-{0,1}[0-9]+\\/{1}-{0,1}[1-9]+)|(-{0,1}[0-9]+)")) return true;
		return false;
	}
	private boolean isQuit(String i){
		// Checks if string is Quit and raises an exception
		if (i.matches("((q)|(Q)|(quit)){1}")) return true;
		return false;
	}
	private boolean isEmpty(String i){
		// Checks if string is empty string
		 if (i == EMPTY) return true;
		 return false;
	}

	private boolean isQuitException(String i){
		if (i.matches("((q)|(Q)|(quit)|(Error)){1}")) return true;
		return false;
	}
	
	private void ignoreLastOperation(String element){
		// Clears the operator memory if last element in User input was an operator 
		if (isMathOperator(element)) clearOperator();
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionCalculatorTest {
	
	FractionCalculator calc = new FractionCalculator();
    
    @Test
	public void splitBySpace() {
    	String[] testArray = calc.split("Jacopo Scotti SP2 Coursework2", " ");
    	String[] checkArray = {"Jacopo", "Scotti", "SP2", "Coursework2"};
    	assertArrayEquals(checkArray, testArray);
	}
    
    @Test
    public void splitBySlash() {
    	String[] testArray = calc.split("1/3", "/");
    	String[] checkArray = {"1", "3"};
    	assertArrayEquals(checkArray, testArray);
	}
    
    @Test
    public void toNumber(){
    	String[] numAndDenom = {"1", "3"};
    	int[] testArray = calc.toNumber(numAndDenom);
    	int[] checkArray = {1, 3};
    	assertArrayEquals(checkArray, testArray);
    }
    
    @Test
    public void toFraction(){
    	int[] numAndDenom = {1, 3};
    	Fraction testFraction = calc.toFraction(numAndDenom);
    	Fraction checkFraction = new Fraction(1, 3);
    	assertEquals(true, checkFraction.equals(testFraction));
    }
    
    @Test
    public void calculate(){
    	Fraction memory = new Fraction(1, 2);
    	String operation = "+";
    	Fraction fraction = new Fraction(1, 3);
    	assertEquals(new Fraction(5, 6), calc.calculate(memory, operation, fraction));
    	
    	memory = new Fraction(5, 6);
    	operation = "-";
    	fraction = new Fraction(1, 6);
    	assertEquals(new Fraction(2, 3), calc.calculate(memory, operation, fraction));
    	
    	memory = new Fraction(2, 3);
    	operation = "*";
    	fraction = new Fraction(2, 1);
    	assertEquals(new Fraction(4, 3), calc.calculate(memory, operation, fraction));
    	
    	memory = new Fraction(4, 3);
    	operation = "/";
    	fraction = new Fraction(1, 2);
    	assertEquals(new Fraction(8, 3), calc.calculate(memory, operation, fraction));
    }
    
    @Test
    public void operateOnMemory(){
    	calc.setMemory(new Fraction(1, -2));
    	String operation = "abs";
    	calc.operateOnMemory(operation);
    	assertEquals(new Fraction(1, 2), calc.getMemory());
    	
    	calc.setMemory(new Fraction(1, 2));
    	operation = "neg";
    	calc.operateOnMemory(operation);
    	assertEquals(new Fraction(-1, 2), calc.getMemory());
    }
    
    @Test
    public void readAndCalculate1(){
    	//1 fraction
    	FractionCalculator calc1 = new FractionCalculator();
    	String[] input = {"1/2"};
    	calc1.readAndCalculate(input);
    	assertEquals(new Fraction(1, 2), calc1.getMemory());
    	
    	//Add 2 fractions
    	FractionCalculator calc2 = new FractionCalculator();
    	String[] input2 = {"1/2", "+", "1/3"};
    	calc2.readAndCalculate(input2);
    	assertEquals(new Fraction(5, 6), calc2.getMemory());
    	
    	//Negate
    	FractionCalculator calc3 = new FractionCalculator();
    	String[] input3 = {"1/2", "+", "1/3", "neg"};
    	calc3.readAndCalculate(input3);
    	assertEquals(new Fraction(-5, 6), calc3.getMemory());
    	
    	//Absolute value
    	FractionCalculator calc4 = new FractionCalculator();
    	String[] input4 = {"-1/2", "+", "-1/3", "abs"};
    	calc4.readAndCalculate(input4);
    	assertEquals(new Fraction(5, 6), calc4.getMemory());
    	
    	// Allow integers
    	FractionCalculator calc5 = new FractionCalculator();
    	String[] input5 = {"1/2", "+", "1"};
    	calc5.readAndCalculate(input5);
    	assertEquals(new Fraction(3, 2), calc5.getMemory());
    	
    	// Use clear function
    	FractionCalculator calc6 = new FractionCalculator();
    	String[] input6 = {"1/2", "+", "1", "C"};
    	calc6.readAndCalculate(input6);
    	assertEquals(new Fraction(0,5), calc6.getMemory());
    	assertEquals(new Fraction(0), calc6.getMemory());
    }
}

import static org.junit.Assert.*;
import org.junit.Test;

public class FractionCalculatorTest {
	
	FractionCalculator calc = new FractionCalculator();
    
    @Test
	public void splitBySpaces() {
    	String[] testArray = calc.splitBySpaces("Jacopo Scotti SP2 Coursework2");
    	String[] checkArray = {"Jacopo", "Scotti", "SP2", "Coursework2"};
    	assertArrayEquals(checkArray, testArray);
	}
    
    @Test
    public void splitBySlash() {
    	String[] testArray = calc.splitBySlash("1/3");
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
    	Fraction memory = new Fraction(1, -2);
    	String operation = "abs";
    	assertEquals(new Fraction(1, 2), calc.operateOnMemory(memory, operation));
    	
    	memory = new Fraction(1, 2);
    	operation = "negate";
    	assertEquals(new Fraction(-1, 2), calc.operateOnMemory(memory, operation));
    }
    
    @Test
    public void readAndCalculate(){
    	String input = "1/2 + 1/3";
    	assertEquals(new Fraction(5, 6), calc.readAndCalculate(input));
    }
}

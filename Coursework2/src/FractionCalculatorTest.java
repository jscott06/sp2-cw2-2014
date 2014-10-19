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

}

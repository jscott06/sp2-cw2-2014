import static org.junit.Assert.*;
import org.junit.Test;

public class FractionCalculatorTest {
    
    @Test
	public void splitBySpaces() {
    	FractionCalculator calc = new FractionCalculator();
    	String[] testArray = calc.splitBySpaces("Jacopo Scotti SP2 Coursework2");
    	String[] checkArray = {"Jacopo", "Scotti", "SP2", "Coursework2"};
    	assertArrayEquals(checkArray, testArray);
	}
    
    public void extractNumAndDenom() {
    	FractionCalculator calc = new FractionCalculator();
    	int[] testArray = calc.extractNumAndDenom("1/3");
    	int[] checkArray = {1,3};
    	assertArrayEquals(checkArray, testArray);
    	// to test negative numbers
    }
}

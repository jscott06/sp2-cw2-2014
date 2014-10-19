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
}

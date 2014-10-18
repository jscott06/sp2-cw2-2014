/**
 * Created by keith for the second coursework assignment.
 *
 * You need to recode this as a series of JUnit tests
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {
//    public static void main(String[] args) {
//
//        // test divide by zero - should print an error and exit
//        new Fraction(1, 0);
//
//        // extend with extra tests
//        assertEquals("Wrong answer!", new Fraction(1, 0));
//    }
    
    @Test
	public void divideByZero() {
    	assertEquals(new Fraction(1, 0), new Fraction(1, 0));
	}
    
    @Test
   	public void equals() {
       	assertEquals(new Fraction(1, 2), new Fraction(1, 2));
       	assertEquals(new Fraction(1, 2), new Fraction(3, 6));
       	assertEquals(new Fraction(-1, 2), new Fraction(1, -2));
       	assertEquals(new Fraction(-1, -2), new Fraction(1, 2));
   	}
    
    @Test
   	public void multiply() {
    	assertEquals(new Fraction(1, 4), new Fraction(1, 2).multiply(new Fraction(1, 2)));
    	assertEquals(new Fraction(3, 10), new Fraction(1, 2).multiply(new Fraction(3, 5)));
   	}

}

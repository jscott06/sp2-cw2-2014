/**
 * Created by keith for the second coursework assignment.
 *
 * You need to recode this as a series of JUnit tests
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {
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
    	assertEquals(new Fraction(-3, 10), new Fraction(1, 2).multiply(new Fraction(-3, 5)));
    	assertEquals(new Fraction(4, 3), new Fraction(2, 1).multiply(new Fraction(2, 3)));
    }
    
    @Test
    public void add() {
    	assertEquals(new Fraction(7, 10), new Fraction(1, 2).add(new Fraction(1, 5)));
    	assertEquals(new Fraction(11, 12), new Fraction(2, 3).add(new Fraction(1, 4)));
    	assertEquals(new Fraction(2, 3), new Fraction(-2, 3).add(new Fraction(4, 3)));
   	}
    
    @Test
    public void subtract() {
    	assertEquals(new Fraction(2, 15), new Fraction(1, 3).subtract(new Fraction(1, 5)));
    	assertEquals(new Fraction(1, 63), new Fraction(4, 7).subtract(new Fraction(5, 9)));
    	assertEquals(new Fraction(2, 7), new Fraction(-1, 7).subtract(new Fraction(-3, 7)));
   	}
    
    @Test
    public void absoluteValue() {
    	assertEquals(new Fraction(1, 2), new Fraction(-1, 2).abs());
    	assertEquals(new Fraction(1, 29), new Fraction(1, -29).abs());
    	assertEquals(new Fraction(5, 2), new Fraction(-5, 2).abs());
   	}
    
    @Test
    public void divide() {
    	assertEquals(new Fraction(5, 6), new Fraction(1, 6).divide(new Fraction(1, 5)));
    	assertEquals(new Fraction(6, 7), new Fraction(3, 7).divide(new Fraction(1, 2)));
    	assertEquals(new Fraction(-6, 7), new Fraction(-3, 7).divide(new Fraction(1, 2)));
   	}
    
    @Test
    public void negate() {
    	assertEquals(new Fraction(1, 2), new Fraction(-1, 2).negate());
    	assertEquals(new Fraction(-1, 29), new Fraction(1, 29).negate());
    	assertEquals(new Fraction(-5, 2), new Fraction(5, 2).negate());
   	}
    
    @Test
    public void print(){
    	Fraction f1 = new Fraction(1,2);
    	assertEquals("1/2", f1.toString());
    	Fraction f2 = new Fraction(5,-9);
    	assertEquals("5/-9", f2.toString());
    	Fraction f = new Fraction(3,1);
    	assertEquals("3/1", f.toString());
    }

}

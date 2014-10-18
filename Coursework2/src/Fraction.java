/**
 * Created by keith for the second coursework assignment.
 */
import static java.lang.Math.*;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
        return "" + getNumerator() + '/' + getDenominator();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction frac) {
        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction add(Fraction frac) {
    	int lcm = myLcm(getDenominator(), frac.getDenominator());
    	int num1 = (this.getNumerator() * (lcm / this.getDenominator()));
    	int num2 = (frac.getNumerator() * (lcm / frac.getDenominator()));
        int num = num1 + num2;
        int denom = lcm;
        return new Fraction(num, denom);
    }
    
    public Fraction subtract(Fraction frac) {
    	int lcm = myLcm(getDenominator(), frac.getDenominator());
    	int num1 = (this.getNumerator() * (lcm / this.getDenominator()));
    	int num2 = (frac.getNumerator() * (lcm / frac.getDenominator()));
        int num = num1 - num2;
        int denom = lcm;
        return new Fraction(num, denom);
    }
    
    public Fraction abs() {
    	int num = Math.abs(this.getNumerator());
        int denom = Math.abs(this.getDenominator());
        return new Fraction(num, denom);
    }
    
    public Fraction divide(Fraction frac) {
        int num = this.getNumerator() * frac.getDenominator();
        int denom = this.getDenominator() * frac.getNumerator();
        return new Fraction(num, denom);
    }
    
    public Fraction negate() {
    	int num = - this.getNumerator();
        int denom = this.getDenominator();
        return new Fraction(num, denom);
    }
    
    private int myLcm(int denumA, int denumB) {
        int a = denumA * denumB;
        return a;
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}

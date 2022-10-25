package lab3;
/**
 * This public class extends from the super class Special Number and implements the comparable function.
 * This class has methods that can find the sum and the division of Rational Numbers.In addition, it implements
 * the hashCode, equals and compareTo method.
 * @author mohammadal-qassim
 * @version 1.0
 * */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber> {
	int numerator, denominator;
	public RationalNumber(int num, int den) throws Lab3Exception{
		if (den == 0) {
			throw new Lab3Exception("Denominator cannot be zero");
		}
		numerator = num;
		denominator = den;

	}

	public  SpecialNumber add (SpecialNumber N) throws Lab3Exception {
		if(!(N instanceof RationalNumber)) {
			throw new Lab3Exception("Cannot add an incompatible type");
		}
		RationalNumber rn = (RationalNumber)N;
		int up,down;
		if (denominator == rn.denominator) {
			up = rn.numerator+numerator;
			down = rn.denominator;
		}
		else {
			up = (denominator * rn.numerator)+(numerator*rn.denominator);
			down = denominator * rn.denominator;
		}
		RationalNumber a = new RationalNumber(up,down);
		return a;
	}

	public SpecialNumber divideByInt(int N) throws Lab3Exception{
		if (N == 0) {
			throw new Lab3Exception("Cannot divide by zero");
		}
		RationalNumber a = new RationalNumber(numerator,denominator*N);
		return a;
	}

	@Override
	public int hashCode() {
		return (int)((double)numerator/(double)denominator);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RationalNumber other = (RationalNumber) obj;
		double d1 = (double)numerator/(double)denominator;
		double d2 = (double)other.numerator/(double)other.denominator;
		return d1==d2;
	}

	@Override
	public int compareTo(RationalNumber other) {
		double d1 = (double)numerator/(double)denominator;
		double d2 = (double)other.numerator/(double)other.denominator;
		if(d1<d2) {
			return -1;
		}
		else if (d1==d2) {
			return 0;
		}
		return 1;
	}


}

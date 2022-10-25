package lab3;

import java.util.Objects;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber> {
	double real, imaginary;

	public ComplexNumber(double real, double imaginary) {
		this.real= real;
		this.imaginary = imaginary;
	}

	public SpecialNumber add(SpecialNumber a) throws Lab3Exception {
		if(!(a instanceof ComplexNumber)) {
			throw new Lab3Exception("Cannot add an incompatible type");
		}

		ComplexNumber cn = (ComplexNumber)a;
		double r, i;
		r = real+cn.real;
		i = imaginary+cn.imaginary;

		ComplexNumber t = new ComplexNumber(r,i);
		return t;
	}



	public SpecialNumber divideByInt(int N) throws Lab3Exception {
		if (N==0) {
			throw new Lab3Exception("Cannot Divide by zero");
		}
		ComplexNumber a = new ComplexNumber(real/N,imaginary/N);
		return a;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(imaginary, real);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexNumber other = (ComplexNumber) obj;
		return Double.doubleToLongBits(imaginary) == Double.doubleToLongBits(other.imaginary)
				&& Double.doubleToLongBits(real) == Double.doubleToLongBits(other.real);
	}

	@Override
	public int compareTo(ComplexNumber other) {
		double d1,d2;
		d1 = Math.sqrt(Math.pow(real,2)+Math.pow(imaginary,2));
		d2 = Math.sqrt(Math.pow(other.real,2)+Math.pow(other.imaginary,2));
		if(d1<d2) {
			return -1;
		}
		else if (d1==d2) {
			return 0;
		}
		return 1;
	}

	
}

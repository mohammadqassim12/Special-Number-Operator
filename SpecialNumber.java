package lab3;

import java.util.*;

public abstract class SpecialNumber {

	public abstract SpecialNumber add (SpecialNumber N) throws Lab3Exception;

	public abstract SpecialNumber divideByInt(int N) throws Lab3Exception;
	/**
	 * This static method computes the average of elements while implementing the methods add and divideByInt.
	 * @param a List of elements of type SpecialNumber.
	 * @return throws a Lab3Exception if the input parameter is null, otherwise, returns the average of the
	 * elements in the input parameter by adding them and diving them by the length of the list with by calling
	 * methods add and divideByInt.
	 * */
	public static SpecialNumber computeAverage (List<SpecialNumber> N) throws Lab3Exception {
		if (N == null || N.isEmpty()){
			throw new Lab3Exception("List cannot be empty");
		}
		SpecialNumber total = N.get(0);		
		for(int i = 1; i < N.size(); i++) {
			total = total.add(N.get(i));
		}
		return total.divideByInt(N.size());

	}
}

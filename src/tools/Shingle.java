package tools;

import java.util.Set;
import java.util.HashSet;

/**
 * This class encapsulates several methods for generating and manipulating shingles
 * where a k-shingle is defined as all unique substrings of length k of string s 
 * @author Brandon LaRue
 */
public class Shingle {
	/**
	 * Generates an array of all k-shingles of string s
	 * @param k - A positive integer representing the length of each shingle
	 * @param s  - The string from which the shingles will be extracted
	 * @return A set containing all k-shingles of string s
	 * @throws IllegalArgumentException if k <= 0 or k > s.length or s is null
	 */
	public static Set<String> getShingles(int k, String s) throws IllegalArgumentException {
		if (s == null || k <= 0 || k > s.length()) {
			throw new IllegalArgumentException("0 <= k < s.length() and s must not be null");
		}
		
		int numShingles = s.length() - k + 1;
		Set<String> shingles = new HashSet<String>();
		
		for (int i = 0; i < numShingles; i++) {
			shingles.add(s.substring(i, i + k));
		}
		return shingles;
	}
}

package test;

import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import tools.Shingle;
import java.util.Set;

public class ShingleTest {
	@Test
	public void invalidArgementTest() {
		String s = "test";
		try {
			Shingle.getShingles(0, s);
			fail("Should have thrown IllegalArgumentException - k out of bounds");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
		
		try {
			Shingle.getShingles(s.length() + 1, s);
			fail("Should have thrown IllegalArgumentException - k out of bounds");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
		
		try {
			Shingle.getShingles(-1, s);
			fail("Should have thrown IllegalArgumentException - k out of bounds");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
		
		try {
			Shingle.getShingles(2, null);
			fail("Should have thrown IllegalArgumentException - s is null");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}
	
	@Test
	public void twoLetterShingleTest() {
		String s = "abcbab";
		String[] expected = {"ab", "bc", "cb", "ba"};
		
		Set<String> shingles = Shingle.getShingles(2, s);
		assertEquals("Did not produce the expected number of shingles", shingles.size(), expected.length);
		
		for (String e : expected) {
			assertTrue("Did not produce correct shingles", shingles.contains(e));
		}
	}
}

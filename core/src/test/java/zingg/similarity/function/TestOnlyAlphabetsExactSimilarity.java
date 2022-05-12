package zingg.similarity.function;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOnlyAlphabetsExactSimilarity {
	
	
	@Test
	public void testNotSameAlhpabets() {
		OnlyAlphabetsExactSimilarity sim = new OnlyAlphabetsExactSimilarity();
		double score = sim.call("I have 1 number", "I have no number");
		assertEquals(0d, score);
	}

	@Test
	public void testSameAlphabetsDiffNumbers() {
		OnlyAlphabetsExactSimilarity sim = new OnlyAlphabetsExactSimilarity();
		double score = sim.call("I have 1 number", "I have 3 number");
		assertEquals(1d, score);
	}
	
	@Test
	public void testSameNoNum() {
		OnlyAlphabetsExactSimilarity sim = new OnlyAlphabetsExactSimilarity();
		assertEquals(1d, sim.call("I have no number", "I have no number"));
	}

	@Test
	public void testDiffNoNumber() {
		OnlyAlphabetsExactSimilarity sim = new OnlyAlphabetsExactSimilarity();
		assertEquals(0d, sim.call("I have a no number", "I have r number"));
	}	

	@Test
	public void testSameIgnoreCase() {
		OnlyAlphabetsExactSimilarity sim = new OnlyAlphabetsExactSimilarity();
		assertEquals(1d, sim.call("I have 1 number", "I HAVE 2 number"));
	}
}

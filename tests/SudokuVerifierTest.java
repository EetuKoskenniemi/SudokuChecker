import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testValidSudokuString() {
		String validSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = v.verify(validSudoku);
		assertEquals("Valid Sudoku shoudl return 0", 0, result);
	}
	
	@Test
	public void testInputLengthBelow81() {
		String shortInput = "41736982563215894795872431682543716979";
		int result = v.verify(shortInput);
		assertEquals("Input length below 81 should return -1", -1, result);
	}
	
	@Test
	public void testInputLengthOver81() {
		String longInput = "4173698256321589479587243168254371697915864323469127582896435715732916841648752936236";
		int result = v.verify(longInput);
		assertEquals("Input length over 81 should return -1", -1, result);
	}
	
	@Test
	public void testInputDigitOutsideRange() {
		String outOfRangeDigits = "417369825032158947958724316825437169791586432346912758289643571573291684164875293";
		int result = v.verify(outOfRangeDigits);
		assertEquals("Input with digits outside the range should return -1", -1, result);
	}
	
	@Test
	public void testDuplicateInSubgrid() {
		String duplicateInSubgrid = "417369825642158937958724316825437169791586432346912758289643571573291684164875293";
		int result = v.verify(duplicateInSubgrid);
		assertEquals("Duplicate in sub-grid should return -2", -2, result);
	}
	
	
	@Test
	public void testDuplicateInRow() {
		String duplicateInRow = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		int result = v.verify(duplicateInRow);
		assertEquals("Duplicate in a row should return -3", -3, result);
	}
	
	@Test
	public void testDuplicateInColumn() {
		String duplicateInColumn = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		int result = v.verify(duplicateInColumn);
		assertEquals("Duplicate in a column should return -4", -4, result);
	}
}

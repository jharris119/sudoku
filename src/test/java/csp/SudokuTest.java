package csp;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SudokuTest {

    public Set<Sudoku.Candidate> puzzle9x9 = new HashSet<Sudoku.Candidate>() {{
        this.add(new Sudoku.Candidate(1,3,6));
        this.add(new Sudoku.Candidate(1,4,9));
        this.add(new Sudoku.Candidate(1,8,8));
        this.add(new Sudoku.Candidate(1,9,7));
        this.add(new Sudoku.Candidate(2,5,1));
        this.add(new Sudoku.Candidate(2,6,6));
        this.add(new Sudoku.Candidate(3,3,7));
        this.add(new Sudoku.Candidate(3,5,3));
        this.add(new Sudoku.Candidate(3,8,9));
        this.add(new Sudoku.Candidate(4,1,6));
        this.add(new Sudoku.Candidate(4,2,5));
        this.add(new Sudoku.Candidate(4,7,8));
        this.add(new Sudoku.Candidate(4,9,4));
        this.add(new Sudoku.Candidate(5,4,6));
        this.add(new Sudoku.Candidate(5,8,1));
        this.add(new Sudoku.Candidate(6,7,7));
        this.add(new Sudoku.Candidate(7,5,2));
        this.add(new Sudoku.Candidate(7,6,8));
        this.add(new Sudoku.Candidate(7,8,3));
        this.add(new Sudoku.Candidate(7,9,9));
        this.add(new Sudoku.Candidate(8,1,9));
        this.add(new Sudoku.Candidate(8,3,3));
        this.add(new Sudoku.Candidate(8,4,1));
        this.add(new Sudoku.Candidate(9,2,2));
        this.add(new Sudoku.Candidate(9,3,5));
    }};

    public Set<Sudoku.Candidate> puzzle16x16 = new HashSet<Sudoku.Candidate>() {{
        this.add(new Sudoku.Candidate(1,1,6));
        this.add(new Sudoku.Candidate(1,6,13));
        this.add(new Sudoku.Candidate(1,9,8));
        this.add(new Sudoku.Candidate(1,13,11));
        this.add(new Sudoku.Candidate(1,14,2));
        this.add(new Sudoku.Candidate(2,1,10));
        this.add(new Sudoku.Candidate(2,2,13));
        this.add(new Sudoku.Candidate(2,4,3));
        this.add(new Sudoku.Candidate(2,6,12));
        this.add(new Sudoku.Candidate(2,11,11));
        this.add(new Sudoku.Candidate(2,12,15));
        this.add(new Sudoku.Candidate(2,13,6));
        this.add(new Sudoku.Candidate(2,14,4));
        this.add(new Sudoku.Candidate(3,4,7));
        this.add(new Sudoku.Candidate(3,7,6));
        this.add(new Sudoku.Candidate(3,8,4));
        this.add(new Sudoku.Candidate(3,9,12));
        this.add(new Sudoku.Candidate(3,12,10));
        this.add(new Sudoku.Candidate(3,16,8));
        this.add(new Sudoku.Candidate(4,1,9));
        this.add(new Sudoku.Candidate(4,2,14));
        this.add(new Sudoku.Candidate(4,3,11));
        this.add(new Sudoku.Candidate(4,4,15));
        this.add(new Sudoku.Candidate(4,7,16));
        this.add(new Sudoku.Candidate(4,12,5));
        this.add(new Sudoku.Candidate(4,15,1));
        this.add(new Sudoku.Candidate(5,1,15));
        this.add(new Sudoku.Candidate(5,2,1));
        this.add(new Sudoku.Candidate(5,10,4));
        this.add(new Sudoku.Candidate(5,12,8));
        this.add(new Sudoku.Candidate(5,15,2));
        this.add(new Sudoku.Candidate(5,16,10));
        this.add(new Sudoku.Candidate(6,1,8));
        this.add(new Sudoku.Candidate(6,2,5));
        this.add(new Sudoku.Candidate(6,3,13));
        this.add(new Sudoku.Candidate(6,11,7));
        this.add(new Sudoku.Candidate(6,13,4));
        this.add(new Sudoku.Candidate(7,5,4));
        this.add(new Sudoku.Candidate(7,9,16));
        this.add(new Sudoku.Candidate(7,10,5));
        this.add(new Sudoku.Candidate(7,13,1));
        this.add(new Sudoku.Candidate(7,14,8));
        this.add(new Sudoku.Candidate(8,2,4));
        this.add(new Sudoku.Candidate(8,3,10));
        this.add(new Sudoku.Candidate(8,9,13));
        this.add(new Sudoku.Candidate(8,11,1));
        this.add(new Sudoku.Candidate(8,12,15));
        this.add(new Sudoku.Candidate(8,13,3));
        this.add(new Sudoku.Candidate(9,4,8));
        this.add(new Sudoku.Candidate(9,8,12));
        this.add(new Sudoku.Candidate(9,10,1));
        this.add(new Sudoku.Candidate(9,16,13));
        this.add(new Sudoku.Candidate(10,1,12));
        this.add(new Sudoku.Candidate(10,5,3));
        this.add(new Sudoku.Candidate(10,7,10));
        this.add(new Sudoku.Candidate(10,15,16));
        this.add(new Sudoku.Candidate(10,16,2));
        this.add(new Sudoku.Candidate(11,6,16));
        this.add(new Sudoku.Candidate(11,7,15));
        this.add(new Sudoku.Candidate(11,9,7));
        this.add(new Sudoku.Candidate(11,11,3));
        this.add(new Sudoku.Candidate(11,14,10));
        this.add(new Sudoku.Candidate(11,15,5));
        this.add(new Sudoku.Candidate(12,1,4));
        this.add(new Sudoku.Candidate(12,3,2));
        this.add(new Sudoku.Candidate(12,6,1));
        this.add(new Sudoku.Candidate(12,7,7));
        this.add(new Sudoku.Candidate(12,8,5));
        this.add(new Sudoku.Candidate(12,10,12));
        this.add(new Sudoku.Candidate(12,11,13));
        this.add(new Sudoku.Candidate(12,15,8));
        this.add(new Sudoku.Candidate(13,1,13));
        this.add(new Sudoku.Candidate(13,2,8));
        this.add(new Sudoku.Candidate(13,4,15));
        this.add(new Sudoku.Candidate(13,9,3));
        this.add(new Sudoku.Candidate(13,11,9));
        this.add(new Sudoku.Candidate(14,2,12));
        this.add(new Sudoku.Candidate(14,3,14));
        this.add(new Sudoku.Candidate(14,4,5));
        this.add(new Sudoku.Candidate(14,6,10));
        this.add(new Sudoku.Candidate(14,7,1));
        this.add(new Sudoku.Candidate(15,1,1));
        this.add(new Sudoku.Candidate(15,3,4));
        this.add(new Sudoku.Candidate(13,5,7));
        this.add(new Sudoku.Candidate(15,8,9));
        this.add(new Sudoku.Candidate(15,9,10));
        this.add(new Sudoku.Candidate(15,10,2));
        this.add(new Sudoku.Candidate(15,12,6));
        this.add(new Sudoku.Candidate(15,16,14));
        this.add(new Sudoku.Candidate(16,4,9));
        this.add(new Sudoku.Candidate(16,5,14));
        this.add(new Sudoku.Candidate(16,7,4));
        this.add(new Sudoku.Candidate(16,8,6));
        this.add(new Sudoku.Candidate(16,9,15));
        this.add(new Sudoku.Candidate(16,12,11));
    }};

    public Sudoku sudoku1, sudoku2;

    @Before
    public void setUp() throws Exception {
        sudoku1 = new Sudoku(puzzle9x9);
        sudoku2 = new Sudoku(puzzle16x16);
    }

    @Test
    public void testIsGiven() throws Exception {
        assertTrue(sudoku1.isGiven(3,8));
        assertFalse(sudoku1.isGiven(8,7));
    }

    @Test
    public void testGetGiven() throws Exception {
        assertEquals(Optional.of(new Sudoku.Candidate(5,8,1)), sudoku1.getGiven(5,8));
        assertEquals(Optional.empty(), sudoku1.getGiven(3,4));
    }

    @Test
    public void testGivenDigitInRow() throws Exception {
        assertTrue(sudoku1.givenDigitInRow(1,9));
        assertFalse(sudoku1.givenDigitInRow(2,2));
    }

    @Test
    public void testGivenDigitInColumn() throws Exception {
        assertTrue(sudoku1.givenDigitInColumn(1,6));
        assertFalse(sudoku1.givenDigitInColumn(9,8));
    }

    @Test
    public void testGivenDigitInBox() throws Exception {
        assertTrue(sudoku1.givenDigitInBox(6,7));
        assertFalse(sudoku1.givenDigitInBox(7,4));
    }

    @Test
    public void testSolve() throws Exception {
        sudoku1.print();

        sudoku1.solve();
        for (int i = 1; i <= sudoku1.size; ++i) {
            final int row = i;
            assertEquals(sudoku1.size, sudoku1.solution.stream()
                    .filter(candidate -> candidate.row == row)
                    .map(candidate -> candidate.digit)
                    .collect(Collectors.toSet())
                    .size()
            );
        }
        for (int i = 1; i <= sudoku1.size; ++i) {
            final int column = i;
            assertEquals(sudoku1.size, sudoku1.solution.stream()
                    .filter(candidate -> candidate.column == column)
                    .map(candidate -> candidate.digit)
                    .collect(Collectors.toSet())
                    .size()
            );
        }
        for (int i = 1; i <= sudoku1.size; ++i) {
            final int box = i;
            assertEquals(sudoku1.size, sudoku1.solution.stream()
                    .filter(candidate -> sudoku1.getBox(candidate) == box)
                    .map(candidate -> candidate.digit)
                    .collect(Collectors.toSet())
                    .size()
            );
        }

        sudoku1.print();


//        sudoku2.solve();
//
//        System.err.println(sudoku2.solution);
//        assertTrue(false);
    }
}
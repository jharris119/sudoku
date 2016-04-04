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
        this.add(new Sudoku.Candidate(1,6,13));
        this.add(new Sudoku.Candidate(1,9,1));
        this.add(new Sudoku.Candidate(1,10,10));
        this.add(new Sudoku.Candidate(1,15,2));
        this.add(new Sudoku.Candidate(1,16,8));
        this.add(new Sudoku.Candidate(2,1,16));
        this.add(new Sudoku.Candidate(2,2,15));
        this.add(new Sudoku.Candidate(2,5,9));
        this.add(new Sudoku.Candidate(2,8,4));
        this.add(new Sudoku.Candidate(2,11,11));
        this.add(new Sudoku.Candidate(2,14,7));
        this.add(new Sudoku.Candidate(2,15,12));
        this.add(new Sudoku.Candidate(2,16,3));
        this.add(new Sudoku.Candidate(3,1,2));
        this.add(new Sudoku.Candidate(3,2,12));
        this.add(new Sudoku.Candidate(3,3,10));
        this.add(new Sudoku.Candidate(3,8,14));
        this.add(new Sudoku.Candidate(3,9,15));
        this.add(new Sudoku.Candidate(3,10,13));
        this.add(new Sudoku.Candidate(3,13,16));
        this.add(new Sudoku.Candidate(4,3,7));
        this.add(new Sudoku.Candidate(4,5,2));
        this.add(new Sudoku.Candidate(4,7,12));
        this.add(new Sudoku.Candidate(4,9,16));
        this.add(new Sudoku.Candidate(4,11,5));
        this.add(new Sudoku.Candidate(4,16,10));
        this.add(new Sudoku.Candidate(5,2,8));
        this.add(new Sudoku.Candidate(5,8,2));
        this.add(new Sudoku.Candidate(5,9,6));
        this.add(new Sudoku.Candidate(5,10,5));
        this.add(new Sudoku.Candidate(5,11,14));
        this.add(new Sudoku.Candidate(5,15,7));
        this.add(new Sudoku.Candidate(6,2,3));
        this.add(new Sudoku.Candidate(6,3,5));
        this.add(new Sudoku.Candidate(6,5,15));
        this.add(new Sudoku.Candidate(6,8,10));
        this.add(new Sudoku.Candidate(6,10,2));
        this.add(new Sudoku.Candidate(6,12,4));
        this.add(new Sudoku.Candidate(6,13,8));
        this.add(new Sudoku.Candidate(6,16,6));
        this.add(new Sudoku.Candidate(7,1,12));
        this.add(new Sudoku.Candidate(7,2,9));
        this.add(new Sudoku.Candidate(7,4,2));
        this.add(new Sudoku.Candidate(7,7,11));
        this.add(new Sudoku.Candidate(7,14,5));
        this.add(new Sudoku.Candidate(8,1,6));
        this.add(new Sudoku.Candidate(8,2,11));
        this.add(new Sudoku.Candidate(8,3,4));
        this.add(new Sudoku.Candidate(8,6,16));
        this.add(new Sudoku.Candidate(8,11,3));
        this.add(new Sudoku.Candidate(8,12,8));
        this.add(new Sudoku.Candidate(9,5,13));
        this.add(new Sudoku.Candidate(9,6,12));
        this.add(new Sudoku.Candidate(9,11,8));
        this.add(new Sudoku.Candidate(9,14,4));
        this.add(new Sudoku.Candidate(9,15,14));
        this.add(new Sudoku.Candidate(9,16,1));
        this.add(new Sudoku.Candidate(10,3,11));
        this.add(new Sudoku.Candidate(10,10,16));
        this.add(new Sudoku.Candidate(10,13,12));
        this.add(new Sudoku.Candidate(10,15,5));
        this.add(new Sudoku.Candidate(10,16,13));
        this.add(new Sudoku.Candidate(11,1,13));
        this.add(new Sudoku.Candidate(11,4,12));
        this.add(new Sudoku.Candidate(11,5,4));
        this.add(new Sudoku.Candidate(11,7,3));
        this.add(new Sudoku.Candidate(11,9,14));
        this.add(new Sudoku.Candidate(11,12,10));
        this.add(new Sudoku.Candidate(11,14,6));
        this.add(new Sudoku.Candidate(11,15,8));
        this.add(new Sudoku.Candidate(12,2,7));
        this.add(new Sudoku.Candidate(12,6,9));
        this.add(new Sudoku.Candidate(12,7,16));
        this.add(new Sudoku.Candidate(12,8,1));
        this.add(new Sudoku.Candidate(12,9,12));
        this.add(new Sudoku.Candidate(12,15,10));
        this.add(new Sudoku.Candidate(13,1,15));
        this.add(new Sudoku.Candidate(13,6,2));
        this.add(new Sudoku.Candidate(13,8,6));
        this.add(new Sudoku.Candidate(13,10,14));
        this.add(new Sudoku.Candidate(13,12,5));
        this.add(new Sudoku.Candidate(13,14,8));
        this.add(new Sudoku.Candidate(14,4,8));
        this.add(new Sudoku.Candidate(14,7,9));
        this.add(new Sudoku.Candidate(14,8,11));
        this.add(new Sudoku.Candidate(14,9,10));
        this.add(new Sudoku.Candidate(14,14,1));
        this.add(new Sudoku.Candidate(14,15,6));
        this.add(new Sudoku.Candidate(14,16,15));
        this.add(new Sudoku.Candidate(15,1,4));
        this.add(new Sudoku.Candidate(15,2,14));
        this.add(new Sudoku.Candidate(15,3,2));
        this.add(new Sudoku.Candidate(15,6,15));
        this.add(new Sudoku.Candidate(15,9,11));
        this.add(new Sudoku.Candidate(15,12,1));
        this.add(new Sudoku.Candidate(15,15,9));
        this.add(new Sudoku.Candidate(15,16,7));
        this.add(new Sudoku.Candidate(16,1,11));
        this.add(new Sudoku.Candidate(16,2,1));
        this.add(new Sudoku.Candidate(16,7,4));
        this.add(new Sudoku.Candidate(16,8,13));
        this.add(new Sudoku.Candidate(16,11,7));
    }};

    public Sudoku sudoku1, sudoku2;

    @Before
    public void setUp() throws Exception {
        sudoku1 = new Sudoku(puzzle9x9);
        sudoku2 = new Sudoku(puzzle16x16);
    }

    @Test
    public void testRead() throws Exception {
        String json = "[[null, null, 3, 9, null, null, null, 8, 7]," +
                       "[null, null, null, null, 1, 6, null, null, null]," +
                       "[null, null, 7, null, 3, null, null, 9 null]," +
                       "[6, 5, null, null, null, null, 8, null, 4]," +
                       "[null, null, null, 6, null, null, null, 1, null]," +
                       "[null, null, null, null, null, null, 7, null, null]," +
                       "[null, null, null, null, 2, 8, null, 3, 9]," +
                       "[9, null, 3, 1, null, null, null, null, null]," +
                       "[null, 2, 5, null, null, null, null, null, null]";
        assertEquals(sudoku1, Sudoku.read(json));
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
        sudoku1.print();
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

        sudoku2.print();
        sudoku2.solve();
        sudoku2.print();
        for (int i = 1; i <= sudoku2.size; ++i) {
            final int row = i;
            assertEquals(sudoku2.size, sudoku2.solution.stream()
                    .filter(candidate -> candidate.row == row)
                    .map(candidate -> candidate.digit)
                    .collect(Collectors.toSet())
                    .size()
            );
        }
        for (int i = 1; i <= sudoku2.size; ++i) {
            final int column = i;
            assertEquals(sudoku2.size, sudoku2.solution.stream()
                    .filter(candidate -> candidate.column == column)
                    .map(candidate -> candidate.digit)
                    .collect(Collectors.toSet())
                    .size()
            );
        }
        for (int i = 1; i <= sudoku2.size; ++i) {
            final int box = i;
            assertEquals(sudoku2.size, sudoku2.solution.stream()
                    .filter(candidate -> sudoku2.getBox(candidate) == box)
                    .map(candidate -> candidate.digit)
                    .collect(Collectors.toSet())
                    .size()
            );
        }
    }
}
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    int run (int num) throws FileNotFoundException {
        Scanner s = new Scanner(new File("SodukuTest/sodoku-board-" + num + ".txt"));
        //SodukuTest/sodoku-board-1.txt
        Sudoku puzzle = Sudoku.read(s);

        System.out.printf("Input puzzle number %d:%n%s%n", num, puzzle);

        boolean b = puzzle.solve();
        if (!b) System.out.println("No solution.");
        else System.out.printf("%n%s%n", puzzle);

        return puzzle.getBacktracking();
    }
    @Test
    public void run5 () throws FileNotFoundException {
        run(5);
    }
    @Test
    public void run6 () throws FileNotFoundException {
        run(6);
    }
    @Test
    public void run1 () throws FileNotFoundException {
        run(1);
    }

    @Test
    public void run2 () throws FileNotFoundException {
        run(2);
    }

    @Test
    public void run3 () throws FileNotFoundException {
        run(3);
    }

    @Test
    public void run4 () throws FileNotFoundException {
        run(4);
    }

    @Test
    public void runBig () throws FileNotFoundException {
        Scanner s = new Scanner(new File("SodukuTest/big-sodoku.txt"));
        Sudoku puzzle = Sudoku.read(s);

        boolean b = puzzle.solve();
        if (!b) System.out.println("No solution.");
        else System.out.printf("Solved with %d backtracking steps", puzzle.getBacktracking());
    }

    @Test
    public void runAll () throws FileNotFoundException {
        assertEquals(1239, run(1));
        System.out.println("----------------------");
        assertEquals(494, run(2));
        System.out.println("----------------------");
        assertEquals(19649, run(3));
        System.out.println("----------------------");
        assertEquals(889, run(4));
        System.out.println("----------------------");
        assertEquals(0, run(5));
        System.out.println("----------------------");
        assertEquals(0, run(6));
        System.out.println("----------------------");

    }
}

/*
Expected output...

Input puzzle number 1:
――――――――――――――――――――――
│8 . . │3 . 9 │. . 5 │
│. . . │. 2 . │. . . │
│5 . . │6 . 8 │. . 3 │
――――――――――――――――――――――
│. 7 5 │9 . 3 │4 6 . │
│. . 1 │. . . │7 . . │
│. 3 8 │7 . 4 │2 5 . │
――――――――――――――――――――――
│6 . . │4 . 1 │. . 2 │
│. . . │. 9 . │. . . │
│3 . . │5 . 7 │. . 4 │
――――――――――――――――――――――


――――――――――――――――――――――
│8 4 6 │3 7 9 │1 2 5 │
│7 9 3 │1 2 5 │8 4 6 │
│5 1 2 │6 4 8 │9 7 3 │
――――――――――――――――――――――
│2 7 5 │9 1 3 │4 6 8 │
│4 6 1 │8 5 2 │7 3 9 │
│9 3 8 │7 6 4 │2 5 1 │
――――――――――――――――――――――
│6 8 7 │4 3 1 │5 9 2 │
│1 5 4 │2 9 6 │3 8 7 │
│3 2 9 │5 8 7 │6 1 4 │
――――――――――――――――――――――

----------------------
Input puzzle number 2:
――――――――――――――――――――――
│8 8 . │3 . 9 │. . 5 │
│. . . │. 2 . │. . . │
│5 . . │6 . 8 │. . 3 │
――――――――――――――――――――――
│. 7 5 │9 . 3 │4 6 . │
│. . 1 │. . . │7 . . │
│. 3 8 │7 . 4 │2 5 . │
――――――――――――――――――――――
│6 . . │4 . 1 │. . 2 │
│. . . │. 9 . │. . . │
│3 . . │5 . 7 │. . 4 │
――――――――――――――――――――――

No solution.
----------------------
Input puzzle number 3:
――――――――――――――――――――――
│2 1 . │9 . . │5 . . │
│. . . │2 6 . │4 . . │
│. . 3 │. . . │. 7 . │
――――――――――――――――――――――
│4 . . │. . . │. 6 . │
│. . . │1 7 9 │. . . │
│. 7 . │. . . │. . 3 │
――――――――――――――――――――――
│. 9 . │. . . │3 . . │
│. . 5 │. 8 4 │. . . │
│. . 6 │. . 2 │. 1 5 │
――――――――――――――――――――――


――――――――――――――――――――――
│2 1 4 │9 3 7 │5 8 6 │
│9 5 7 │2 6 8 │4 3 1 │
│6 8 3 │5 4 1 │9 7 2 │
――――――――――――――――――――――
│4 2 9 │8 5 3 │1 6 7 │
│3 6 8 │1 7 9 │2 5 4 │
│5 7 1 │4 2 6 │8 9 3 │
――――――――――――――――――――――
│7 9 2 │6 1 5 │3 4 8 │
│1 3 5 │7 8 4 │6 2 9 │
│8 4 6 │3 9 2 │7 1 5 │
――――――――――――――――――――――

----------------------
Input puzzle number 4:
――――――――――――――――――――――
│. 7 . │. 4 1 │. . 8 │
│2 3 . │. . . │. . 6 │
│. . 4 │6 2 7 │. . 3 │
――――――――――――――――――――――
│. 4 6 │2 . 9 │. . . │
│. . 2 │. . . │5 . . │
│. . . │7 . 6 │8 2 . │
――――――――――――――――――――――
│5 . . │1 7 3 │9 . . │
│1 . . │. . . │. 8 5 │
│4 . . │9 8 . │. 1 . │
――――――――――――――――――――――


――――――――――――――――――――――
│6 7 5 │3 4 1 │2 9 8 │
│2 3 1 │5 9 8 │4 7 6 │
│9 8 4 │6 2 7 │1 5 3 │
――――――――――――――――――――――
│8 4 6 │2 5 9 │7 3 1 │
│7 1 2 │8 3 4 │5 6 9 │
│3 5 9 │7 1 6 │8 2 4 │
――――――――――――――――――――――
│5 6 8 │1 7 3 │9 4 2 │
│1 9 7 │4 6 2 │3 8 5 │
│4 2 3 │9 8 5 │6 1 7 │
――――――――――――――――――――――




 */
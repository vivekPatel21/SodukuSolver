import java.util.HashMap;
import java.util.Scanner;

class Sudoku {
    private static final int EMPTY = -1;

    private final int dim;
    private final int sdim;
    private final int[][] cells;
    private int backtracking;

    public Sudoku(int[][] cells) {
        this.dim = cells.length;
        this.sdim = (int) Math.sqrt(dim);
        this.cells = cells;
        this.backtracking = 0;
    }

    int getBacktracking() {
        return backtracking;
    }

    public boolean isBlank(int row, int col) {
        return cells[col][row] == EMPTY;
    }

    public boolean isValid(int val, int row, int col) {
        return checkRow(val, row) && checkCol(val, col) && checkBlock(val, row, col) && isBlank(row, col);
    }

    private boolean checkRow(int val, int row) {

        for (int i = 0; i < dim; i++) {
            if (cells[i][row] == val) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int val, int col) {

        for (int i = 0; i < dim; i++) {
            if (cells[col][i] == val) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBlock(int val, int row, int col) {
        int startingC = (int) Math.floor(col / sdim);
        int startingR = (int) Math.floor(row/ sdim);

        for(int i = 0; i < sdim; i++){
            for(int j = 0; j < sdim; j++) {
                if (cells[(startingC * sdim) + j][(startingR * sdim) + i] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve() {
        return tryColumn(0);
    }

    private boolean tryColumn(int col) {
        if (col == dim) return true;
        if (col > dim) return false;
        return tryCell(col, 0);
    }

    private boolean tryCell(int col, int row) {
        if(row == dim){
            return tryColumn(col + 1);
        }
        if (!isBlank(row, col)) {
            return tryCell(col, row+1);
        }
        for (int i = 1; i <= dim; i++) {
            if (isValid(i, row, col)){
                cells[col][row] = i;
                if(tryCell(col, row + 1)){
                    return true;
                }
                else {
                    ++backtracking;
                    cells[col][row] = EMPTY;
                }
            }
        }
        return false;

    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < dim; j++) {
            if (j % sdim == 0) res.append("――――――――――――――――――――――\n");
            for (int i = 0; i < dim; i++) {
                if (i % sdim == 0) res.append("│");
                int c = cells[i][j];
                res.append(c == EMPTY ? "." : c);
                res.append(" ");
            }
            res.append("│\n");
        }
        res.append("――――――――――――――――――――――\n");
        return res.toString();
    }

    //------------------------------------------------------------

    public static Sudoku read(Scanner s) {
        int dim = s.nextInt();
        int[][] cells = new int[dim][dim];
        for (int j = 0; j < dim; j++)
            for (int i = 0; i < dim; i++) {
                String c = s.next();
                cells[i][j] = c.equals(".") ? EMPTY : Integer.parseInt(c);
            }
        return new Sudoku(cells);
    }
}
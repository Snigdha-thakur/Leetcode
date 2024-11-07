import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(result, board, 0, n);
        return result;
    }
    
    private void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') return false;
            if (col + (row - i) < n && board[i][col + (row - i)] == 'Q') return false;
        }
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}

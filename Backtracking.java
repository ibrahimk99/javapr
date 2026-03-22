public class Backtracking {
  public static void changeArr(int arr[], int i, int val) {
    if (i == arr.length) {
      printArr(arr);
      return;
    }
    arr[i] = val;
    changeArr(arr, i + 1, val + 1);
    arr[i] = arr[i] - 2;
  }

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void findSubsets(String str, String ans, int i) {
    if (i == str.length()) {
      System.out.println(ans);
      return;
    }
    // take the element
    findSubsets(str, ans + str.charAt(i), i + 1);
    // not take the element
    findSubsets(str, ans, i + 1);
  }

  public static void findPermutations(String str, String ans) {
    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String newStr = str.substring(0, i) + str.substring(i + 1);
      findPermutations(newStr, ans + ch);
    }
  }

  public static boolean isSafe(char board[][], int row, int col) {
    // vertical up
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // left diagonal up
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    // right diagonal up
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  public static void nQueens(char board[][], int row) {
    if (row == board.length) {
      printBoard(board);
      return;
    }
    for (int j = 0; j < board.length; j++) {
      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        nQueens(board, row + 1);
        board[row][j] = '.';
      }
    }
  }

  public static void printBoard(char board[][]) {
    System.out.println("------Chess Board------");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void gridWays() {

  }

  public static boolean isSafeSudoku(int sudoku[][], int digit, int row, int col) {
    // check for current value in row
    for (int i = 0; i < sudoku.length; i++) {
      if (sudoku[row][i] == digit) {
        return false;
      }
    }
    for (int j = 0; j < sudoku[0].length; j++) {
      if (sudoku[j][col] == digit) {
        return false;
      }
    }
    // check for current box
    int miniRow = row / 3 * 3;
    int miniCol = col / 3 * 3;

    for (int i = miniRow; i < miniRow + 3; i++) {
      for (int j = miniCol; j < miniCol + 3; j++) {
        if (sudoku[i][j] == digit) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean sudokuSolver(int sudoku[][], int row, int col) {
    if (row == 9) {
      return true;
    }
    int nxtRow = row, nxtCol = col + 1;
    if (col + 1 == 9) {
      nxtRow = row + 1;
      nxtCol = 0;
    }
    if (sudoku[row][col] != 0) {
      return sudokuSolver(sudoku, nxtRow, nxtCol);
    }
    for (int digit = 1; digit <= 9; digit++) {
      if (isSafeSudoku(sudoku, digit, row, col)) {
        sudoku[row][col] = digit;

        if (sudokuSolver(sudoku, nxtRow, nxtCol)) {
          return true;
        }
        sudoku[row][col] = 0; // backtrack
      }
    }
    return false;
  }

  public static void printSudoku(int sudoku[][]) {
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku[0].length; j++) {
        System.out.print(sudoku[i][j] + " |");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    // int arr[] = new int[5];
    // changeArr(arr, 0, 1);
    // printArr(arr);
    // findSubsets("abc", "", 0);
    // findPermutations("abc", "");
    int n = 4;
    char board[][] = new char[n][n];
    //
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
      System.out.println();
    }
    // nQueens(board, 0);
    int sudoku[][] = {
        { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
        { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
        { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
        { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
        { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
        { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
        { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
        { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
        { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
    };
    sudokuSolver(sudoku, 0, 0);
    printSudoku(sudoku);
    gridWays();
  }

}

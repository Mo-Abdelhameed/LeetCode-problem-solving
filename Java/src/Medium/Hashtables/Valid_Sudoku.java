package Medium.Hashtables;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.*/

import java.util.ArrayList;
import java.util.HashSet;

public class Valid_Sudoku {

    public static int getBoxNumber(int row, int column){
        if(row >= 0 && row <= 2){
            if(column >= 0 && column <= 2)
                return 0;
            if(column >= 3 && column <= 5)
                return 1;
            if(column >= 6 && column <= 8)
                return 2;
        }

        if(row >= 3 && row <= 5){
            if(column >= 0 && column <= 2)
                return 3;
            if(column >= 3 && column <= 5)
                return 4;
            if(column >= 6 && column <= 8)
                return 5;
        }

        if(row >= 6 && row <= 8){
            if(column >= 0 && column <= 2)
                return 6;
            if(column >= 3 && column <= 5)
                return 7;
            if(column >= 6 && column <= 8)
                return 8;
        }
        return -1;
    }

    public static ArrayList<HashSet<Character>> nineSets(){
        ArrayList<HashSet<Character>> sets = new ArrayList<>();
        for(int i = 0 ; i < 9 ; i++)
            sets.add(new HashSet<Character>());
        return sets;
    }

    public static boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rows = nineSets();
        ArrayList<HashSet<Character>> columns = nineSets();
        ArrayList<HashSet<Character>> boxes = nineSets();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                int boxNumber = getBoxNumber(i, j);
                if(rows.get(i).contains(board[i][j]) || columns.get(j).contains(board[i][j]) || boxes.get(boxNumber).contains(board[i][j]))
                    return false;

                rows.get(i).add(board[i][j]);
                columns.get(j).add(board[i][j]);
                boxes.get(boxNumber).add(board[i][j]);
            }
        }
        return true;
    }

}

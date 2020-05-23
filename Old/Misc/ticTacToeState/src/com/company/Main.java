package com.company;

/*

THIS CODE IS IF YOU KNOW THE LAST PLAYED MOVE

After a player puts down a piece at position (x,y)
col=row=diag=rdiag=0
winner=false
for i=0 to n
  if cell[x,i]=player then col++
  if cell[i,y]=player then row++
  if cell[i,i]=player then diag++
  if cell[i,n-(i+1)]=player then rdiag++
if row=n or col=n or diag=n or rdiag=n then winner=true

*/

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        board[1][0] = 'O';
        board[1][1] = 'O';
        board[1][2] = 'X';
        board[2][0] = 'O';
        board[2][1] = 'O';
        board[2][2] = 'X';


        System.out.println(checkTicTacToeState(board));
    }

    public static String checkTicTacToeState (char[][] board){

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                boolean xWin = checkTicTacToeState(board, 'X', i, j);
                boolean oWin = checkTicTacToeState(board, 'O', i, j);
                if (xWin) return "X WIN";
                if (oWin) return "Y WIN";
            }
        }

        if (checkFull(board)) return "TIE";

        return "Game in Progress";
    }

    public static boolean checkFull(char[][] board) {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] == '\0') return false;
            }
        }

        return true;
    }

    public static boolean checkTicTacToeState (char[][] board, char sign, int x, int y){

        int n = board.length;

        //check col
        for(int i = 0; i < n; i++){
            if(board[x][i] != sign)
                break;
            if(i == n-1){
                return true;
            }
        }

        //check row
        for(int i = 0; i < n; i++){
            if(board[i][y] != sign)
                break;
            if(i == n-1){
                return true;
            }
        }

        //check diag
        if(x == y){
            //we're on a diagonal
            for(int i = 0; i < n; i++){
                if(board[i][i] != sign)
                    break;
                if(i == n-1){
                    return true;
                }
            }
        }

        //check anti diag
        if(x + y == n - 1){
            for(int i = 0; i < n; i++){
                if(board[i][(n-1)-i] != sign)
                    break;
                if(i == n-1){
                    return true;
                }
            }
        }

        return false;
    }
}
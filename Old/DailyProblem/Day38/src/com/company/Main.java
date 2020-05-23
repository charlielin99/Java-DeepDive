package com.company;

/*
This problem was asked by Microsoft.

You have an N by N board. Write a function that, given N,
returns the number of possible arrangements of the board where N queens
can be placed on the board without threatening each other, i.e. no two queens share the same row, column, or diagonal.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    // traditional dfs backtracking would be O(n!)
    // time: exponential
    // space: exponential

    public static void main(String[] args) {
        List<List<Integer>> ret = nQueens(4);
        System.out.println("Number of Placements is: " + ret.size());
        for (List<Integer> k : ret){
            for (int i: k){
                System.out.println(i);
            }
            System.out.println("");
        }
    }


    private static boolean is_valid_move(int proposed_row, int proposed_col, List<Integer> solution) {
        // we need to check with all queens in current solution
        for (int i = 0; i < proposed_row; ++i) {
            int old_row = i;
            int old_col = solution.get(i);
            int diagonal_offset = proposed_row - old_row;

            if (old_col == proposed_col || old_col == proposed_col - diagonal_offset || old_col == proposed_col + diagonal_offset) {
                return false;
            }
        }
        return true;
    }

    //This solution uses stack to store the solution.
    //Stack will hold only the column values and one solution
    //will be stored in the stack at a time.

    public static List<List<Integer>> nQueens(int n) {

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> solution = new ArrayList<Integer>(n);
        Stack<Integer> sol_stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            solution.add(-1);
        }

        int row = 0;
        int col = 0;

        while(row < n){
            while(col < n){
                if(is_valid_move(row, col, solution)){
                    sol_stack.push(col);
                    solution.set(row, col);
                    row++;
                    col = 0;
                    break;
                }
                col++;
            }

            if(col == n){
                if(!sol_stack.empty()){
                    col = sol_stack.peek() + 1;
                    sol_stack.pop();
                    row--;
                }
                else{
                    // no more solutions exist
                    break;
                }
            }

            if(row == n){
                // add the solution into results
                ret.add(new ArrayList<Integer>(solution));

                //backtrack to find the next solution
                row--;
                col = sol_stack.peek() + 1;
                sol_stack.pop();
            }
        }

        return ret;
    }
}

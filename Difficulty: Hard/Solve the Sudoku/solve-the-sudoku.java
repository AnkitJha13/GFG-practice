//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver_class {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int grid[][] = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) grid[i][j] = sc.nextInt();
            }

            Solution ob = new Solution();

            if (ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("No solution exists");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][]) {
        // add your code here
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(grid[row][col] == 0){
                    for(int digit=1; digit<=9;digit++){
                        if(canPlace(grid, row, col, digit)){
                            grid[row][col] = digit;
                            if(SolveSudoku(grid)){
                                return true;
                            }
                            grid[row][col] = 0;   // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;  //sudoku solved 
    }
    static boolean canPlace(int grid[][], int row, int col, int digit){
        for(int j=0;j<9;j++){
            if(grid[row][j] == digit){   // for row
                return false;
            }
        }
        
         for(int i=0;i<9;i++){
            if(grid[i][col] == digit){   // for col
                return false;
            }
        }
        
        int gridRow = (row/3) * 3;      // for subgrid
        int gridCol = (col/3) * 3;
        
        for(int i=gridRow;i<gridRow+3;i++){
            for(int j=gridCol;j<gridCol+3;j++){
                if(grid[i][j] == digit){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    

    // Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        // add your code here
        
         for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(grid[row][col] + " ");
            }
        }
    }
}
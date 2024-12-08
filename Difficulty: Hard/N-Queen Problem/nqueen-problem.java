//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private void solveQueen(ArrayList<ArrayList<Integer>> solution, char[][] board, 
    int row, int n){
        if(row == n){
            solution.add(convertBoardToList(board, n));
            return;
        }
        
        for(int col=0;col<n;col++){
            if(canPlaceQueen(board, row, col, n)){
                board[row][col] = 'Q';
                solveQueen(solution, board, row+1, n);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean canPlaceQueen(char[][] board, int row, int col, int n){
        // vertical up
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        for(int i=row-1, j=col-1; i>=0 && j>=0 ; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        return true;
        
        
    }
    
    private ArrayList<Integer> convertBoardToList(char[][] board, int n){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'Q'){
                    result.add(j+1);
                    break;
                }
            }
        }
        return result;
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        
        solveQueen(solution, board, 0, n);
        return solution;
    }
}
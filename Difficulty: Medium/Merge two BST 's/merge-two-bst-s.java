//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            ArrayList<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public void getInorder(Node root, List<Integer> ans){
        if(root == null){
            return ;
        }
        
        getInorder(root.left, ans);
        ans.add(root.data);
        getInorder(root.right, ans);
    }
    
    // public void Node createBST(List<Integer> arr, int start, int end){
    //     if(start > end){
    //         return null;
    //     }
        
    //     int mid = (start + end)/2;
        
    //     Node root = new Node(arr.get(mid));
    //     root.left = createBST(arr, start, mid-1);
    //     root.right = createBST(arr, mid+1, end);
        
    //     return root;
    // }
    
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // Write your code here
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        
        ArrayList<Integer> mergedArr = new ArrayList<>();
        int i=0, j=0;
        
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                mergedArr.add(arr1.get(i));
                i++;
            }
            else{
                mergedArr.add(arr2.get(j));
                j++;
            }
        }
        
        while(i < arr1.size()){
            mergedArr.add(arr1.get(i));
            i++;
        }
        
        while(j < arr2.size()){
            mergedArr.add(arr2.get(j));
            j++;
        }
        
        return mergedArr;
    }
}

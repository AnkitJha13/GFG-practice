//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        
System.out.println("~");
}
    }
    
}



// } Driver Code Ends


class Solution {
    // Function to build a Heap from an array.
    void buildHeap(int arr[], int n) {
        // Build the max heap starting from the last non-leaf node.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    // Heapify function to maintain heap property.
    void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index
        int maxIdx = i; // Assume current node is the largest

        // Check if the left child is larger than the current largest
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        // Check if the right child is larger than the current largest
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        // If the largest is not the root, swap and heapify the affected subtree
        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, maxIdx, size);
        }
    }

    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        // Step 1: Build the max heap
        buildHeap(arr, n);

        // Step 2: Extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the root (largest element) to the end of the array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, 0, i);
        }
    }
}

 
 

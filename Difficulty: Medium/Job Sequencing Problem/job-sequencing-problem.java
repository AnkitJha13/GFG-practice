//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            // adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            // function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
*/

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job jobs[], int n) {
        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline to determine the time slots
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxDeadline) {
                maxDeadline = jobs[i].deadline;
            }
        }

        // Array to track used time slots
        boolean[] slots = new boolean[maxDeadline];

        int jobsDone = 0, totalProfit = 0;

        // Loop through each job
        for (int i = 0; i < n; i++) {
            // Find an available slot before the deadline
            for (int j = jobs[i].deadline - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true; // Mark slot as filled
                    jobsDone++;
                    totalProfit += jobs[i].profit; // Add the profit
                    break;
                }
            }
        }

        return new int[]{jobsDone, totalProfit};
    }
}

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
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> (b.profit - a.profit));

        // Find the maximum deadline to determine the size of the result array
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        // Initialize the result array to keep track of scheduled jobs
        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1); // -1 means slot is empty

        // Variables to store the count of jobs and total profit
        int countJobs = 0, jobProfit = 0;

        // Try to schedule each job
        for (int i = 0; i < n; i++) {
            // Try to find a free slot for the current job (from its deadline backward)
            for (int j = jobs[i].deadline; j > 0; j--) {
                // If the slot is empty, schedule the job
                if (result[j] == -1) {
                    result[j] = i; // Mark the job as scheduled
                    countJobs++; // Increase job count
                    jobProfit += jobs[i].profit; // Add profit
                    break; // Break once the job is scheduled
                }
            }
        }

        // Return the result as an array with the number of jobs and total profit
        return new int[] { countJobs, jobProfit };
    }
}


//{ Driver Code Starts
import java.util.*;

class TwoStack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            twoStacks g = new twoStacks();
            int Q = sc.nextInt();
            while (Q > 0) {
                int stack_no = sc.nextInt();
                int QueryType = sc.nextInt();

                if (QueryType == 1) {
                    int a = sc.nextInt();
                    if (stack_no == 1)
                        g.push1(a);
                    else if (stack_no == 2)
                        g.push2(a);
                } else if (QueryType == 2) {
                    if (stack_no == 1)
                        System.out.print(g.pop1() + " ");
                    else if (stack_no == 2)
                        System.out.print(g.pop2() + " ");
                }

                Q--;
            }
            System.out.println();
            T--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class twoStacks {
    private static final int DEFAULT_SIZE = 100;
    int[] arr;
    int top1;
    int top2;
    int size;

    // Constructor to initialize the array with a given size
    twoStacks() {
        size = DEFAULT_SIZE;
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow for Stack1");
        }
    }

    void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow for Stack2");
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int popped = arr[top1];
            top1--;
            return popped;
        } else {
            return -1; // Stack1 is empty
        }
    }

    int pop2() {
        if (top2 < size) {
            int popped = arr[top2];
            top2++;
            return popped;
        } else {
            return -1; // Stack2 is empty
        }
    }
}


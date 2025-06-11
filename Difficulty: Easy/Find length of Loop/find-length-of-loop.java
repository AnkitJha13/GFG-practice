/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // code here.
        if(head == null || head.next == null){
            return 0;
        }
        
        Node slow = head, fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                slow = slow.next;
                int length = 1;
                
                while(slow != fast){
                    slow = slow.next;
                    length++;
                }
                return length;
            }
        }
        
        return 0;
    }
}
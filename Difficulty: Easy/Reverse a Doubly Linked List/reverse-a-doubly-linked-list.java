/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        if(head == null || head.next == null) return head;
        
        Node prev = null;
        Node curr = head;
        
        while(curr != null){
            Node forward = curr.next;
            curr.next = curr.prev;
            curr.prev = forward;
            prev = curr;
            curr = forward;
        }
        
        return prev;
        
        
    }
}
/*
Structure of node class is:
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node insertInMiddle(Node head, int x) {
        // Code here
        Node newNode = new Node(x);
        Node fast = head, slow = head;
        
        if(head == null) return newNode;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        newNode.next = slow.next;
        slow.next = newNode;
        return head;
    }
}
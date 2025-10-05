/*
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public ArrayList<Integer> printList(Node head) {
        // code here
        ArrayList<Integer> addNode = new ArrayList<>();
        Node curr = head;
        while(curr != null){
            addNode.add(curr.data);
            curr = curr.next;
        }
        
        return addNode;
    }
}
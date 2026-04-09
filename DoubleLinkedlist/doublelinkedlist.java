class doublelinkedlist {

    // Node code
   Node head;
   class Node{
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.prev=null;
        this.next=null;
    }
} 

    //  length of doubly linkedlist
    public int length(){
        int count =0;
        Node curr = head;

        while (curr != null) {
            count++;
            curr=curr.next;
        }
        return count;
    }

    // search of an element

    public boolean search(int target){
        Node curr = head;
        while (curr != null) {
            if(curr.data == target){
                return true; // found
            }
            curr=curr.next;
        }
        return false;
    }

    // ---- Insertion code -----

    // Insert at beginning​
    public void insertbegin(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head=newNode;
            return;
        }

        newNode.next=head;
        head.prev = newNode;
        head=newNode;
    }

    // Insert at end​
    public void insertend(int data){
        Node newNode = new Node(data); 
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;

        while(curr.next != null){
            curr = curr.next; 
        }

        curr.next=newNode;
        newNode.prev=curr;
    } 
    
    // Insert at specific position​
    public void insertPosition(int pos , int data){
        Node newNode = new Node(data);
        if (pos == 0) {
            insertbegin(data);
            return;
        }

        Node curr = head;
        for (int i = 0; i < pos-1; i++) {
            if (curr==null) {
                System.out.println("position out of bound");
                return;
            }
            curr = curr.next;
        }

        if (curr.next == null) {
            insertend(data);
            return;
        }
        newNode.next=curr.next;
        newNode.prev=curr;

        curr.next.prev=newNode;
        curr.next=newNode;
    }
    // Insert after a given node​
    public void insertAfter(int target,int data){
        Node curr = head;
        while (curr != null && curr.data != target) {
            curr=curr.next;
        }

        if (curr == null) {
            System.out.println("node not found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next=curr.next;
        newNode.prev=curr;

        if(curr.next !=  null){
            curr.next.prev=newNode;
        }

        curr.next=newNode;
    }
     
    // Insert before a given node
    public void insertBefore(int target,int data){
        if (head == null) {
            System.out.println("list is empty");            
            return;
        }

        if(head.data == target){
            insertbegin(data);
            return;
        }

        Node curr = head;
        while (curr != null && curr.data != target) {
            curr=curr.next;
        }

        if(curr == null){
            System.out.println("node not found");
            return;
        }

        Node newNode = new Node(data);
        newNode.prev=curr.prev;
        newNode.next=curr;

        curr.prev.next=newNode;
        curr.prev=newNode;
    }
    // ----- Deletion code  -----

    // Delete from beginning​
    public void deletebegin(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        head=head.next;
        head.prev=null;

    }

    // Delete form end
    public void deleteEnd(){
         if(head == null){
            System.out.println("list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr=curr.next;
        }

        curr.prev.next=null;
    }

    // delete at position
    public void deletePosition(int pos){
        if (head == null) {
            System.out.println("list is empty");
            return;            
        }
        // case 1:- delete head
        if (pos ==0) {
            deletebegin();
            return;
        }

        Node curr = head;
        for (int i = 0; i < pos; i++) {
            if(curr == null){
                System.out.println("position out of bond");
                return;
            }
            curr = curr.next;
        }

        // case 2:- last node
        if (curr.next == null) {
         curr.prev.next=null;   
         return;
        }

        // case 3:- middle node
       curr.prev.next=curr.next;
       curr.next.prev=curr.prev;
    }

    // delete by value
    public void deleteValue(int target){
        if (head == null) {
            System.out.println("list is empty");
            return;            
        }
        Node curr = head;
        // case 01:- head contain target
        if(curr.data == target){
            deletebegin();
            return;
        }

        while (curr != null && curr.data != target) {
            curr=curr.next;
        }

        if(curr == null){
            System.out.println("node not found");
            return;
        }

        // case 02:- last node
        if(curr.next == null){
            curr.prev.next=null;
        }

        // case 03:- middle node
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }

    // Delete entire linked list
    public void deleteAll(){
        head = null;
    }

    // ---- Traversal of linkedlist----

    // Forward Traversal
    public void ForwardTraversal(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "<->");
            curr=curr.next;
        }
        System.out.println("null");
    }

    // Backward Traversal
    public void BackwardTraversal(){
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node curr = head;
        // go to last
        while(curr.next != null){
            curr = curr.next;
        }

        // traverse 
        while (curr != null) {
            System.out.print(curr.data + "<->");
            curr=curr.prev;
        }
       
        System.out.println("null");
    }   
    
    // create node function
    public Node createNode(int data){
        return new Node(data);
    }
    public static void main(String[] args) {
        doublelinkedlist list = new doublelinkedlist();
       Node n1 = list.createNode(20);
       Node n2 = list.createNode(30);
       list.head=n1;
       n1.next = n2;
       n2.prev=n1;

    //    insertion code
       list.insertbegin(10);
       list.insertend(40);
       list.insertPosition(2, 25);
       list.insertAfter(30, 35);
       list.insertAfter(40, 50);
       list.insertBefore(30, 28);

    //    deletion code
       list.deletebegin();
       list.deleteEnd();
       list.deletePosition(2);
       list.deleteValue(35);
    // list.deleteAll();
        
    list.ForwardTraversal();
    list.BackwardTraversal();

    System.out.println("the lenght of doubly linkedlist is :- " +list.length());
    System.out.println("the search element is :- "  + list.search(40));
    }       
}

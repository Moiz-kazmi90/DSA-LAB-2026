class singlelinkedlist{
    
    // length of a linklist
    private int size;

    singlelinkedlist(){
        this.size = 0;
    }

    public int size(){
        return size;
    }

    // Node declare code
    Node head;
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
            size++; 
        }
    }

    //  Search an element​
    public int searchElement(String value){
        Node curr = head;
        int index = 0;

        while(curr != null){
            if (curr.data.equals(value)) {
                return index;
            }

            curr = curr.next;
            index++;
        }

        return -1;   // element nahi mila

    }

    // -----Insertion code ---------

    // Insert at beginning​
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    // Insert at end​
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head=newNode;
            return;
        }
        Node curNode = head;
        while (curNode.next != null) {
            curNode=curNode.next;
        }
        curNode.next=newNode;
    }
    
    // Insert at Specific Position
    public void insertpos(int pos , String data){
        if (pos < 0) {
            System.out.println("Invalid position");
            return;
        }
        if(pos == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node curr = head;

        for (int i = 0; i < pos -1; i++) {
            if(curr == null){
                System.out.println("position out of bond");
                return;
            }
            curr = curr.next;
        }
        newNode.next=curr.next;
        curr.next=newNode;
    }

    // Insert After a Given Node
    public void insertAfterNode(String target, String data){
        Node curr = head;

        while (curr != null) {
            if(curr.data.equals(target)){
                Node newNode = new Node(data);
                newNode.next=curr.next;
                curr.next=newNode;
                return;
            }
            curr = curr.next;
        }
        System.out.println("node not found");
    }

    // Insert Before a Given Node
    public  void InsertBefore(String target , String data) {
          if (head == null) {
            System.out.println("list is empty");
            return;
          }
          if(head.data.equals(target)){
            addFirst(data);
            return;
          }
          Node prev = null;
          Node curr = head;

          while (curr != null && !curr.data.equals(target)) {
            prev = curr;
            curr=curr.next;
          }

          Node newNode = new Node(data);
          prev.next=newNode;
          newNode.next=curr;
                    
    }    


    //  ----- delete code ------

   // Delete from beginning​ 
    public  void deleteFirst() {
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        size--;

        head = head.next;
    }
    // Delete from end
    public  void deleteLast() {
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while (secondLast.next.next != null) {
            secondLast=secondLast.next;
            lastNode=lastNode.next;
        }
        secondLast.next=null;

    }

    // Delete by position​
    public void deleteposition(int pos) {
      if (head == null) {
        System.out.println("list is empty");
        return;
      }
      if(pos < 0){
        System.out.println("Invalid position");
        return;
      }
      if (pos == 0) {
        deleteFirst();
        return;
      }
     Node curr = head;
      for (int i = 0; i < pos -1; i++) {
           if (curr.next == null) {
            System.out.println("position out of bound");
            return;
           }        
           curr = curr.next;
      }
       if (curr.next == null) {
            System.out.println("position out of bound");
            return;
           }  
           
           curr.next = curr.next.next;
           size--;
    }
    
    // delete by value
    public void deletevalue(String value){
         if (head == null) {
            System.out.println("list is empty");
            return;
         }
         if (head.data.equals(value)) {
            deleteFirst();
            return;
         }

         Node prev = head;
         Node curr = head.next;

         while (curr != null & !curr.data.equals(value)) {
            prev = curr;
            curr = curr.next;
         }
         
        // if (curr == null){
        //     System.out.println("value not found");
        //     return;
        // } 

        prev.next = curr.next;
        size--;

    }

    // Delete Entire Linked List
    public void deleteentire(){
        head = null;
        size =0;
    }

    // Traversal the  linkedlist
    public void printlist(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode=curNode.next;
        }
        System.out.print("null");

    }
    // create a node function
    public Node createNode(String data){
        return new Node(data);
    }


     
    public static void main(String[] args) {
        singlelinkedlist list = new singlelinkedlist();
        Node n1 = list.createNode("is");
        Node n2 = list.createNode("a");

        // link node
        n1.next=n2;
        
        // set head
        list.head=n1;

        // insertion function
        list.addFirst("this");
        list.addLast("list");
        list.insertpos(2, "not");
        list.insertAfterNode("not", "and");
        list.InsertBefore("is", "my");


        // deletion code
        list.deleteFirst();
        list.deleteLast();
        list.deleteposition(1);
        list.deletevalue("and");
        // list.deleteentire();  

        list.printlist();
        System.out.println();
        System.out.println("the search element is :- " + list.searchElement("a"));
        System.out.println();
        System.out.println("the size if linklist is :- " + list.size());


    }
}
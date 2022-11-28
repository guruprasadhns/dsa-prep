class SinglyLinkedList {
 
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    int length;

    public SinglyLinkedList() {
        head = null;
        length = 0;
    }

    //insert a node from the front
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //insert a node from the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        length++;
    }

    //insert a node at particular position
    public void insertAtPosition(int data, int position) {
        if(position < 0) {
            insertAtFront(data);
        }else if(position > length) {
            insertAtEnd(data);
        }else {
            Node temp = head;
            Node newNode = new Node(data);
            for(int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
    }

    //display list
    public void printlist() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //remove a node from the front of the list
    public void removeFromFront() {
        if(head == null) {
            System.out.print("List is Empty!!");
        }else {
            Node temp = head;
            head = temp.next;
            temp.next = null;
            length--;
        }
    }

    //remove a node from the end of the list
    public void removeFromEnd() {
        if(head == null) {
            System.out.print("List is Empty");
        }else {
            Node temp = null;
            Node curr = head;
            while(curr.next != null) {
                temp = curr;
                curr = curr.next;
            }
            temp.next = null;
            length--;
        }
    }

    //remove particular node from the list
    public void removeNode(int data) {
        if(head == null) {
            System.out.println("List is Empty!");
        }else {
            Node temp = head;
            if(temp.data == data) {
                head = temp.next;
                temp.next = null;
            }else {
               Node curr = temp.next;
               while(curr != null) {
                 if(curr.data != data) {
                   temp = curr;
                   curr = curr.next;
                 }else {
                    break;
                 }
               }
               temp.next = curr.next;
               curr.next = null;
            }
            length--;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(10);
        list.insertAtEnd(20);
        list.insertAtEnd(40);
        list.insertAtEnd(60);
        list.removeFromFront();
        list.removeFromFront();
        list.removeFromEnd();
        list.removeFromEnd();
        list.removeNode(10);
        list.removeNode(60);
        list.printlist();
    }
}
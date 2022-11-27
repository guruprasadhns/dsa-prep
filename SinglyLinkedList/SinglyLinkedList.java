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

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(10);
        list.insertAtFront(20);
        list.insertAtFront(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtPosition(99, 2);
        list.insertAtPosition(1001, 4);
        list.insertAtPosition(900, -1);
        list.insertAtPosition(888, 200);
        list.printlist();
    }
}
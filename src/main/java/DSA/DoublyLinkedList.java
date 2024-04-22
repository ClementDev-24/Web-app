package DSA;
public class DoublyLinkedList {
    Node head;
    Node tail;
    class Node{
        int data;
        Node prev;
        Node next;

        Node(int val){
            data = val;
            next = null;
            prev = null;

        }
    }
    DoublyLinkedList(){
        head = null;
        tail = null;

    }
    public void insertAtBeginning(int val){
        Node newNode = new Node(val);
        newNode.next = head;

        if(head==null) {
            tail = newNode;
        }
        else {
            head.prev = newNode;
        }
        head = newNode;
    }
    public void display() {
        if(head==null) {
            System.out.println("List is empty");
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
    public void displayRev() {
        if(head==null) {
            System.out.println("List is empty");
        }
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }
    public void insertAtPos(int pos,int val) {
        if(pos==0)
        {
            insertAtBeginning(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for(int i=1;i<pos;i++) {
            temp = temp.next;
            if(temp==null)
                throw new IndexOutOfBoundsException("Invalid Pos " + pos);
        }


        newNode.next = temp.next;
        newNode.prev = temp;

        if(temp==tail)
            tail=newNode;
        else
            temp.next.prev = newNode;
        temp.next = newNode;

    }

    public void deleteAtPos(int pos) {
        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        if(pos==0) {
            head = head.next;
            if(head==null) {
                tail = null;
            }
            else {
                head.prev = null;
            }
            return;
        }
        Node temp = head;
        Node prev = null;
        for(int i=1;i<=pos;i++) {
            prev = temp;
            temp = temp.next;
            if(temp==null)
                throw new IndexOutOfBoundsException("Invalid position ");
        }
        prev.next = temp.next; //reassign pointer
        if(temp.next==null)
            tail = prev;
        else
            temp.next.prev = prev;
    }
    public void deleteAtBeginning() {
        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        head = head.next;
        if(head==null)
            tail=null;
        else
            head.prev = null;
    }
public DoublyLinkedList reverseList(DoublyLinkedList list) {
    DoublyLinkedList reversedList = new DoublyLinkedList();
    Node temp = list.head;

    while (temp != null) {
       reversedList.insertAtBeginning(temp.data);
       temp= temp.next;
    }

    return reversedList;
}
    public DoublyLinkedList reverseListMethod(DoublyLinkedList list) {
        Node temp = list.head;
        Node temp1 = null;


     while (temp != null) {
            temp1 = temp.prev;
            temp.prev = temp.next;
            temp.next = temp1;
            temp = temp.prev;
        }
        if (temp1 != null) {
            list.head = temp1.prev;

        }
        System.out.println("++============");
       list.display();
        System.out.println("inside method");
        return list;
    }
    public int valueFromTail(int index) {
        Node current = tail;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            current = current.prev;
            count++;
        }

        throw new IndexOutOfBoundsException("Index out of range");
    }
public void insertSorted(int val){
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
        } else if (newNode.data < head.data) {
            newNode.next=head;
            head.prev=newNode;
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.next!=null && temp.next.data< newNode.data){
                temp = temp.next;
            }
            newNode.prev = temp;
            newNode.next = temp.next;
            if (temp.next!=null) {
                temp.next.prev = newNode;
            }
            temp.next =newNode;
        }

}
public int getIndex(int value){
        Node temp = head;
        int index = 0;
        while (temp.next!= null){
            if (temp.data == value){
                return index;
            }
            temp= temp.next;
            index++;
        }
        return -1;
}
public int findIndexBiDirection(int value){
        Node forward = head;
        Node backward = tail;
        int forwardIndex = 0;
        int backwardIndex = 0;
        while (forward !=null ||backward !=null){
            if (forward!=null && forward.data == value){
                return forwardIndex;
            }
            if (backward!=null && backward.data == value){
                return backwardIndex;
            }
            if (forward!=null){
                forward =forward.next;
                forwardIndex++;
            }
            if (backward!=null){
                backward =backward.prev;
                backwardIndex++;
            }
        }
        return -1;
}


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertSorted(9);
        System.out.println();
        list.display();
        list.insertSorted(6);
        System.out.println();
        list.display();
        list.insertSorted(7);
        System.out.println();
        list.display();
        list.insertSorted(5);
        System.out.println();
        list.display();
        list.insertSorted(10);
        System.out.println();
        list.display();
        System.out.println("Search Index");
        int value = list.findIndexBiDirection(6);
        System.out.println(value);

//        list.insertAtBeginning(10);
//        list.insertAtBeginning(11);
//        list.insertAtBeginning(12);
//        DoublyLinkedList list1 = list.reverseList(list);
//        list1.display();
          System.out.println();
//          list.display();
//        DoublyLinkedList list2 = list.reverseListMethod(list);
//        list.deleteAtPos(0);
          System.out.println();
//        list2.display();
        System.out.println();
//        int val = list.valueFromTail(-1);
//        System.out.println(val);
//        int value = list.valueFromTail(9);
//        System.out.println(value);


    }

}


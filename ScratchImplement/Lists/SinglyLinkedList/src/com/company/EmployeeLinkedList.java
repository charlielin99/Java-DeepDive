package com.company;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee){
        com.company.EmployeeNode node = new com.company.EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public void printList(){
        com.company.EmployeeNode current = head;
        System.out.print("HEAD ->");
        while (current!= null){
            System.out.print(current);
            System.out.print("->");
            current = current.getNext();
        }
        System.out.print("Null");
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removedNode = head;
        head = head.getNext();
        size --;
        removedNode.setNext(null);
        return removedNode;
    }


}


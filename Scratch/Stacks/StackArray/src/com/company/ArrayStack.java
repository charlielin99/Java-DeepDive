package com.company;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top; //starts at 0, ALWAYS POINTS TO NEXT FREE POSITION

    public ArrayStack (int capacity){ //constructor for size
        stack = new Employee[capacity];
    }

    public void push (Employee employee){ //O(n)
        if(top == stack.length){
            // need to resize array
            Employee[] newArray = new Employee[2* stack.length];
            System.arraycopy(stack,0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }


    public Employee pop(){ //O(1)
        if (isEmpty()){
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack [top] = null;
        return employee;
    }

    public Employee peek(){ //O(1)
        if (isEmpty()){
            throw new EmptyStackException();
        }

        return stack[top -1];
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public void printStack(){
        for(int i=top-1; i>=0; i--){
            System.out.println(stack[i]);
        }
    }
}

package com.company;

/*
This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair)
returns the first and last element of that pair. For example,
car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
Implement car and cdr.

*/


public class Main {

    public static class Cons<X, Y> {
        private X x;
        private Y y;

        public Cons(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X car() {
            return x;
        }

        public Y cdr() {
            return y;
        }
    }


    public static void main(String[] args) {
        Cons myPair = new Cons(3, 4);
        System.out.println(myPair.car());
        System.out.println(myPair.cdr());
    }
}

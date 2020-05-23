/*
This problem was asked by Google.

An XOR linked list is a more memory efficient doubly linked list.
Instead of each node holding next and prev fields, it holds a field named both,
which is an XOR of the next node and the previous node. Implement an XOR linked list;
it has an add(element) which adds the element to the end,
and a get(index) which returns the node at index.

*/


#include <cstdlib>
#include <iostream>

using namespace std;

class XorDoublyLinkedList {
    class XorNode {
        size_t xorAddr;
        int value;

    public:
        XorNode(int value, XorNode *prev, XorNode *next):
                value {value},
                xorAddr {reinterpret_cast<size_t>(prev) ^ reinterpret_cast<size_t>(next)} {}

        XorNode* getNextNode(XorNode *prevNode) {
            return reinterpret_cast<XorNode*>(xorAddr ^ reinterpret_cast<size_t>(prevNode));
        }

        void setNextNode(XorNode *node) {
            xorAddr ^= reinterpret_cast<size_t>(node);
        }

        int getValue() {
            return value;
        }
    };

    XorNode *head, *tail;

public:
    XorDoublyLinkedList():
            head {nullptr},
            tail {nullptr} {}

    void add(int value) {
        if (head == nullptr) {
            cout << "setHead: " << value << endl;
            head = new XorNode{value, nullptr, nullptr};
        } else if (tail == nullptr) {
            cout << "setSecond: " << value << endl;
            tail = new XorNode{value, head, nullptr};
            head -> setNextNode(tail);
        } else {
            cout << "addNode: " << value << endl;
            XorNode *newNode = new XorNode{value, tail, nullptr};
            tail -> setNextNode(newNode);
            tail = newNode;
        }
    }

    int get(int index) {
        XorNode *prev = nullptr, *curr = head, *temp;

        for (int i = 0; i < index; i++) {
            temp = curr;
            curr = curr -> getNextNode(prev);
            prev = temp;
        }

        return curr -> getValue();
    }
};

int main(int argc, char const *argv[]) {
    XorDoublyLinkedList list {};

    list.add(-1);
    list.add(-2);
    list.add(-3);
    list.add(-4);

    cout << list.get(0) << " " << list.get(1) << " " << list.get(2) << " " << list.get(3) << endl;

    return 0;
}
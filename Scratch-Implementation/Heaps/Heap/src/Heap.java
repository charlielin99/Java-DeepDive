public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity){
        heap = new int[capacity];
    }

    public void insert(int value){
        if (isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;

        fixHeapAbove(size);
        size++;
    }

    private void fixHeapAbove(int index){
        int newValue = heap[index];
        while (index >0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public int getParent(int index){
        return (index - 1) / 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild (int index, boolean left){
        return 2 * index + (left? 1 : 2);
    }

    public int delete(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]){
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        size --;

        return deletedValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;

        while(index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex){
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild: rightChild;
                }

                if (heap[index] < heap[childToSwap]){
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public void printHeap(){
        for (int i=0; i<size; i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public int peek(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    public void sort(){
        int lastHeapIndex = size -1;
        for (int i=0; i<lastHeapIndex; i++){
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }


}

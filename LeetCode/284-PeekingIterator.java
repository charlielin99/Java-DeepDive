import java.util.NoSuchElementException;
/*
Why not a Queue?

imagine that we have an array contains 1 million elements. If we only want the k element. 
By using iterator, we can just consume k elements. Time complexity is O(k), space is O(1).
By using queue, time complexity will be O(N), space will be O(N) as well, which is workable but not so efficiency.
*/
class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iter;
    boolean noSuchElement;

    public PeekingIterator(Iterator<Integer> iterator) {
	// initialize any member here.
	iter = iterator;
        advanceIter();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        // you should confirm with interviewer what to return/throw
        // if there are no more values
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (noSuchElement)
            throw new NoSuchElementException();
        Integer res = next;
        advanceIter();
        return res;
    }

    @Override 
    public boolean hasNext() {
        return !noSuchElement;
    }
    
    private void advanceIter() {
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            noSuchElement = true;
        }
    }
}
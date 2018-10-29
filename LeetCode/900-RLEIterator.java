class RLEIterator {
    // o(n) time
    // could be o(n) or o(1) space due to the way constructor is called
    int A[];
    int index = 0;//indicate the current start of the array(number of times)
    public RLEIterator(int[] A) {
        this.A = A;
    }
    
    public int next(int n) {
        while(index + 1 < A.length){//valid
            if(n > A[index]){
                n -= A[index];
                index += 2;
            }else {//smaller or equal
                A[index] -= n;
                return A[index + 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
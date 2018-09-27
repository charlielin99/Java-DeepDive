class LRUCache {
  int capacity;
  
  //LinkedListNode holds key and value pairs
  HashMap<Integer,LinkedListNode> cache; 
  LinkedList<LinkedListNode> cache_vals;
  
  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<Integer,LinkedListNode>(capacity);
    cache_vals = new LinkedList<LinkedListNode>();
  }


  int get(int key) {
    LinkedListNode node = cache.get(key);
    
    if (node == null){
      return -1;
    }
    
    cache_vals.remove(node);
    cache_vals.addLast(node);
    return node.data;
  }

  void set(int key, int value) {
    LinkedListNode node = cache.get(key);
    
    if (node == null){
      evictIfNeeded();
      node = new LinkedListNode(key, value);
      cache_vals.addLast(node);
      cache.put(key, node);
    } else {
      node.data = value;
      cache_vals.remove(node);
      cache_vals.addLast(node);
    }
  }
  
  void evictIfNeeded(){
    if (cache_vals.size() >= capacity){
      LinkedListNode node = cache_vals.remove();
      cache.remove(node.key);
    }
  }

  String print() {
    String result = "";
    ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
    while(iterator.hasNext()){
      LinkedListNode node = iterator.next();
      result += "("+node.key + ":" +node.data+")" + ",";  
    }
   return result;
  }
}  
class Node {
  public int data;
  public List<Node> neighbors = new ArrayList<Node>();
  public Node(int d) {data = d;}
}

class graph {
  public static Node clone(Node root) {
    Map<Node, Node> map = new HashMap<>();
    return cloneDeepCopy(root, map);
  }
  
  public static Node cloneDeepCopy(Node root, Map<Node, Node> map){
    if (root == null){
      return null;
    }
    
    Node deepNode = new Node(root.data);
    map.put(root, deepNode);
    
    for (Node list: root.neighbors){
      Node temp = map.get(list);
      if (temp == null){
        deepNode.neighbors.add(cloneDeepCopy(list, map));
      } else {
        deepNode.neighbors.add(list);
      }
    }
    
    return deepNode;
  }
}